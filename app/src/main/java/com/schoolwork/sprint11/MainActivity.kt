package com.schoolwork.sprint11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, layout_constraint_main, savedInstanceState)

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(/*TODO MultiplyController()*/))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()){
            super.onBackPressed()
        }
    }
}
