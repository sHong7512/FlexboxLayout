package com.shong.flexboxlayout

import android.app.Application
import android.content.Context
import android.widget.Toast

class Appbase: Application() {
    companion object {
        private var toast: Toast? = null
        fun toastShow(context: Context, message: String, length: Int) {
            toast?.cancel()
            toast = Toast.makeText(context, message, length)
            toast?.show()
        }
    }
}