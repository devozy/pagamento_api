# pagamento_api

Swagger: http://localhost:8080/swagger-ui/index.html#/


Dados Mockagem

==================================================

POST

Pagamento com PIX
{ 
"codigoDebito": 101, 
"cpfCnpj": "123.456.789-10", 
"valorPagamento": "100", 
"tipoPagamento": "pix" 
}

Pagamento com boleto
{ 
"codigoDebito": 102, 
"cpfCnpj": "123.456.789-10", 
"valorPagamento": "100", 
"tipoPagamento": "boleto" 
}

Pagamento com cartão (bad request porque não há número do cartão)
{ 
"codigoDebito": 103, 
"cpfCnpj": "123.456.789-10", 
"valorPagamento": "100", 
"tipoPagamento": "cartao_debito" 
}

Pagamento com cartão (com número de cartão)
{ 
"codigoDebito": 103, 
"cpfCnpj": "123.456.789-10", 
"numeroCartao": "155515", 
"valorPagamento": "100", 
"tipoPagamento": "cartao_debito" 
}


Dados para que o pagamento seja processado como "Falha" 
{ 
"codigoDebito": 104, 
"cpfCnpj": "123.456.789-10", 
"valorPagamento": "0", 
"tipoPagamento": "pix" 
}


==================================================

GET (lista)

Paginação: 
{}

Filtros
Ex1: 
{ 
"codigoDebito": 101, 
"cpfCnpj": "123.456.789-10", 
"statusPagamento": "pendente" 
}

Ex2: 
{ 
"statusPagamento": "pendente" 
}

==================================================
