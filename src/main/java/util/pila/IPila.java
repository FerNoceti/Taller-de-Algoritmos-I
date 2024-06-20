package util.pila;

public interface IPila<T> {
    void insertarElemento(NodoPila<T> nuevoNodo);

    NodoPila<T> eliminarElemento();

    void listarElementos();

    void listarElementosInverso();

    boolean estaVacia();
}
