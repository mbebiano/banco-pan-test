# Vis�o geral

O projeto � um servi�o back-end, com o objetivo de atender os requisitos elencados pelo Banco Pan.

Afim de auxiliar o prcesso de testes encontra-se disponivel um servi�o para persist�ncia de cliente.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) � uma framework que auxilia na configura��o e execu��o de aplica��es Java, e que tem como objetivo facilitar esses pontos contribuindo tamb�m para a agilidade no procecsso de desenvolvimento.

- [Spring Data](https://spring.io/projects/spring-data) Facilita o uso de tecnologias de acesso a dados, bancos de dados relacionais e n�o relacionais sendo sua miss�o fornecer um modelo de programa��o familiar e consistente baseado em Spring para acesso a dados.


# Setup da aplica��o (local)

## Pr�-requisito

Antes de rodar a aplica��o � preciso garantir que as seguintes depend�ncias estejam corretamente instaladas:
```
Java 11
Maven 3.8.4 
```

## Instala��o da aplica��o

Primeiramente, fa�a o clone do reposit�rio:
```
git clone https://github.com/mbebiano/banco-pan-test
```
Feito isso, acesse o projeto:
```
cd banco-pan-test
```
� preciso compilar o c�digo e baixar as depend�ncias do projeto:
```
mvn clean install
```

Finalizado esse passo, vamos iniciar a aplica��o:
```
mvn spring-boot:run
```
Pronto. A aplica��o back-end est� dispon�vel em http://localhost:8080/
```
Tomcat started on port(s): 8080 (http)
Started BancopanApplication in xxxx seconds (JVM running for xxxx)
```

## Swagger

A API fornece uma breve documenta��o via Swagger. Ap�s startada, voc� poder� acess�-la atrav�s da url:
```
http://localhost:8080/swagger-ui.html
```

## Collections

Caso necessite poder� importar as collections utilizadas para realiza��o de testes na aplica��o:
```
https://www.getpostman.com/collections/6f6c841605806f1776d6
```

# API

O projeto disponibiliza API possibilitando consultas de clientes, busca de estados dentre outros, produzindo e consumindo dados em formato JSON.
