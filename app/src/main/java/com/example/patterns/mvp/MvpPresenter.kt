package com.example.patterns.mvp

import com.example.patterns.models.CounterModel

class MvpPresenter : MvpContract.Presenter {

    private var view: MvpContract.View? = null
    private val model = CounterModel()

    override fun attachView(view: MvpContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun incrementCounter() {
        model.increment()
        view?.showCounter(model.count)
    }
}
