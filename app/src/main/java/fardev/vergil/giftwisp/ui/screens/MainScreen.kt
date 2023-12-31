package fardev.vergil.giftwisp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fardev.vergil.giftwisp.ui.navigation.HomeBottomNavigationItems
import fardev.vergil.giftwisp.ui.navigation.Screens
import fardev.vergil.giftwisp.ui.theme.GiftWispTheme
import fardev.vergil.my_groups.ui.screens.MyGroupsScreen
import fardev.vergil.my_list.ui.screens.MyListScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { HomeBottomBar(navController) }
    ) { scaffoldPadding ->
        HomeContent(navController = navController, scaffoldPadding = scaffoldPadding)
    }
}

@Composable
private fun HomeContent(navController: NavHostController, scaffoldPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.routeName,
        modifier = Modifier.padding(scaffoldPadding)
    ) {
        composable(Screens.Home.routeName) {
            MyGroupsScreen()
        }
        composable(Screens.MyList.routeName) {
            MyListScreen()
        }
        composable(Screens.Settings.routeName) {
            Text("Oi")
        }
    }
}

@Composable
private fun HomeBottomBar(navController: NavHostController) {
    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    NavigationBar {
        HomeBottomNavigationItems.getItems().mapIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedTab,
                onClick = {
                    if(selectedTab == index)
                        return@NavigationBarItem
                    selectedTab = index
                    navController.navigate(item.route)
                },
                label = { Text(text = stringResource(id = item.label)) },
                icon = { Icon(imageVector = item.icon, contentDescription = null) },
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    GiftWispTheme {
        MainScreen()
    }
}