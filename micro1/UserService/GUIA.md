# SkillMatch

Plataforma de contratação de serviços onde clientes podem contratar profissionais para trabalhos rápidos como design, programação, manutenção, fotografia, consultoria e outros serviços.

O objetivo principal deste projeto não é a regra de negócio, mas sim o estudo de:

* Microserviços
* API Gateway
* Spring Cloud Gateway
* Spring Security + JWT
* Docker e Docker Compose
* Comunicação entre serviços via HTTP (WebClient)
* Arquitetura Distribuída
* Observabilidade
* Testes de Integração

---

# Arquitetura

```text
                    +----------------------+
                    |     API Gateway      |
                    |       :8080          |
                    +----------+-----------+
                               |
        +----------------------+----------------------+
        |                      |                      |
        v                      v                      v

+---------------+     +---------------+     +---------------+
| User Service  |     | Offer Service |     |Request Service|
|     :8081     |     |     :8082     |     |     :8083     |
+---------------+     +---------------+     +---------------+

        |                      |                      |
        v                      v                      v

 PostgreSQL            PostgreSQL            PostgreSQL
```

---

# Tecnologias

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Spring WebFlux
* Spring Cloud Gateway
* PostgreSQL

## Infraestrutura

* Docker
* Docker Compose

## Testes

* JUnit 5
* Mockito
* Testcontainers (opcional)
* WebTestClient

---

# Microserviços

## 1. User Service

Responsável por usuários da plataforma.

### Entidade

```java
User
{
    Long id;
    String nome;
    String email;
    String senha;
    UserType tipo;
}
```

### UserType

```java
CLIENTE
PROFISSIONAL
```

### Endpoints

#### Criar usuário

```http
POST /users
```

Body:

```json
{
  "nome": "Lucas",
  "email": "lucas@email.com",
  "senha": "123456",
  "tipo": "CLIENTE"
}
```

---

#### Buscar usuário

```http
GET /users/{id}
```

---

#### Listar usuários

```http
GET /users
```

---

#### Remover usuário

```http
DELETE /users/{id}
```

---

### Login

```http
POST /auth/login
```

Body:

```json
{
  "email": "lucas@email.com",
  "senha": "123456"
}
```

Resposta:

```json
{
  "token": "jwt_token"
}
```

---

# 2. Offer Service

Responsável pelos serviços oferecidos pelos profissionais.

### Entidade

```java
Offer
{
    Long id;
    String titulo;
    String descricao;
    BigDecimal preco;
    Long profissionalId;
}
```

---

### Endpoints

#### Criar oferta

```http
POST /offers
```

Body:

```json
{
  "titulo": "Landing Page",
  "descricao": "Landing page profissional",
  "preco": 500,
  "profissionalId": 2
}
```

---

#### Buscar oferta

```http
GET /offers/{id}
```

---

#### Listar ofertas

```http
GET /offers
```

---

#### Listar ofertas de um profissional

```http
GET /offers/professional/{professionalId}
```

---

#### Excluir oferta

```http
DELETE /offers/{id}
```

---

# 3. Request Service

Responsável pelas solicitações dos clientes.

### Entidade

```java
Request
{
    Long id;
    Long clienteId;
    Long offerId;
    RequestStatus status;
}
```

### Status

```java
PENDENTE
ACEITA
RECUSADA
FINALIZADA
```

---

### Endpoints

#### Criar solicitação

```http
POST /requests
```

Body:

```json
{
  "clienteId": 1,
  "offerId": 10
}
```

---

#### Buscar solicitação

```http
GET /requests/{id}
```

---

#### Listar solicitações

```http
GET /requests
```

---

#### Atualizar status

```http
PATCH /requests/{id}/status
```

Body:

```json
{
  "status": "ACEITA"
}
```

---

#### Excluir solicitação

```http
DELETE /requests/{id}
```

---

# Endpoint de Agregação

Objetivo: praticar comunicação entre microserviços.

### Endpoint

```http
GET /requests/{id}/details
```

### Fluxo

Request Service

↓

Offer Service

↓

User Service

---

### Resposta Esperada

```json
{
  "requestId": 1,
  "status": "ACEITA",
  "cliente": {
    "id": 1,
    "nome": "Lucas"
  },
  "profissional": {
    "id": 2,
    "nome": "João"
  },
  "servico": {
    "id": 10,
    "titulo": "Landing Page",
    "preco": 500
  }
}
```

---

# API Gateway

Porta:

```text
8080
```

### Rotas

```text
/api/users/**      -> User Service
/api/offers/**     -> Offer Service
/api/requests/**   -> Request Service
```

---

# JWT

### Fluxo

```text
Login
 ↓
User Service
 ↓
JWT
 ↓
Gateway
 ↓
Microserviços
```

### Header

```http
Authorization: Bearer TOKEN
```

---

# Funcionalidades do Gateway

## 1. Authentication Filter

Validar JWT antes de encaminhar a requisição.

---

## 2. Correlation ID

Se não existir:

```http
X-Correlation-ID
```

Gerar automaticamente UUID.

---

## 3. Logging

Registrar:

```text
Método
Path
CorrelationId
Tempo de Resposta
```

---

## 4. Rate Limiting

Limite inicial:

```text
20 requisições por minuto
```

---

## 5. Circuit Breaker

Quando um serviço estiver indisponível.

Resposta:

```json
{
  "message": "Serviço temporariamente indisponível"
}
```

---

# Banco de Dados

Cada serviço possui seu próprio banco.

## user_db

Tabela:

```sql
users
```

---

## offer_db

Tabela:

```sql
offers
```

---

## request_db

Tabela:

```sql
requests
```

---

# Docker

Containers:

```text
gateway
user-service
offer-service
request-service

postgres-user
postgres-offer
postgres-request
```

---

# Estrutura do Projeto

```text
skillmatch/

gateway/

user-service/

offer-service/

request-service/

docker-compose.yml

README.md
```

---

# Objetivos de Aprendizado

Ao concluir o projeto você deverá dominar:

* Arquitetura de Microserviços
* API Gateway
* Spring Cloud Gateway
* JWT
* Spring Security
* Docker
* Docker Compose
* PostgreSQL
* Comunicação HTTP entre serviços
* WebClient
* Circuit Breaker
* Rate Limiting
* Correlation ID
* Logging Distribuído
* Testes de Integração
* Observabilidade básica

---
