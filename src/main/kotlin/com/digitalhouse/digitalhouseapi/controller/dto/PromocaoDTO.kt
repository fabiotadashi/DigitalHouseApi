package com.digitalhouse.digitalhouseapi.controller.dto

import java.time.LocalDateTime

data class PromocaoDTO(
        var id: Int?,
        var descricao: String,
        var preco: Float,
        var imageUrl: String?
)