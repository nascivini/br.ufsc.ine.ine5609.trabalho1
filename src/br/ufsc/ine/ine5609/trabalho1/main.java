
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
        teste.insereNoComeco("um");
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco("dois");
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco("três");
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco("quatro");
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco("cinco");
        System.out.println(teste.acessarAtual().getData());
        teste.insereNoComeco("seis");
        System.out.println(teste.acessarAtual().getData());
        teste.insereNoComeco("sete");
        System.out.println(teste.acessarAtual().getData());
    }
    
}
