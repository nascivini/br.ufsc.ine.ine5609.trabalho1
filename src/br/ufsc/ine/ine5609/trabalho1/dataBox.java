/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento  
 */
public class dataBox <T> {
    private T data;
    private dataBox enderecoAnterior;
    private dataBox enderecoProximo;
    
    public dataBox(){
        this.enderecoAnterior = null;
        this.enderecoProximo = null;
    }
    
    public void setData(T value){
        this.data = value;
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setEnderecoAnterior(dataBox novo){
        this.enderecoAnterior = novo;
    }
    
    public dataBox getEnderecoAnterior(){
        return this.enderecoAnterior;
    }
    
    public void setEnderecoProximo(dataBox novo){
        this.enderecoProximo = novo;
    }
    
    public dataBox getEnderecoProximo(){
        return this.enderecoProximo;
    }
    
}
