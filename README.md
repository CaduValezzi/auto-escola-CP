
# 📘 API Auto-Escola - Checkpoint 1

## 🎯 Objetivo
Este projeto tem como finalidade aplicar os conceitos de **APIs REST com Spring Boot** no contexto de uma autoescola, permitindo o **cadastro, listagem, atualização, exclusão e agendamento de instruções** para alunos e instrutores.  

---

## 👥 Integrantes
- RM551059 | Cassio Valezzi
- RM98215 | Gabriel Antony Cadima Ciziks
- RM98169 | Lucca Sabatini Tambellini
- RM550781 | Sabrina Flores Morais
---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3+**
- **Banco de Dados H2**
- **JPA/Hibernate**
- **DTO, VO e Entidades**
- **Validações e Migrations**

---

## 📂 Funcionalidades

### 👨‍🏫 Instrutores
- **Cadastro** com:
  - Nome, E-mail, Telefone, CNH, Especialidade (Motos, Carros, Vans, Caminhões), Endereço completo  
  - Número e complemento do endereço são opcionais  
- **Listagem** paginada (10 registros por página), ordenada por nome, exibindo: Nome, E-mail, CNH, Especialidade  
- **Atualização**:
  - Pode alterar: Nome, Telefone, Endereço  
  - **Não pode alterar:** E-mail, CNH e Especialidade  
- **Exclusão lógica** (marcado como *inativo*, sem apagar dados)

---

### 👨‍🎓 Alunos
- **Cadastro** com:
  - Nome, E-mail, Telefone, CPF, Endereço completo  
  - Número e complemento do endereço são opcionais  
- **Listagem** paginada (10 registros por página), ordenada por nome, exibindo: Nome, E-mail, CPF  
- **Atualização**:
  - Pode alterar: Nome, Telefone, Endereço  
  - **Não pode alterar:** E-mail e CPF  
- **Exclusão lógica** (marcado como *inativo*, sem apagar dados)

---

### 📅 Agendamento de Instruções
- **Cadastro**:
  - Aluno, Instrutor (opcional, senão sorteado automaticamente), Data/Hora  
- **Regras de negócio**:
  - Funcionamento: **Seg-Sáb, das 06:00 às 21:00**  
  - Duração fixa: **1h**  
  - Antecedência mínima: **30 min**  
  - Restrições:
    - Aluno/instrutor não podem estar inativos  
    - Máximo **2 instruções por dia** por aluno  
    - Instrutor não pode ter conflito de horário  
- **Cancelamento**:
  - Requer **motivo obrigatório** (Aluno desistiu, Instrutor cancelou, Outros)  
  - Cancelamento só permitido com **mínimo de 24h de antecedência**

---

## 📦 Estrutura do Projeto
- **controllers/** → Endpoints REST  
- **services/** → Regras de negócio  
- **repositories/** → Acesso ao banco (JPA)  
- **dtos/** → Transferência de dados entre API e sistema  
- **entities/** → Entidades do domínio  
- **vos/** → Objetos de valor (endereços, etc.)  

---

## 🛠️ Como Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-autoescola.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd api-autoescola
   ```
3. Compile e rode:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse no navegador:
   ```
   http://localhost:8080
   ```

---
