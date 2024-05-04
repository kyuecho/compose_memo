package com.kecho.wantuapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.kecho.wantu.domain.model.TodoModel
import com.kecho.wantuapp.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ListItemContainer(
    todo: TodoModel,
    onClick: (todo: Int) -> Unit = {},
    onDeleteClick: (id: Int) -> Unit = {},
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onClick(todo.uid) }
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(20.dp),
            painter = painterResource(id = if (todo.isDone) R.drawable.baseline_check_circle_24 else R.drawable.baseline_check_circle_outline_24),
            contentDescription = null,
            tint = if (todo.isDone) Color.Green else Color.Red,
        )

        // 내용
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                todo.memo,
                color = if (todo.isDone) Color.Gray else Color.Black,
                maxLines = 1,
                style = TextStyle(textDecoration = if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None),
            )
            val format = SimpleDateFormat("yyyy-MM-dd (EEE)", Locale.KOREA)
            Text(
                format.format(Date(todo.date)),
                color = if (todo.isDone) Color.Gray else Color.Black,
                style = TextStyle(textDecoration = if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None),
            )
        }

        // 삭제 아이콘
        Icon(
            modifier = Modifier
                .padding(20.dp)
                .clickable { onDeleteClick(todo.uid) },
            painter = painterResource(id = R.drawable.baseline_delete_24),
            contentDescription = null,
            tint = Color.Black
        )
    }

}
