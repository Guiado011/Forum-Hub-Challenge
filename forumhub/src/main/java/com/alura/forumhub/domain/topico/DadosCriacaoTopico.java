package com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCriacaoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
