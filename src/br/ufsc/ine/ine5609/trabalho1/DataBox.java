package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento, Marco Geremias  
 * @param <T>  
 */
public class DataBox <T extends Comparable<T>> implements Comparable <DataBox<T>> {
    private int id;
    private T data;
    private DataBox enderecoProximo;
    
    public DataBox(){
        this.data = null;
        this.enderecoProximo = null;
        this.id = -1;
    }
    
    public DataBox(T data){
        this.data = data;
        this.enderecoProximo = null;
        this.id = -1;
    }
    
    public void setData(T value){
        this.data = value;
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setEnderecoProximo(DataBox novo){
        this.enderecoProximo = novo;
    }
    
    public DataBox getEnderecoProximo(){
        return this.enderecoProximo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(DataBox<T> o) {
        return data.compareTo(o.getData());
    }
    
    
}
