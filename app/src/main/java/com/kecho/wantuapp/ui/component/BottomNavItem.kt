package com.kecho.wantuapp.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kecho.wantuapp.R
import com.kecho.wantuapp.utils.Constant.BUCKET_LIST
import com.kecho.wantuapp.utils.Constant.TODO_LIST

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val screenRoute: String) {
    object Todo : BottomNavItem(R.string.txt_todo, R.drawable.baseline_playlist_add_check_24, TODO_LIST)
    object BucketList : BottomNavItem(R.string.txt_bucket, R.drawable.baseline_favorite_24, BUCKET_LIST)
}