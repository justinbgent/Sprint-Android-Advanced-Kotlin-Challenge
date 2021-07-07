package com.schoolwork.sprint11.Controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.schoolwork.sprint11.R

// TODO: Refactor

class ResultController(private val bundle: Bundle): BaseController(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.result_controller, container, false)
    }

    override fun onChangeStarted(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeStarted(changeHandler, changeType)
        val array: IntArray? = bundle.getIntArray("key")
        if (array != null){
            view?.findViewById<TextView>(R.id.top_left_txt)?.text = array[0].toString()
            view?.findViewById<TextView>(R.id.top_right_txt)?.text = array[1].toString()
            view?.findViewById<TextView>(R.id.bot_left_txt)?.text = array[2].toString()
            view?.findViewById<TextView>(R.id.bot_right_txt)?.text = array[3].toString()
        }

    }
}