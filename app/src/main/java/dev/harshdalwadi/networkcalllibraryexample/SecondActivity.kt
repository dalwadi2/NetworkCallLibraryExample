package dev.harshdalwadi.networkcalllibraryexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dev.harshdalwadi.network.models.SampleData
import dev.harshdalwadi.networkcalllibraryexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val TAG = SecondActivity::class.java.simpleName

    private val apiUrl = "https://demo.ezetap.com/mobileapps/android_assignment.json"

    private lateinit var binding: ActivitySecondBinding
    val gson by lazy {
        Gson()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val sampleData: SampleData? = gson.fromJson(intent.extras?.getString("data"), SampleData::class.java)
        renderUI(sampleData)

    }

    private fun renderUI(sampleData: SampleData?) {
        runOnUiThread {

            sampleData?.let {
                it.uidata?.forEach { uidata ->
                    when (uidata?.uitype) {
                        "label" -> {
                            binding.llMain.addView(UiUtils.generateTextView(this@SecondActivity, uidata))
                        }
                        "edittext" -> {
                            binding.llMain.addView(UiUtils.generateValueTextView(this@SecondActivity, uidata))
                        }
                        else -> {}
                    }
                }
            }
        }
    }

}