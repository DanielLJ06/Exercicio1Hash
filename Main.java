import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Hash hash = new Hash();
        Random random = new Random(1090);
        int[] tamanho_d_lista = new int[hash.tabela.length];
        int[] ultimos = new int[3];

        for (int i = 0; i < 10001; i++) {
            int chave = random.nextInt(100001);
            int indice = hash.funcaoHash(chave);

            if (hash.tabela[indice] == null) {
                hash.tabela[indice] = new Linha(chave);
                hash.tabela[indice].valor = new ListaEncadeada();
            }
            hash.tabela[indice].valor.insereOrdenado(chave);
            tamanho_d_lista[indice]++;

            for (int x = 0; x < 2; x++) {
                ultimos[x] = ultimos[x + 1];
            }
            ultimos[2] = chave;
        }

        int quantidadeListas = 0;
        int posicoesVazias = 0;
        int maiorTamanho = 0;
        int indiceMaiorLista = -1;

        for (int i = 0; i < hash.tabela.length; i++) {
            if (hash.tabela[i] == null) {
                posicoesVazias = posicoesVazias + 1;
            } else if (hash.tabela[i].valor != null) {
                quantidadeListas = quantidadeListas + 1;
                int tamanho = 0;
                ListaEncadeada.No atual = hash.tabela[i].valor.inicio;
                while (atual != null) {
                    tamanho = tamanho + 1;
                    atual = atual.proximo;
                }

                if (tamanho > maiorTamanho) {
                    maiorTamanho = tamanho;
                    indiceMaiorLista = i;
                }
            }
        }

        if (indiceMaiorLista != -1) {
            System.out.println("Maior lista (índice " + indiceMaiorLista + ", " + maiorTamanho + " elementos):");
            hash.tabela[indiceMaiorLista].valor.exibeLista();
        } else {
            System.out.println("Nenhuma lista foi gerada.");
        }

        System.out.println("Listas geradas: " + quantidadeListas);
        System.out.println("Posições vazias: " + posicoesVazias);
        System.out.println("Últimos inseridos: " + ultimos[0] + ", " + ultimos[1] + ", " + ultimos[2]);
    }
}
