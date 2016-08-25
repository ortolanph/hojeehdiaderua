package org.hojeehdiaderua.beans.estatisticas;

public class CidadeRua {
    private Integer position;
    private String cidade;
    private Long total;

    public CidadeRua() {

    }

    public CidadeRua(String cidade, Long total) {
        this.position = 0;
        this.cidade = cidade;
        this.total = total;
    }

    public CidadeRua(Integer position, String cidade, Long total) {
        this.position = position;
        this.cidade = cidade;
        this.total = total;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
