

A API Influenza é uma aplicação web construída com Spring Boot (versão 3.4.2) e Java 23, que fornece endpoints REST para análise de dados relacionados a internações por Influenza no Nordeste, disponibilidade de leitos SUS e não SUS, além de funcionalidades de autenticação e gerenciamento de usuários. O projeto segue a arquitetura *feature by folder*, utilizando `DTOs`, `controllers`, `services`, `mappers (MapStruct)` e acesso a banco via Spring Data JPA com PostgreSQL.

Entre os principais módulos da API estão:

1. **Autenticação**: o `AuthController` oferece login via JSON Web Tokens (JWT), retornando um token JWT válido para acesso autenticado à API. O token é gerado a partir da autenticação do e-mail e senha do usuário.

2. **InfluenzaNordeste**: permite buscas por dados de internações por Influenza no Nordeste, com suporte a filtros por estado (`uf`), ano e mês (de `jan` a `dec`). Os dados podem ser buscados por ID ou de forma paginada com múltiplos parâmetros opcionais. A filtragem é implementada usando `Specification`.

3. **Leitos SUS e Não SUS**: fornece acesso aos dados de leitos hospitalares. Suporta busca por ID ou listagem paginada de todos os registros disponíveis.

4. **Usuários**: o `UserController` oferece criação, busca, atualização e ativação/desativação de usuários. A criação de usuário permite envio de arquivos (`multipart/form-data`) junto ao DTO. Também é possível buscar usuários com filtros por CPF, e-mail, curso, instituição, papel (role) e status de ativação.

O projeto utiliza:

* **Spring Boot Starters**: web, data JPA, security, test, redis.
* **Banco de dados**: suporte a PostgreSQL e MySQL (via dependência, mas PostgreSQL é o usado).
* **MapStruct** para mapeamento de entidades.
* **JWT** para autenticação, usando `jjwt` e `java-jwt`.
* **dotenv-java** para carregamento de variáveis de ambiente.
* **Swagger (SpringDoc OpenAPI)** para documentação interativa dos endpoints.
* **Mockito** para testes unitários.
* **Redis** para cache (caso configurado).

Além disso, o projeto está estruturado com boas práticas como:

* Separação clara de responsabilidades (Controller → Service → Repository).
* Utilização de DTOs para comunicação externa.
* Validação com grupos personalizados (ex: `UpdateValidation`).
* Arquitetura limpa com fácil manutenção e extensão.

Para executar o projeto localmente:

1. Certifique-se de ter o Java 23 e Maven instalados.
2. Configure o banco de dados PostgreSQL e um arquivo `.env` com as variáveis necessárias (usuário, senha, host etc).
3. Execute `./mvnw spring-boot:run` ou `mvn spring-boot:run`.
4. Acesse a documentação em `http://localhost:8080/swagger-ui.html`.

---
