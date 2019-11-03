package com.minseop.mydrawer.util

import android.content.ClipboardManager
import android.content.Context
import com.minseop.mydrawer.MyDrawerApplication
import com.minseop.mydrawer.service.clipboard.ClipboardType

object ClipboardUtils {

    /// html, jpg, mp3, mp4 등 확장자에 따라서 데이터를 어떻게 분류할지 정한다.

    fun startClipBoardEventCatch(result : (String?, ClipboardType) -> Unit) {
        val clipboard = MyDrawerApplication.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.addPrimaryClipChangedListener {
            val clipData = clipboard.primaryClip
            val clipItem = clipData?.getItemAt(0)
            val text = clipItem?.text.toString()
            result(text, getContentFormat(text))
        }
    }


    fun getContentFormat(text: String) : ClipboardType {
        val extensionWord = getExtension(text)

        for(type in ClipboardType.values()) {
            for(detailType in type.value) {
                if(extensionWord == detailType) {
                    com.orhanobut.logger.Logger.d(type)
                    return type
                }
            }
        }
        return ClipboardType.PAGE
    }

    fun getExtension(text: String): String {
        val dotLastIndex = text.lastIndexOf(".")
        return text.substring(dotLastIndex + 1)
    }

}