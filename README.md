# Spring JWT Role

## 📑 Descrição

Este projeto é uma aplicação Spring Boot que implementa autenticação e autorização baseadas em JSON Web Tokens (JWT) e controle de acesso baseado em papéis (roles). Ele fornece uma estrutura robusta para gerenciar usuários, registrar novos usuários com diferentes papéis e proteger endpoints da API.

---

## 🚀 Funcionalidades

- ✅ Autenticação de usuário com JWT
- ✅ Registro de novos usuários com atribuição de papéis (User, Admin)
- ✅ Autorização baseada em papéis para acesso a endpoints específicos
- ✅ Geração e validação de tokens JWT
- ✅ Proteção de rotas da API com Spring Security
- ✅ Integração com banco de dados PostgreSQL usando Spring Data JPA e Flyway para migrações de schema

---



## 🏗️ Arquitetura do Projeto

```
spring-jwt-role-main/
├── src/
│   ├── main/
│   │   ├── java/com/project/project/
│   │   │   ├── auth/                  # Módulos de autenticação e autorização
│   │   │   │   ├── controller/        # Endpoints de autenticação
│   │   │   │   ├── dto/               # Objetos de Transferência de Dados (DTOs)
│   │   │   │   ├── entity/            # Entidades de usuário e papel
│   │   │   │   ├── infra/security/    # Configurações de segurança (JWT, filtros)
│   │   │   │   ├── repository/        # Repositórios para acesso a dados de usuário
│   │   │   │   └── service/           # Serviços de autenticação e token
│   │   │   ├── home/                  # Exemplo de endpoint protegido
│   │   │   └── ProjectApplication.java# Classe principal da aplicação Spring Boot
│   │   └── resources/
│   │       ├── application.properties # Configurações da aplicação e banco de dados
│   │       └── db/migration/          # Scripts de migração de banco de dados (Flyway)
│   └── test/                          # Testes da aplicação
├── Dockerfile                         # Dockerfile para conteinerização
├── mvnw                               # Wrapper Maven para execução
├── mvnw.cmd                           # Wrapper Maven para Windows
└── pom.xml                            # Gerenciamento de dependências Maven
```

---

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens) com `com.auth0:java-jwt`
- PostgreSQL (Banco de Dados)
- Flyway (Migrações de Banco de Dados)
- Maven (Gerenciador de dependências)
- Lombok (Opcional, para reduzir boilerplate code)

---



## 💻 Pré-requisitos

- Java Development Kit (JDK) 21 ou superior
- Maven
- PostgreSQL (instância local ou remota)
- Docker (opcional, para conteinerização)

---

## 🏁 Como Executar o Projeto

### 1️⃣ Clone o Repositório

```bash
git clone https://github.com/kaiudiass/spring-jwt-role.git
cd spring-jwt-role-main
```

### 2️⃣ Configuração do Banco de Dados

Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

Certifique-se de que o banco de dados `your_database_name` exista. O Flyway cuidará das migrações do schema automaticamente.

### 3️⃣ Compile e Rode o Projeto

Via terminal Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Ou, se preferir rodar via Docker:

```bash
docker build -t spring-jwt-role .
docker run -p 8080:8080 spring-jwt-role
```

---

## 🗂️ Scripts do Banco de Dados

As migrações do banco de dados são gerenciadas pelo Flyway e estão localizadas em `src/main/resources/db/migration/`.

- `V1__create-users.sql`: Cria a tabela de usuários.
- `V2__create-nomedobanco2.sql`: Exemplo de script de migração adicional.

---



## 🎯 Endpoints da API

Os principais endpoints da API são:

- `POST /auth/login`: Autentica um usuário e retorna um token JWT.
- `POST /auth/register`: Registra um novo usuário com um papel específico (USER ou ADMIN).
- `GET /home`: Exemplo de endpoint protegido que requer autenticação e autorização (acessível por USER e ADMIN).
- `GET /admin`: Exemplo de endpoint protegido que requer o papel ADMIN.

### Exemplo de Requisição (Login):

```http
POST /auth/login
Content-Type: application/json

{
  "login": "username",
  "password": "password"
}
```

### Exemplo de Resposta (Login):

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Exemplo de Requisição (Registro):

```http
POST /auth/register
Content-Type: application/json

{
  "login": "newuser",
  "password": "newpassword",
  "role": "USER"
}
```

---
