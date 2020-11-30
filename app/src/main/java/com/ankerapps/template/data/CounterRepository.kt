package com.ankerapps.template.data

import com.tfcporciuncula.flow.FlowSharedPreferences
import com.ankerapps.template.domain.models.Counter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Provider

class CounterRepositoryImpl
@Inject constructor(
    private val preferences: Provider<FlowSharedPreferences>
): CounterRepository {

    private val counterPreferences by lazy {
        preferences.get().getInt(COUNTER_KEY, 0)
    }

    override suspend fun getValue() = counterPreferences.asFlow().map { Counter(it) }

    override suspend fun setValue(counter: Counter) { counterPreferences.setAndCommit(counter.value) }

    companion object {
        const val COUNTER_KEY : String = "counter_value"
    }
}


interface CounterRepository {
    suspend fun getValue(): Flow<Counter>
    suspend fun setValue(counter: Counter)
}
