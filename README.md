<div id="top"></div>

[![LinkedIn][linkedin-shield]][linkedin-url]

  <h2 align="center">1k Guesser </h2>
  <p align="center"> Eu vou programagicamente adivinhar o seu número! </p
    <br /> <br />
 



<details>
  <summary>Sumário</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o projeto</a>
      <ul>
        <li><a href="#ferramentas-utilizadas">Ferramentas utilizadas</a></li>
      </ul>
    </li>
    <li>
      <ul>
        <li><a href="#requisitos">Requisitos</a></li>
        <li><a href="#instalar">Instalar</a></li>
      </ul>
    </li>
  </ol>
</details>



## Sobre o projeto


Este 'Jogo' foi criado como um desafio, uma proposta da Scale ,  o desafio é implementar um jogo que adivinhe o seu número, de 1 a 1000, utilizando Java com Spring Boot no backend, e Html / Javascript (minha opção) no frontend.

A arquitetura está tal qual a da  proposta pelo próprio Spring



### Ferramentas utilizadas

* Java SE 11
* Maven 
* Spring Boot 2.5.2, Spring Data, Spring Validation, Spring Web,
* H2 (Banco em memória) 
* Project Lombok ( Diminuir código repetitivo )
* Swagger / Swagger UI 2.9.2 ( Documentação API / Endpoints ), (Foi mais utilizado para referências iniciais)
* JPA / Hibernate ( Mapeamento Objeto-Relacional )



### Requisitos
* Na configuração atual do projeto, não há requisito algum. Em especial utilizando o wrapper do Maven (mvnw), nem mesmo uma IDE se faz necessária.
  
   

### Instalar

1. Clone este repositório
   ```sh
   git clone https://github.com/jonahanzen/1kguesser.git
   ```
   
#### Se rodar usando o Maven

2.  Abra o terminal na pasta do projeto e execute o comando
   ```sh
   mvnw spring-boot:run
   ```
  
3. Abra o index.html  no browser de sua escolha
  ```sh
  O index deve funcionar em qualquer browser
  ```

OPCIONAL -  Acesse o link para testar os endpoints e uso geral do projeto
 ```sh
 http://localhost:8080/swagger-ui.html#/
  ```

<!-- Links -->
[test]: src/test/java/br/com
[lombok]: https://projectlombok.org
[pom]: pom.xml
[application-properties]: src/main/resources
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://br.linkedin.com/in/jonathanhflores


