@file:OptIn(ExperimentalMaterial3Api::class)

package fardev.vergil.my_list.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import fardev.vergil.core_ui.Dimensions
import fardev.vergil.my_list.ui.MyListViewModel
import fardev.vergil.my_list.ui.widgets.MyListItemCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyListScreen(
    viewModel: MyListViewModel = hiltViewModel(),
) {
    val scope = rememberCoroutineScope()
    val modalState = rememberModalBottomSheetState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    modalState.expand()
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new Group")
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) { scaffoldPadding ->
        MyListContent(
            myList = viewModel.getGiftList(),
            modalState = modalState,
            scope = scope,
            modifier = Modifier.padding(scaffoldPadding),
        )
    }
}

@Composable
fun MyListContent(
    myList: List<String>,
    modalState: SheetState,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimensions.ONE_UNIT),
            modifier = Modifier.padding(Dimensions.TWO_UNIT),
        ) {
            items(myList) { item ->
                MyListItemCard(item = item)
            }
        }
    }
    if(modalState.isVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                scope.launch {
                    modalState.hide()
                }
            }
        ) {
            MyListItemEditScreen(isEditMode = false)
        }
    }
}

@Preview
@Composable
private fun PreviewMyListScreen() {
    MaterialTheme {
        MyListScreen()
    }
}