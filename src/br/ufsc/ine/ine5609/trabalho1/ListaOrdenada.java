package br.ufsc.ine.ine5609.trabalho1;

/**
 *
 * @author Vinicius Nascimento, Marco Geremias
 */
public class ListaOrdenada<T extends Comparable<T>> implements ListaEncadeada {

    private DataBox primeiro;
    private DataBox ultimo;
    private int numElementos;

    public ListaOrdenada() {
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
            DataBox caixinha = primeiro;
            DataBox maiorOuIgual = caixinha;
            DataBox novo = new DataBox<T>(dado);
            if (novo.compareTo(caixinha) <= 0) {
                novo.setEnderecoProximo(caixinha);
                primeiro = novo;
                novo.setId(0);
                numElementos++;
                DataBox controlador = new DataBox();
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
                numElementos++;
                DataBox controlador = new DataBox();
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

    public DataBox buscar(int id) throws Exception {
        if (numElementos >= id + 1) {
            int contador = 0;
            DataBox atual = primeiro;
            while (contador < id) {
                contador++;
                atual = atual.getEnderecoProximo();
            }
            return atual;
        }
        throw new Exception("Não há um elemento na posição " + id);
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

            if (atual.getEnderecoProximo() == null) {
                DataBox controlador = new DataBox();
                controlador = primeiro;
                for (int i = 0; i < numElementos; i++) {
                    if (controlador.getEnderecoProximo() == atual) {
                        controlador.setEnderecoProximo(null);
                    }
                }
                numElementos--;
            } else {
                DataBox controlador = new DataBox();
                controlador = primeiro;
                int guardaId = atual.getId();
                for (int i = 0; i < numElementos; i++) {
                    if (controlador.getEnderecoProximo() == atual) {
                        controlador.setEnderecoProximo(atual.getEnderecoProximo());
                    }
                    if (guardaId < controlador.getId()) {
                        controlador.setId(controlador.getId() - 1);
                    }
                    controlador = controlador.getEnderecoProximo();
                    if (controlador.getEnderecoProximo() == null) {
                        break;
                    }
                }
                numElementos--;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public String printaLista() {
        if (numElementos > 0) {
            DataBox atual = primeiro;
            for (int i = 0; i < numElementos; i++) {
                System.out.println("ID: " + atual.getId() + "| " + atual.getData().toString());
                if(atual.getEnderecoProximo() != null){
                    atual = atual.getEnderecoProximo();
                }
                else{
                    break;
                }
            }
        }
        else{
            System.out.println("Lista vazia!");
        }
        return "";
    }

    @Override
    public void inserirAntesDe(DataBox novo, int posicao) {
        DataBox novoDado = new DataBox();
        novoDado.setData(novo);

        try {
            DataBox atual = this.buscar(posicao);

            if (atual.equals(primeiro)) {
                novoDado.setEnderecoProximo(primeiro);
                primeiro = novoDado;
            }

            if (!atual.equals(ultimo)) {
                DataBox anterior = this.buscar(posicao - 1);
                anterior.setEnderecoProximo(novoDado);
                novoDado.setEnderecoProximo(this.buscar(posicao + 1));
                numElementos++;
            }

            if (atual.equals(ultimo) && !(atual.equals(primeiro))) {
                DataBox anterior = this.buscar(posicao - 1);
                anterior.setEnderecoProximo(novo);
                novoDado.setEnderecoProximo(null);
                ultimo = novoDado;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void inserirDepoisDe(DataBox novo, int posicao) {
        DataBox novoDado = new DataBox();
        novoDado.setData(novo);

        try {
            DataBox atual = this.buscar(posicao);

            if (atual.equals(ultimo)) {
                novoDado.setEnderecoProximo(ultimo);
                primeiro = novoDado;
            }

            if (!atual.equals(primeiro)) {
                DataBox anterior = this.buscar(posicao + 1);
                anterior.setEnderecoProximo(novoDado);
                novoDado.setEnderecoProximo(this.buscar(posicao - 1));
                numElementos++;
            }

            if (atual.equals(primeiro) && !(atual.equals(ultimo))) {
                DataBox anterior = this.buscar(posicao - 1);
                anterior.setEnderecoProximo(novo);
                novoDado.setEnderecoProximo(null);
                ultimo = novoDado;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
