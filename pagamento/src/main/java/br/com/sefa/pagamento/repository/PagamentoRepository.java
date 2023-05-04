package br.com.sefa.pagamento.repository;

import br.com.sefa.pagamento.model.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

//    @Query("SELECT p FROM pagamento p " +
//            "WHERE p.codigoDebito = :codigoDebito " +
//            "OR p.cpfCnpj like ':%cpfCnpj%'" +
//            "OR p.statusPagamento like ':%statusPagamento%'")
//    List<PagamentoEntity> findPagamentoEntityByCodigoDebitoOrCpfCnpjOrStatusPagamento(@Param("codigoDebito") int codigoDebito,
//                                                                                      @Param("cpfCnpj") String cpfCnpj,
//                                                                                      @Param("statusPagamento") String statusPagamento);
}
