package com.minseop.mydrawer.service.clipboard

enum class ContentType(val index: Int, val value: Array<String>) {
    PAGE(0, arrayOf("")),
    IMAGE(1, arrayOf("jpg", "png")),
    MUSIC(2, arrayOf("mp3")),
    VIDEO(3, arrayOf("mp4")),
}