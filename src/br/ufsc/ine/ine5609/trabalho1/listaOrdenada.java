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
    
    public int geraNovoId(){
        this.ultimoIdGerado++;
        return this.ultimoIdGerado;
    }
}
