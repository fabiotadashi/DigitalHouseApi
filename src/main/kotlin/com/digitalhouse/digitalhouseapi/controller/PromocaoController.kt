package com.digitalhouse.digitalhouseapi.controller

import com.digitalhouse.digitalhouseapi.controller.dto.PromocaoDTO
import com.digitalhouse.digitalhouseapi.exception.NotFoundException
import com.digitalhouse.digitalhouseapi.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/promocoes")
class PromocaoController {

    @Autowired
    lateinit var service: PromocaoService

    @GetMapping
    fun get(): List<PromocaoDTO> {
        return service.getPostList()
    }

    @GetMapping("/page")
    fun get(@RequestParam("offset") offset: Int,
            @RequestParam("limit") limit: Int): List<PromocaoDTO> {
        return service.getPostList(offset, limit)
    }

    @GetMapping("/page-number")
    fun get(@RequestParam("page") page: Int): List<PromocaoDTO> {
        return service.getPostList(page)
    }

    @PostMapping
    fun post(@RequestBody dto: PromocaoDTO): PromocaoDTO {
        service.createPost(dto)
        return dto
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        if (!service.delete(id)) {
            throw NotFoundException("Post not found")
        }
    }

    @PostMapping("/reset")
    fun reset() {
        service.reset()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int,
               @RequestBody dto: PromocaoDTO): PromocaoDTO {
        return service.update(id, dto)
    }

}
