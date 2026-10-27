import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hash hash = new Hash();
        Random random = new Random();
        int[] ultimos = new int[3];

        int quantidade = 1000;
        for (int k = 0; k < quantidade; k++) {
            int numero = random.nextInt(10000);
            hash.insere(numero);

            ultimos[0] = ultimos[1];
            ultimos[1] = ultimos[2];
            ultimos[2] = numero;
        }

        int quantidadeListas = 0;
        int posicoesVazias = 0;
        int maiorTamanho = 0;
        int indiceMaiorLista = -1;

        for (int i = 0; i < hash.tabela.length; i++) {
            if (hash.tabela[i] == null) {
                posicoesVazias++;
            } else {
                quantidadeListas++;
                int tamanho = hash.tabela[i].valor.contagem();
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

        int chaveBusca = ultimos[2];
        int pos = hash.busca_hashing(chaveBusca);
        if (pos != -1) {
            System.out.println("Chave " + chaveBusca + " encontrada no índice " + pos);
        } else {
            System.out.println("Chave " + chaveBusca + " não encontrada");
        }
    }
}
