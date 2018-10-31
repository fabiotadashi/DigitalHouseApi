package com.digitalhouse.digitalhouseapi.service

import com.digitalhouse.digitalhouseapi.controller.dto.PostDTO
import javassist.NotFoundException
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors

@Service
@Scope("singleton")
class PostServiceImpl(
        val id: AtomicInteger = AtomicInteger(),
        var postMap: HashMap<Int, PostDTO> = initializeMap(id)
) : PostService {

    override fun getPostList(): List<PostDTO> {
        return postMap.values
                .stream()
                .sorted { post1, post2 -> post2.date?.compareTo(post1.date) ?: 0 }
                .collect(Collectors.toList())
    }

    override fun createPost(dto: PostDTO) {
        dto.date = LocalDateTime.now()
        dto.id = id.getAndIncrement()
        dto.imageUrl = if (dto.imageUrl?.isEmpty() != false) "https://i.imgur.com/Ci9D35a.png" else dto.imageUrl
        postMap[id.get()] = dto
    }

    override fun update(id: Int, dto: PostDTO): PostDTO {
        postMap[id]?.apply {
            title = dto.title
            description = dto.description
            date = LocalDateTime.now()
            author = dto.author
            imageUrl = if (dto.imageUrl?.isEmpty() != false) "https://i.imgur.com/Ci9D35a.png" else dto.imageUrl
        }
        return postMap[id] ?: throw NotFoundException("Post com $id não encontrado")
    }

    override fun reset() {
        postMap = initializeMap(id)
    }

    override fun delete(id: Int): Boolean {
        return postMap.remove(id) != null
    }

}

fun initializeMap(id: AtomicInteger): HashMap<Int, PostDTO> {
    val map = HashMap<Int, PostDTO>()
    map[id.get()] = PostDTO(id.getAndIncrement(), "Nova turma iniciada", "Em setembro começou a nova turma de Marketing Digital", LocalDateTime.now(), "Jose da Silva", "https://imgur.com/Ci9D35a.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "Cardápio do Gran Coffee Atualizado", "No espaço de co-working existe um café com diversas opções.", LocalDateTime.now(), "João Ribeiro", "https://imgur.com/Yi8C91Z.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "O poder da nova educação", "Tudo está acelerado. As mudanças vêm em ondas, os conceitos sobrepõem-se e é difícil definir o que é temporário, modismo, do que é efetivamente novo e duradouro.", LocalDateTime.now(), "Maria Souza", "https://imgur.com/i4Tmmuh.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "Digital Summit em breve", "O digital summit reunirá diversos palestrantes na Digital House", LocalDateTime.now(), "Jose da Silva", "https://imgur.com/xxIXUDu.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "Novas turmas de Mobile para 2019", "No ano de 2019 teremos mais turmas para desenvolvimento mobile. Confira mais em nosso site!", LocalDateTime.now(), "João Ribeiro", "https://imgur.com/Yi8C91Z.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "Recomende a Digital House", "Tem amigos que compartilham do desejo de aprender e inovar? Recomende vir com a gente para ajudarmos na sua caminhada de aprendizado.", LocalDateTime.now(), "Maria Souza", "https://imgur.com/i4Tmmuh.png")
    map[id.get()] = PostDTO(id.getAndIncrement(), "Nova escala dos professores assistentes", "Você que frequenta o colearning, confira quando os professores estarão disponíveis de acordo com as escalas. O colearning funciona das 14h às 22h.", LocalDateTime.now(), "Jose da Silva", "https://imgur.com/xxIXUDu.png")

    return map
}
