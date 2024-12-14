public class ArvoreAVL {
    private No raiz;

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esq = inserir(no.esq, valor);
        } else if (valor > no.valor) {
            no.dir = inserir(no.dir, valor);
        } else {
            return no;  // Evita duplicatas
        }

        atualizarAltura(no);
        return rebalancear(no);
    }

    // Método para remover um valor na árvore
    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private No remover(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor < no.valor) {
            no.esq = remover(no.esq, valor);
        } else if (valor > no.valor) {
            no.dir = remover(no.dir, valor);
        } else {
            if (no.esq == null || no.dir == null) {
                return (no.esq != null) ? no.esq : no.dir;
            } else {
                No temp = getMin(no.dir);
                no.valor = temp.valor;
                no.dir = remover(no.dir, temp.valor);
            }
        }

        atualizarAltura(no);
        return rebalancear(no);
    }

    // Funções auxiliares para rebalanceamento
    private No rebalancear(No no) {
        int fatorBalanceamento = getFatorBalanceamento(no);

        // Rotações necessárias
        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) >= 0) {
            System.out.println("Rotação à direita em " + no.valor);
            return rotacaoDireita(no);
        }
        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) <= 0) {
            System.out.println("Rotação à esquerda em " + no.valor);
            return rotacaoEsquerda(no);
        }
        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) > 0) {
            System.out.println("Rotação dupla à esquerda em " + no.valor);
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }
        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) < 0) {
            System.out.println("Rotação dupla à direita em " + no.valor);
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }

        return no;
    }

    private No rotacaoDireita(No A) {
        No B = A.esq;
        No Bdir = B.dir;

        B.dir = A;
        A.esq = Bdir;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    private No rotacaoEsquerda(No A) {
        No B = A.dir;
        No Besq = B.esq;

        B.esq = A;
        A.dir = Besq;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int getFatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esq) - altura(no.dir);
    }

    private No getMin(No no) {
        while (no.esq != null) {
            no = no.esq;
        }
        return no;
    }

    // Função para imprimir a árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.esq);
            System.out.print(no.valor + "(" + getFatorBalanceamento(no) + ") ");
            imprimirEmOrdem(no.dir);
        }
    }
}