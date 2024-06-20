package util.cola;

public class NodoCola<T> {
    public T dato;
    public NodoCola<T> siguienteNodo;

    public NodoCola(T dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }
}
