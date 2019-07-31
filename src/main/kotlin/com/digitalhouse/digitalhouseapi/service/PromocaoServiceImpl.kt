package com.digitalhouse.digitalhouseapi.service

import com.digitalhouse.digitalhouseapi.controller.dto.PromocaoDTO
import com.digitalhouse.digitalhouseapi.exception.BadRequestException
import javassist.NotFoundException
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors

@Service
@Scope("singleton")
class PromocaoServiceImpl(
        val id: AtomicInteger = AtomicInteger(),
        var promocaoMap: HashMap<Int, PromocaoDTO> = initializePromocaoMap(id)
) : PromocaoService {

    override fun getPostList(): List<PromocaoDTO> {
        return promocaoMap.values
                .stream()
                .sorted { post1, post2 -> post2.id?.compareTo(post1?.id ?: 0) ?: 0 }
                .collect(Collectors.toList())
    }

    override fun createPost(dto: PromocaoDTO) {
        dto.id = id.get()
        dto.imageUrl = if (dto.imageUrl?.isEmpty() != false) "https://i.imgur.com/Ci9D35a.png" else dto.imageUrl
        promocaoMap[id.getAndIncrement()] = dto
    }

    override fun update(id: Int, dto: PromocaoDTO): PromocaoDTO {
        promocaoMap[id]?.apply {
            descricao = dto.descricao
            preco = dto.preco
            imageUrl = if (dto.imageUrl?.isEmpty() != false) "https://i.imgur.com/Ci9D35a.png" else dto.imageUrl
        }
        return promocaoMap[id] ?: throw NotFoundException("Post com $id não encontrado")
    }

    override fun getPostList(offset: Int, limit: Int): List<PromocaoDTO> {
        var pageLimit = offset + limit

        if (promocaoMap.size < offset) {
            throw BadRequestException("Page unavailable")
        }
        if (promocaoMap.size < offset + limit) {
            pageLimit = promocaoMap.size
        }

        return getPostList()
                .subList(offset, pageLimit)
    }

    override fun getPostList(page: Int): List<PromocaoDTO> {
        val limit = 3
        val offset = page * limit
        return getPostList(offset, limit)
    }

    override fun reset() {
        promocaoMap = initializePromocaoMap(id)
    }

    override fun delete(id: Int): Boolean {
        return promocaoMap.remove(id) != null
    }

}

fun initializePromocaoMap(id: AtomicInteger): HashMap<Int, PromocaoDTO> {
    val map = HashMap<Int, PromocaoDTO>()
    map[id.get()] = PromocaoDTO(id.getAndIncrement(), "Macarrão Barilla 500g", 3.50F, "https://mambo.vteximg.com.br/arquivos/ids/230883/183540_Macarrao-Penne-com-Ovos-Barilla-500g.jpg")
    map[id.get()] = PromocaoDTO(id.getAndIncrement(), "Arroz Camil 5kg", 9.90F, "https://static.carrefour.com.br/medias/sys_master/images/images/hfb/h28/h00/h00/9476860543006.jpg")
    map[id.get()] = PromocaoDTO(id.getAndIncrement(), "Coca-cola lata 350ml", 2.90F, "http://starkaraokeuiuc.net/wp-content/uploads/2017/09/best-sodas-coca-cola.jpg")

    return map
}
