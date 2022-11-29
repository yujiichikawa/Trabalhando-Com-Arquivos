package model;

import model.enums.Tipo_Produto;

public class Produto {
    private String nome;
    private Double preco;
    private Tipo_Produto tipo;
    private Estoque estoque;

    public Produto(String nome, Double preco, Tipo_Produto tipo) {
      this.nome = nome;
      this.preco = preco;
      this.tipo = tipo;
      estoque = new Estoque(0);
    }

    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public Double getPreco() {
      return preco;
    }
    public void setPreco(Double preco) {
      this.preco = preco;
    }
    public Tipo_Produto getTipo() {
      return tipo;
    }
    public void setTipo(Tipo_Produto tipo) {
      this.tipo = tipo;
    }

    public Estoque getEstoque() {
      return estoque;
    }

    public void setEstoque(Estoque estoque) {
      this.estoque = estoque;
    }

}
