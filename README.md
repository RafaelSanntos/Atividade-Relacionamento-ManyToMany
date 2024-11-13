# Atividade-Relacionamento-ManyToMany

Este projeto demonstra um relacionamento Many-to-Many entre entidades `Aluno` e `Curso` usando Spring Boot e JPA.

## Proposta do Projeto

**Objetivo**: Desenvolver uma aplicação em Spring Boot que implemente um relacionamento Many-to-Many entre duas entidades, Aluno e Curso, com as operações básicas de CRUD e listagem. Ao final, a aplicação deverá permitir que um aluno esteja matriculado em vários cursos e um curso tenha vários alunos matriculados.

**Cenário**: Uma escola está implementando um sistema para gerenciar as matrículas de alunos em diversos cursos. Para isso, você deve criar duas entidades principais:

- **Aluno**:
  - Atributos: id (Long), nome (String), email (String).
  - Cada aluno pode estar matriculado em vários cursos.

- **Curso**:
  - Atributos: id (Long), nome (String), descricao (String).
  - Cada curso pode ter vários alunos matriculados.

Para este relacionamento, utilize o padrão `@ManyToMany` do JPA, criando uma tabela intermediária que vincule alunos e cursos.

### Requisitos

1. **Modelagem do Banco de Dados**: Configure o relacionamento Many-to-Many entre as entidades Aluno e Curso, de modo que o JPA crie uma tabela de junção automaticamente.

2. **Entidades JPA**:
   - Configure o relacionamento utilizando a anotação `@ManyToMany` nas classes de entidade.
   - Utilize `@JoinTable` para definir a tabela de junção, juntamente com `@JoinColumn` para especificar as colunas de chave estrangeira.

3. **Repositórios**: Crie repositórios para as entidades Aluno e Curso para realizar operações CRUD e consultas.

4. **Serviço**: Implemente um serviço que permita:
   - Criar novos alunos e cursos.
   - Adicionar e remover um aluno de um curso específico.
   - Listar todos os cursos de um aluno e todos os alunos de um curso.

5. **Controller**: Implemente um controlador REST para as seguintes operações:
   - `POST /alunos`: Adicionar um novo aluno.
   - `POST /cursos`: Adicionar um novo curso.
   - `POST /alunos/{id}/cursos/{cursoId}`: Matricular um aluno em um curso.
   - `DELETE /alunos/{id}/cursos/{cursoId}`: Remover um aluno de um curso.
   - `GET /alunos/{id}/cursos`: Listar todos os cursos em que um aluno está matriculado.
   - `GET /cursos/{id}/alunos`: Listar todos os alunos matriculados em um curso.

**Desafio Adicional (Opcional)**: Implemente uma funcionalidade que permita pesquisar cursos por nome e alunos por e-mail, utilizando consultas dinâmicas no repositório.

## Clonando o Projeto

1. **Abra o terminal ou prompt de comando**:
   - No Windows, você pode usar o Prompt de Comando ou o PowerShell.
   - No macOS ou Linux, você pode usar o Terminal.

2. **Navegue até o diretório onde você deseja clonar o projeto**:
   cd /caminho/para/seu/diretorio

3. **Clone o repositório do GitHub**:
   Execute o seguinte comando para clonar o repositório:
   git clone https://github.com/RafaelSanntos/Atividade-Relacionamento-ManyToMany.git

4. **Navegue até o diretório do projeto clonado**:
   cd Atividade-Relacionamento-ManyToMany

## Configurando o Projeto

1. **Abra o projeto em sua IDE preferida**:
   - Você pode usar IntelliJ IDEA, Eclipse, VS Code, ou qualquer outra IDE que suporte projetos Java.

2. **Certifique-se de que todas as dependências estão instaladas**:
   - Se estiver usando Maven, execute:
     mvn clean install
   - Se estiver usando Gradle, execute:
     gradle build

3. **Configure o banco de dados**:
   - Certifique-se de que o banco de dados H2 está configurado corretamente no arquivo `application.properties`(já está configurado!).

## Executando a Aplicação

1. **Execute a aplicação**:
   - Na sua IDE, encontre a classe principal `DemoApplication` e execute-a.
   - Alternativamente, você pode executar a aplicação a partir do terminal:
     mvn spring-boot:run

## Testando os Endpoints no Postman

1. **Abra o Postman**:
   - Se você ainda não tem o Postman instalado, você pode baixá-lo aqui: https://www.postman.com/downloads/

2. **Crie uma nova coleção**:
   - No Postman, clique em "New" e selecione "Collection".
   - Dê um nome à coleção, por exemplo, "Testes de Alunos e Cursos".

3. **Adicionar requisições à coleção**:
   - Para cada endpoint, crie uma nova requisição e adicione-a à coleção.

### Exemplo de Requisições:

1. **Adicionar um novo aluno**:
   - **Método**: POST
   - **URL**: `http://localhost:8080/alunos`
   - **Body**: JSON
     ```json
     {
         "nome": "João Silva",
         "curso": "Matemática"
     }
     ```
   - Outro exemplo:
     ```json
     {
         "nome": "Maria Oliveira",
         "curso": "Física"
     }
     ```

2. **Adicionar um novo curso**:
   - **Método**: POST
   - **URL**: `http://localhost:8080/cursos`
   - **Body**: JSON
     ```json
     {
         "nome": "Curso de Matemática"
     }
     ```
   - Outro exemplo:
     ```json
     {
         "nome": "Curso de Física"
     }
     ```

3. **Matricular um aluno em um curso**:
   - **Método**: POST
   - **URL**: `http://localhost:8080/alunos/{id}/cursos/{cursoId}`
   - **Path Variables**: Substitua `{id}` e `{cursoId}` pelos valores reais.

4. **Remover um aluno de um curso**:
   - **Método**: DELETE
   - **URL**: `http://localhost:8080/alunos/{id}/cursos/{cursoId}`
   - **Path Variables**: Substitua `{id}` e `{cursoId}` pelos valores reais.

5. **Listar todos os cursos em que um aluno está matriculado**:
   - **Método**: GET
   - **URL**: `http://localhost:8080/alunos/{id}/cursos`
   - **Path Variables**: Substitua `{id}` pelo valor real.

6. **Listar todos os alunos matriculados em um curso**:
   - **Método**: GET
   - **URL**: `http://localhost:8080/cursos/{id}/alunos`
   - **Path Variables**: Substitua `{id}` pelo valor real.

## Executando os Testes

1. **Adicionar um novo aluno**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que o aluno foi adicionado corretamente.

2. **Adicionar um novo curso**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que o curso foi adicionado corretamente.

3. **Matricular um aluno em um curso**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que o aluno foi matriculado no curso corretamente.

4. **Remover um aluno de um curso**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que o aluno foi removido do curso corretamente.

5. **Listar todos os cursos em que um aluno está matriculado**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que todos os cursos do aluno foram listados corretamente.

6. **Listar todos os alunos matriculados em um curso**:
   - Crie a requisição no Postman conforme descrito acima e clique em "Send".
   - Verifique a resposta para garantir que todos os alunos do curso foram listados corretamente.

## Deletando Todos os Registros

1. **Deletar todos os alunos**:
   - **Método**: DELETE
   - **URL**: `http://localhost:8080/alunos`
   - Clique em "Send".

2. **Deletar todos os cursos**:
   - **Método**: DELETE
   - **URL**: `http://localhost:8080/cursos`
   - Clique em "Send".

Projeto criado por Rafael Santos, para o curso +PraTI.
