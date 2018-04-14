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
        
        try{
            dataBox atual = this.buscar(posicao);
            
            if(atual.equals(primeiro)){
               novoDado.setEnderecoAnterior(null);
               novoDado.setEnderecoProximo(primeiro);
               primeiro.setEnderecoAnterior(novoDado);
               primeiro = novoDado;
            }
            atual.getEnderecoAnterior().setEnderecoProximo(novoDado);
            novoDado.setEnderecoAnterior(atual.getEnderecoAnterior());
            atual.setEnderecoAnterior(novoDado);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public dataBox buscar(int posicao) throws Exception {
        if (numElementos >= posicao) {
            int contador = 0;
            dataBox atual = primeiro;
            while (contador < posicao) {
                contador++;
                atual = atual.getEnderecoProximo();
            }
            return atual;
        }
        throw new Exception("Não há um elemento na posição " + posicao);
    }

    public int retornaPosicao(dataBox elemento) throws Exception {
        int contador = 0;
        dataBox atual = primeiro;
        while (contador < numElementos) {
            if (elemento.equals(atual)) {
                return contador;
            } else {
                contador++;
            }

        }
        throw new Exception("Este elemento não está na lista.");

    }
}
