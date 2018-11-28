# spring
Para rodar o projeto, executar o jar: 
avaliacao-0.0.1-SNAPSHOT.jar

Para verificar os serviços disponíveis, abrir a URL: 

http://localhost:8080/swagger-ui.html

É possível visualizar o uso da fila com o projeto

http://activemq.apache.org/activemq-5158-release.html

Basta fazer download de acordo com o SO, descompactar, acessar o diretorio bin e rodar o executável.

A URL default é http://localhost:8161/admin/ e

o Usuario/senha é admin

- o Endpoint http://localhost:8080/pessoa/add envia o json para uma fila
- O listener JmsConsumer logo que percebe algo na fila recupera a informação e persiste no banco em memŕóia
- o Endpoint http://localhost:8080/pessoa/list irá listar os registros que foram enviados pela fila ao banco