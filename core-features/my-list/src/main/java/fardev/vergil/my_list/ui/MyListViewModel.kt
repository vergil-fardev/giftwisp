package fardev.vergil.my_list.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(): ViewModel() {
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
}