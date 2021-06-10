package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.data.users
import com.example.composeplayground.domain.User
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AuthorInfoSection(author = users[0])
                }
            }
        }
    }
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
            modifier = Modifier.align(CenterVertically)
        )
        IconButton(
            modifier = Modifier.align(CenterVertically),
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
