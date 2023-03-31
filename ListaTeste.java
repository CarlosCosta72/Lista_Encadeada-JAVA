package ed.teste;

import ed.ListaEncadeada;

class ListaTeste {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.insere(1,10);
        lista.insere(2,20);
        lista.insere(4,30);
        System.out.println(lista);
        lista.remove(2);

        System.out.println(lista);
        System.out.println(lista.getTamanho());
        lista.Listar();
    }
}
