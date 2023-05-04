package br.com.sefa.pagamento.repository;

import br.com.sefa.pagamento.model.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {


    PagamentoEntity findPagamentoEntityByIdStatusPagamentoAndId(Long Id, int id);
}
