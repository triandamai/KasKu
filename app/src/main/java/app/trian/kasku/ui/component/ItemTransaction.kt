package app.trian.kasku.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.kasku.R
import app.trian.kasku.ui.theme.DisableColor
import app.trian.kasku.ui.theme.DisableContentColor
import app.trian.kasku.ui.theme.KasKuTheme

/**
 *
 * author Trian Damai
 * created_at 09/03/22 - 20.03
 * site https://trian.app
 */

@Composable
fun ItemTransaction(
    modifier: Modifier=Modifier,
    onClick:()->Unit={}
) {
    val ctx = LocalContext.current
    val currentWidth = ctx
        .resources
        .displayMetrics.widthPixels.dp /
            LocalDensity.current.density
    val cardHeight = currentWidth / 5 - 10.dp
    Row(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 30.dp,
                vertical = 10.dp
            )
            .fillMaxWidth()
            .height(cardHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = modifier
                .size(currentWidth / 6)
                .clip(CircleShape)
                .background(DisableColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_category_autonomous_car),
                contentDescription ="",
                modifier = modifier
                    .size(cardHeight - cardHeight / 3)
            )
        }
        Spacer(modifier = modifier.width(10.dp))
        Column(
            modifier= modifier
                .height(cardHeight)
                .width(currentWidth - cardHeight),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "Grauthier Drewit",
                        style = MaterialTheme.typography.body2.copy(

                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = "Fri 12AM",
                        style = MaterialTheme.typography.caption.copy(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                }
                Text(
                    text = "Rp 100.000",
                    style = MaterialTheme.typography.body2.copy(
                        color = MaterialTheme.colors.secondary
                    )
                )
            }
            Divider()
        }

    }
}

@Composable
fun ItemTotalTransaction(
    modifier: Modifier=Modifier
) {
    val ctx = LocalContext.current
    val currentWidth = ctx
        .resources
        .displayMetrics.widthPixels.dp /
            LocalDensity.current.density
    val cardHeight = currentWidth / 5 - 10.dp
    Row(
        modifier = modifier
            .padding(
                horizontal = 30.dp,
                vertical = 10.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = modifier
                .width(currentWidth / 6)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
        Spacer(modifier = modifier.width(10.dp))
        Row(
            modifier = modifier
                .width(currentWidth - cardHeight),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total",
                style = MaterialTheme.typography.body2.copy(
                    color = DisableContentColor
                )
            )
            Text(
                text = "Rp 100.000",
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }
}

@Preview
@Composable
fun PreviewItemTransaction() {
    KasKuTheme {
        Column {
            ItemTransaction()
            ItemTotalTransaction()
        }

    }
}