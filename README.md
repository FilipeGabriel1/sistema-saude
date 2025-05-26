# Projeto Sistema de Saúde

Este projeto é um sistema de gerenciamento para uma clínica de saúde, desenvolvido em Java com persistência de dados em MySQL. Ele permite o cadastro, edição, remoção e listagem de pacientes, médicos, recepcionistas, exames e consultas.

## Autores

- *Maria Iasmin Clementino da Silva*
- *Filipe Gabriel Dutra Meves*
- *Maria Roberta de Lima Silva*


## Funcionalidades

- Cadastro, edição, remoção e listagem de:
  - Pacientes
  - Médicos
  - Recepcionistas
  - Exames
  - Consultas

- Persistência dos dados em banco MySQL via JDBC

## Estrutura do Projeto

- **Entidades**: Representam os objetos do sistema (Paciente, Medico, Recepcionista, Exame, Consulta, Administrador).
- **Serviços**: Camada de lógica de negócio para cada entidade.
- **Repositórios**: Responsáveis pela persistência dos dados no banco.
- **Interfaces**: Contratos para os repositórios.
- **Conexao.java**: Gerencia a conexão com o banco de dados MySQL.
- **Main.java**: Ponto de entrada da aplicação.

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL chamado `sistema_saude`.
2. Crie as tabelas necessárias (`paciente`, `medico`, `recepcionista`, `exame`, `consulta`) conforme os atributos das entidades.
3. Atualize as credenciais de acesso ao banco em [`Conexao.java`](src/main/java/co/projeto/Conexao.java) se necessário.

## Como Executar

1. Clone o repositório:
```bash
https://github.com/FilipeGabriel1/sistema-saude.git
```

2. Instale as dependências com Maven:
   ```sh
   mvn clean install
   ```
3. Execute o projeto:
   ```sh
   mvn exec:java -Dexec.mainClass="co.projeto.Main"
   ```
4. Observação
```
Troque a senha em Conexoes (LightMobile123) pela sua senha do MYSQL para poder se conectar ao banco de dados.
 ```

