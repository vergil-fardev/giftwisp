package fardev.vergil.my_groups.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fardev.vergil.core_ui.Dimensions

@Composable
fun GroupCardItem(groupName: String) {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(Dimensions.TWO_UNIT)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = groupName,
                    maxLines = 2,
                    minLines = 2,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "Participants: 5/10",
                    style = MaterialTheme.typography.labelSmall,
                )
            }
            IconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewGroupCardItem() {
    MaterialTheme {
        GroupCardItem("Some Group Name")
    }
}