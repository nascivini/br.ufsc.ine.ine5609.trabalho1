package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 */
public class listaOrdenada extends listaEncadeada {
    
    public int ultimoIdGerado;
    
    public listaOrdenada(){
        super();
        this.ultimoIdGerado = 0;
    }
    
    public void inserirOrdenado(Object dado){
        dataBox nova = new dataBox();
        nova.setDataBox(dado);
    }
    
    @Override
    public void excluir (Object id){
        
    }
    
    @Override
    public dataBox<T> buscar (Object id){
    
    }
    
    public int geraNovoId(){
        this.ultimoIdGerado++;
        return this.ultimoIdGerado;
    }
}
