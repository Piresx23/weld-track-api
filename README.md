WELD TRACK

A Weld Track é uma API feita para fazer a gestão, monitorização e controlo dos soldadores e dos seus registos de trabalho.

A aplicação permite registrar a atividade diaria os tempos gastos e garantir a validação dos dados.

----Tecnologias Usadas-------------------------------------------------

As tecnologias que usei foram as seguintes:

- Java 21 -> (anteriormente 26 mas dava muitos erros entao mudei)

- SpringBoot 3.4.2 -> (anteriormente tambem era uma versão mais recente mas tambem mudei)

- PostgreSQL (Base de dados)

- Springdoc OpenAPI 2.7.0 (documentação interativa para o API, anteriormente 2.6.0)

- Maven

----Pré-Requesitos-------------------------------------------------------

1. Java21
2. PostgreSQL (porta 5432)
3. Maven

Para correr o projeto basta abrir no Intelij esperar que o maven reconheça os
comandos, certeficar se que o pstgreSQL esta a rodar e executar no inteliJ o 
Código principal main.

----EndPoints Disponiveis----------------------------------------------

Para cada classe tem disponivel 6 Endpoits

- GET - Lista a informação
- GET para o ID - Procura o ID
- POST - Cria novo
- PUT - Atualiza os dados
- DELETE - Apaga