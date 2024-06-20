package util.lista;

public interface IListaSimple {

    void agregarNodo(NodoLista nuevoNodo);

    NodoLista eliminarNodo(int dato);

    void listar();

    NodoLista buscarNodo(int dato);
}
