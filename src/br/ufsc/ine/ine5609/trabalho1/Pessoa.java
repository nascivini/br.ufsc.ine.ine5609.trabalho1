package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Marco Aurelio Geremias
 */
public class Pessoa implements Comparable<Pessoa>{

    private String nome;
    private int idade;
    private int altura;
    private int peso;
    
    public Pessoa() {
        this.altura = 0;
        this.peso = 0;
        this.idade = 0;
        this.nome = null;
    }
    
    public Pessoa(String nome, int idade, int altura, int peso) {
        this.altura = 0;
        this.peso = 0;
        this.idade = 0;
        this.nome = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    @Override
    public int compareTo(Pessoa o) {
        int retorno;
        retorno = (this.altura <= o.getAltura()) ? -1 : 1;
        return retorno;
    }
    
}
