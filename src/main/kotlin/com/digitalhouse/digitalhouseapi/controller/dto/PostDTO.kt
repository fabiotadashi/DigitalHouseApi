package com.digitalhouse.digitalhouseapi.controller.dto

import java.time.LocalDateTime

data class PostDTO(
        var id: Int?,
        var title: String,
        var description: String,
        var date: LocalDateTime?,
        var author: String,
        var imageUrl: String?
)