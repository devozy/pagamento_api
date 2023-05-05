package br.com.sefa.pagamento.service;

import br.com.sefa.pagamento.util.EnumStatus;
import br.com.sefa.pagamento.model.PagamentoEntity;
import br.com.sefa.pagamento.repository.PagamentoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            pagamento.setStatusPagamento(EnumStatus.SUCESSO.getDescricao());
            pagamento.setIdStatusPagamento(EnumStatus.SUCESSO.getIdEnum());
        }
        else{
            pagamento.setStatusPagamento(EnumStatus.FALHA.getDescricao());
            pagamento.setIdStatusPagamento(EnumStatus.FALHA.getIdEnum());
        }

        return pagamentoRepository.save(pagamento);
    }

    public PagamentoEntity regressarPendencia (Long id) throws NotFoundException  {

        Optional<PagamentoEntity> pagamentoOptional =  pagamentoService.buscarPorId(id);
        PagamentoEntity pagamento = pagamentoOptional.orElseThrow(() -> new NotFoundException("Pagamento não encontrado"));

        if(pagamento.getIdStatusPagamento().equals(EnumStatus.FALHA.getIdEnum()))
        {
            pagamento.setStatusPagamento(EnumStatus.PENDENTE.getDescricao());
            pagamento.setIdStatusPagamento(EnumStatus.PENDENTE.getIdEnum());
        }
        return pagamentoRepository.save(pagamento);
    }


}
