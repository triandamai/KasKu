package app.trian.kasku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import app.trian.kasku.domain.BudgetType
import app.trian.kasku.ui.Routes
import app.trian.kasku.ui.pages.auth.*
import app.trian.kasku.ui.pages.bank.PageAddBank
import app.trian.kasku.ui.pages.bank.PageAddBankSuccess
import app.trian.kasku.ui.pages.budget.PageCreateBudget
import app.trian.kasku.ui.pages.category.PageAddCategory
import app.trian.kasku.ui.pages.category.PageListCategory
import app.trian.kasku.ui.pages.dashboard.PageBudget
import app.trian.kasku.ui.pages.dashboard.PageDaily
import app.trian.kasku.ui.pages.dashboard.PageHome
import app.trian.kasku.ui.pages.dashboard.PageProfile
import app.trian.kasku.ui.pages.settings.PageSetting
import app.trian.kasku.ui.pages.stat.PageStat
import app.trian.kasku.ui.pages.transaction.PageAddTransaction
import app.trian.kasku.ui.pages.transaction.PageAddTransactionSuccess
import app.trian.kasku.ui.pages.transaction.PageDetailTransaction
import app.trian.kasku.ui.theme.KasKuTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import logcat.LogPriority
import logcat.logcat

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            KasKuTheme {
                val router = rememberAnimatedNavController()
                val systemUI = rememberSystemUiController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                   AnimatedNavHost(
                       navController = router,
                       startDestination = Routes.SPLASH
                   ){
                       composable(Routes.SPLASH){
                           val uiColor = MaterialTheme.colors.primary
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = false
                           )
                           PageSplashScreen(router = router)
                       }
                       composable(
                           Routes.ONBOARD,
                           enterTransition = {
                               fadeIn()
                           },
                           exitTransition = {
                               fadeOut()
                           }
                       ){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageOnboard(router = router)
                       }
                       composable(Routes.LOGIN){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageLogin(router = router)
                       }
                       composable(Routes.REGISTER){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageRegister(router = router)
                       }
                       composable(Routes.CHANGE_PASSWORD){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageChangePassword(router = router)
                       }
                       composable(Routes.RESET_PASSWORD){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageResetPassword(router = router)
                       }

                       composable(Routes.ADD_BANK){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageAddBank(router = router)
                       }
                       composable(
                           Routes.ADD_BANK_SUCCESS,
                           enterTransition = {
                               slideInVertically {
                                   it
                               }
                           },
                           exitTransition = {
                               slideOutVertically { it }
                           }
                       ){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageAddBankSuccess(router = router)
                       }
                       navigation(
                           route = Routes.DASHBOARD,
                           startDestination = Routes.Dashboard.HOME
                       ){

                           composable(Routes.Dashboard.HOME){
                               val uiColor = MaterialTheme.colors.surface
                               systemUI.setSystemBarsColor(
                                   color = uiColor,
                                   darkIcons = true
                               )
                               PageHome(router = router)
                           }
                           composable(Routes.Dashboard.DAILY){
                               val uiColor = MaterialTheme.colors.surface
                               systemUI.setSystemBarsColor(
                                   color = uiColor,
                                   darkIcons = true
                               )
                               PageDaily(router = router)

                           }
                           composable(Routes.Dashboard.BUDGET){
                               val uiColor = MaterialTheme.colors.surface
                               systemUI.setSystemBarsColor(
                                   color = uiColor,
                                   darkIcons = true
                               )

                               PageBudget(router = router)
                           }
                           composable(Routes.Dashboard.PROFILE){
                               val uiColor = MaterialTheme.colors.surface
                               systemUI.setSystemBarsColor(
                                   color = uiColor,
                                   darkIcons = true
                               )
                               PageProfile(router = router)

                           }
                       }
                       composable(Routes.STAT_EXPENSE){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageStat(
                               router = router,
                               type = BudgetType.EXPENSE
                           )
                       }
                       composable(Routes.STAT_INCOME){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageStat(
                               router = router,
                               type = BudgetType.INCOME
                           )
                       }
                       composable(Routes.CREATE_BUDGET){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageCreateBudget(
                               router = router,
                           )
                       }
                       composable(Routes.DETAIL_TRANSACTION){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageDetailTransaction(router = router)
                       }
                       composable(
                           Routes.ADD_TRANSACTION,
                           enterTransition = {
                               slideInVertically {
                                   it
                               }

                           },
                           exitTransition = {
                               slideOutVertically {
                                   it
                               }
                           }
                       ){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageAddTransaction(router = router)
                       }
                       composable(
                           Routes.ADD_TRANSACTION_SUCCESS,
                           enterTransition = {
                               slideInVertically {
                                   it
                               }
                           },
                           exitTransition = {
                               slideOutVertically { it }
                           }
                       ){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageAddTransactionSuccess(router = router)
                       }
                       composable(Routes.LIST_CATEGORY){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageListCategory(router = router)
                       }
                       composable(Routes.ADD_CATEGORY){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageAddCategory(router = router)
                       }
                       composable(Routes.SETTINGS){
                           val uiColor = MaterialTheme.colors.surface
                           systemUI.setSystemBarsColor(
                               color = uiColor,
                               darkIcons = true
                           )
                           PageSetting(router = router)
                       }
                   }
                }
            }
        }
    }
}

