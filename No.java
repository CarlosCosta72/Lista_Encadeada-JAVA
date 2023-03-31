package ed;

public class No<T>{
    
    private T elemento;
    private No<T> proximo;


    //construtores
    public No(T elemento) {
        this.elemento = elemento;
        this.proximo= null;
    }
    
    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    //getters e setter
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public No<T> getProximo() {
        return proximo;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        StringBuilder builder= new StringBuilder();
        builder.append("No: [elemento=").append(elemento).append(", próximo=").append(proximo).append("]");
        return builder.toString();
    }    

    
}