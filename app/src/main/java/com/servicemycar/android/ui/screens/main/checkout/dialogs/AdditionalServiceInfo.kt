package com.servicemycar.android.ui.screens.main.checkout.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.servicemycar.android.R
import com.servicemycar.android.ui.helpers.toheight
import com.servicemycar.android.ui.theme.black
import com.servicemycar.android.ui.theme.white
import kotlinx.coroutines.launch

@Composable
fun AdditionalServiceInfoView(
    onDismiss: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(fraction = .90f)
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.large.copy(all = CornerSize(4.dp)),
        color = white
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://d2hucwwplm5rxi.cloudfront.net/wp-content/uploads/2021/12/27164030/Types-of-Car-Service-in-Dubai-Cover-27-12.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                //placeholder = painterResource(R.drawable.bg_placeholder),
                loading = { CircularProgressIndicator() },
                error = {
                    Image(
                        painterResource(R.drawable.bg_placeholder),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                },
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        black.copy(alpha = 0.1f)
                    )
            )
            15.dp.toheight()
            Text(
                stringResource(R.string.dumm_msg_rta_renew),
                style = MaterialTheme.typography.bodyMedium
            )
            15.dp.toheight()
            ElevatedButton(
                onClick = {
                    onDismiss.invoke()
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Ok",
                    style = MaterialTheme.typography.labelSmall.copy(color = white)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun AdditionalServiceInfoViewPreview() {
    AdditionalServiceInfoView()
}

@Composable
fun ShowInfoDialog(showDialog: (show: Boolean) -> Unit) {
    val scope = rememberCoroutineScope()
    Dialog(
        onDismissRequest = {
            showDialog.invoke(false)
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        AdditionalServiceInfoView(onDismiss = {
            scope.launch { }.invokeOnCompletion {
                showDialog.invoke(false)
            }
        })
    }
}