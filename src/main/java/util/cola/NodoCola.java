package util.cola;

public class NodoCola<T> {
    public T dato;
    public NodoCola sig;

    public NodoCola(T value) {
        super();
        this.dato = value;
        this.sig = null;
    }
}
