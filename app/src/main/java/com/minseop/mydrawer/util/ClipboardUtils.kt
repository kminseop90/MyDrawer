package com.minseop.mydrawer.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.minseop.mydrawer.MyDrawerApplication

object ClipboardUtils {

    /// html, jpg, mp3, mp4 등 확장자에 따라서 데이터를 어떻게 분류할지 정한다.

    fun startClipBoardEventCatch(result : (ClipData.Item?) -> Unit) {
        val clipboard = MyDrawerApplication.context.getSystemService(Context.CLIPBOARD_SERVICE)
        (clipboard as ClipboardManager).addPrimaryClipChangedListener {
            result(clipboard.primaryClip?.getItemAt(0))
        }
    }

}