package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 */
public interface ListaEncadeada<T> {

    public void inserirAntesDe(DataBox novo, int posicao);
        
    public void inserirDepoisDe(DataBox novo, int posicao);

    public DataBox buscar(int posicao) throws Exception;
}
