package br.com.sefa.pagamento.service;

import br.com.sefa.pagamento.entity.Pagamento;
import br.com.sefa.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listaPagamento(){
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id){
        return pagamentoRepository.findById(id);
    }

    public void removerPorId(Long id){
        pagamentoRepository.deleteById(id);
    }
}
