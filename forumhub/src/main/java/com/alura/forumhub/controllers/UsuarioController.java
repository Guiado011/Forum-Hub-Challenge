package com.alura.forumhub.controllers;

import com.alura.forumhub.domain.usuario.DadosUsuario;
import com.alura.forumhub.domain.usuario.Usuario;
import com.alura.forumhub.domain.usuario.UsuarioRepository;
import com.alura.forumhub.infra.security.DadosToken;
import com.alura.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping("/login")
    public ResponseEntity fazerLogin(@RequestBody @Valid DadosUsuario dados){
        var userAuthentication = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(userAuthentication).getPrincipal();
        var token = service.gerarToken((Usuario) authentication);
        return ResponseEntity.ok(new DadosToken(token));
    }

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody @Valid DadosUsuario dados, UriComponentsBuilder uriComponentsBuilder){
        var senhaCriptografada = new BCryptPasswordEncoder().encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCriptografada);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        repository.save(usuario);
        return ResponseEntity.created(uri).body(new DadosUsuario(usuario));
    }
}
