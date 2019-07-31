package com.digitalhouse.digitalhouseapi.service

import com.digitalhouse.digitalhouseapi.controller.dto.PromocaoDTO

interface PromocaoService {

    fun getPostList() : List<PromocaoDTO>
    fun createPost(dto: PromocaoDTO)
    fun reset()
    fun delete(id: Int): Boolean
    fun update(id: Int, dto: PromocaoDTO): PromocaoDTO
    fun getPostList(offset: Int, limit: Int): List<PromocaoDTO>
    fun getPostList(page: Int): List<PromocaoDTO>

}