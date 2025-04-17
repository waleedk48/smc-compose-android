package com.servicemycar.android.test


class SharedResource {
    private var counter = 0
    val currentCounter get() = counter

    val onceCounter by lazy { counter }

    val unInitializedCounter = lazy { counter }

    fun increment() {
        synchronized(this) {
            counter++
        }
    }

    companion object {
        const val SHARED_CONST = "this is shared const"
    }

}


fun main() {
    println("Hello Kotlin Console")
    val sRes = SharedResource()

    val thread = Thread {
        for (i in 1..4) {
            println("Thread 1 ->" + sRes.currentCounter)
        }
    }

    val thread2 = Thread {
        for (i in 1..4) {
            println("Thread 2 ->" + sRes.currentCounter)
        }

    }

    thread.start()
    thread2.start()
    println("Line print before join threads")
    thread.join()
    thread2.join()

    println("Line print after join threads")

//     for(i in 1..10){
//       println(sRes.increment())
//     }
}