package fardev.vergil.core_ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fardev.vergil.core_data.utils.createLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseViewModel
<State: ViewModelState, Event: ViewEvent, Effect: ViewModelEffect>(initialState: State)
    : ViewModel() {

    private val logger by lazy { createLogger() }

    // VIEW MODEL STATE
    private val _viewState = MutableStateFlow(initialState)
    val viewState: Flow<State> = _viewState.onEach {
        logger.d("${this.javaClass.simpleName} emitted a new State: $it")
    }
    protected val currentState: State get() = _viewState.value

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun onNewState(newState: State) {
        this._viewState.value = newState
    }

    // VIEW EVENT
    private val _viewEvents = MutableSharedFlow<OneTimeEffect<Event>>()

    init {
        viewModelScope.launch {
            _viewEvents.collect { oneTimeEffect ->
                if(!oneTimeEffect.alreadyHandled) {
                    logger.d("${this.javaClass.simpleName} emitted a new Event: ${oneTimeEffect.peekContent()}")
                    handleViewEvent(oneTimeEffect.peekContent())
                }
            }
        }
    }

    fun onNewEvent(newEvent: Event) {
        viewModelScope.launch {
            _viewEvents.emit(OneTimeEffect(newEvent))
        }
    }

    protected abstract fun handleViewEvent(event: Event)
}