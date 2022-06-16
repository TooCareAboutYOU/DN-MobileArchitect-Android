package com.dn.mobile.architect.lsn4.aop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import com.dn.mobile.architect.lsn4.R
import com.dn.mobile.architect.lsn4.aop.aspect.BehaviorTrace
import java.util.*

class AopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aop)
    }

    //没有反应 AOP没有成功
    @BehaviorTrace("share")
    fun clickShare(view: View) {
        Log.i("print_logs", "AopActivity::clickShare()")

    }
    @BehaviorTrace("audio")
    fun clickAudio(view: View) {
        SystemClock.sleep(Random().nextInt(2000).toLong())

    }

    @BehaviorTrace("video")
    fun clickVideo(view: View) {
        SystemClock.sleep(Random().nextInt(2000).toLong())

    }

    @BehaviorTrace("other")
    fun clickOther(view: View) {
        SystemClock.sleep(Random().nextInt(2000).toLong())

    }
}