package br.com.sefa.pagamento.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pagamento implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "codigo_debito", nullable = false)
        private int codigoDebito;

        @Column(name = "numero_cartao")
        private String numeroCartao;

        @Column(name = "cpf_cnpj")
        private String cpfCnpj;

        @Column(name = "valor_pagamento")
        private String valorPagamento;

        @Column(name = "tipo_pagamento")
        private String tipoPagamento;}
