### Descrição do Projeto

Este projeto é uma API REST desenvolvida em Java que gerencia usuários, contas, funcionalidades(Features), cartões e notícias(News). A API permite a criação, leitura, atualização e exclusão (CRUD) de recursos relacionados a esses elementos. A seguir, estão descritos os principais aspectos do projeto.

### Diagrama de Classes

```mermaid
classDiagram
class User {
-String name
-Account account
-List~Feature~ features
-Card card
-List~News~ news
}

    class Account {
        -String number
        -String agency
        -double balance
        -double limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -double limit
    }

    class News {
        -String icon
        -String description
    }

    User --> Account
    User --> Feature
    User --> Card
    User --> News
```

### Endpoints da API

A API possui diversos endpoints para gerenciar os recursos. Alguns dos principais endpoints são:

- **Usuários (Users)**
  - `GET /users`: Retorna uma lista de todos os usuários.
  - `GET /users/{id}`: Retorna os detalhes de um usuário específico.
  - `POST /users`: Cria um novo usuário.
  - `POST/users/create-all`: Cria um novo usuário e as demais entidades relacionadas em um único endpoint.
  - `PUT /users/{id}`: Atualiza um usuário existente.
  - `DELETE /users/{id}`: Exclui um usuário.

- **Contas (Accounts)**
  - `GET /accounts`: Retorna uma lista de todas as contas.
  - `GET /accounts/{id}`: Retorna os detalhes de uma conta específica.
  - `POST /accounts`: Cria uma nova conta.
  - `PUT /accounts/{id}`: Atualiza uma conta existente.
  - `DELETE /accounts/{id}`: Exclui uma conta.

- **Funcionalidades (Features)**
  - `GET /features`: Retorna uma lista de todas as funcionalidades.
  - `GET /features/{id}`: Retorna os detalhes de uma funcionalidade específica.
  - `POST /features`: Cria uma nova funcionalidade.
  - `PUT /features/{id}`: Atualiza uma funcionalidade existente.
  - `DELETE /features/{id}`: Exclui uma funcionalidade.

- **Cartões (Cards)**
  - `GET /cards`: Retorna uma lista de todos os cartões.
  - `GET /cards/{id}`: Retorna os detalhes de um cartão específico.
  - `POST /cards`: Cria um novo cartão.
  - `PUT /cards/{id}`: Atualiza um cartão existente.
  - `DELETE /cards/{id}`: Exclui um cartão.

- **Notícias (News)**
  - `GET /news`: Retorna uma lista de todas as notícias.
  - `GET /news/{id}`: Retorna os detalhes de uma notícia específica.
  - `POST /news`: Cria uma nova notícia.
  - `PUT /news/{id}`: Atualiza uma notícia existente.
  - `DELETE /news/{id}`: Exclui uma notícia.

### Swagger

O Swagger é uma ferramenta para documentação de APIs REST. Ele permite que desenvolvedores e consumidores da API visualizem e testem os endpoints de forma interativa. 

Nesta API, o Swagger foi aplicado para gerar automaticamente a documentação dos endpoints, facilitando o entendimento e a utilização da API.

Para acessar a documentação do Swagger, basta acessar a URL `/swagger-ui.html` no navegador após iniciar a aplicação.

### Distribuição de Pacotes e Classes

A estrutura de pacotes do projeto é organizada da seguinte forma:

- **domain.model**: Contém as classes de modelo que representam as entidades do domínio, como `User`, `Account`, `Feature`, `Card` e `News`.
- **dto**: Contém as classes de Data Transfer Object (DTO) que são usadas para transferir dados entre as camadas da aplicação, como `UserMinDTO` e `AccountDTO`.
- **service**: Contém as classes de serviço que implementam a lógica de negócios da aplicação.
- **controller**: Contém as classes de controlador que expõem os endpoints da API.

### Uso do Gradle

O Gradle é uma ferramenta de automação de build que é usada para compilar, testar e empacotar a aplicação. Ele permite gerenciar as dependências do projeto e definir tarefas automatizadas para facilitar o desenvolvimento.

No projeto, o Gradle é usado para:

- **Gerenciar Dependências**: As dependências do projeto são definidas no arquivo build.gradle, permitindo que o Gradle baixe e configure automaticamente as bibliotecas necessárias.
- **Compilar o Código**: O Gradle compila o código-fonte Java e gera os arquivos `.class`.
- **Executar Testes**: O Gradle executa os testes automatizados para garantir a qualidade do código.
- **Empacotar a Aplicação**: O Gradle empacota a aplicação em um arquivo `.jar` ou `.war` para distribuição e implantação.

Para executar a aplicação usando o Gradle, basta usar o comando `./gradlew bootRun` no terminal.

### Conclusão

Este projeto de API REST em Java é uma solução para gerenciar usuários, contas, funcionalidades, cartões e notícias. Com a documentação gerada pelo Swagger e a automação de build fornecida pelo Gradle, o desenvolvimento e a manutenção da aplicação são facilitados, garantindo uma experiência de desenvolvimento eficiente e organizada.