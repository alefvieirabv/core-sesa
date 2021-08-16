
Para os seguintes procedimentos, será necessário a instalação do docker (https://www.docker.com) e configurações mínimas para que o projeto seja executado com sucesso. São elas:

## Instalando o docker ##

OBS.: Realizar todos comandos com privilégios de admin/root.

1. Instalar docker (https://www.docker.com)

2. Verificar instalação (https://docs.docker.com/engine/reference/commandline/version): 

    ```bash
    $ docker -v
    Docker version 20.1.7, build f0df350
    ```

## Criação do Banco de Dados ##

1. Com o docker instalado, iremos criar um container para o banco de dados Postgres 10.0

```bash
$ docker run --name postgres_sesa -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_ROOT_PASSWORD=postgres -e TZ=America/Fortaleza -d postgres:10.0
```

2. No próximo passo, serão criadas as bases de dados usando os seguintes comandos:

```sql
CREATE DATABASE retaguardadb_sesa WITH ENCODING='UTF8';
```

3. Ao executar o projeto o mesmo irá criar automaticamente todas as tabelas e campos correspondentes (Segue abaixo o exemplo do que será criado):

```sql
CREATE TABLE PESSOA (
   id             SERIAL        PRIMARY KEY,
   nome           VARCHAR(255),
   sobrenome      VARCHAR(255),
   cpf            VARCHAR(255)  UNIQUE
);

CREATE TABLE CONTATO (
   id            SERIAL        PRIMARY KEY,valor   VARCHAR(255) NOT NULL,
   id_pessoa     INT           NOT NULL REFERENCES PESSOA,
   tipo_contato  INT           NOT NULL
);
```
## Informações de Ambiente de Execução ##

Angular CLI: 10.1.3

Node: 12.18.3

OS: darwin x64

JAVA: 11