package util.cola;

public class ColaImp<T> implements ICola<T> {
    private NodoCola<T> inicio;
    private NodoCola<T> fin;

    public ColaImp() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public void insertarElemento(NodoCola<T> nuevoNodo) {
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            fin.siguienteNodo = nuevoNodo;
        }
        fin = nuevoNodo;
    }

    @Override
    public NodoCola<T> eliminarElemento() {
        NodoCola<T> nodoEliminado = null;
        if (inicio == null) {
            System.out.println("La cola está vacía");
        } else {
            nodoEliminado = inicio;
            inicio = inicio.siguienteNodo;
            if (inicio == null) {
                fin = null;
            }
        }
        return nodoEliminado;
    }

    @Override
    public void listarElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoCola<T> temp = inicio;
        while (temp != null) {
            elementos.append(temp.dato).append(" ");
            temp = temp.siguienteNodo;
        }
        System.out.println(elementos);
    }

    @Override
    public void listarElementosInverso() {
        System.out.println(listarElementosInversoRecursivo(inicio));
    }

    private String listarElementosInversoRecursivo(NodoCola<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return listarElementosInversoRecursivo(nodo.siguienteNodo) + nodo.dato + " ";
    }

    private boolean estaVacia() {
        return this.inicio == null;
    }

}
