package br.com.sefa.pagamento.model.dto;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
    private int codigoDebito;
    private String cpfCnpj;
    private String status;

}