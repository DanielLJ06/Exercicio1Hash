public class Hash { 
    Linha[] tabela;

    Hash(){
        this.tabela = new Linha[100];
    }


    public int funcaoHash(int chave){

        return chave % 100;
    }



    int busca_hashing(int chave) {
        int i = funcaoHash(chave);
        if (tabela[i].chave == chave) {
            tabela[i].valor.insereOrdenado(chave);
            return i;

        }
        return i;

    }



}
