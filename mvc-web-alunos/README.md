# mvc-web-alunos

Projeto Spring Boot com arquitetura MVC para cadastro de alunos.

---

## Arquitetura MVC

O padrão **Model-View-Controller (MVC)** divide a aplicação em três camadas com responsabilidades distintas:

| Camada | Arquivo | Responsabilidade |
|--------|---------|-----------------|
| **Model** | `Aluno.java` | Representa a entidade de negócio. Armazena dados e valida regras (ex: nome obrigatório). Não conhece HTTP nem HTML. |
| **View** | `alunos-form.html`, `alunos-lista.html` | Apresenta dados ao usuário. Usa Thymeleaf para renderizar HTML dinamicamente. Não contém lógica de negócio. |
| **Controller** | `AlunoController.java` | Recebe requisições HTTP, aciona o Model e decide qual View exibir. Faz a ponte entre as outras duas camadas. |

### Fluxo de uma requisição

```
Navegador
   │
   ▼
Controller (recebe GET /alunos)
   │
   ▼
View (renderiza alunos-form.html)
   │
   ▼
Navegador (exibe formulário)
   │  [usuário preenche e envia]
   ▼
Controller (recebe POST /alunos)
   │
   ▼
Model (cria objeto Aluno com validação)
   │
   ▼
Controller (passa lista ao Model do Spring)
   │
   ▼
View (renderiza alunos-lista.html com os dados)
   │
   ▼
Navegador (exibe lista atualizada)
```

---

## Como executar

### Pré-requisitos
- Java 17+
- Maven (ou usar o wrapper `./mvnw`)
- VS Code com *Extension Pack for Java* e *Spring Boot Extension Pack*

### Rodando no VS Code
1. `File → Open Folder` → selecionar a pasta do projeto
2. Aguardar o Maven importar as dependências
3. Abrir `MvcApplication.java` e clicar em ▶ **Run**

### Rodando pelo terminal
```bash
mvn spring-boot:run
```

### Acessando
Abra o navegador em: [http://localhost:8080/alunos](http://localhost:8080/alunos)

---

## Estrutura do projeto

```
mvc-web-alunos/
├── src/
│   └── main/
│       ├── java/com/exemplo/mvc/
│       │   ├── model/
│       │   │   └── Aluno.java          ← MODEL
│       │   ├── controller/
│       │   │   └── AlunoController.java ← CONTROLLER
│       │   └── MvcApplication.java
│       └── resources/
│           ├── templates/
│           │   ├── alunos-form.html    ← VIEW
│           │   └── alunos-lista.html   ← VIEW
│           └── application.properties
└── pom.xml
```

---

## Tecnologias

- **Spring Boot 3.2** — framework principal
- **Spring MVC** — camada web
- **Thymeleaf** — template engine para as Views
- **Maven** — gerenciamento de dependências
