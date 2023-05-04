package br.com.sefa.pagamento.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiltroPagamento {

    private Long id;
    private Integer codigoDebito;
    private String cpfCnpj;
    private String statusPagamento;

}