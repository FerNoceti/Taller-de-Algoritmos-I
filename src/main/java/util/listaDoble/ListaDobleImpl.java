package util.listaDoble;

public class ListaDobleImpl implements IListaDoble {

    private NodoDoble primerNodo, ultimoNodo;

    public ListaDobleImpl(){
        this.primerNodo = this.ultimoNodo = null;
    }

    @Override
    public void insertarNodo(String dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = nuevoNodo;
        } else if (this.primerNodo.dato.compareTo(nuevoNodo.dato) > 0) {
            this.primerNodo.nodoAnterior = nuevoNodo;
            nuevoNodo.nodoSiguiente = this.primerNodo;
            this.primerNodo = nuevoNodo;
        } else if (this.ultimoNodo.dato.compareTo(nuevoNodo.dato) < 0) {
            this.ultimoNodo.nodoSiguiente = nuevoNodo;
            nuevoNodo.nodoAnterior = this.ultimoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            NodoDoble nodoActual = this.primerNodo.nodoSiguiente;
            while (nodoActual != null) {
                if (nodoActual.dato.compareTo(nuevoNodo.dato) > 0) {
                    nuevoNodo.nodoSiguiente = nodoActual;
                    nuevoNodo.nodoAnterior = nodoActual.nodoAnterior;
                    nodoActual.nodoAnterior.nodoSiguiente = nuevoNodo;
                    nodoActual.nodoAnterior = nuevoNodo;
                    break;
                }
                nodoActual = nodoActual.nodoSiguiente;
            }
        }
    }

    @Override
    public NodoDoble eliminarNodo(String dato) {
        NodoDoble nodoEliminado = null;
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
                NodoDoble nodoActual = this.primerNodo.nodoSiguiente;
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
    public void listarListaDoble(String tipoOrden) {
        switch (tipoOrden) {
            case "ASC":
                NodoDoble nodoActual = this.primerNodo;
                while (nodoActual != null) {
                    System.out.println("El dato es: " + nodoActual.dato);
                    nodoActual = nodoActual.nodoSiguiente;
                }
                break;
            case "DES":
                NodoDoble nodoActualDesc = this.ultimoNodo;
                while (nodoActualDesc != null) {
                    System.out.println("El dato es: " + nodoActualDesc.dato);
                    nodoActualDesc = nodoActualDesc.nodoAnterior;
                }
                break;
        }
    }

    @Override
    public NodoDoble buscarNodo(String dato) {
        NodoDoble nodoBuscado = null;
        NodoDoble nodoActual = this.primerNodo;
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
