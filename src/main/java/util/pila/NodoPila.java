package util.pila;

public class NodoPila {
    public int dato;
    public NodoPila ant;

    public NodoPila(int value) {
        super();
        this.dato = value;
        this.ant = null;
    }
}
