<p align="center">
  <img src="https://github.com/hildocosta/hildocosta-Curso-Java--Nelio-Alves/blob/main/logo.png" width="300">
</p>

<h1 align="center">💡 Projeto de Integração Backend-Frontend: Gestão de Usuários e Login</h1>

<p>🚀 Este projeto visa fornecer uma API REST para a gestão de usuários e integração com uma página de login no frontend, permitindo operações de criação, leitura, atualização e exclusão (CRUD) de usuários, além de autenticação de usuários.</p>

<h2 align="center">📝 Sobre o Projeto</h2>

<p>🌟 O sistema permite a gestão completa de usuários, bem como a autenticação de usuários por meio de uma página de login no frontend.</p>

<h2 align="center">🚀 Vamos Começar</h2>


<h3>Pré-requisitos</h3>

<p>🔧 Antes de iniciar, certifique-se de ter o <a href="https://www.oracle.com/java/technologies/javase-downloads.html">JDK (Java Development Kit)</a> instalado em sua máquina, além de uma IDE Java (Eclipse, IntelliJ IDEA, NetBeans, etc.).</p>

<h3>Clonando o Repositório</h3>

<p>📥 Para começar, clone este repositório em sua máquina local usando o seguinte comando no terminal:</p>

<pre><code>git clone https://github.com/seu-usuario/seu-repositorio.git</code></pre>

<h3>Configuração do Git</h3>

<p>🔑 Se você ainda não tem o Git instalado, baixe e instale-o rapidamente a partir do <a href="https://git-scm.com/downloads">site oficial do Git</a>. Depois de instalado, configure seu nome de usuário e endereço de e-mail com os seguintes comandos:</p>

<pre><code>git config --global user.name "Seu Nome"
git config --global user.email "seu-email@example.com"</code></pre>

<h2 align="center">📋 Estrutura do Projeto</h2>

```
br.com.hildo.login
├── Application.java
├── model
│   ├── request
│   │   └── UserRequest.java
│   └── response
│       └── UserResponse.java
├── persistence
│   ├── entity
│   │   └── User.java
│   └── repository
│       └── UserRepository.java
├── service
│   ├── impl
│   │   └── UserServiceImpl.java
│   ├── mapper
│       └── Mapper
│       └── UserRequestMapper.java
│       └── UserResponseMapper.java
└── web
    └── UserController.java
```


### 📋 Endpoints e Métodos

- **Criar Usuário**
  - **URL:** `POST /users`
  - **Body:**
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com",
    "password": "Password123"
  }
  ```

- **Listar Todos os Usuários**
  - **URL:** `GET /users`

- **Obter Detalhes de um Usuário**
  - **URL:** `GET /users/{id}`

- **Atualizar Usuário**
  - **URL:** `PUT /users/{id}`
  - **Body:**
  ```json
  {
    "name": "John Doe Updated",
    "email": "john.doe.updated@example.com",
    "password": "NewPassword123"
  }
  ```

- **Deletar Usuário**
  - **URL:** `DELETE /users/{id}`

- **Autenticar Usuário**
  - **URL:** `POST /login`
  - **Body:**
  ```json
  {
    "email": "johndoe@example.com",
    "password": "Password123"
  }
  ```

<h2 align="center">🛠️ Testes com Postman</h2>

<p>🔍 Para testar a API, você pode utilizar o <a href="https://www.postman.com/">Postman</a> ou qualquer outra ferramenta de teste de API. Abaixo estão os passos para testar cada operação:</p>

<h3>Autenticar Usuário</h3>

- **URL:** `POST /login`
- **Body:**
```json
{
  "email": "johndoe@example.com",
  "password": "Password123"
}
```

<h2 align="center">🔒 Licença</h2>

<p>⚖️ Este projeto está licenciado sob a <a href="LICENSE">Licença MIT</a>.</p>

<h2 align="center">📧 Contato</h2>

<h3>🔗 Redes Sociais e Contato</h3>

<ul>
  <li>📌 GitHub: <a href="https://github.com/seu-usuario">seu-usuario</a></li>
  <li>💼 LinkedIn: <a href="https://www.linkedin.com/in/seu-linkedin/">Seu Nome</a></li>
  <li>✉️ Email: seu-email@example.com</li>
</ul>

<p>Agora que você está preparado e animado, vamos começar!</p>
```

Certifique-se de substituir as informações de URL, corpo das requisições, pré-requisitos, estrutura do projeto, classes principais, endpoints e métodos, entre outras, de acordo com o seu projeto real.
