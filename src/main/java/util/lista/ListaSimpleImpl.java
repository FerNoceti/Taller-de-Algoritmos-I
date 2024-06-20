package util.lista;

public class ListaSimpleImpl implements IListaSimple {

    private NodoLista primerNodo, ultimoNodo;

    public ListaSimpleImpl(){
        this.primerNodo = this.ultimoNodo = null;
    }

    @Override
    public void agregarNodo(NodoLista nuevoNodo) {
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = nuevoNodo;
        } else {
            if (nuevoNodo.dato < this.primerNodo.dato) {
                nuevoNodo.siguienteNodo = this.primerNodo;
                this.primerNodo = nuevoNodo;
            } else if (nuevoNodo.dato > this.ultimoNodo.dato) {
                this.ultimoNodo.siguienteNodo = nuevoNodo;
                this.ultimoNodo = nuevoNodo;
            } else {
                NodoLista nodoActual = this.primerNodo.siguienteNodo;
                NodoLista nodoAnterior = this.primerNodo;
                while (nodoActual != null) {
                    if (nuevoNodo.dato < nodoActual.dato) {
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
    public NodoLista eliminarNodo(int dato) {
        NodoLista nodoEliminado = null;
        if (!estaVacia()) {
            if (this.primerNodo.dato == dato) {
                nodoEliminado = this.primerNodo;
                this.primerNodo = this.primerNodo.siguienteNodo;
            } else {
                NodoLista nodoActual = this.primerNodo.siguienteNodo;
                NodoLista nodoAnterior = this.primerNodo;
                while (nodoActual != null) {
                    if (nodoActual.dato == dato) {
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
        NodoLista nodoActual = this.primerNodo;
        while (nodoActual != null) {
            System.out.println("El dato es: " + nodoActual.dato);
            nodoActual = nodoActual.siguienteNodo;
        }
    }

    @Override
    public NodoLista buscarNodo(int dato) {
        NodoLista nodoBuscado = null;
        NodoLista nodoActual = this.primerNodo;
        while (nodoActual != null) {
            if (nodoActual.dato == dato) {
                nodoBuscado = nodoActual;
                break;
            }
            nodoActual = nodoActual.siguienteNodo;
        }
        return nodoBuscado;
    }

    private boolean estaVacia() {
        return this.primerNodo == null && this.ultimoNodo == null;
    }
}
