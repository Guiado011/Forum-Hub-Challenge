package com.alura.forumhub.domain.topico.validacao;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
