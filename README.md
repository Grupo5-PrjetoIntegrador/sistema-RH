# Gen RH :bookmark_tabs:

### Gen RH: Sistema de Cadastro RH

---

## 📚 Tabela de Conteúdo
- [Descrição :black_nib:](#descrição-black_nib)
- [Entidades e Atributos :card_file_box:](#entidades-e-atributos-card_file_box)
- [Tecnologias :computer:](#tecnologias-utilizadas-computer)
- [Dependências :paperclips:](#dependências-paperclips)
- [Como Executar? :runner:](#como-executar-runner)
- [Colaboradores :technologist:](#colaboradores-technologist)

---

## Descrição :black_nib:
O projeto Gen RH traz em si a implementação de um sistema de cadastro RH com todos os métodos básicos de CRUD, métodos de busca específicos por nome em todas as suas entidades, um método especial de cálculo automático de salários com base em horas trabalhadas, bônus e descontos para a entidade Funcionário e o método de autenticação para a entidade Usuário que em conjunto com o ecossistema de segurança do Spring, garante uma aplicação funcional e protegida.

## [Escopo Projeto](docs/escopo-PI-desafio-03.docx)

## Entidades e Atributos :card_file_box:  
1. **Usuário**:
   - Id
   - Nome
   - Usuário (email)
   - Foto
   - Senha
   - Lista de Funcionários (Relação de classes)

2. **Funcionário**:
   - Id
   - Nome
   - Cargo
   - Salário Base
   - Horas Trabalhadas
   - Bonus
   - Descontos
   - Aniversário Empresa
   - Setor (Relação de classes)
   - Usuário (Relação de classes)

3. **Setor**:
   - Id
   - Nome Setor
   - Lista de Funcionários (Relação de classes)


---

##  Tecnologias Utilizadas :computer:
- **Backend**: Java com o FrameWork Spring
- **Banco de Dados**: MySQL
- **Cliente Teste Local**: Insomnia
- **Deploy e Banco de Dados Remoto**: Render e Docker
- **Documentação**: Ferramenta Swagger

---

## Dependências :paperclips:
  - Spring Boot DevTools
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Validation
  - Spring Security
  - Geração e Validação Token JWT

---

## Como Executar? :runner:
### Localmente :round_pushpin:
Ao abrir o repositório do projeto, clique no botão **<> Code** e copie o link disponível na opção https e execute o comando **git clone <link-do-repositório-remoto>** ou faça o download e extração da pasta zip. Importe o projeto em sua IDE de escolha e execute o projeto. Com o projeto executando, é possível realizar os testes das funcionalidades utilizando o seu ambiente de teste de APIs de escolha, recomendamos o Insomnia.

### Remotamente :earth_americas:
Acesse a url __________, digite um usuário e senhas válidos fornecidos pelo time de desenvolvedores e utilize a aplicação.

### Pré-requisitos :clipboard:
   **Localmente**
   - **Java 17** ou superior
   - **MySQL** para gerenciamento do banco de dados
   - **Maven** para gerenciamento de dependências
   
   **Remotamente**
   - O navegador de sua escolha
   - Conexão com a Internet
   - Acesso Permitido pelo Time de Desenvolvedores

### Recomendações :thumbsup:
   - IDE **Spring Tools Suite**, para a execução do projeto.
   - **MySQL Workbench** para criação de entradas no banco de dados
   - Ferramenta **Insomnia** para realização dos testes
     
---

## Colaboradores :technologist:
Esse Projeto foi desenvolvido por Cacia Rodrigues, Anna Carolina Vighi, Bruno Alexandre Barros e Marcos Lopes

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/CaciaRodrigues">
        <img src="https://avatars.githubusercontent.com/u/98604798?v=4" width="125px;" alt="Colaboradora Cacia Rodrigues"/><br />
        <sub><b>Cacia Rodrigues</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/annavighi">
        <img src="https://avatars.githubusercontent.com/u/180130500?v=4" width="125px;" alt="Colaboradora Anna Carolina Vighi"/><br />
        <sub><b>Anna Carolina Vighi</b></sub>
      </a>
    </td>
        <td align="center">
      <a href="https://github.com/brunoalexb">
        <img src="https://avatars.githubusercontent.com/u/88696076?v=4" width="125px;" alt="Colaborador Bruno Alexandre Barros"/><br />
        <sub><b>Bruno Alexandre Barros</b></sub>
      </a>
    </td>
          <td align="center">
      <a href="https://github.com/marcoslopesdev">
        <img src="https://avatars.githubusercontent.com/u/110929754?v=4" width="125px;" alt="Colaborador Marcos Lopes"/><br />
        <sub><b>Marcos Lopes</b></sub>
      </a>
    </td>
  </tr>
</table>
