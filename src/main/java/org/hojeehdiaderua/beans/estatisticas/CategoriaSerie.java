package org.hojeehdiaderua.beans.estatisticas;

import java.util.List;

public class CategoriaSerie<S, D> {
    private List<S> categorias;
    private List<D> series;

    public List<S> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<S> categorias) {
        this.categorias = categorias;
    }

    public List<D> getSeries() {
        return series;
    }

    public void setSeries(List<D> series) {
        this.series = series;
    }
}
