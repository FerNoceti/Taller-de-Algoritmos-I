package util.cola;

public interface ICola<T> {
    void insertarElemento(NodoCola<T> nuevoNodo);

    NodoCola<T> eliminarElemento();

    void listarElementos();

    void listarElementosInverso();
}
