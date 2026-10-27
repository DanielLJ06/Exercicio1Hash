class Linha{
    int chave;
    ListaEncadeada valor;


    Linha(int chave){
        this.chave = chave;
        this.valor = null;
    }
}


class ListaEncadeada {

    class No {
        int dado;
        No proximo;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }
    No inicio = null;

    public void insereOrdenado(int elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;

            if (elemento < inicio.dado) {
                inicio = novoNo;
                inicio.proximo = atual;
            } else {
                while (atual.proximo != null) {
                    No anterior = atual;

                    atual = atual.proximo;

                    if (elemento > anterior.dado && elemento < atual.dado) {
                        novoNo.proximo = atual;
                        anterior.proximo = novoNo;
                        atual = novoNo;
                    }
                }

                if (elemento > atual.dado) {
                    atual.proximo = novoNo;
                    novoNo.proximo = null;
                }
            }


        }
    }

    public void removeElemento(int elemento) {
        if (inicio == null) {
     
            System.out.println("Lamento, porém a lista esta vazia");
        } else {
            No atual = inicio;
            if (elemento == inicio.dado) {
                if (atual.proximo != null) {
                    inicio = atual.proximo;
                } else {
                    inicio = null;
                }
            } else {
                while (atual.proximo != null) {
                    No anterior = atual;
                    atual = atual.proximo; 
                    if (atual.dado == elemento) {
                        anterior.proximo = atual.proximo;
                        return;
                    }
                }
                System.out.println("Não existe este elemento na lista");
            }


        }
    }

    public void exibeLista() {
        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo; 
        }
        System.out.println();
    }

    public  int contagem(){
        int quantidade = 0;
        No atual = inicio;

        while(atual != null){
            quantidade++;
            atual = atual.proximo;
        }
        return quantidade;
    }


}
