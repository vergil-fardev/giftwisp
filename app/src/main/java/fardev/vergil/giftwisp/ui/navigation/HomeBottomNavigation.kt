package fardev.vergil.giftwisp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import fardev.vergil.giftwisp.R

data class HomeBottomNavigation(
    val icon: ImageVector,
    @StringRes val label: Int,
    val route: String,
)

object HomeBottomNavigationItems {
    fun getItems(): List<HomeBottomNavigation> = listOf(
        HomeBottomNavigation(
            icon = Icons.Default.Home,
            label = R.string.label_home,
            route = Screens.Home.routeName,
        ),
        HomeBottomNavigation(
            icon = Icons.Default.Settings,
            label = R.string.label_settings,
            route = Screens.Settings.routeName,
        ),
    )
}

sealed class Screens(val routeName: String) {
    data object Home: Screens(routeName = "home")
    data object Settings: Screens(routeName = "settings")
}