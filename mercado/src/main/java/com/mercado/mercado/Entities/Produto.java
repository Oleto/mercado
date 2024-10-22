package com.mercado.mercado.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    @Column
    String nome;
    @Column
    String tipo;
    @Column
    Double preco;
    @Column
    Double estoque;

    public Produto(Integer id, String nome, String tipo, Double preco, Double estoque) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto() {

    }

    @Override
public String toString() {
        return this.nome+" "+this.tipo+" "+this.preco+" "+this.estoque;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }


}
