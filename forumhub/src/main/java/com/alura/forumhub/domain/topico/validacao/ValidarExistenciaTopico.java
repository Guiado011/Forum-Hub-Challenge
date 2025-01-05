package com.alura.forumhub.domain.topico.validacao;

import com.alura.forumhub.domain.topico.Topico;
import com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarExistenciaTopico {

    @Autowired
    private TopicoRepository repository;

    public void validar(Topico topico){

        var topicoExiste = repository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem());

        if(topicoExiste.isPresent()){
            throw new ValidacaoException("Esse tópico já existe no banco de dados!");
        }
    }
}
