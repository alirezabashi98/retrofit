package com.arb.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arb.retrofit.dataClass.Users
import kotlinx.android.synthetic.main.activity_full_screen.*

class fullScreen : AppCompatActivity(),DataListener<Users> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)


        UserPresenter(this)
            .getUserData(intent.getIntExtra("id",0).toString())

    }

    override fun onSuccess(users: Users) {

        tv_fullScreen_name.text = users.name
        tv_fullScreen_username.text = users.username
        tv_fullScreen_email.text = users.email
        tv_fullScreen_phone.text = users.phone
        tv_fullScreen_website.text = users.website

    }

    override fun onError(error: Throwable) {

        Toast.makeText(this,"error",Toast.LENGTH_LONG).show()

    }
}