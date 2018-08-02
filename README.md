# Desafio MUXI

Desafio passado pela MUXI para criação de um aplicativo consumindo a API para exibição de uma lista de frutas e seus detalhes,
convertendo seus valor em dolar para real.

## Ferramenta de desenvolvimento e linguagem
- Android Studio 3.1.3
- Kotlin 1.2.60


## Requisitos
- JDK 1.8
- Android SDK.
- Versão minima LOLLIPOP (SDK 21)
- Ultimas versões do Android SDK Tools e build tools.

## Bibliotecas
- Support libraries
- RecyclerViews
- Constraint Layout
- Mockito
- Gson
- Picasso

## Sobre o projeto

O projeto em tem uma premissa simples mas serve para demonstrar os conhecimentos de desenvolvimento da plataforma, uso de bibliotecas e padrões. Alguns itens não foram resolvidos como os métodos nitive e os testes funcionais. Infelismente tive bastantes contratempos devido ao lançamento do novo app que apresentou muitos erros dos lados da API e consumiu boa parte do tempo que pretendia dedicar ao desafio, mas tentei fazer ao menos uma MVP aceitavel para esse desafio.

Utilizei as pricipais bibliotecas utilizadas pelo mercado para o desenvolvimento do app como o Retrofit para a comunicação com a API e o Picasso para o carregamento das imagens. Também escrevi alguns testes unitários utilizando o Mockito. Testes funcionais não foram realizados, mas a ideia era utlizar a ferramenta do proprio Android Studio para isso (Record Espresso Test).

Sobre layout o fiz todo redimensionavel utilizando o Constraint Layout. O layout é exibido tanto no formato portrait quando landscape sem perder seu estado. Na tela de detalhe da fruta selecionada ao mudar a orientação o layout tbm muda, o objetivo era mostrar a exibição de diferentes layouts dependendo da orientação.

## Telas

### Tela principal portrait

[![Tela Principal](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/main_portrait.jpeg)](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/main_portrait.jpeg)

### Tela principal landscape

[![Tela Principal](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/mail_landscape.jpeg)](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/mail_landscape.jpeg)


### Tela de detalhes portrait

[![Tela Principal](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/detail_portrait.jpeg)](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/detail_portrait.jpeg)

### Tela de detalhes portrait

[![Tela Principal](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/detail_landscape.jpeg)](https://github.com/AllysonBRodrigues/desafio-muxi/blob/master/screenshots/detail_landscape.jpeg)
