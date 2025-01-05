package com.alura.forumhub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime dataCriacao;
    private String autor;
    private String curso;

    public Topico(DadosCriacaoTopico dados) {
        this(null, dados.titulo(), dados.mensagem(), Status.NAO_RESPONDIDO, LocalDateTime.now(), dados.autor(), dados.curso());
    }

    public void editarTopico(Topico topico) {
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.status = Status.EDITADO;
    }
}
