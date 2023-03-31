package ed;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;



    public No<T> getInicio() {
        return inicio;
    }

    public boolean vazia() {
        if (this.tamanho == 0) {
            return true;
        } else
            return false;
    }

    public T conteudo(int pos) {
        No<T> aux = this.inicio;
        int cont = 1;
        if (vazia()) {
            System.out.println("Lista vazia!");
            System.exit(1);
        }
        if ((pos < 1) || (pos > this.tamanho)) {
            System.out.println("Valor inválido!");
            System.exit(1);
        }
        while (cont < pos) {
            aux = aux.getProximo();
            cont++;
        }
        return aux.getElemento();
    }

    public int posicao(T dado) {
        int cont = 1;
        No<T> aux = this.inicio;
        if (vazia()) {
            return 0;
        }
        while (aux != null) {
            if (aux.getElemento() == dado) {
                return cont;
            }
            aux = aux.getProximo();
            cont++;
        }
        return -1;
    }
    private boolean insereInicio(T valor){
        No<T>novoNo= new No(valor,this.getInicio());
        inicio=novoNo;
        this.tamanho++;
        return true; 
    }
    private boolean insereMeio(int pos,T dado){
        int cont=1;
        No novoNo= new No(dado);

        No aux= inicio;
        while((cont<pos-1)&&(aux!=null)){
            aux=aux.getProximo();
            cont++;
        }
        if(aux==null){
            return false;
        }
        novoNo.setProximo(aux.getProximo());
        aux.setProximo(novoNo);
        tamanho++;
        return true;
    }
    private boolean insereFim(T elemento) {
        No<T> novoNo = new No<>(elemento);
        No aux=this.inicio;
        while(aux.getProximo()!=null){
            aux=aux.getProximo();
        }
        novoNo.setProximo(null);
        aux.setProximo(novoNo);
        this.tamanho++;
        return true;
    }
    public boolean insere(int pos,T dado){
        if((this.vazia())&& (pos!=1)){
            return false;
        }
        if(pos==1){
            return insereInicio(dado);
        }
        if(pos>this.tamanho+1){
            return insereFim(dado);
        }
        else{
            return insereMeio(pos, dado);
        }
    }
    public T remove(int pos){
        if(vazia()){
            System.exit(1);
        }
        if(pos==1){
            return removeInicio();
        }
        else{
            return removeNaLista(pos);
        }
    }
    private T removeInicio(){
        No novoNo=inicio;
        T dado=(T) novoNo.getElemento();
        inicio=novoNo.getProximo();
        tamanho--;
        novoNo=null;
        return dado;

    }
    private T removeNaLista(int pos){
        No atual=null,antecessor=null;
        T dado;
        int cont=1;
        atual=inicio;
        while((cont<pos)&&(atual!=null)){
            antecessor=atual;
            atual=atual.getProximo();
            cont++;
        }
        if(atual==null){
            System.exit(1);
        }
        dado=(T) atual.getElemento();
        antecessor.setProximo((atual.getProximo()));
        this.tamanho--;

        atual=null;
        return dado;

    }
    public void limpa() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }
    public void Listar(){
        System.out.print("[");
        for(int i=1;i<=this.tamanho;i++){
            System.out.print(this.conteudo(i)+",");
        }
        System.out.print("]");
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (this.tamanho == 0) {
            return "[]";
        }
        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }

}
