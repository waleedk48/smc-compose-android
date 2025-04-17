package com.servicemycar.android.ui.screens.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.servicemycar.android.core.domain.util.onError
import com.servicemycar.android.core.domain.util.onSuccess
import com.servicemycar.android.repos.core.CoreRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import timber.log.Timber

class IntroViewModel(
    private val coreRepository: CoreRepository
) : ViewModel() {

    private var count = MutableLiveData<String>("")

    var mutex = Mutex(locked = false)

    init {
        fetchGeneralSettings()


    }

    fun callMutexTTest() {
        viewModelScope.launch {
            lockTest()
        }
    }

    private suspend fun lockTest() {
        Timber.d("MutexTest: lockTest()")

        count.observeForever {
            Timber.d("MutexTest: Count is Changed -> $it")
        }


        coroutineScope {
            val c1 = async { coroutine1() }
            val c2 = async { coroutine2() }

            awaitAll(c1,c2)
        }


    }

    private suspend fun coroutine1() {
        (0..20).forEach { index ->
            delay((100 * index).toLong())
            mutex.withLock {
                count.postValue("c1 $index")
            }

        }

    }

    private suspend fun coroutine2() {
        (0..20).forEach { index ->
            delay((100 * index).toLong())
            mutex.withLock {
                count.postValue("c2 $index")
            }

        }

    }

    private fun fetchGeneralSettings() {
        viewModelScope.launch {
            coreRepository.generalSettings()
                .onSuccess { data ->
                    Timber.d("GeneralSettings: data -> $data")
                }.onError { error ->
                    Timber.d("GeneralSettings: error -> $error")
                }
        }
    }
}