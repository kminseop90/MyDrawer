package com.minseop.mydrawer.service.clipboard

enum class ClipboardType(val value: Array<String>) {
    VIDEO(arrayOf("mp4")),
    MUSIC(arrayOf("mp3")),
    IMAGE(arrayOf("jpg")),
    PAGE(arrayOf("")),
}