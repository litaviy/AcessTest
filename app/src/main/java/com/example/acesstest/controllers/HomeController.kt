package com.example.acesstest.controllers

import com.example.acesstest.DataBase
import com.example.acesstest.main.ViewDelegate
import com.example.acesstest.list.ItemClickLictener
import com.example.acesstest.list.ItemModel

class HomeController(private val dataBase: DataBase) {

    fun getItems(): List<ItemModel> =
        List(
            size = 5,
            init = { index ->
                val title = if (index == 0) {
                    "Switch To The Select Payment Type"
                } else {
                    "Title $index"
                }
                ItemModel(
                    title = title,
                    action = object : ItemClickLictener {
                        override fun onItemClick(delegate: ViewDelegate, item: ItemModel) {
                            if (index == 0) {
                                delegate.switchModeToSelectPaymentType()
                            } else {
                                val dataFromDataBase = dataBase.getData(index)
                                delegate.showMessage(dataFromDataBase)
                            }
                        }
                    }
                )
            }
        )
}