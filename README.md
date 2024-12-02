Projeto CRUD - Gestão de Categorias, Atividades e Emissões
Este é um projeto que implementa um CRUD (Create, Read, Update, Delete) para gerenciamento de Categorias, Atividades e Emissões (como Emissão de Gasolina) utilizando Spring Boot, H2 Database e HTTPie para testar a API.

Estrutura do Projeto
-Categoria: Representa uma categoria que pode ser associada a atividades e emissões.
-Atividade: Representa uma atividade relacionada a uma categoria.
-Emissão: Representa os dados sobre as emissões de CO2, incluindo emissões de gasolina.

Tecnologias Utilizadas
-Spring Boot
-H2 Database (para testes locais)
-HTTPie (para testes da API)
-Spring Data JPA (para persistência de dados)

///////////////////////////////////////////////////////////////////////////////////

Endpoints da API
Categoria:
Criar uma nova categoria
Rota: POST:http://localhost:8080/categorias
Corpo da requisição:
{
  "nome": "Transporte"
}
Rota: POST:http://localhost:8080/categorias/multi   para multiplas criações
Corpo da requisição:
[ 
        {"nome": "moto"},
        {"nome": "carro"},
        {"nome": "caminhão"}
]

Obter todas as categorias

Rota: GET:http://localhost:8080/categorias
Resposta esperada:
[
  {
    "id": 1,
    "nome": "Transporte"
  },
  {
    "id": 3,
    "nome": "carro"
  },
  {
    "id": 4,
    "nome": "caminhão"
  }
]

Obter categoria por ID

Rota: GET:http://localhost:8080/categorias/{id}
Resposta esperada:
{
    "id": 4,
    "nome": "caminhão"
}

Atualizar categorias

Rota: PUT://localhost:8080/categorias/{id}
Corpo da requisição:
{
    "nome": "Transporte Público"
}


Excluir categoria por ID
Rota: DELETE:http://localhost:8080/categorias/{id}
Corpo da requisição:http://localhost:8080/categorias/2
Resposta esperada:"Categoria excluída com sucesso!" 
-----------------------------------------------------------------------------------

Atividade:
Criar uma nova atividade

Rota: POST:http://localhost:8080/atividades
Corpo da requisição:
{
    "nome": "Deslocamento de Carro"
}

Obter todas as atividades

Rota: GET:http://localhost:8080/atividades/
Resposta esperada:
[
  {
    "id": 1,
    "nome": "Deslocamento de Bicicleta"
  },
  {
    "id": 2,
    "nome": "Carro"
  },
  {
    "id": 3,
    "nome": "Carro"
  },
  {
    "id": 4,
    "nome": "Carro"
  }
]

Obter atividade por ID
Rota:http://localhost:8080/atividades/{id}
Resposta esperada:
{
  "id": 1,
  "nome": "Deslocamento de Carro"
}

Atualizar atividade

Rota: PUT:http://localhost:8080/atividades/{id}
Corpo da requisição:
{
    "nome": "Deslocamento de Bicicleta"
}

Excluir atividade por ID
Rota: DELETE:http://localhost:8080/atividades/{id}
Resposta esperada:"atividade excluída com sucesso!" 
-----------------------------------------------------------------------------------


Criar emissão de gasolina
Rota: POST:http://localhost:8080/emissoes/gasolina
Corpo da requisição:
{
    "atividadeId": {id},
    "quantidadeGasolina": {Quantidade}
}  

Obter todas as emissões
Rota: GET:http://localhost:8080/emissoes/gasolina
CORRIGIR PARA ACEITAR POR ID OU TODOS

Obter emissão por ID
Rota: GET:http://localhost:8080/emissoes/gasolina/{id}
Resposta esperada:
{
  "id": 1,
  "quantidadeEmissao": 0,
}

Atualizar emissão
Rota: PUT:http://localhost:8080/emissoes/gasolina/{id}
Corpo da requisição:
{
    "quantidadeGasolina": {Quantidade}
}

Excluir emissão por ID
Rota: DELETE:http://localhost:8080/emissoes/gasolina/{id}
Resposta esperada:"Emissão excluída com sucesso!" 
-----------------------------------------------------------------------------------

Criar Relatório de Emissão
Rota: POST:http://localhost:8080/relatorios/emissao
Corpo da requisição:
{
    "atividadeId": {id},
    "categoriaId": {id},
    "emissaoTotal": {Quantidade}
}
Obter todos os relatórios de emissão
Rota: GET:http://localhost:8080/relatorios/emissao


Obter relatório de emissão por ID
Rota: GET:http://localhost:8080/relatorios/emissao/{id}

Atualizar Relatório de Emissão
Rota: PUT:http://localhost:8080/relatorios/emissao/{id}
Corpo da requisição:
{
    "atividadeId": {id},
    "categoriaId": {id},
    "emissaoTotal": {Quantidade}
}

Excluir Relatório de Emissão por ID
Rota: DELETE:http://localhost:8080/relatorios/emissao/{id}
Resposta esperada:"Relatório de Emissão excluído com sucesso!"
