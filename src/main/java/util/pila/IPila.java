package util.pila;

public interface IPila {
    void insertarElemento(NodoPila nodoPila);

    NodoPila eliminarElemnto();

    void listarElementos();

    void listarElementosInverso();
}
