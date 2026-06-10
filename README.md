SkillMatch

Projeto de estudo focado em Arquitetura de Software, Microserviços e Boas Práticas de Desenvolvimento.

Sobre o Projeto

O SkillMatch é uma plataforma que conecta clientes e profissionais para contratação de serviços.

O objetivo principal deste projeto não é o domínio de negócio, mas sim servir como laboratório para estudo e aplicação de conceitos modernos de desenvolvimento backend utilizando Java e Spring.

Este projeto está sendo desenvolvido com foco em evolução arquitetural, qualidade de código e construção de sistemas distribuídos.

Objetivos de Estudo

Durante o desenvolvimento do SkillMatch estou praticando:

Arquitetura
Microservices Architecture
API Gateway Pattern
Database per Service
Distributed Systems Fundamentals
Service-to-Service Communication
REST APIs
Princípios de Desenvolvimento
SOLID

Aplicação dos cinco princípios para construção de código desacoplado e manutenível.

Single Responsibility Principle
Open/Closed Principle
Liskov Substitution Principle
Interface Segregation Principle
Dependency Inversion Principle
Clean Architecture

Separação clara entre:

Domain
Application
Infrastructure
Presentation

Mantendo as regras de negócio independentes de frameworks.

KISS

Keep It Simple, Stupid

As soluções devem resolver o problema da forma mais simples possível.

DRY

Don't Repeat Yourself

Evitar duplicação de código através de abstrações bem definidas.

YAGNI

You Aren't Gonna Need It

Evitar implementar funcionalidades que não possuem necessidade real no momento.

Arquitetura Geral
                    +----------------------+
                    |     API Gateway      |
                    +----------+-----------+
                               |
         -----------------------------------------
         |                   |                   |
         v                   v                   v

+----------------+  +----------------+  +----------------+
| User Service   |  | Offer Service  |  | Request Service|
+----------------+  +----------------+  +----------------+

         |                   |                   |
         v                   v                   v

     PostgreSQL         PostgreSQL         PostgreSQL

Cada microserviço possui:

Banco de dados próprio
Responsabilidade única
Independência de deploy
Comunicação via HTTP
Tecnologias
Backend
Java 21
Spring Boot
Spring Security
Spring Data JPA
Spring WebFlux
Spring Cloud Gateway
Banco de Dados
PostgreSQL
Infraestrutura
Docker
Docker Compose
Testes
JUnit 5
Mockito
WebTestClient
Microserviços
User Service

Responsável pelo gerenciamento de usuários.

Funcionalidades:

Cadastro de usuários
Consulta de usuários
Login
Geração de JWT
Offer Service

Responsável pelas ofertas de serviços.

Funcionalidades:

Cadastro de ofertas
Consulta de ofertas
Listagem de serviços por profissional
Request Service

Responsável pelas solicitações realizadas pelos clientes.

Funcionalidades:

Criar solicitação
Atualizar status
Consultar solicitações
Agregação de dados entre serviços
API Gateway

Ponto único de entrada para a aplicação.

Responsabilidades:

Roteamento
Autenticação JWT
Logging
Rate Limiting
Correlation ID
Circuit Breaker
Conceitos Praticados
JWT Authentication
Stateless Authentication
API Gateway
Reverse Proxy
WebClient
Comunicação entre Microserviços
DTO Mapping
Exception Handling
Validation
Logging Distribuído
Observabilidade
Dockerização de Aplicações
Containers
Integração entre Serviços
Estrutura do Projeto
skillmatch/

├── gateway
│
├── user-service
│
├── offer-service
│
├── request-service
│
├── docker-compose.yml
│
└── README.md

Status

🚧 Em desenvolvimento

Projeto utilizado como ambiente de aprendizado para aprofundamento em arquitetura de software, sistemas distribuídos e desenvolvimento backend moderno com Java e Spring.

Autor

Lucas Moreira

Engenheiro/Arquiteto de Software
