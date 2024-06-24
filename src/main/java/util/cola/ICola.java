package util.cola;

import java.util.NoSuchElementException;

public interface ICola<T> {

    /**
     * Inserta un elemento en la cola.
     * @param elemento Elemento a insertar.
     */
    void insertarElemento(T elemento);

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * @return NodoCola que representa el elemento eliminado.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    NodoCola<T> eliminarElemento();

    /**
     * Lista todos los elementos de la cola en el orden en que fueron agregados.
     * @return Cadena con los elementos de la cola.
     */
    String listaDeElementos();

    /**
     * Lista todos los elementos de la cola en orden inverso al que fueron agregados.
     * @return Cadena con los elementos de la cola en orden inverso.
     */
    String listarElementosInverso();

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false si tiene elementos.
     */
    boolean estaVacia();
}
