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
import com.schoolwork.sprint11.*

// TODO: Refactor

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
                    val matrixStart = CustomMatrix(2, 2).initialMatrix
                    val matrix1Start = CustomMatrix(2, 2).initialMatrix
                    var matrix = MatrixCustom(matrixStart)
                    var matrix1 = MatrixCustom(matrix1Start)

                    matrix.matrix[0][0] = stringTTL.toInt()
                    matrix.matrix[0][1] = stringTTR.toInt()
                    matrix.matrix[1][0] = stringTBL.toInt()
                    matrix.matrix[1][1] = stringTBR.toInt()
                    matrix1.matrix[0][0] = stringBTL.toInt()
                    matrix1.matrix[0][1] = stringBTR.toInt()
                    matrix1.matrix[1][0] = stringBBL.toInt()
                    matrix1.matrix[1][1] = stringBBR.toInt()

                    var result = (matrix * matrix1)

                    bundle.putIntArray("key", result)

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