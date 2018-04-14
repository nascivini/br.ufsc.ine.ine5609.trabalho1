package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 */
public class listaEncadeada<T> {

    private dataBox<T> primeiro;
    private dataBox<T> ultimo;
    private int numElementos;

    public listaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.numElementos = 0;
    }

    public void inserir(T novo) {
        dataBox novoDado = new dataBox();
        novoDado.setData(novo);
        if (numElementos == 0) {
            this.primeiro = novoDado;
            this.ultimo = novoDado;
        } else {
            if (numElementos == 1) {
                primeiro.setEnderecoProximo(novoDado);
                ultimo = novoDado;
                ultimo.setEnderecoAnterior(primeiro);
            } else {
                ultimo.setEnderecoProximo(novoDado);
                novoDado.setEnderecoAnterior(ultimo);
                ultimo = novoDado;
            }
            numElementos++;
        }
    }

    public void inserirAntesDe(T novo, int posicao) {
        dataBox novoDado = new dataBox();
        novoDado.setData(novo);


    }
}
