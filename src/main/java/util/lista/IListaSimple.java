package util.lista;

/**
 * Interface para una lista simplemente enlazada genérica.
 *
 * @param <T> el tipo de dato que almacenará la lista
 */
public interface IListaSimple<T extends Comparable<T>> {

    /**
     * Agrega un nuevo nodo a la lista.
     *
     * @param nuevoNodo el nodo a agregar
     */
    void agregarNodo(NodoLista<T> nuevoNodo);

    /**
     * Elimina el nodo que contiene el dato especificado.
     *
     * @param dato el dato del nodo a eliminar
     * @return el nodo eliminado, o null si no se encuentra
     */
    NodoLista<T> eliminarNodo(T dato);

    /**
     * Lista todos los elementos de la lista.
     */
    void listar();

    /**
     * Busca un nodo que contiene el dato especificado.
     *
     * @param dato el dato del nodo a buscar
     * @return el nodo encontrado, o null si no se encuentra
     */
    NodoLista<T> buscarNodo(T dato);
}
