package com.example.felipe.projeto.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mria do carmo on 25/10/2015.
 */
public class ListaMotos implements Serializable{
    List<Moto> results;

    public List<Moto> getResults() {
        return results;
    }
    public void setResults(List<Moto> result) {
        this.results = result;
    }
}
