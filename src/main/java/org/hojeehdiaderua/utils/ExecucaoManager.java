package org.hojeehdiaderua.utils;

import org.hojeehdiaderua.beans.admin.Execucao;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class ExecucaoManager {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm:ss.A");
    private List<String> log;
    private Execucao execucao;
    private Instant inicio;
    private Instant fim;

    public void criarNovaExecucao() {
        execucao = new Execucao();
        log = newArrayList();
        inicio = Instant.now();

        execucao.setTimestampInicial(inicio.toString());
    }

    public void adicionaLog(String mensagem) {
        log.add(String.format("[%s] %s", formatter.format(LocalTime.now()), mensagem));
    }

    public void finalizaExecucao() {
        fim = Instant.now();

        execucao.setTimestampFinal(fim.toString());

        Duration duracao = Duration.between(inicio, fim);

        adicionaLog(String.format("Duração total: %s", duracao.toString()));
    }

    public Execucao obtemRelatorioExecucao() {
        execucao.setLog(newArrayList(log).stream().distinct().collect(Collectors.toList()));
        return execucao;
    }

}
