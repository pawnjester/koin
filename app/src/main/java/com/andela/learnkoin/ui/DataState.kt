package com.andela.learnkoin.ui

import com.andela.learnkoin.model.Post

sealed class DataState {
    object Loading : DataState()
    class Data(val list: List<Post>): DataState()
    object Error: DataState()

}
