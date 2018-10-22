package com.digitalhouse.digitalhouseapi.controller

import com.digitalhouse.digitalhouseapi.controller.dto.PostDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/posts")
class PostController {

    @GetMapping
    fun get(): List<PostDTO> {
        return arrayListOf(
                PostDTO("Nova turma iniciada","Em setembro começou a nova turma de Marketing Digital", LocalDateTime.now(),"Jose da Silva","https://imgur.com/Ci9D35a"),
                PostDTO("Cardápio do Gran Coffee Atualizado","No espaço de co-working existe um café com diversas opções.", LocalDateTime.now(),"João Ribeiro","https://imgur.com/Yi8C91Z"),
                PostDTO("O poder da nova educação","Tudo está acelerado. As mudanças vêm em ondas, os conceitos sobrepõem-se e é difícil definir o que é temporário, modismo, do que é efetivamente novo e duradouro.", LocalDateTime.now(),"Maria Souza","https://imgur.com/i4Tmmuh"),
                PostDTO("Digital Summit em breve","O digital summit reunirá diversos palestrantes na Digital House", LocalDateTime.now(),"Jose da Silva","https://imgur.com/xxIXUDu")
        )
    }

}