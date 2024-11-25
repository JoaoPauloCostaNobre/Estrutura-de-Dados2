public class BST {
    private No raiz;

    public BST() {
        this.raiz = null;
    }
        //Exercicio 1
    public int contarNos() {
        return quantidadeNos(raiz);
    }

    private int quantidadeNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + quantidadeNos(no.esq) + quantidadeNos(no.dir);
    }
            //Exercicio 2
    public int contarFolhas() {
        return quantidadeFolhas(raiz);
    }

    private int quantidadeFolhas(No no) {
        if (no == null) {
            return 0;
        } else if (no.esq == null && no.dir == null) {
            return 1;
        } else {
            return quantidadeFolhas(no.esq) + quantidadeFolhas(no.dir);
        }
    }
    
       //Exercicio 3
    
    public void adicionar(int novoValor) {
            raiz = adicionarNo(raiz, novoValor);
        }
       
    private No adicionarNo(No raiz, int novoValor) {
            No novoNo = new No(novoValor);
    
            if (raiz == null) {
                return novoNo; 
            }
    
            No atual = raiz;
            No anterior = null;
    
       while (atual != null) {
                anterior = atual;
            if (novoValor < atual.valor) {
                    atual = atual.esq; 
            } else if (novoValor > atual.valor) {
                    atual = atual.dir; 
            } else {
                    return raiz;
                }
            }
    
            if (novoValor < anterior.valor) {
                anterior.esq = novoNo;
            } else {
                anterior.dir = novoNo;
            }
    
            return raiz;
        }
    
         //Exercicio 4

    public void obterEspelho() {
        obterEspelho(raiz);
    }

    private void obterEspelho(No no) {
        if (no == null) {
            return;
        }
        No temp = no.esq;
        no.esq = no.dir;
        no.dir = temp;

        obterEspelho(no.esq);
        obterEspelho(no.dir);
    }
      //Exercicio 5
    public boolean saoSimilares(BST outraArvore) {
        return saoSimilares(this.raiz, outraArvore.raiz);
    }

    private boolean saoSimilares(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }
        if (no1 == null || no2 == null) {
            return false;
        }
        return saoSimilares(no1.esq, no2.esq) && saoSimilares(no1.dir, no2.dir);
    }
      //Exercicio 6 
    public boolean igualdade(BST outraArvore) {
        return saoIguais(this.raiz, outraArvore.raiz);
    }

    private boolean saoIguais(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }
        if (no1 != null && no2 != null) {
            return (no1.valor == no2.valor) &&
                    saoIguais(no1.esq, no2.esq) &&
                    saoIguais(no1.dir, no2.dir);
        }
        return false;
    }
           //Exercicio 7

    public boolean estritoBin() {
        return ehEstritamenteBinaria(raiz);
    }

    private boolean ehEstritamenteBinaria(No no) {
        if (no == null) {
            return true;
        }
        if (no.esq == null && no.dir == null) {
            return true;
        }
        if (no.esq != null && no.dir != null) {
            return ehEstritamenteBinaria(no.esq) && ehEstritamenteBinaria(no.dir);
        }
        return false;
    }
       //impressoes
    public void imprimirEmOrdem() {
        imprimirEmOrdem(this.raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }
        imprimirEmOrdem(noRaiz.esq);
        System.out.print(noRaiz.valor + " ");
        imprimirEmOrdem(noRaiz.dir);
    }
}
