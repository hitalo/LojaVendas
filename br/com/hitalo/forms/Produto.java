
package br.com.hitalo.forms;


public class Produto {
    
    private String nome, marca, unidade;
    private float valor;

    public Produto(String nome, String marca, String unidade, float valor) {
        this.nome = nome;
        this.marca = marca;
        this.unidade = unidade;
        this.valor = valor;
    }

    public Produto() {     
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
