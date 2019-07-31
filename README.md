# Protobuf - Apache Camel vs Spring Boot

Este projeto demonstra como utilizar o [Protobuf](https://developers.google.com/protocol-buffers/) para realizar a integração entre duas aplicações, como demonstração foram criadas utilizando a linaguagem Java, sendo a primeira com [Apache Camel](https://camel.apache.org/) e a segunda com [Spring Boot](https://spring.io/projects/spring-boot).

#### O que é Protobuf?
É um protocolo criado pelo Google em meados de 2001, permitindo a serialização e deserialização de dados estruturados. 

Por ser independente de linguagem ou plataforma, tem como objetivo facilitar a criação de contratos e interoperabilidade entre diferentes aplicações, sejam elas: Java e Python, entre Go e Node, entre Node e Java. 

O Protobuf trabalha com arquivos **.proto**, que possuem *schema* que define como será o contrato de integração. O Google resolveu disponibilizar no mercado por volta de 2008 e tem se popularizado cada vez mais, devido às suas caracteristicas, assim como sua performance quando comparado com XML e JSON. 


<p align="center">
  <img src="https://github.com/douglsantos/proc-apache-camel-integration-spring-boot-protobuf/raw/master/images/comparacao-protobuf-json.png">
Comparativo Protobuf vs JSON - <a href= "https://medium.com/@krebs.bruno/beating-json-performance-with-protobuf-c205397c8bc6">Bruno Krebs</a> - Julho, 2018.
</p>


De forma breve, para se trabalhar com o Protobuf é necessário 3 passos:
* Definição do contrato de forma estruturada - em um arquivo de extensão **.proto**;
* O arquivo é compilado e o resultado é o código-fonte automaticamente gerado para a linguagem desejada, até a data desse projeto as linguagens suportadas são: C++, C#, Dart, Go, Ruby, Java, Objective-C e Python;
* Código-fonte gerado está pronto para ser utilizado, seja para leitura ou gravação dos dados;

<p align="center">
  <img src="https://github.com/douglsantos/proc-apache-camel-integration-spring-boot-protobuf/raw/master/images/fluxo-protobuf.png">
</p>

Sempre que houver alguma alteração do contrato - arquivo *.proto* - o ciclo se repetirá.


## Getting Started

Os passos descritos fartão com que você execute o projeto em sua máquina localmente para fins de desenvolvimento, teste e estudo.

### Prerequisites

Para build e run das aplicações, você precisa:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


### Installing

Abra um terminal de comando ou importe o projeto na sua IDE favorita, e em seguida execute os comandos descritos abaixo:

- Instalar as dependências do projeto e compilar os arquivos **.proto**:

```
mvn clean install
```
- Execute as aplicações individualmente pelo terminal ou IDE:

```
mvn spring-boot:run
```

Importe as collections no Postman para executar os testes localmente.

## Running the tests

**TODO**

### Break down into end to end tests

**TODO**

### And coding style tests

**TODO**

## Deployment

**TODO**

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

**TODO**

## Authors

* **Douglas Santos** - *Initial work* - [douglsantos](https://github.com/douglsantos)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

