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

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

