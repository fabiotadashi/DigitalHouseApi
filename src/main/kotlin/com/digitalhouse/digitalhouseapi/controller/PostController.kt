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
                PostDTO("Nova turma iniciada","Em setembro começou a nova turma de Marketing Digital", LocalDateTime.now(),"Jose da Silva","http://www.meioemensagem.com.br/wp-content/uploads/2018/05/SalaAula_575.png"),
                PostDTO("Cardápio do Gran Coffee Atualizado","No espaço de co-working existe um café com diversas opções.", LocalDateTime.now(),"João Ribeiro","https://www.digitalhouse.com/wp-content/uploads/2016/11/campus_img7.jpg"),
                PostDTO("O poder da nova educação","Tudo está acelerado. As mudanças vêm em ondas, os conceitos sobrepõem-se e é difícil definir o que é temporário, modismo, do que é efetivamente novo e duradouro.", LocalDateTime.now(),"Maria Souza","http://vmv.group/wp-content/uploads/2018/07/IMG_8619-2.jpg"),
                PostDTO("Digital Summit em breve","O digital summit reunirá diversos palestrantes na Digital House", LocalDateTime.now(),"Jose da Silva","https://www.digitalhouse.com/wp-content/uploads/2017/11/digital-su-643697.png")
        )
    }

}