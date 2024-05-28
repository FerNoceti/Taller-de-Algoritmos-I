package util.pila;

public class NodoPila {
    public int dato;
    public NodoPila ant;

    public NodoPila(int dato) {
        super();
        this.dato = dato;
        this.ant = null;
    }
}
