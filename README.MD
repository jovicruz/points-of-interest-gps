
# Points of Interest API

*Esse projeto é a solução de um [desafio da backend-br](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md)*

API construída com Spring Boot que permite criar pontos de interesse, listar todos os pontos e encontrar os mais próximos a um ponto de referência com base em uma distância máxima.

## Funcionalidades

- **Criação de Pontos de Interesse:** Permite adicionar novos pontos de interesse com nome e coordenadas.
- **Listagem de Pontos de Interesse:** Retorna todos os pontos de interesse cadastrados.
- **Busca de Pontos de Interesse Próximos:** Encontra e retorna pontos de interesse que estão dentro de uma distância máxima de um ponto de referência fornecido.

## Endpoints

### 1. Criar um Novo Ponto de Interesse

- **Método:** `POST`
- **Endpoint:** `/newpoi`
- **Descrição:** Recebe os detalhes de um novo ponto de interesse e cria uma entrada no banco de dados.
- **Exemplo de Request:**

  ```json
  {
    "name": "Sorveteria",
    "x": 10,
    "y": 10
  }
  ```

- **Exemplo de Response:**

  ```json
  {
    "name": "Sorveteria",
    "x": 10,
    "y": 10
  }
  ```

- **Status de Resposta:** `201 Created`

### 2. Listar Todos os Pontos de Interesse

- **Método:** `GET`
- **Endpoint:** `/`
- **Descrição:** Retorna uma lista de todos os pontos de interesse cadastrados.
- **Exemplo de Response:**

  ```json
  [
    {
      "name": "Lanchonete",
      "x": 27,
      "y": 12
    },
    {
      "name": "Posto",
      "x": 31,
      "y": 18
    },
    {
      "name": "Joalheria",
      "x": 15,
      "y": 12
    },
    {
      "name": "Floricultura",
      "x": 19,
      "y": 21
    },
    {
      "name": "Pub",
      "x": 12,
      "y": 8
    },
    {
      "name": "Supermercado",
      "x": 23,
      "y": 6
    },
    {
      "name": "Churrascaria",
      "x": 28,
      "y": 2
    }
  ]
  ```

- **Status de Resposta:** `200 OK`

### 3. Encontrar Pontos de Interesse Próximos

- **Método:** `POST`
- **Endpoint:** `/getnearest/`
- **Descrição:** Envia um ponto de referência com coordenadas e distância máxima e retorna os pontos de interesse que estão dentro dessa distância.
- **Exemplo de Request:**

  ```json
  {
    "x": 25,
    "y": 15,
    "dMax": 10
  }
  ```

- **Exemplo de Response:**

  ```json
  [
    {
      "name": "Lanchonete",
      "x": 27,
      "y": 12
    },
    {
      "name": "Joalheria",
      "x": 15,
      "y": 12
    },
    {
      "name": "Supermercado",
      "x": 23,
      "y": 6
    }
  ]
  ```

- **Status de Resposta:** `200 OK`
