package com.arb.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arb.retrofit.adapter.AdapterRecyclerView
import com.arb.retrofit.dataClass.Users
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),DataListener<List<Users>> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UsersPresenter(this)
            .getUsersData()

    }

    override fun onSuccess(users: List<Users>) {

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecyclerView(users)

    }

    override fun onError(error: Throwable) {

        Toast.makeText(this,"error",Toast.LENGTH_LONG).show()

    }
}