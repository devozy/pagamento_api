package br.com.sefa.pagamento.util;

public enum EnumStatus {

    SUCESSO("Processado com Sucesso", 1),
    FALHA("Processado com Falha", 2),
    PENDENTE("Processamento Pendente", 3);

    private String descricao;
    private int idEnum;

    EnumStatus(String descricao, int idEnum) {
        this.descricao = descricao;
        this.idEnum = idEnum;
    }


    public String getDescricao() {
        return descricao;
    }

    public int getIdEnum() {
        return idEnum;
    }
}
