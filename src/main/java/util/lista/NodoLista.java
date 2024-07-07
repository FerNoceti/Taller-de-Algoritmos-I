package util.lista;

public class NodoLista<T extends Comparable<T>> {
    public T dato;
    public NodoLista<T> siguienteNodo;

    public NodoLista(T dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }
}
