# Specification Pattern with Spring Boot and Spring Web

Este repositório contém exemplos de código que demonstram o uso do padrão de projeto Specification em conjunto com o framework Spring Boot e Spring Web para criar endpoints que consomem as especificações.

## Introdução

O padrão de projeto Specification é uma solução comum para lidar com a lógica de negócios complexa que envolve múltiplos critérios de seleção. O objetivo do padrão é separar a lógica de seleção dos objetos de negócios em classes independentes e reutilizáveis.

Neste repositório, você encontrará exemplos de código que demonstram como utilizar o padrão Specification em conjunto com o Spring Boot e Spring Web para criar endpoints que consomem as especificações.

![Arc](assets/img.png "Project Design")

## Design Patterns

O padrão de projeto Specification se enquadra na categoria de padrões comportamentais, que se concentram no comportamento de objetos e classes. No entanto, o padrão também pode ser combinado com outros padrões de projeto, como o Strategy e o Chain of Responsibility, para alcançar melhores resultados.

## Exemplos de Uso

Os exemplos de código neste repositório incluem casos de uso do padrão Specification em diferentes cenários, como seleção de produtos, cálculo de descontos e validação de regras de negócios.

## Como Usar

### Executando o projeto localmente

Para executar os exemplos de código, você precisa ter o ambiente de desenvolvimento Kotlin e Spring Boot instalado em sua máquina. Você pode executar o código diretamente a partir do seu editor de código preferido ou utilizando o comando `./mvnw spring-boot:run` no terminal.

A coleção do Postman contendo os endpoints disponíveis pode ser encontrada em [src/resources/Specification.postman_collection.json](src/resources/SpecificationPattern.postman_collection.json).

### Utilizando o Docker

Para rodar o projeto utilizando o Docker, siga as seguintes instruções:

1. Certifique-se de ter o Docker instalado em sua máquina.
2. Clone o repositório em sua máquina local.
3. Abra o terminal e navegue até o diretório raiz do projeto clonado.
4. Execute o seguinte comando para construir a imagem Docker: `docker build -t specification-pattern .`
5. Execute o seguinte comando para rodar a imagem Docker em um container: `docker run -p 8080:8080 specification-pattern`

Agora você pode acessar os endpoints do projeto através do `localhost:8080` em seu navegador ou ferramenta de API client.

## Contribuindo

Este repositório é aberto a contribuições de todos os níveis de habilidade. Se você tem um exemplo de código que demonstra o uso do padrão Specification em Kotlin e Spring Boot, ou se tem ideias para melhorias ou correções nos exemplos existentes, fique à vontade para abrir uma pull request.

## Licença

Este repositório está sob a licença MIT. Veja o arquivo [LICENSE.md](LICENSE.md) para mais detalhes.

---

