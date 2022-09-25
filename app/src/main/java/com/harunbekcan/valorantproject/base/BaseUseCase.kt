package com.harunbekcan.valorantproject.base

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseUseCase<T> {

    private val compositeDisposable = CompositeDisposable()
    private var disposable: Disposable? = null

    internal abstract fun buildUseCaseSingle(): Single<Any>

    fun execute(
        onSuccess: ((t: Any) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        disposable = buildUseCaseSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onError)
        add()
    }

    private fun disposeLast() {
        disposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    private fun add() {
        disposable?.let {
            compositeDisposable.add(it)
        }
    }
}