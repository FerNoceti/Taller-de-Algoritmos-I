package util.pila;

/**
 * Interfaz que define las operaciones básicas que debe implementar una Pila.
 *
 * @param <T> Tipo de elemento que contendrá la pila.
 */
public interface IPila<T> {

    /**
     * Inserta un elemento en la cima de la pila.
     *
     * @param elemento Elemento a insertar.
     */
    void insertarElemento(T elemento);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return Elemento eliminado de la cima de la pila.
     */
    T eliminarElemento();

    /**
     * Retorna una representación en forma de cadena de caracteres de los elementos
     * presentes en la pila.
     *
     * @return Cadena de caracteres que representa los elementos de la pila.
     */
    String listaDeElementos();

    /**
     * Retorna una representación en forma de cadena de caracteres de los elementos
     * presentes en la pila en orden inverso.
     *
     * @return Cadena de caracteres que representa los elementos de la pila en orden inverso.
     */
    String listaDeElementosInverso();

    /**
     * Vacía la pila, eliminando todos sus elementos.
     */
    void vaciar();

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean estaVacia();
}
