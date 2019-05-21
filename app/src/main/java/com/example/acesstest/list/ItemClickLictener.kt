package com.example.acesstest.list

import com.example.acesstest.main.ViewDelegate

interface ItemClickLictener {

    fun onItemClick(delegate: ViewDelegate, item: ItemModel)
}