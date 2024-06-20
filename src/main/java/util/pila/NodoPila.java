package util.pila;

public class NodoPila<T> {
    public T dato;
    public NodoPila<T> nodoAnterior;

    public NodoPila(T dato) {
        this.dato = dato;
        this.nodoAnterior = null;
    }
}
