package com.alura.forumhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuario(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
        public DadosUsuario(Usuario usuario) {
                this(usuario.getLogin(), usuario.getSenha());
        }
}
