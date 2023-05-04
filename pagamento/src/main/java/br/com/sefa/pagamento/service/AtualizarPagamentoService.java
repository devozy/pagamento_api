package br.com.sefa.pagamento.service;

import br.com.sefa.pagamento.model.PagamentoEntity;
import br.com.sefa.pagamento.repository.PagamentoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AtualizarPagamentoService {

    @Autowired
    private  PagamentoRepository pagamentoRepository;
    @Autowired
    private PagamentoService pagamentoService;

    public PagamentoEntity atualizarPagamento(Long id) throws NotFoundException {

        Optional<PagamentoEntity> pagamentoOptional =  pagamentoService.buscarPorId(id);
        PagamentoEntity pagamento = pagamentoOptional.orElseThrow(() -> new NotFoundException("Pagamento não encontrado"));

        boolean pagamentoConfirmado = false;

        if(pagamento.getValorPagamento() > 0){
            pagamentoConfirmado = true;
        }

        if(pagamentoConfirmado)
        {
            pagamento.setStatusPagamento(Util.SUCESSO.getDescricao());
            pagamento.setIdStatusPagamento(Util.SUCESSO.getIdEnum());
        }
        else{
            pagamento.setStatusPagamento(Util.FALHA.getDescricao());
            pagamento.setIdStatusPagamento(Util.FALHA.getIdEnum());
        }

        return pagamentoRepository.save(pagamento);
    }

    public PagamentoEntity regressarPendencia (Long id) throws NotFoundException  {

        Optional<PagamentoEntity> pagamentoOptional =  pagamentoService.buscarPorId(id);
        PagamentoEntity pagamento = pagamentoOptional.orElseThrow(() -> new NotFoundException("Pagamento não encontrado"));

        if(pagamento.getIdStatusPagamento().equals(Util.FALHA.getIdEnum()))
        {
            pagamento.setStatusPagamento(Util.PENDENTE.getDescricao());
            pagamento.setIdStatusPagamento(Util.PENDENTE.getIdEnum());
        }
        return pagamentoRepository.save(pagamento);
    }


}
