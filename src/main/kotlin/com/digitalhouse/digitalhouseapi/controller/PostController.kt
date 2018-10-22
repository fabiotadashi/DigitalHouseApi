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
                PostDTO("Nova turma iniciada","Em setembro começou a nova turma de Marketing Digital", LocalDateTime.now(),"Jose da Silva","https://imgur.com/Ci9D35a.png"),
                PostDTO("Cardápio do Gran Coffee Atualizado","No espaço de co-working existe um café com diversas opções.", LocalDateTime.now(),"João Ribeiro","https://imgur.com/Yi8C91Z.png"),
                PostDTO("O poder da nova educação","Tudo está acelerado. As mudanças vêm em ondas, os conceitos sobrepõem-se e é difícil definir o que é temporário, modismo, do que é efetivamente novo e duradouro.", LocalDateTime.now(),"Maria Souza","https://imgur.com/i4Tmmuh.png"),
                PostDTO("Digital Summit em breve","O digital summit reunirá diversos palestrantes na Digital House", LocalDateTime.now(),"Jose da Silva","https://imgur.com/xxIXUDu.png")
                PostDTO("Novas turmas de Mobile para 2019","No ano de 2019 teremos mais turmas para desenvolvimento mobile. Confira mais em nosso site!", LocalDateTime.now(),"João Ribeiro","https://imgur.com/Yi8C91Z.png"),
                PostDTO("Recomende a Digital House","Tem amigos que compartilham do desejo de aprender e inovar? Recomende vir com a gente para ajudarmos na sua caminhada de aprendizado.", LocalDateTime.now(),"Maria Souza","https://imgur.com/i4Tmmuh.png"),
                PostDTO("Nova escala dos professores assistentes","Você que frequenta o colearning, confira quando os professores estarão disponíveis de acordo com as escalas. O colearning funciona das 14h às 22h.", LocalDateTime.now(),"Jose da Silva","https://imgur.com/xxIXUDu.png")
        )
    }

}
