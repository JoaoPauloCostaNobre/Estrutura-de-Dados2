public class Main {
    public static void main(String[] args) {
        // Cria a árvore AVL
        ArvoreAVL avl = new ArvoreAVL();

        // Sequência de inserções conforme o enunciado
        int[] insercoes = {1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 7, 60, 43, 16, 67, 34, 35};

        System.out.println("Inserindo elementos na árvore AVL:");
        for (int valor : insercoes) {
            System.out.println("\nInserindo: " + valor);
            avl.inserir(valor);
            avl.imprimirEmOrdem();  // Imprime a árvore após a inserção
        }

        // Sequência de remoções conforme o enunciado
        int[] remocoes = {50, 95, 70, 60, 35};

        System.out.println("\nRemovendo elementos da árvore AVL:");
        for (int valor : remocoes) {
            System.out.println("\nRemovendo: " + valor);
            avl.remover(valor);
            avl.imprimirEmOrdem();  // Imprime a árvore após a remoção
        }
    }
}
