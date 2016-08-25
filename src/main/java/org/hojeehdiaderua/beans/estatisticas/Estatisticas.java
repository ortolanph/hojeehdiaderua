package org.hojeehdiaderua.beans.estatisticas;

import java.util.List;

public class Estatisticas {

    private long quantidadeDeRuas;
    private long quantidadeDeCidades;
    private CategoriaSerie<String, Long> ruasPorMes;
    private CategoriaSerie<String, Long> ruasPorUF;
    private CategoriaSerie<Byte, Long> ruasPorDia;
    private List<CidadeRua> topTenCidadeRua;

    public long getQuantidadeDeRuas() {
        return quantidadeDeRuas;
    }

    public void setQuantidadeDeRuas(long quantidadeDeRuas) {
        this.quantidadeDeRuas = quantidadeDeRuas;
    }

    public long getQuantidadeDeCidades() {
        return quantidadeDeCidades;
    }

    public void setQuantidadeDeCidades(long quantidadeDeCidades) {
        this.quantidadeDeCidades = quantidadeDeCidades;
    }

    public CategoriaSerie<String, Long> getRuasPorMes() {
        return ruasPorMes;
    }

    public void setRuasPorMes(CategoriaSerie<String, Long> ruasPorMes) {
        this.ruasPorMes = ruasPorMes;
    }

    public CategoriaSerie<String, Long> getRuasPorUF() {
        return ruasPorUF;
    }

    public void setRuasPorUF(CategoriaSerie<String, Long> ruasPorUF) {
        this.ruasPorUF = ruasPorUF;
    }

    public CategoriaSerie<Byte, Long> getRuasPorDia() {
        return ruasPorDia;
    }

    public void setRuasPorDia(CategoriaSerie<Byte, Long> ruasPorDia) {
        this.ruasPorDia = ruasPorDia;
    }

    public List<CidadeRua> getTopTenCidadeRua() {
        return topTenCidadeRua;
    }

    public void setTopTenCidadeRua(List<CidadeRua> topTenCidadeRua) {
        this.topTenCidadeRua = topTenCidadeRua;
    }
}
