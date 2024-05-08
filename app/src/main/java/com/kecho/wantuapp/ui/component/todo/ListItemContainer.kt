package com.kecho.wantuapp.ui.component.todo

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    onUpdateClick: (model: TodoModel) -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxWidth()
            .heightIn(if (isExpanded) 0.dp else 100.dp)
            .animateContentSize()
            .clickable { onClick(todo.uid) }
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = if (todo.isDone) R.drawable.baseline_check_circle_24 else R.drawable.baseline_check_circle_outline_24),
            contentDescription = null,
            tint = if (todo.isDone) Color.Green else Color.Red,
        )

        // 내용
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(30.dp)
                .align(Alignment.CenterVertically)
                .clickable { isExpanded = !isExpanded },
        ) {
            Text(
                todo.memo,
                modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically),
                color = if (todo.isDone) Color.Gray else Color.Black,
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = TextStyle(textDecoration = if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None),
            )
            val format = SimpleDateFormat("yyyy-MM-dd (EEE)", Locale.KOREA)

            Text(
                format.format(Date(todo.date)),
                color = if (todo.isDone) Color.Gray else Color.Black,
                style = TextStyle(textDecoration = if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None),
            )
        }

        // 수정 아이콘
        Icon(
            modifier = Modifier
                .padding(10.dp)
                .clickable { onUpdateClick(todo) },
            painter = painterResource(id = R.drawable.baseline_pinch_24),
            contentDescription = null,
            tint = Color.Black
        )

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
