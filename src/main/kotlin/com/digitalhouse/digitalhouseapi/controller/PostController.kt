package com.digitalhouse.digitalhouseapi.controller

import com.digitalhouse.digitalhouseapi.controller.dto.PostDTO
import com.digitalhouse.digitalhouseapi.exception.NotFoundException
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

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Int) {
        if(!service.delete(id)){
            throw NotFoundException("Post not found")
        }
    }

    @PostMapping("/reset")
    fun reset() {
        service.reset()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id : Int,
               @RequestBody dto: PostDTO) : PostDTO{
        return service.update(id, dto)
    }

}
