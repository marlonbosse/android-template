package com.ankerapps.template.domain

import com.ankerapps.template.domain.models.Counter
import com.ankerapps.template.data.CounterRepository
import timber.log.Timber
import javax.inject.Inject

class CounterUsecase
@Inject constructor(
    private val counterRepo: CounterRepository
){

    suspend fun get() = counterRepo.getValue()

    suspend fun editCounter(counter: Counter) : Result<Counter> {
        if (counter.value < 0) {
            Timber.w(IncrementError(), "Value given was ${counter.value}")
            return Result.failure(IncrementError())
        }
        counterRepo.setValue(counter)
        return Result.success(counter)
    }

    class IncrementError :
        Exception("Value given to .editCounter() is negative. Negative numbers are not allowed")
}
