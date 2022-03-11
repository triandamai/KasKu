package app.trian.kasku.ui.pages.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.trian.kasku.R
import app.trian.kasku.ui.Routes
import app.trian.kasku.ui.component.AppbarAuth
import app.trian.kasku.ui.component.ButtonSocial
import app.trian.kasku.ui.component.FormInput
import app.trian.kasku.ui.component.FormInputWithButton
import app.trian.kasku.ui.theme.KasKuTheme
import app.trian.kasku.ui.theme.fontFamily

/**
 *
 * author Trian Damai
 * created_at 09/03/22 - 11.27
 * site https://trian.app
 */
@Composable
fun PageLogin(
    modifier: Modifier = Modifier,
    router: NavHostController
) {


    val annotationStringForgotPassword = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onBackground,
                fontFamily = fontFamily
            )
        ){
            append("Forgot password?")
        }
        append(" ")
        pushStringAnnotation(
            tag = "reset_here",
            annotation = "reset_here"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontFamily = fontFamily
            )
        ){
            append("Reset here")
        }
        pop()
    }

    Scaffold(
        topBar = {
            AppbarAuth(navigationText = "Sign up"){
                router.navigate(Routes.REGISTER)
            }
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.bg_onboard_2),
                    contentDescription = "",
                    modifier = modifier.fillMaxWidth(fraction = 0.5f)
                )
            }
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Login to your account",
                    style = MaterialTheme.typography.body1
                )
                FormInput(
                    placeholder = "name@trian.app",
                    label = "Email",
                    singleLine = true
                )
                FormInputWithButton(
                    placeholder = "your password",
                    label = "password",
                    showPasswordObsecure = true,
                    singleLine = true,
                    onSubmit = {
                        router.navigate(Routes.ADD_BANK)
                    }
                )
            }
            Text(
                text = "or",
                style = MaterialTheme.typography.caption
            )
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonSocial("Login with Google"){
                    router.navigate(Routes.DASHBOARD)
                }
                Spacer(modifier = modifier.height(20.dp))
                ClickableText(
                    text = annotationStringForgotPassword,
                    onClick = {
                            offset->
                        annotationStringForgotPassword.getStringAnnotations(
                            tag = "reset_here",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let { _ ->
                            router.navigate(Routes.RESET_PASSWORD)

                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPageLogin() {
    KasKuTheme {
        PageLogin(router = rememberNavController())
    }
}