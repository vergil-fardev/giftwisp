@file:OptIn(ExperimentalMaterial3Api::class)

package fardev.vergil.my_list.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fardev.vergil.core_ui.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor()
    : BaseViewModel<MyListState, MyListEvent, MyListEffect>(
    MyListState(
        editListModalState = SheetState(
            skipPartiallyExpanded = true,
            initialValue = SheetValue.Hidden,
        )
    )
) {
    private val myList = listOf(
        "PS5",
        "Nintendo Switch",
        "Hogwarts Castle LEGO",
        "Percy Jackson Book Series",
        "New Mug",
    )

    fun getGiftList(): List<String> {
        return myList
    }

    override fun handleViewEvent(event: MyListEvent) {
        when(event) {
            MyListEvent.OnAddClicked -> handleOnAddClicked()
        }
    }

    /**
     * TODO RAFVER: expand() and hide() method are called from within the Composable method,
     * I'm not sure how to call them from the ViewModel.
     * Also, hide() should be called from the Dismiss event of the BottomSheet, I'm not sure how
     * to do it from the ViewModel either.
     */
    private fun handleOnAddClicked() = viewModelScope.launch {
        if(currentState.editListModalState.isVisible) {
            currentState.editListModalState.expand()
        } else {
            currentState.editListModalState.hide()
        }
    }

}