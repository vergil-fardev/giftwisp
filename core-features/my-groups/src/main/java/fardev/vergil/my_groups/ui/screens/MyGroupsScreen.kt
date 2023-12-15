package fardev.vergil.my_groups.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fardev.vergil.core_ui.Dimensions
import fardev.vergil.my_groups.ui.widgets.GroupCardItem

@Composable
fun MyGroupsScreen() {
    val groups = listOf(
        "Group 1",
        "Christmas 2023",
        "Mimi's Birthday",
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new Group")
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) { scaffoldPadding ->
        LazyColumn(
            contentPadding = PaddingValues(Dimensions.TWO_UNIT),
            verticalArrangement = Arrangement.spacedBy(Dimensions.ONE_UNIT),
            modifier = Modifier.padding(scaffoldPadding),
        ) {
            items(groups) { group ->
                GroupCardItem(groupName = group)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMyGroupsScreen() {
    MaterialTheme {
        MyGroupsScreen()
    }
}