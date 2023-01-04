package dev.harshdalwadi.networkcalllibraryexample

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import dev.harshdalwadi.network.models.UiData


/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 04-01-2023
 */
object UiUtils {
    fun generateTextView(context: Context, uidata: UiData): TextView {
        val textView = TextView(context)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 20, 0, 0)

        textView.apply {
            textSize = 14f
            text = uidata.value
            tag = uidata.key
            layoutParams = params
        }

        return textView
    }

    fun generateValueTextView(context: Context, uidata: UiData): TextView {
        val textView = TextView(context)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 20, 0, 0)

        textView.apply {
            textSize = 16f
            text = uidata.value
            tag = uidata.key
            layoutParams = params
            setTextColor(Color.parseColor("#000000"))
        }

        return textView
    }

    fun generateEditText(context: Context, uidata: UiData): EditText {
        val editText = EditText(context)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 20, 0, 0)

        editText.apply {
            textSize = 14f
            hint = uidata.hint
            tag = uidata.key
            layoutParams = params
        }

        return editText
    }

    fun generateButton(context: Context, uidata: UiData): MaterialButton {
        val materialButton = MaterialButton(context)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 20, 0, 0)
        params.gravity = Gravity.CENTER

        materialButton.apply {
            textSize = 16f
            text = uidata.value
            tag = uidata.key
            layoutParams = params
            gravity = Gravity.CENTER
        }

        return materialButton
    }

}