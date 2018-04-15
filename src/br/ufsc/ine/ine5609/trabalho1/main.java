
package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento, Marco Geremias
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    
    //Bateria de Testes 1    
        // Bateria de Testes na Lista, com tipos compostos
        ListaOrdenada teste = new ListaOrdenada();
        
        // Inserção e Exclusão Imediata de Objetos na Lista (com leitura)
        Pessoa Vinicius = new Pessoa("Vinicius", 18, 179, 60);
        Pessoa Marco = new Pessoa("Marco", 23, 174, 108);
        Pessoa Marina = new Pessoa("Marina", 23, 175, 57);
        
        //
        teste.inserir(Vinicius);
        System.out.println(teste.toStringAll()[0]);
        teste.inserir(Marco);
        System.out.println(teste.toStringAll()[1]);
        teste.inserir(Marina);
        System.out.println(teste.toStringAll()[2]);
        
        teste.excluir(2);
        System.out.println(teste.toStringAll()[1]);
        teste.excluir(1);
        System.out.println(teste.toStringAll()[1]);
        teste.excluir(0);
        
        System.out.println(teste.toStringAll()[0]);
    
    }
    
}
