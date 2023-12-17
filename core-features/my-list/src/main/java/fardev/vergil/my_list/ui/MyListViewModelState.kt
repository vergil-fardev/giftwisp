@file:OptIn(ExperimentalMaterial3Api::class)

package fardev.vergil.my_list.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import fardev.vergil.core_ui.ViewEvent
import fardev.vergil.core_ui.ViewModelEffect
import fardev.vergil.core_ui.ViewModelState

data class MyListState(
    val editListModalState: SheetState,
): ViewModelState

sealed class MyListEvent: ViewEvent {
    data object OnAddClicked: MyListEvent()
}

data object MyListEffect: ViewModelEffect