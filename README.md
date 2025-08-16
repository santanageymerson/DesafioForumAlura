💬 Fórum Hub - Desafio Back-end Java
📌 Descrição do Projeto

Este projeto foi desenvolvido como parte do desafio do programa Oracle Next Education em parceria com a Alura.
O objetivo é criar uma API REST que simule um fórum de dúvidas, inspirado no Fórum da Alura, permitindo que usuários autenticados criem, listem, atualizem e excluam tópicos.

🎯 Objetivo

Implementar uma aplicação back-end em Java com Spring Boot, capaz de:

Gerenciar usuários e autenticação via JWT (Bearer Token).

Criar, listar, detalhar, atualizar e excluir tópicos.

Garantir que apenas o autor do tópico possa alterá-lo ou excluí-lo.

Relacionar cada tópico a um curso.

Proteger os endpoints com autenticação e regras de autorização.

🛠 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Security (JWT)

Spring Data JPA (Hibernate)

Bean Validation

Banco de Dados Relacional (H2, MySQL ou PostgreSQL)

Maven

Insomnia para testes de endpoints

📋 Regras de Negócio

Apenas usuários cadastrados e autenticados podem criar tópicos.

Cada tópico deve conter:

Título

Mensagem

Nome do Curso

Data de Criação (gerada automaticamente pelo sistema)

Usuário Autor

Apenas o autor pode alterar ou excluir o tópico.

A exclusão e atualização devem respeitar as permissões definidas no sistema.

A API deve conter endpoints para:

GET /topicos → listar todos os tópicos

GET /topicos/{id} → detalhar um tópico

POST /topicos → criar um novo tópico (apenas autenticados)

PUT /topicos/{id} → atualizar um tópico (apenas autor autenticado)

DELETE /topicos/{id} → excluir um tópico (apenas autor autenticado)

🚀 Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/forum-hub.git


Abra o projeto no IntelliJ IDEA ou Eclipse.

Configure o banco de dados no arquivo application.properties.

Instale as dependências com:

mvn install


Execute a aplicação:

mvn spring-boot:run


Acesse em:

http://localhost:8080

🔑 Autenticação

A API utiliza autenticação JWT (Bearer Token).

Registrar usuário:
POST /auth/register

Fazer login:
POST /auth/login
→ retorna um token JWT.

Para acessar os endpoints protegidos, envie no header:

Authorization: Bearer SEU_TOKEN_AQUI

📖 Exemplo de Fluxo no Insomnia

Registrar usuário:

{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}


Login:

{
  "email": "joao@email.com",
  "senha": "123456"
}


→ Retorna um token JWT.

Criar tópico (com token no header):

{
  "titulo": "Dúvida sobre Java",
  "mensagem": "Como funciona o Spring Boot?",
  "nomeCurso": "Java"
}


Atualizar tópico (apenas autor):

{
  "titulo": "Dúvida solucionada",
  "mensagem": "Já entendi o funcionamento!"
}

💡 Possíveis Melhorias

Paginação e ordenação de tópicos.

Filtros por curso ou autor.

Testes automatizados com JUnit e Mockito.

Documentação da API com Swagger.

📜 Licença

Este projeto foi desenvolvido para fins educacionais, sem fins comerciais.
