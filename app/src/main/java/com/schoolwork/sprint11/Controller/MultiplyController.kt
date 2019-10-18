package com.schoolwork.sprint11.Controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.schoolwork.sprint11.R
import com.schoolwork.sprint11.makeToast

class MultiplyController: BaseController(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.multiply_controller, container, false)
    }

    override fun onChangeStarted(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeStarted(changeHandler, changeType)

        val bundle = Bundle()

        view?.findViewById<Button>(R.id.btn_multiply)?.setOnClickListener {

            val stringTTL = view?.findViewById<EditText>(R.id.top_top_left_num_field)?.text.toString()
            val stringTTR = view?.findViewById<EditText>(R.id.top_top_right_num_field)?.text.toString()
            val stringTBL = view?.findViewById<EditText>(R.id.top_bot_left_num_field)?.text.toString()
            val stringTBR = view?.findViewById<EditText>(R.id.top_bot_right_num_field)?.text.toString()
            val stringBTL = view?.findViewById<EditText>(R.id.bot_top_left_num_field)?.text.toString()
            val stringBTR = view?.findViewById<EditText>(R.id.bot_top_right_num_field)?.text.toString()
            val stringBBL = view?.findViewById<EditText>(R.id.bot_bot_left_num_field)?.text.toString()
            val stringBBR = view?.findViewById<EditText>(R.id.bot_bot_right_num_field)?.text.toString()

            if (stringTTL.isEmpty() ||
                stringTTR.isEmpty() ||
                stringTBL.isEmpty() ||
                stringTBR.isEmpty() ||
                stringBTL.isEmpty() ||
                stringBTR.isEmpty() ||
                stringBBL.isEmpty() ||
                stringBBR.isEmpty()){
                activity?.makeToast("All fields are required")
            }else{
                try {
                    val numTTL = stringTTL.toInt()
                    val numTTR = stringTTR.toInt()
                    val numTBL = stringTBL.toInt()
                    val numTBR = stringTBR.toInt()
                    val numBTL = stringBTL.toInt()
                    val numBTR = stringBTR.toInt()
                    val numBBL = stringBBL.toInt()
                    val numBBR = stringBBR.toInt()

                    bundle.putInt("key", 36)

                    router.pushController(
                        RouterTransaction.with(ResultController(bundle))
                            .pushChangeHandler(HorizontalChangeHandler())
                            .popChangeHandler(HorizontalChangeHandler())
                    )
                }catch (e: NumberFormatException){
                    activity?.makeToast("Only integers allowed")
                }
            }
        }

    }
}