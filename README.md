# pagamento_api

URLs:

Incluir pagamentos:
http://localhost:8080/pagamento

Buscar um pagamento por id:
http://localhost:8080/pagamento/id

Deletar um pagamento por id:
http://localhost:8080/pagamento/id

Atualizar um pagamento:
http://localhost:8080/atualizar/aprovar/id

Regressar pagamento falho para estado pendente
http://localhost:8080/atualizar/regressar/id


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



