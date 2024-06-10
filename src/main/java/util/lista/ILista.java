package util.lista;

public interface ILista<T> {
    public void agregarNodo(NodoLista<T> nodoLista);

    public NodoLista<T> eliminarNodo(NodoLista<T> nodoLista);

    public void listar();

    public void buscarElemento(NodoLista<T> nodoLista);

    public boolean esVacio();

}
