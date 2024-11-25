public class Main {
    public static void main(String[] args) {
        BST arvore1 = new BST();
        BST arvore2 = new BST();

        // Inserindo valores na primeira árvore
        arvore1.adicionar(50);
        arvore1.adicionar(30);
        arvore1.adicionar(70);
        arvore1.adicionar(20);
        arvore1.adicionar(40);
        arvore1.adicionar(60);
        arvore1.adicionar(80);

        // Inserindo valores na segunda árvore
        arvore2.adicionar(15);
        arvore2.adicionar(10);
        arvore2.adicionar(20);
        arvore2.adicionar(8);
        arvore2.adicionar(12);
        arvore2.adicionar(17);
        arvore2.adicionar(25);
        arvore2.adicionar(19);
        arvore2.adicionar(30);
        arvore2.adicionar(5);
        arvore2.adicionar(11);

        // Imprimindo as árvores em ordem
        System.out.println("Árvore 1 em ordem:");
        arvore1.imprimirEmOrdem();
        System.out.println("\nÁrvore 2 em ordem:");
        arvore2.imprimirEmOrdem();

        // Contando os nós em cada árvore
        System.out.println("\nQuantidade de nós na Árvore 1: " + arvore1.contarNos());
        System.out.println("Quantidade de nós na Árvore 2: " + arvore2.contarNos());

        // Contando as folhas em cada árvore
        System.out.println("\nQuantidade de nós-folha na Árvore 1: " + arvore1.contarFolhas());
        System.out.println("Quantidade de nós-folha na Árvore 2: " + arvore2.contarFolhas());

        // Verificando igualdade entre as árvores
        System.out.println("\nAs árvores são iguais? " + arvore1.igualdade(arvore2));

        // Verificando se as árvores são estritamente binárias
        System.out.println("\nA Árvore 1 é estritamente binária? " + arvore1.estritoBin());
        System.out.println("A Árvore 2 é estritamente binária? " + arvore2.estritoBin());

        // Verificando similaridade entre as árvores
        System.out.println("\nAs árvores são semelhantes? " + arvore1.saoSimilares(arvore2));

        // Obtendo e imprimindo o espelho da Árvore 1
        arvore1.obterEspelho();
        System.out.println("\nÁrvore 1 após obter o espelho:");
        arvore1.imprimirEmOrdem();
    }
}
