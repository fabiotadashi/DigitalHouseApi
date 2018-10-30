package com.digitalhouse.digitalhouseapi.controller

import com.digitalhouse.digitalhouseapi.controller.dto.PostDTO
import com.digitalhouse.digitalhouseapi.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController {

    @Autowired
    lateinit var service: PostService

    @GetMapping
    fun get(): List<PostDTO> {
        return service.getPostList()
    }

    @PostMapping
    fun post(@RequestBody dto: PostDTO): PostDTO {
        service.createPost(dto)
        return dto
    }

    @PostMapping("/reset")
    fun reset() {
        service.reset()
    }

}
