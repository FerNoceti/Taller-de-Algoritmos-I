package util.listaDoble;

public class NodoDoble<T extends Comparable<T>> implements Comparable<NodoDoble<T>> {

    public T dato;
    public NodoDoble<T> nodoAnterior;
    public NodoDoble<T> nodoSiguiente;

    public NodoDoble(T dato) {
        this.dato = dato;
        this.nodoSiguiente = this.nodoAnterior = null;
    }

    @Override
    public int compareTo(NodoDoble<T> otroNodo) {
        return this.dato.compareTo(otroNodo.dato);
    }
}
