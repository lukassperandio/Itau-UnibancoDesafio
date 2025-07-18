package com.lukas.itau.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukas.itau.demo.models.EstatisticaDTO;
import com.lukas.itau.demo.models.Transacao;
import com.lukas.itau.demo.service.TransacaoService;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    
    
    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        List<Transacao> lista = transacaoService.obterTodasTransacoes();
        return ResponseEntity.ok(lista);
    }

    
    @PostMapping("/transacao")
    public ResponseEntity<Void> criarTransacao(@RequestBody Transacao transacao) {
        boolean aceita = transacaoService.adicionar(transacao);

        if (!aceita) {
            return ResponseEntity.unprocessableEntity().build(); 
        }

        return ResponseEntity.status(201).build(); 
    }

    @DeleteMapping("/deleteTransacao")
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limpar();
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/estatisticas")
    public EstatisticaDTO obterEstatisticas() {
        return transacaoService.gerarEstatisticas();
    }
    
}














