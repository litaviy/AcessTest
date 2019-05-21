package com.example.acesstest.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.acesstest.R
import com.example.acesstest.list.ItemRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewDelegate {

    private val presenter: MainPresenter =
            MainPresenterProvider.provide(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupList()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun switchModeToSelectPaymentType() {
        presenter.onSwitchToTheSelectPaymentMethodTypeRequest()
    }

    private fun setupList() {
        mainDataList.layoutManager = LinearLayoutManager(this)

        val adapter = ItemRecyclerViewAdapter(this)

        mainDataList.adapter = adapter

        val data = presenter.getInitialItems()
        adapter.switchDataList(data)
    }
}
