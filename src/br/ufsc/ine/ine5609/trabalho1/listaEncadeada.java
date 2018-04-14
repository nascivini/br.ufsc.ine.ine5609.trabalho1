package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 */
public class listaEncadeada<T> {

    private dataBox<T> ultimo;
    private dataBox<T> primeiro;
    private dataBox<T> cursor;
    private int size;

    public listaEncadeada() {
        this.cursor = null;
        this.ultimo = null;
        this.primeiro = null;
        this.size = 0;
    }

    public void insereNoComeco(Object novo) {
        dataBox novoDado = new dataBox();
        novoDado.setDataBox(novo);
        if (size == 0) {
            this.primeiro = novoDado;
            this.ultimo = novoDado;
            novoDado.setEnderecoProximo(null);
        } else {
            primeiro.setEnderecoAnterior(novoDado);
            novoDado.setEnderecoProximo(primeiro);
            ultimo = primeiro;
            primeiro = novoDado;
        }
        cursor = novoDado;
        size++;
    }

    public void inserirAntesDoAtual(Object novo) throws java.lang.Exception {
        /* falta validar na inserção a atualização do último (atributo). Está causando problemas na busca e na exclusão.*/
        if (size == 0) {
            throw new Exception("A lista está vazia, não é possível inserir o elemento. Utilize o método (inserir após o atual)");
        } else {
            dataBox nova = new dataBox();
            nova.setDataBox(novo);

            cursor.getEnderecoAnterior().setEnderecoProximo(nova);
            nova.setEnderecoAnterior(cursor.getEnderecoAnterior());
            cursor.setEnderecoAnterior(nova);
            nova.setEnderecoProximo(cursor);

            cursor = nova;
            size++;
        }
    }

    public void inserirDepoisDoAtual(Object novo) throws Exception {
        if (size == 0) {
            throw new Exception("A lista está vazia, utilize o método genérico de inserção.");
        } else {
            dataBox nova = new dataBox();
            nova.setDataBox(novo);

            cursor.getEnderecoProximo().setEnderecoAnterior(nova);
            nova.setEnderecoProximo(cursor.getEnderecoProximo());
            cursor.setEnderecoProximo(nova);
            nova.setEnderecoAnterior(cursor);

            cursor = nova;
            size++;
        }
    }

    public void excluirAtual() throws Exception {
        if (size == 1) {
            primeiro.setEnderecoAnterior(null);
            primeiro.setEnderecoProximo(null);
            size = 0;
        }

        else if (cursor.equals(ultimo)) {
            ultimo.getEnderecoAnterior().setEnderecoProximo(null);
            size--;
        }
        
        else if(cursor.equals(primeiro)){
            primeiro.getEnderecoProximo().setEnderecoAnterior(null);
            primeiro = primeiro.getEnderecoProximo();
        }

        else if (size != 0) {
            cursor.getEnderecoProximo().setEnderecoAnterior(cursor.getEnderecoAnterior());
            cursor.getEnderecoAnterior().setEnderecoProximo(cursor.getEnderecoProximo());
        } 
        
        else {
            throw new Exception("A lista está vazia! Insira um elemento antes de excluí-lo.");
        }
    }

    public void excluir(Object toBeExcluded) throws Exception {
        if (size == 0) {
            throw new Exception("A lista está vazia! Insira um elemento antes de excluí-lo.");
        } else {
            boolean passouPeloUltimo = false;
            dataBox atual = primeiro;

            while (!passouPeloUltimo) {
                if (atual.equals(ultimo)) {
                    passouPeloUltimo = true;
                } else {
                    atual = atual.getEnderecoProximo();
                }
                if (atual.getData().equals(toBeExcluded)) {
                    atual.getEnderecoAnterior().setEnderecoProximo(atual.getEnderecoProximo());
                    atual.getEnderecoProximo().setEnderecoAnterior(atual.getEnderecoAnterior());
                }
            }
        }
    }

    public dataBox<T> buscar(Object toBeFind) throws Exception {
        boolean passouPeloUltimo = false;
        dataBox atual = primeiro;

        while (!passouPeloUltimo) {
            if (atual.equals(ultimo)) {
                passouPeloUltimo = true;
            } else {
                atual = atual.getEnderecoProximo();
            }
            if (atual.getData().equals(toBeFind)) {
                return atual;
            }
        }
        throw new Exception("O objeto não está na lista.");

    }

    public dataBox<T> acessarAtual() {
        return cursor;
    }
    
    public void printaListaInteira(){
        dataBox atual = primeiro;
        for(int i = 0; i < size; i++){
            System.out.print(atual.getData());
            atual = atual.getEnderecoProximo();
        }
    }
}
