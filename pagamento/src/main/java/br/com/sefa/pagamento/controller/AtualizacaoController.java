package br.com.sefa.pagamento.controller;

import br.com.sefa.pagamento.model.PagamentoEntity;
import br.com.sefa.pagamento.model.dto.FiltroPagamento;
import br.com.sefa.pagamento.service.AtualizarPagamentoService;
import br.com.sefa.pagamento.service.PagamentoService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/atualizar")
public class AtualizacaoController {

    @Autowired
    private AtualizarPagamentoService atualizarPagamentoService;

    @Autowired
    private PagamentoService pagamentoService;

    @PutMapping("/aprovar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPagamento(@PathVariable("id") Long id){
        pagamentoService.buscarPorId(id)
                .map(pagamento -> {
                    try {
                        atualizarPagamentoService.atualizarPagamento(id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

    @PutMapping("/regressar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void regressarPendencia(@PathVariable("id") Long id){
        pagamentoService.buscarPorId(id)
                .map(pagamento -> {
                    try {
                        atualizarPagamentoService.regressarPendencia(id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

}
