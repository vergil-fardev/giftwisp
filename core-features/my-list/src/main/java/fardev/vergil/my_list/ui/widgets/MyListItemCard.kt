package fardev.vergil.my_list.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fardev.vergil.core_ui.Dimensions

@Composable
fun MyListItemCard(item: String) {
    Card(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
        Box(modifier = Modifier.padding(Dimensions.TWO_UNIT)) {
            Text(text = item)
        }
    }
}

@Preview
@Composable
private fun PreviewMyListItemCard() {
    MaterialTheme {
        MyListItemCard("Some Item")
    }
}