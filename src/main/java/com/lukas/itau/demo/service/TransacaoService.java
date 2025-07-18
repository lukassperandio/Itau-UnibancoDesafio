package com.lukas.itau.demo.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukas.itau.demo.models.EstatisticaDTO;
import com.lukas.itau.demo.models.Transacao;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    public boolean adicionar(Transacao transacao) {
        if (transacao == null
                || transacao.getDataHora() == null
                || transacao.getValor() < 0
                || transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            return false;
        }

        transacoes.add(transacao);
        return true;
    }

    
    public void limpar() {
        transacoes.clear();
    }

  
    public List<Transacao> obterTodasTransacoes() {
        return transacoes;
    }
    
    public EstatisticaDTO gerarEstatisticas() {
        OffsetDateTime agora = OffsetDateTime.now();
        System.out.println("Transações atuais: " + transacoes);

        DoubleSummaryStatistics stats = transacoes.stream()
            .filter(t -> t.getDataHora().isAfter(agora.minusSeconds(60)))
            .mapToDouble(Transacao::getValor)
            .summaryStatistics();

        return new EstatisticaDTO(
            stats.getCount(),
            stats.getSum(),
            stats.getAverage(),
            stats.getMin(),
            stats.getMax()
        );
    }

}
