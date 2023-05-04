package br.com.sefa.pagamento.service;

import br.com.sefa.pagamento.model.PagamentoEntity;
import br.com.sefa.pagamento.model.dto.FiltroPagamento;
import br.com.sefa.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private  PagamentoRepository pagamentoRepository;

    public Page<PagamentoEntity> listaPagamento(FiltroPagamento filtroPagamento, Pageable pageable){
        PagamentoEntity pagamentoEntity = PagamentoEntity.builder()
                .id(filtroPagamento.getId())
                .codigoDebito(filtroPagamento.getCodigoDebito())
                .cpfCnpj(filtroPagamento.getCpfCnpj())
                .statusPagamento(filtroPagamento.getStatusPagamento())
                .build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(pagamentoEntity, exampleMatcher);

        return pagamentoRepository.findAll(example, pageable);
    }

    public PagamentoEntity salvar(PagamentoEntity pagamento) throws Exception {

        //Utizando verificação com um contains no lugar de um enum por questão de tempo.
        if(pagamento.getTipoPagamento().contains("cartao") && pagamento.getNumeroCartao().isEmpty())
        {
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário Número do Cartão.");
            throw new Exception("Necessário Número do Cartão.");
         }

        return pagamentoRepository.save(pagamento);
    }

    public List<PagamentoEntity> listaPagamentoTodos(){
        return pagamentoRepository.findAll();
    }

    public Optional<PagamentoEntity> buscarPorId(Long id){
        return pagamentoRepository.findById(id);
    }

    public void removerPorId(Long id){
        pagamentoRepository.deleteById(id);
    }
}
