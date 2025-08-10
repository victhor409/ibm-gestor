
Sistema desenvolvido para gerenciar e organizar as finanças da Igreja Batista do Mirante, permitindo o controle de receitas, despesas e relatórios financeiros, com foco em transparência e eficiência.

## 📋 Funcionalidades

- Cadastro de receitas e despesas com categorias.
- Relatórios financeiros mensais e anuais.
- Controle de saldo atualizado automaticamente.
- Integração com banco de dados PostgreSQL.
- API REST para integração com outros sistemas.
- Serviço de envio de e-mails via Gmail.

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5
- Maven
- PostgreSQL
- Git & GitHub

## ⚙️ Configuração e Execução

### Pré-requisitos

- Java 21 instalado
- Maven instalado
- PostgreSQL instalado e configurado

### Passos para executar

1 - Clone o repositório:

```
git clone https://github.com/SEU_USUARIO/seu-repositorio.git
```

2 - Configure o `application.properties`:

```
spring.application.name=gestor  
  
spring.datasource.url=jdbc:postgresql://localhost:5432/${DB_NAME}  
spring.datasource.username=${DB_USER}  
spring.datasource.password=${DB_PASSWORD}  
spring.datasource.driver-class-name=org.postgresql.Driver  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
  
spring.mail.host=smtp.gmail.com  
spring.mail.port=587  
spring.mail.username=${USER_EMAIL}  
spring.mail.password=${EMAIL_APP_PASSWORD}  
spring.mail.properties.mail.smtp.auth=true  
spring.mail.properties.mail.smtp.starttls.enable=true
```

3 - Compile e execute:

```
mvn spring-boot:run
```


---

## 🗄 Banco de Dados

- Banco: PostgreSQL
- É necessário criar previamente o banco de dados no PostgreSQL:
```
CREATE DATABASE nomedobanco;
```

---

## 📌 Contribuindo

Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias no sistema.