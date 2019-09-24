package com.andela.learnkoin.ui

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.andela.learnkoin.network.ApiService
import com.andela.learnkoin.ui.DataState.Loading
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class PostListViewModel(val apiService: ApiService) : ViewModel() {

    private lateinit var disposable: Disposable

    val commands = PublishSubject.create<DataState>()


    init {
        getPost()
    }

    fun getPost() {
        disposable = apiService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    commands.onNext(Loading)
                }
                .subscribe ({
                    commands.onNext(DataState.Data(it))
                }
                , {
                    commands.onNext(DataState.Error)
                })
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}