package com.digitalhouse.digitalhouseapi.service

import com.digitalhouse.digitalhouseapi.controller.dto.PostDTO

interface PostService {

    fun getPostList() : List<PostDTO>
    fun createPost(dto: PostDTO)
    fun reset()
    fun delete(id: Int): Boolean
    fun update(id: Int, dto: PostDTO): PostDTO
    fun getPostList(offset: Int, limit: Int): List<PostDTO>
    fun getPostList(page: Int): List<PostDTO>

}