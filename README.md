# projuris
Projeto baseado em Docker, possuindo 2 containers, sendo eles:
* projuris-database-server: container responsável pela base de dados com PostgreSQL
* projuris-order-service: serviço de ordens de serviço

### Estrutura de pastas
Entendendo a estrutura do projeto:

* **/applications**: local onde se encontra o microserviço. Visualize o README interno do serviço para maiores detalhes.
* **/storage**: local onde se encontra a configuração do banco (Dockerfile + init.sql) e o mapeamento do Volume.
* **docker-compose.yml**: docker-compose, para iniciar o projeto execute `docker-compose up`
