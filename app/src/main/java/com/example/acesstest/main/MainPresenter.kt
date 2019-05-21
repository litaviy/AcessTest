package com.example.acesstest.main

import com.example.acesstest.DataBase
import com.example.acesstest.controllers.HomeController
import com.example.acesstest.list.ItemModel

class MainPresenter(
        private val view: ViewDelegate,
        private val homeController: HomeController
) {

    fun getInitialItems(): List<ItemModel> {
        // depending on the launch type return some list
        return homeController.getItems()
    }

    fun onSwitchToTheSelectPaymentMethodTypeRequest() {
        view.showMessage("Request handling...")
    }

}

object MainPresenterProvider {

    fun provide(view: ViewDelegate): MainPresenter {

        val dataBase = DataBase()
        val homneController = HomeController(dataBase)

        return MainPresenter(view, homneController)
    }
}