public class buscaSequencial {

public static int buscaSequencial(int[] vetor, int chaveBusca) {
    int i = 0; 

  
    while (i < vetor.length) {
        if (vetor[i] == chaveBusca) {
            return i; 
        }
        i++; 
    }

    return -1; 
}
}
