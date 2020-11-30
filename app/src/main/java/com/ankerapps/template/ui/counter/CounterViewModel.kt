package com.ankerapps.template.ui.counter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankerapps.template.domain.CounterUsecase
import com.ankerapps.template.ui.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CounterViewModel
@ViewModelInject constructor(
    private val counterUsecaseDomain: CounterUsecase
) : BaseViewModel() {

    private val counterValue: MutableLiveData<Int> = MutableLiveData(0)
    private val errorsValue = MutableLiveData<Throwable>()

    val counter: LiveData<Int>
        get() = counterValue
    val errors: LiveData<Throwable>
        get() = errorsValue

    init {
        ioScope.launch {
            counterUsecaseDomain.get()
                .onEach {
                    counterValue.postValue(it.value)
                }
                .catch {
                    errorsValue.postValue(it)
                }
                .launchIn(ioScope)
        }
    }

    fun incrementClick() {
        ioScope.launch {
            counterUsecaseDomain.editCounter(counterUsecaseDomain.get().first().inc())
                .onFailure { errorsValue.postValue(it) }
        }
    }

    fun decrementClick() {
        ioScope.launch {
            counterUsecaseDomain.editCounter(counterUsecaseDomain.get().first().dec())
                .onFailure { errorsValue.postValue(it) }
        }
    }
}
