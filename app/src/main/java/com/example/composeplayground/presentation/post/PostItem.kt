package com.example.composeplayground.presentation.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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