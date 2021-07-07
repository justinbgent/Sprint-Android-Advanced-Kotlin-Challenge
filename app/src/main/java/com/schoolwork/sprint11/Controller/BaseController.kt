package com.schoolwork.sprint11.Controller

import android.os.Bundle
import com.bluelinelabs.conductor.Controller

abstract class BaseController: Controller{
    protected constructor()
    protected constructor(arg: Bundle): super(arg)
}