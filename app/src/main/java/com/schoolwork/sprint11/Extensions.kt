package com.schoolwork.sprint11

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.schoolwork.sprint11.Controller.MultiplyController

fun Context.makeToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}