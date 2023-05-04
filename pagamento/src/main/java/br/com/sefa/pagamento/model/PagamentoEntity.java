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

        @Column(name = "codigo_debito")
        private Integer codigoDebito;

        @Column(name = "numero_cartao")
        private String numeroCartao;

        @Column(name = "cpf_cnpj")
        private String cpfCnpj;

        @Column(name = "valor_pagamento")
        private String valorPagamento;

        @Column(name = "tipo_pagamento")
        private String tipoPagamento;

        @Column(name = "status_pagamento")
        private String statusPagamento;

}