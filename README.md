# Visão geral

O projeto é um serviço back-end, com o objetivo de atender os requisitos elencados pelo Banco Pan.

Afim de auxiliar o prcesso de testes encontra-se disponivel um serviço para persistência de cliente.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma framework que auxilia na configuração e execução de aplicações Java, e que tem como objetivo facilitar esses pontos contribuindo também para a agilidade no procecsso de desenvolvimento.

- [Spring Data](https://spring.io/projects/spring-data) Facilita o uso de tecnologias de acesso a dados, bancos de dados relacionais e não relacionais sendo sua missão fornecer um modelo de programação familiar e consistente baseado em Spring para acesso a dados.

- [H2 Database](https://www.h2database.com/html/main.html) Utilização do banco de dados H2 como repositório em memória.

# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 11
Maven 3.8.4 
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
git clone https://github.com/mbebiano/banco-pan-test
```
Feito isso, acesse o projeto:
```
cd banco-pan-test
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean install
```

Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação back-end está disponível em http://localhost:8080/
```
Tomcat started on port(s): 8080 (http)
Started BancopanApplication in xxxx seconds (JVM running for xxxx)
```

## Swagger

A API fornece uma breve documentação via Swagger. Após startada, você poderá acessá-la através da url [Local Swagger](http://localhost:8080/swagger-ui.html).

## Collections

Caso necessite poderá importar as collections utilizadas para realização de testes na aplicação [Collections Postman](https://www.getpostman.com/collections/a5b5d0a3b12c0cd55614).

# API

O projeto disponibiliza API possibilitando consultas de clientes, busca de estados dentre outros, produzindo e consumindo dados em formato JSON.
