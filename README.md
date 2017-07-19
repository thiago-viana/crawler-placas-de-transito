# Crawler
Esta aplicação é um crawler que acessa o site https://clubedetran.com.br em busca de informações sobre as principais placas de trânsito.
Ao término da execução do crawler teremos uma base de dados contendo informações referentes as placas dos tipos:
- Advertência
- Regulamentares
- Serviços auxiliares
### Antes de executar a aplicação
É preciso criar uma base de dados antes de executar o crawler. É nela que ele guardará as informações que ele encontrar sobre cada uma das placas. A seguir um passo-a-passo para a criação da base de dados no MySQL via linha de comando.
##### Acessando o MySQL
```
mysql -uroot -proot 
```
##### Criando o banco
```
create database detran; 
```
##### Selecionando o banco detran 
```
use detran; 
```
##### Criando a tabela
```
CREATE TABLE placas ( 
id INT(5) AUTO_INCREMENT PRIMARY KEY, 
sigla VARCHAR(10) NULL, 
titulo VARCHAR(100) NULL, 
descricao VARCHAR(2000) NULL, 
imagem VARCHAR(300) NULL 
);
```
Finalizada a criação da tabela, a aplicação estará pronta para ser executada.
### Executando a aplicação

  - Clone o projeto e importe-o para o eclipse
  - Acesse a classe BaseDAO e a configure para que ela consiga se conectar ao seu banco
  - Execute o método main da classe *CrawlerRegulamentacaoAdvertencia* e o da classe *CrawlerServicosAuxiliares*

Se tudo ocorreu como o esperado, teremos uma base de dados MySQL chamada *detran*
com a tabela *placas* populada pela execução do crawler.

### Observações
O banco de dados criado será usado por uma aplicação web. Essa aplicação web irá buscar, de maneira aleatória, uma das placas
e a exibirá para o usuário, que tentará adivinhar o seu significado, em seguida o usuario poderá verificar a resposta cliacando
em um botão que traga o restante das innformações da placa.
