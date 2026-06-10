# SkillMatch

SkillMatch é uma plataforma de microserviços desenvolvida para conectar profissionais e clientes, permitindo a criação e gestão de ofertas de serviços de forma eficiente e segura. O projeto utiliza uma arquitetura moderna baseada em microserviços para garantir escalabilidade e independência entre as funcionalidades do sistema.

## Arquitetura do Projeto

O sistema é composto por três módulos principais que operam de forma integrada:

1.  **UserService (Microserviço de Usuários):** Responsável pela gestão de perfis, autenticação e autorização. Implementa segurança utilizando JWT (JSON Web Token) e controle de acesso baseado no tipo de usuário.
2.  **OfferService (Microserviço de Ofertas):** Gerencia as ofertas de serviços publicadas pelos profissionais, incluindo informações como título, descrição, preço e vínculo com o profissional responsável.
3.  **UserFront (Frontend):** Uma aplicação web moderna e responsiva construída com React, que oferece uma interface intuitiva para que os usuários interajam com os microserviços.

## Tecnologias Utilizadas

### Backend (Java)
- Java 21
- Spring Boot 3.x / 4.x
- Spring Security (Autenticação JWT)
- Spring Data JPA (Persistência de dados)
- PostgreSQL (Banco de dados relacional)
- Maven (Gerenciamento de dependências)
- Docker & Docker Compose (Containerização)

### Frontend (TypeScript)
- React 19
- Vite (Build tool)
- Tailwind CSS (Estilização)
- TanStack Query (Gerenciamento de estado assíncrono)
- React Hook Form + Zod (Validação de formulários)
- Radix UI (Componentes de interface acessíveis)
- Axios (Cliente HTTP)

## Estrutura de Pastas

```text
SkillMatch/
├── micro1/                  # UserService (Java/Spring Boot)
│   ├── src/                 # Código-fonte do microserviço
│   ├── pom.xml              # Configurações do Maven
│   └── compose.yaml         # Configuração Docker para o serviço
├── micro2-front/            # UserFront (React/TypeScript)
│   ├── src/                 # Componentes, hooks e páginas
│   ├── package.json         # Dependências do Node.js
│   └── tailwind.config.js   # Configuração do Tailwind
└── micro3/                  # OfferService (Java/Spring Boot)
    ├── src/                 # Código-fonte do microserviço
    └── pom.xml              # Configurações do Maven
```

## Como Executar o Projeto

### Pré-requisitos
- JDK 21 ou superior
- Node.js (versão LTS recomendada)
- Docker e Docker Compose
- Maven

### Passo a Passo

1.  **Configurar o Banco de Dados:**
    Certifique-se de que o Docker esteja em execução e utilize os arquivos `compose.yaml` presentes nos diretórios dos microserviços para subir as instâncias de banco de dados necessárias.

2.  **Executar os Microserviços:**
    Navegue até as pastas `micro1/UserService` e `micro3/OfferService` e execute o comando:
    ```bash
    mvn spring-boot:run
    ```

3.  **Executar o Frontend:**
    Navegue até a pasta `micro2-front/UserFront`, instale as dependências e inicie o servidor de desenvolvimento:
    ```bash
    npm install
    npm run dev
    ```

## Funcionalidades Implementadas
- Cadastro e Autenticação de Usuários.
- Dashboard Administrativo com listagem de usuários.
- Criação e visualização de ofertas de serviços.
- Proteção de rotas no frontend e backend através de JWT.
- Design responsivo e componentes de UI modernos.
