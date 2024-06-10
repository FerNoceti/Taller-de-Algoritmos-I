package util.cola;

public interface ICola<T> {
    void insertarElemento(NodoCola<T> nodoCola);

    NodoCola<T> eliminarElemnto();

    void listarElementos();

    void listarElementosInverso();
}
