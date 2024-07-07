package util.lista;

public class ListaSimpleImpl<T extends Comparable<T>> implements IListaSimple<T> {

    private NodoLista<T> primerNodo;
    private NodoLista<T> ultimoNodo;

    public ListaSimpleImpl() {
        this.primerNodo = this.ultimoNodo = null;
    }

    @Override
    public void agregarNodo(NodoLista<T> nuevoNodo) {
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = nuevoNodo;
        } else {
            if (nuevoNodo.dato.compareTo(this.primerNodo.dato) < 0) {
                nuevoNodo.siguienteNodo = this.primerNodo;
                this.primerNodo = nuevoNodo;
            } else if (nuevoNodo.dato.compareTo(this.ultimoNodo.dato) > 0) {
                this.ultimoNodo.siguienteNodo = nuevoNodo;
                this.ultimoNodo = nuevoNodo;
            } else {
                NodoLista<T> nodoActual = this.primerNodo.siguienteNodo;
                NodoLista<T> nodoAnterior = this.primerNodo;
                while (nodoActual != null) {
                    if (nuevoNodo.dato.compareTo(nodoActual.dato) < 0) {
                        nuevoNodo.siguienteNodo = nodoAnterior.siguienteNodo;
                        nodoAnterior.siguienteNodo = nuevoNodo;
                        break;
                    }
                    nodoAnterior = nodoActual;
                    nodoActual = nodoActual.siguienteNodo;
                }
            }
        }
    }

    @Override
    public NodoLista<T> eliminarNodo(T dato) {
        NodoLista<T> nodoEliminado = null;
        if (!estaVacia()) {
            if (this.primerNodo.dato.compareTo(dato) == 0) {
                nodoEliminado = this.primerNodo;
                this.primerNodo = this.primerNodo.siguienteNodo;
            } else {
                NodoLista<T> nodoActual = this.primerNodo.siguienteNodo;
                NodoLista<T> nodoAnterior = this.primerNodo;
                while (nodoActual != null) {
                    if (nodoActual.dato.compareTo(dato) == 0) {
                        nodoEliminado = nodoActual;
                        nodoAnterior.siguienteNodo = nodoActual.siguienteNodo;
                        break;
                    }
                    nodoAnterior = nodoActual;
                    nodoActual = nodoActual.siguienteNodo;
                }
            }
        } else {
            System.out.println("La lista está vacía");
        }
        return nodoEliminado;
    }

    @Override
    public void listar() {
        NodoLista<T> nodoActual = this.primerNodo;
        while (nodoActual != null) {
            System.out.println("El dato es: " + nodoActual.dato);
            nodoActual = nodoActual.siguienteNodo;
        }
    }

    @Override
    public NodoLista<T> buscarNodo(T dato) {
        NodoLista<T> nodoBuscado = null;
        NodoLista<T> nodoActual = this.primerNodo;
        while (nodoActual != null) {
            if (nodoActual.dato.compareTo(dato) == 0) {
                nodoBuscado = nodoActual;
                break;
            }
            nodoActual = nodoActual.siguienteNodo;
        }
        return nodoBuscado;
    }

    private boolean estaVacia() {
        return this.primerNodo == null;
    }
}
