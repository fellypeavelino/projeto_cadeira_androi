package com.example.felipe.projeto.model;

import java.io.Serializable;

/**
 * Created by mria do carmo on 24/10/2015.
 */
public class Moto implements Serializable{
    public String nome;
    public String marca;
    public int ano;

    public Moto(String nome, String marca, int ano){
        this.ano = ano;
        this.marca = marca;
        this.nome = nome;
    }

    public Moto() {

    }

    @Override
    public String toString(){
        return nome;
    }

}
