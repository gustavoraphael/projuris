# Projuris Order Service
Serviço de Ordens de Serviço da Projuris

### Tecnologias utilizadas:

* **Spring:** Spring Boot, Spring Web, Spring Data JPA
* **Flyway:** versionamento de dados (migrations)
* **Maven:**  gerenciamento do projeto
* **PostgresJDBC:**  driver para conexão com banco
* **Docker:** Container do serviço

### Build
Para realizar o build do serviço execute:
```sh
$ mvn clean install
```

### Testes Automatizados
O serviço possui testes que garantem o funcionamento das regras de negócio solicitadas.


### Flyway
O projeto possui dois scripts que são executados de forma sequencial:

* **V1__init.sql:** responsável pela criação da estrutura de tabelas do serviço.
* **V2__initSetup.sql:** responsável por um "boot" inicial de dados do serviço

### Debug Remoto
Para debugar remotamente atribuir ao JAVA_OPTS no em **projuris-order-service** do docker-compose o seguinte valor:
```sh
 - JAVA_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8100,suspend=y # REMOTE DEBUG
```
Com isso, ao executar `docker-compose up` o container ficará aguardando a conexão remota para iniciar.
