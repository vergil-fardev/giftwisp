package fardev.vergil.my_list.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fardev.vergil.core_ui.Dimensions
import fardev.vergil.my_list.R

@Composable
fun MyListItemEditScreen(modifier: Modifier = Modifier, isEditMode: Boolean) {
    Surface(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimensions.TWO_UNIT),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.TWO_UNIT),
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.my_list_item_placeholder))
                },
                modifier = Modifier.fillMaxWidth(),
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(
                    id = if(isEditMode) {
                        R.string.my_list_item_update_item
                    } else {
                        R.string.my_list_item_add_item
                    }
                ))
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMyListItemEditScreenEditMode() {
    MaterialTheme {
        MyListItemEditScreen(isEditMode = true)
    }
}

@Preview
@Composable
private fun PreviewMyListItemEditScreenInsertionMode() {
    MaterialTheme {
        MyListItemEditScreen(isEditMode = false)
    }
}