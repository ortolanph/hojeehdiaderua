package org.hojeehdiaderua.utils;

import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.beans.Status;

public class ResultadoUtil<T> {

    public Resultado<T> comSucesso(T resultado) {
        Resultado<T> resultadoFinal = novo(Status.SUCCESS);
        resultadoFinal.setMensagem("Processamento concluído com sucesso");
        resultadoFinal.setResultado(resultado);

        return resultadoFinal;
    }

    public Resultado<T> comFalha(T resultado) {
        Resultado<T> resultadoFinal = novo(Status.ERROR);
        resultadoFinal.setMensagem("Houve uma falha no processamento da requisição");
        resultadoFinal.setResultado(resultado);

        return resultadoFinal;
    }

    private Resultado<T> novo(Status status) {
        Resultado<T> resultadoFinal = new Resultado<>();

        resultadoFinal.setStatus(status);

        return resultadoFinal;
    }

}
