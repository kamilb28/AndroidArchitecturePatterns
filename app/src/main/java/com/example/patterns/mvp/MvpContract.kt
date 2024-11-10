package com.example.patterns.mvp

interface MvpContract {
    interface View {
        fun showCounter(counter: Int)
    }

    interface Presenter {
        fun incrementCounter()
        fun attachView(view: View)
        fun detachView()
    }
}
