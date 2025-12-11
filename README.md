# 📚 LibraryMS

Este é um projeto de **sistema de gerenciamento de biblioteca** desenvolvido em **Java com Spring Boot**.

---

## 📖 Visão Geral

O **LibraryMS** é uma aplicação que permite o gerenciamento de livros, usuários e empréstimos em uma biblioteca.  
Ele oferece funcionalidades para:

- 📘 Cadastro e consulta de **livros**  
- 👤 Cadastro e consulta de **usuários**  
- 🔄 Registro e controle de **empréstimos e devoluções**

---

## 🛠️ Tecnologias Utilizadas

- ☕ **Java** – Linguagem de programação principal  
- 🚀 **Spring Boot** – Framework para construção de aplicações Java robustas e escaláveis  
- 📦 **Maven** – Automação de build e gerenciamento de dependências  
- 🗄️ **H2 Database** – Banco de dados em memória para desenvolvimento e testes (configurável para outros bancos)

---

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão de uma aplicação **Spring Boot**:

````
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── codingSamurai
│   │   │           └── libraryMS
│   │   │               ├── controllers
│   │   │               ├── dto
│   │   │               ├── entities
│   │   │               ├── repositories
│   │   │               └── services
│   │   └── resources
│   └── test
│       └── java
│           └── com
│               └── codingSamurai
│                   └── libraryMS
└── pom.xml
````

# Principais diretórios

controllers/: Controladores REST que lidam com as requisições HTTP

dto/: Objetos de transferência de dados (DTOs) usados entre camadas

entities/: Entidades de domínio que representam tabelas do banco

repositories/: Interfaces de repositório com Spring Data JPA

services/: Lógica de negócio da aplicação

resources/: Configurações (ex.: application.properties)

test/: Testes unitários e de integração

# ▶️ Como Executar o Projeto
1. Pré-requisitos

JDK 17 ou superior

Maven 3.x

2. Clonar o repositório
git clone https://github.com/KarineA213/LibraryMS.git
cd LibraryMS

3. Compilar e executar
mvn spring-boot:run


A aplicação estará disponível em:
http://localhost:8080


# 🔗 Endpoints da API (Exemplos)
Livros

GET /api/books → Lista todos os livros

GET /api/books/{id} → Obtém um livro por ID

POST /api/books → Adiciona um novo livro

PUT /api/books/{id} → Atualiza um livro existente

DELETE /api/books/{id} → Exclui um livro

Usuários

GET /api/users → Lista todos os usuários

GET /api/users/{id} → Obtém um usuário por ID

POST /api/users → Adiciona um novo usuário

PUT /api/users/{id} → Atualiza um usuário existente

DELETE /api/users/{id} → Exclui um usuário

Empréstimos

GET /api/loans → Lista todos os empréstimos

GET /api/loans/{id} → Obtém um empréstimo por ID

POST /api/loans → Registra um novo empréstimo

PUT /api/loans/{id} → Atualiza um empréstimo existente

DELETE /api/loans/{id} → Exclui um empréstimo


# 🤝 Contribuição

Contribuições são bem-vindas!
Sinta-se à vontade para abrir issues e pull requests.
