package util.listaDoble;

public class ListaDobleImpl<T extends Comparable<T>> implements IListaDoble<T> {

    private NodoDoble<T> primerNodo;
    private NodoDoble<T> ultimoNodo;

    public ListaDobleImpl() {
        this.primerNodo = this.ultimoNodo = null;
    }

    @Override
    public void insertarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.nodoSiguiente = nuevoNodo;
            nuevoNodo.nodoAnterior = this.ultimoNodo;
            this.ultimoNodo = nuevoNodo;
        }
    }

    @Override
    public NodoDoble<T> eliminarNodo(T dato) {
        NodoDoble<T> nodoEliminado = null;
        if (!estaVacia()) {
            if (this.primerNodo.dato.compareTo(dato) == 0) {
                nodoEliminado = this.primerNodo;
                this.primerNodo = this.primerNodo.nodoSiguiente;
                if (this.primerNodo != null) {
                    this.primerNodo.nodoAnterior = null;
                }
            } else if (this.ultimoNodo.dato.compareTo(dato) == 0) {
                nodoEliminado = this.ultimoNodo;
                this.ultimoNodo = this.ultimoNodo.nodoAnterior;
                if (this.ultimoNodo != null) {
                    this.ultimoNodo.nodoSiguiente = null;
                }
            } else {
                NodoDoble<T> nodoActual = this.primerNodo.nodoSiguiente;
                while (nodoActual != null) {
                    if (nodoActual.dato.compareTo(dato) == 0) {
                        nodoEliminado = nodoActual;
                        nodoActual.nodoAnterior.nodoSiguiente = nodoActual.nodoSiguiente;
                        if (nodoActual.nodoSiguiente != null) {
                            nodoActual.nodoSiguiente.nodoAnterior = nodoActual.nodoAnterior;
                        }
                        break;
                    }
                    nodoActual = nodoActual.nodoSiguiente;
                }
            }
        } else {
            System.out.println("La lista doble está vacía");
        }
        return nodoEliminado;
    }

    @Override
    public void listarElementos(String tipoOrden) {
        switch (tipoOrden) {
            case "ASC":
                NodoDoble<T> nodoActualAsc = this.primerNodo;
                while (nodoActualAsc != null) {
                    System.out.println("El dato es: " + nodoActualAsc.dato);
                    nodoActualAsc = nodoActualAsc.nodoSiguiente;
                }
                break;
            case "DES":
                NodoDoble<T> nodoActualDesc = this.ultimoNodo;
                while (nodoActualDesc != null) {
                    System.out.println("El dato es: " + nodoActualDesc.dato);
                    nodoActualDesc = nodoActualDesc.nodoAnterior;
                }
                break;
        }
    }

    @Override
    public NodoDoble<T> buscarNodo(T dato) {
        NodoDoble<T> nodoBuscado = null;
        NodoDoble<T> nodoActual = this.primerNodo;
        while (nodoActual != null) {
            if (nodoActual.dato.compareTo(dato) == 0) {
                nodoBuscado = nodoActual;
                break;
            }
            nodoActual = nodoActual.nodoSiguiente;
        }
        return nodoBuscado;
    }

    private boolean estaVacia() {
        return this.primerNodo == null && this.ultimoNodo == null;
    }
}
