package br.com.sefa.pagamento.repository;

import br.com.sefa.pagamento.model.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}
