package util.cola;

public class ColaImp<T> implements ICola<T> {
    private NodoCola<T> inicio;
    private NodoCola<T> fin;

    public ColaImp() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public void insertarElemento(T elemento) {
        NodoCola<T> nuevoNodo = new NodoCola<>(elemento);
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
    public String listaDeElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoCola<T> temp = inicio;
        int indice = 0;
        while (temp != null) {
            elementos.append(indice).append(":\n").append(temp.dato);
            if (temp.siguienteNodo != null) {
                elementos.append("\n");
            }
            temp = temp.siguienteNodo;
            indice++;
        }
        return elementos.toString();
    }


    @Override
    public String listarElementosInverso() {
        return listarElementosInversoRecursivo(inicio);
    }

    private String listarElementosInversoRecursivo(NodoCola<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return listarElementosInversoRecursivo(nodo.siguienteNodo) + nodo.dato + " ";
    }

    @Override
    public boolean estaVacia() {
        return this.inicio == null;
    }

}
