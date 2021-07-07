package com.schoolwork.sprint11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.schoolwork.sprint11.Controller.MultiplyController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    val parentLayout by lazy {
        findViewById<ConstraintLayout>(R.id.layout_constraint_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, parentLayout, savedInstanceState)

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(MultiplyController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()){
            super.onBackPressed()
        }
    }
}
