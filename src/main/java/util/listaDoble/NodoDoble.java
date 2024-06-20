package util.listaDoble;

public class NodoDoble implements Comparable<NodoDoble> {

    public String dato;
    public NodoDoble nodoAnterior;
    public NodoDoble nodoSiguiente;

    public NodoDoble(String dato) {
        this.dato = dato;
        this.nodoSiguiente = this.nodoAnterior = null;
    }

    @Override
    public int compareTo(NodoDoble otroNodo) {
        return this.dato.compareTo(otroNodo.dato);
    }
}
