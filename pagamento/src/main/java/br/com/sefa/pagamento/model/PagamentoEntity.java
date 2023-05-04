package br.com.sefa.pagamento.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity (name = "pagamento")
public class PagamentoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "codigo_debito", nullable = false)
        private Integer codigoDebito;

        @Column(name = "numero_cartao")
        private String numeroCartao = "";

        @Column(name = "cpf_cnpj", nullable = false)
        private String cpfCnpj;

        @Column(name = "valor_pagamento", nullable = false)
        private String valorPagamento;

        @Column(name = "tipo_pagamento", nullable = false)
        private String tipoPagamento;

        @Column(name = "status_pagamento")
        private String statusPagamento = "P";

}