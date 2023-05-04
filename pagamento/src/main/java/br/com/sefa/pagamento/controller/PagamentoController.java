package br.com.sefa.pagamento.controller;

import br.com.sefa.pagamento.entity.Pagamento;
import br.com.sefa.pagamento.service.PagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento salvar(@RequestBody Pagamento pagamento){
        return pagamentoService.salvar(pagamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listaPagamento(){
        return pagamentoService.listaPagamento();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento buscarPagamentoPorId(@PathVariable("id") Long id){
        return pagamentoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPagamento(@PathVariable("id") Long id){
        pagamentoService.buscarPorId(id)
                .map(pagamento -> {
                    pagamentoService.removerPorId(pagamento.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPagamento(@PathVariable("id") Long id, @RequestBody Pagamento pagamento){
        pagamentoService.buscarPorId(id)
                .map(pagamento1 -> {
                    modelMapper.map(pagamento, pagamento1);
                    pagamentoService.salvar(pagamento1);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento nao encontrado."));
    }


}
