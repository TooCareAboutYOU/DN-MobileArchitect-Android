package com.dn.mobile.architect.lsn5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.dn.mobile.architect.lsn5.bean.User
import com.dn.mobile.architect.lsn5.db.BaseDaoFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun insertObject(view: View) {
        val dao = BaseDaoFactory.getOurInstance().getBaseDao(User::class.java)
        val user = User(100,"Hello","world")
        val result = dao?.insert(user)
        Log.i("print_logs", "MainActivity::insertObject: $result")
    }

    fun deleteObject(view: View) {}
    fun updateObject(view: View) {}
    fun queryObject(view: View) {}
}