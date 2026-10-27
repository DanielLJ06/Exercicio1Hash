public class Hash {
    Linha[] tabela;

    Hash() {
        this.tabela = new Linha[100];
    }

    public int funcaoHash(int chave) {
        return chave % 100;
    }

    void insere(int chave) {
        int i = funcaoHash(chave);
        if (tabela[i] == null) {
            tabela[i] = new Linha(chave);
            tabela[i].valor = new ListaEncadeada();
        }
        tabela[i].valor.insereOrdenado(chave);
    }

    int busca_hashing(int chave) {
        int i = funcaoHash(chave);
        if (tabela[i] == null)
            return -1;

        ListaEncadeada.No atual = tabela[i].valor.inicio;
        while (atual != null && atual.dado <= chave) {
            if (atual.dado == chave)
                return i;
            atual = atual.proximo;
        }
        return -1;
    }
}
