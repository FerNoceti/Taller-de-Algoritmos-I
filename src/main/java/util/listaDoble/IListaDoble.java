package util.listaDoble;

/**
 * Interface para una lista doblemente enlazada genérica.
 *
 * @param <T> el tipo de dato que almacenará la lista
 */
public interface IListaDoble<T extends Comparable<T>> {

    /**
     * Inserta un nuevo nodo con el dato especificado al final de la lista.
     *
     * @param dato el dato a insertar
     */
    void insertarAlFinal(T dato);

    /**
     * Elimina el nodo que contiene el dato especificado.
     *
     * @param dato el dato del nodo a eliminar
     * @return el nodo eliminado, o null si no se encuentra
     */
    NodoDoble<T> eliminarNodo(T dato);

    /**
     * Lista todos los elementos de la lista en el orden especificado.
     *
     * @param tipoOrden "ASC" para orden ascendente, "DES" para orden descendente
     */
    void listarElementos(String tipoOrden);

    /**
     * Busca un nodo que contiene el dato especificado.
     *
     * @param dato el dato del nodo a buscar
     * @return el nodo encontrado, o null si no se encuentra
     */
    NodoDoble<T> buscarNodo(T dato);

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario
     */
    boolean estaVacia();

    /**
     * Devuelve el primer nodo de la lista.
     *
     * @return el primer nodo de la lista
     */
    NodoDoble<T> getPrimerNodo();

    /**
     * Devuelve el último nodo de la lista.
     *
     * @return el último nodo de la lista
     */
    NodoDoble<T> getUltimoNodo();

    /**
     * Devuelve el tamaño de la lista.
     *
     * @return el tamaño de la lista
     */
    int getTamanio();

    /**
     * Ordena la lista de forma ascendente con el algoritmo Quicksort.
     */
    void quicksort();
}
