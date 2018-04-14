
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
        teste.insereNoComeco(1);
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco(2);
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco(3);
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco(4);
        System.out.println(teste.acessarAtual().getData());        
        teste.insereNoComeco(5);
        System.out.println(teste.acessarAtual().getData());
        teste.insereNoComeco(6);
        System.out.println(teste.acessarAtual().getData());
        teste.insereNoComeco(7);
        System.out.println(teste.acessarAtual().getData());
        teste.printaListaInteira();
        teste.excluirAtual();
        teste.printaListaInteira();
    }
    
}
