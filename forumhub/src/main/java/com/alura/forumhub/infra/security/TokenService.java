package com.alura.forumhub.infra.security;

import com.alura.forumhub.domain.topico.validacao.ValidacaoException;
import com.alura.forumhub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.key.secret}")
    private String KEY_SECRET;

    public String gerarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(KEY_SECRET);
            return JWT.create()
                    .withIssuer("forum hub api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(expiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException e) {
            throw new ValidacaoException("Erro ao gerar token!");
        }
    }

    public String getSubject(String token){
       try {
           var algoritmo = Algorithm.HMAC256(KEY_SECRET);
           return JWT.require(algoritmo)
                   .withIssuer("forum hub api")
                   .build()
                   .verify(token)
                   .getSubject();

       } catch (JWTVerificationException e) {
           throw new ValidacaoException("Token inválido!");
       }
    }

    private Instant expiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
