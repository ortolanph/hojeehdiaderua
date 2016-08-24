package org.hojeehdiaderua.beans.admin;

import java.util.List;

public class Execucao {
    private String timestampInicial;
    private String timestampFinal;
    private List<String> log;

    public String getTimestampInicial() {
        return timestampInicial;
    }

    public void setTimestampInicial(String timestampInicial) {
        this.timestampInicial = timestampInicial;
    }

    public String getTimestampFinal() {
        return timestampFinal;
    }

    public void setTimestampFinal(String timestampFinal) {
        this.timestampFinal = timestampFinal;
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
