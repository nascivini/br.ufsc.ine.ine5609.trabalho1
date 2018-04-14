package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento
 * @param <T>
 */
public class ListaEncadeada<T extends Comparable<T>> {

    private DataBox<T> primeiro;
    private DataBox<T> ultimo;
    private int numElementos;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.numElementos = 0;
    }

    public void inserir(T dado) {
        if (primeiro == null) {
            primeiro = new DataBox(dado);
            primeiro.setId(0);
            ultimo = primeiro;
            numElementos++;
        } else {
            DataBox<T> caixinha = primeiro;
            DataBox<T> maiorOuIgual = caixinha;
            DataBox<T> novo = new DataBox<T>(dado);
            if (novo.compareTo(caixinha) <= 0) {
                novo.setEnderecoProximo(caixinha);
                primeiro = novo;
                novo.setId(0);
                numElementos++;
                DataBox<T> controlador = new DataBox();
                controlador = caixinha;
                for (int i = 0; i < numElementos; i++) {
                    controlador.setId(controlador.getId() + 1);
                    controlador = controlador.getEnderecoProximo();
                    if (controlador == null) {
                        break;
                    }
                }
            } else {
                while (novo.compareTo(caixinha) > 0) {
                    maiorOuIgual = caixinha;
                    caixinha = caixinha.getEnderecoProximo();
                    if (caixinha == null) {
                        break;
                    }
                }
                maiorOuIgual.setEnderecoProximo(novo);
                novo.setId(caixinha.getId());
                novo.setEnderecoProximo(caixinha);
                DataBox<T> controlador = new DataBox();
                controlador = caixinha;
                for (int i = 0; i < numElementos; i++) {
                    controlador.setId(controlador.getId() + 1);
                    controlador = controlador.getEnderecoProximo();
                    if (controlador == null) {
                        break;
                    }
                }
            }
        }
    }

    public void inserirAntesDe(T dado, int id) {
        try {
            DataBox atual = this.buscar(id);
            DataBox nova = new DataBox(dado);

            DataBox<T> maiorOuIgual = atual;

            if (!atual.equals(primeiro)) {
                while (nova.compareTo(atual) > 0) {
                    maiorOuIgual = atual;
                    atual = atual.getEnderecoProximo();
                    if (atual == null) {
                        break;
                    }
                }
                maiorOuIgual.setEnderecoProximo(nova);
                nova.setId(atual.getId());
                nova.setEnderecoProximo(atual);
                DataBox<T> controlador = new DataBox();
                controlador = atual;
                
                for (int i = 0; i < numElementos; i++) {
                    controlador.setId(controlador.getId() + 1);
                    controlador = controlador.getEnderecoProximo();
                    if (controlador == null) {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void inserirDepoisDe(T dado, int id) {
       try {
            DataBox atual = this.buscar(id);
            DataBox nova = new DataBox(dado);
            DataBox<T> maiorOuIgual = atual;
                while (nova.compareTo(atual) > 0) {
                    maiorOuIgual = atual;
                    atual = atual.getEnderecoProximo();
                    if (atual == null) {
                        break;
                    }
                }
                maiorOuIgual.setEnderecoProximo(nova);
                nova.setId(atual.getId());
                nova.setEnderecoProximo(atual);
                DataBox<T> controlador = new DataBox();
                controlador = atual;
                
                for (int i = 0; i < numElementos; i++) {
                    controlador.setId(controlador.getId() + 1);
                    controlador = controlador.getEnderecoProximo();
                    if (controlador == null) {
                        break;
                    }
                }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public DataBox buscar(int posicao) throws Exception {
        if (numElementos >= posicao) {
            int contador = 0;
            DataBox atual = primeiro;
            while (contador < posicao) {
                contador++;
                atual = atual.getEnderecoProximo();
            }
            return atual;
        }
        throw new Exception("Não há um elemento na posição " + posicao);
    }

    public int retornaPosicao(DataBox elemento) throws Exception {
        int contador = 0;
        DataBox atual = primeiro;
        while (contador < numElementos) {
            if (elemento.equals(atual)) {
                return contador;
            } else {
                contador++;
            }
        }
        throw new Exception("Este elemento não está na lista.");

    }

    public void excluir(int posicao) {
        try {
            DataBox atual = this.buscar(posicao);

            if (atual.equals(primeiro)) {
                primeiro = atual;
            }

            numElementos--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int getNumElementos() {
        return numElementos;
    }

}
