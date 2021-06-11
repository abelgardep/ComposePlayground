package com.example.composeplayground.presentation.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.R
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.data.users
import com.example.composeplayground.domain.Post
import com.example.composeplayground.domain.User
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme


@Composable
fun PostItem(
    post: Post
) {
    Column {
        AuthorInfoSection(author = post.author)
        PostImage(imageId = post.postImageId)
        IconSection()
    }
}

@Composable
fun PostImage(
    imageId: Int
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AuthorInfoSection(
    author: User
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RowImageWithText(
            imageId = author.avatarId,
            text = author.name,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = {/* TODO */ }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
            )
        }
    }
}

/**
 * We will use the icons available in compose material icons. If we need more,
 * we could check https://developer.android.com/jetpack/compose/resources#icons
 * We could add a library with more icons, or add them to the project via drawable,
 * but since this is just an example, we will keep it simple.
 */
@Composable
fun IconSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            var fav by remember { mutableStateOf(false) }
            IconToggleButton(checked = fav, onCheckedChange = { fav = it }) {
                val icon = if (fav) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
                val tint = if (fav) Color.Red else MaterialTheme.colors.onBackground
                Icon(
                    imageVector = icon,
                    tint = tint,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.MailOutline,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_border),
                contentDescription = null
            )
        }
    }
}

@Composable
fun RowImageWithText(
    imageId: Int,
    text: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imageId),
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            modifier = modifier
                .padding(8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    ComposePlaygroundTheme {
        PostItem(initialPosts.first())
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemBigPreview() {
    ComposePlaygroundTheme {
        PostItem(initialPosts[1])
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemDarkPreview() {
    ComposePlaygroundTheme(darkTheme = true) {
        PostItem(initialPosts.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionPreview() {
    ComposePlaygroundTheme {
        AuthorInfoSection(users.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionDarkPreview() {
    ComposePlaygroundTheme(darkTheme = true) {
        AuthorInfoSection(users.first())
    }
}
