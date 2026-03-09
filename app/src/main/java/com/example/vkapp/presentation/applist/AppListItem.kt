package com.example.vkapp.presentation.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.vkapp.R
import com.example.vkapp.domain.applist.AppListItem
import com.example.vkapp.presentation.common.title


@Composable
fun AppListItem(
    appListItem: AppListItem,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
            .clickable { onClick(appListItem.id) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(appListItem.iconUrl)
                .crossfade(true).build(),
            contentDescription = appListItem.name,
            contentScale = ContentScale.Crop,
            error = ColorPainter(colorScheme.primaryContainer),
            placeholder = painterResource(R.drawable.loading_img),
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp)),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = appListItem.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = appListItem.shortDescription,
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = appListItem.category.title(),
                style = MaterialTheme.typography.labelMedium,
                color = colorScheme.outline,
            )
        }
    }
}

@Preview
@Composable
private fun AppListItemPreview() {
    AppListItem(
        appListItem = AppListItem(
            id = "1",
            name = "Приложение 1",
            iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
            shortDescription = "Краткое описание приложения 1",
            category = com.example.vkapp.domain.common.Category.APP
        ),
        onClick = {}
    )
}