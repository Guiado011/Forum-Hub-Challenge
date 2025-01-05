package com.alura.forumhub.domain.topico;

import com.alura.forumhub.domain.topico.validacao.ValidarExistenciaTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private ValidarExistenciaTopico validador;

    public Topico criarTopico(DadosCriacaoTopico dados) {
        var topico = new Topico(dados);

        validador.validar(topico);

        return topico;
    }

    public Topico editarTopico(DadosEdicaoTopico dados, Topico topico) {

        var topicoEditado = new Topico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getStatus(), topico.getDataCriacao(), topico.getAutor(), topico.getCurso());

        if(dados.titulo() != null){
            topicoEditado.setTitulo(dados.titulo());
        }

        if(dados.mensagem() != null){
            topicoEditado.setMensagem(dados.mensagem());
        }

        validador.validar(topicoEditado);

        return topicoEditado;
    }
}
