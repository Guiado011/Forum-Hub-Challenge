# Fórum Hub API

Este repositório contém a solução para o challenge da formação **Java e Spring Framework do programa ONE**.
O objetivo deste desafio foi desenvolver uma API com endpoints para gerenciamento de tópicos e autenticação de usuários com token JWT.

## Sobre

O desafio propôs o desenvolvimento de uma API com endpoints públicos para autenticação do usuário, e rotas privadas para gerenciamento de tópicos,
possibilitando realizar operações CRUD (CRIAR, LER, ATUALIZAR, DELETAR). Essas operações devem interagir com o banco de dados para o gerenciamento dos dados.

## Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java** 21
- **Spring Boot**
- **Spring Security** (para autenticação JWT)
- **Swagger** (para documentação e interação com a API)
- **MySQL** (Banco de Dados)
- **IDE**: IntelliJ IDEA
- **Postman** (para testes das APIs)

## Funcionalidades

O projeto tem as seguintes funcionalidades:

- Criar usuário
- Autenticação com JWT
- Criar tópicos
- Buscar os tópicos cadastrados no banco de dados
- Detalhar um tópico cadastrado no banco de dados
- Editar informações de tópicos
- Excluir tópicos

## Como Rodar o Projeto

Para rodar este projeto localmente, siga os seguintes passos:

### 1. Clonar o repositório:

```bash
  git clone https://github.com/Guiado011/Forum-Hub-Challenge.git
```

### 2. Criar o Banco de Dados e configurar a conexão:

```bash
  CREATE DATABASE forum_hub;
```

No arquivo `application.properties`, configure a conexão com o Banco de Dados e altere o valor da variável `key_secret`:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

api.key.secret=${key}

```

### 3. Execute o projeto:

```bash
mvn install

```

### 4. Teste a API fazendo requisições:

O projeto está utilizando o **Swagger** para documentação e interação com a API. Basta acessar no seu navegador:

```bash
http://localhost:8080/swagger-ui/index.html#/

```

Ou, se preferir, use uma ferramenta de sua preferência como **Postman** ou **Insomnia** para realizar as requisições.

### Endpoints da API:

- **POST** `/usuarios`: Para cadastrar um novo usuário.
- **POST** `/usuarios/login`: Para realizar a autenticação.
- **POST** `/topicos`: Para criar um novo tópico.
- **GET** `/topicos`: Para listar os tópicos.
- **GET** `/topicos/{id}`: Para detalhamento de um tópico.
- **PUT** `/topicos/{id}`: Para edição de um tópico.
- **DELETE** `/topicos/{id}`: Para exclusão de um tópico.
