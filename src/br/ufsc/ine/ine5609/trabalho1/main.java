
package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        listaEncadeada teste = new listaEncadeada();
        
        teste.inserir("um");
        System.out.println(teste.buscar(0).getData());
        teste.inserir("dois");
        System.out.println(teste.buscar(1).getData());
        teste.inserir("três");
        System.out.println(teste.buscar(2).getData());
        teste.inserir("quatro");
        System.out.println(teste.buscar(3).getData());
        teste.inserir("cinco");
        System.out.println(teste.buscar(4).getData());
        teste.excluir(4);
        teste.excluir(3);
        
        for(int i = 0; i < teste.getNumElementos(); i++){
            System.out.println(teste.buscar(i).getData());
        }
    }
    
}
