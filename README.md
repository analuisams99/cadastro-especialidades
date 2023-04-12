# Sistema de Cadastro de Especialidades (Logs e Datasources)

    Este projeto foi realizado com o objetivo de aprimorar o conhecimento em 
    Logs e Datasources na linguagem Java.

## :zap: Descrição

Sistema web responsável por consultar, cadastrar, editar e deletar profissionais e suas especialidades no banco de dados.

### 🔴 Desenvolvimento

  - Desenvolvi o projeto utilizando o framework Spring Boot na versão `2.x`;
  
  - Defini `maven` como gerenciador de dependências e ferramenta de build do projeto;
  
  - Construí a camada de acesso a dados, utilizando os conceitos de abstração da base de dados disponíveis nas especificações do `JPA`;
  
  - Implementei os campos presentes na entidade representacional do profissional e sua especialidade com os atributos: `id`, `name` e `speciality`;
  
  - Configurei devidamente as propriedades do sistema em um arquivo `.yml` conforme a lista abaixo:
	   - Porta de execução da aplicação foi a `8080`;
	   - Datasource apontado para acessar o `H2 Database` com as seguintes credenciais: `username = speciality-app` / `password = speciality-app!`;
	
  - Definí as propriedades do logger para gerar um arquivo de logs em uma pasta especificada `./logs/speciality-app.log`, assim como o level de logging das informações.
	
  - O projeto foi empacotado no formato `.war` para deploy.

  
#### 📌 CRUD
  **Implementei as 4 operações básicas de um CRUD (GET, POST, PUT e DELETE) utilizando as especificações do `JAX-RS`, em que cada uma dessas operações deverá corresponder a um caminho na API Rest:**
   
   🔵 `GET path = "/api/professional/all": `

   * Traz todos os registros cadastrados dos profissionais e suas especialidades. 
     
   * Caso não encontre nenhum registro, deverá retornar um `404 Not Found`, com uma mensagem de erro: "*Nenhum registro foi encontrado!*"; 

   🔵 `POST path = "/api/professional/add"`
   
   * Cadastra um novo registro no banco de dados com retorno `201 Created` e a string "*Inserido*". 
   
   * O id é autogerado e portanto não pode ser informado manualmente. 
   
   * Caso seja um `400 Bad Request`, uma mensagem "*Não é permitido inserir novos registros com ID explícito*" será exibida.
   
   🔵 `PUT path = "/api/professional/edit/{id}"`: 
   
   * Edita um registro já existente na base de dados, retorna um `200 Ok` e a string "*ID [%d] atualizado*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL.
   
   * Caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível editar, o ID informado não existe*" deve ser retornado;
   
   🔵 `DELETE path = "/api/professional/delete/{id}"`: 
 
   * Deleta um registro já existente da base de dados, retornar um `200 Ok` e a string "*ID [%d] removido*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL.
   
   * Caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível deletar, o ID informado não existe*" deve ser retornado;


---

## 📌 Instalação do projeto em sua máquina
  1. Clone o repositório
   
     `git@github.com:analuisams99/cadastro-especialidades.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd cadastro-especialidades`
   
  3. Instale as dependências necessárias:
   
     `mvn install`
     
  

## 📌 Para testar o projeto
  1. digite o comando no seu terminal
      
      `mvn test`
      
    Os códigos de cobertura de testes, do arquivo src/test/java/com/trybe/acc/java/cadastroEspecialidades/CoverageValidationTest.java,
    foram desenvolvidos pela Trybe.
    
---

-- Projeto desenvolvido por Ana Luisa Marques Simões, para fins didáticos. 2023
