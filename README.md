# pagamento_api

Swagger: http://localhost:8080/swagger-ui/index.html#/


Mocks para testes:

Mock com pix
{
    "codigoDebito": 100,
    "cpfCnpj": "123.456.789-10",
    "valorPagamento": "100",
    "tipoPagamento": "pix"
}

Mock para falhar com cartao

{
    "codigoDebito": 100,
    "cpfCnpj": "123.456.789-10",
    "valorPagamento": "100",
    "tipoPagamento": "cartao_debito"
}

Mock com cartão sem falha

{
    "codigoDebito": 155,
    "numeroCartao": "155515",
    "cpfCnpj": "123.456.789-10",
    "valorPagamento": "100",
    "tipoPagamento": "cartao_debito"
}


Mock para atualizacao de status de pagamento ser falha

{
    "codigoDebito": 100,
    "numeroCartao": "155515",
    "cpfCnpj": "123.456.789-10",
    "valorPagamento": "0",
    "tipoPagamento": "cartao_debito"
}


Paginação:

{
  "page": 1,
  "size": 1,
  "sort": [
  ]
}


Filtros:

{
  "codigoDebito": 100,
  "cpfCnpj": "123.456.789-10",
  "statusPagamento": "pendente"
}


