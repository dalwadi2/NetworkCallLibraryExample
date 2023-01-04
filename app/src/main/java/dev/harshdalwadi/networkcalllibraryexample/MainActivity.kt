package dev.harshdalwadi.networkcalllibraryexample

import android.R.attr.data
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import com.google.gson.Gson
import dev.harshdalwadi.network.NetworkUtils
import dev.harshdalwadi.network.models.SampleData
import dev.harshdalwadi.networkcalllibraryexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private val apiUrl = "https://demo.ezetap.com/mobileapps/android_assignment.json"

    private lateinit var binding: ActivityMainBinding
    val gson by lazy {
        Gson()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        fetchData()
    }


    private fun fetchData() {
        binding.progress.isVisible = true
        val networkUtils = NetworkUtils()

        CoroutineScope(Dispatchers.IO).launch {
            val result = networkUtils.fetchCustomUI(apiUrl)
            val sampleData: SampleData? = gson.fromJson(result.toString(), SampleData::class.java)

            val logoByteArray = networkUtils.fetchLogo(sampleData?.logoUrl.orEmpty())

            renderUI(sampleData, logoByteArray)
        }
    }

    private fun renderUI(sampleData: SampleData?, logoByteArray: ByteArray) {
        runOnUiThread {
            binding.progress.isVisible = false

            sampleData?.let {
                val bitmap = BitmapFactory.decodeByteArray(logoByteArray, 0, logoByteArray.size)
                binding.ivLogo.setImageBitmap(bitmap)

                binding.tvHeading.text = it.headingText
                it.uidata?.forEach { uidata ->
                    when (uidata?.uitype) {
                        "label" -> {
                            binding.llMain.addView(UiUtils.generateTextView(this@MainActivity, uidata))
                        }
                        "edittext" -> {
                            binding.llMain.addView(UiUtils.generateEditText(this@MainActivity, uidata))
                        }
                        "button" -> {
                            val button = UiUtils.generateButton(this@MainActivity, uidata)
                            button.setOnClickListener { view ->
                                it.uidata?.forEach { data ->
                                    if (data?.uitype == "edittext") {
                                        data.value = binding.root.findViewWithTag<EditText>(data.key).text.toString()
                                    }
                                }
                                val bundle = bundleOf(Pair("data", gson.toJson(it)))
                                startActivity(Intent(this@MainActivity, SecondActivity::class.java).putExtras(bundle))
                            }
                            binding.llMain.addView(button)
                        }
                        else -> {}
                    }
                }
            }
        }
    }

}