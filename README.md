## Automação de Teste para REST, Web e Mobile

Palestra ministrada no JavaOne Latin America 2016.
Aqui você vai encontrar informações sobre o código e ferramentas utilizadas.

### Ferramentas

#### Automação para REST
Utilização do [RESTAssured](https://github.com/rest-assured/rest-assured) como ferramenta de teste automatizado para REST com a utilização do [Java Spark](http://sparkjava.com) para a criação de Mocks REST.

#### Automação para Web
Utilização do [Selenium WebDriver](http://docs.seleniumhq.org) como ferramenta de teste automatizado para Web com a utilização d [Firebug](http://getfirebug.com) (plugin do Firefox) para inspeção dos elementos.

#### Automação para Mobile
Utilização do [Appium](http://appium.io) como ferramenta de teste automatizado para Mobile.
O foco é em um app Android, sendo necessário instalar também:
* [Android SDK](https://developer.android.com/studio/index.html)
* Configurar os PATHs do Android
* Instalar, pelo menos, um SDK Platform e um System Image para o emulador

### Código

#### Pacote src
* __SparkMockAPI__: Código de mock de uma API REST utilizando Java Spark
* __Person__: bean/pojo para materializar um objeto person

#### Pacote test

* __rest__: contém os testes de API REST com RESTAssured
* __web__: contém os testes web com Selenium WebDriver
* __mobile__: contém os testes mobile para Android com Appium
* __suite__: contém as suites de teste para cada camada
