package br.com.sefa.pagamento.repository;

import br.com.sefa.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
