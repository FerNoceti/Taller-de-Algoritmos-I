package util.pila;

public class PilaImp<T> implements IPila<T> {
    private NodoPila<T> cima;

    public PilaImp() {
        this.cima = null;
    }

    @Override
    public void insertarElemento(T elemento) {
        NodoPila<T> nuevoNodo = new NodoPila<>(elemento);
        if (estaVacia()) {
            this.cima = nuevoNodo;
        } else {
            nuevoNodo.nodoAnterior = cima;
            this.cima = nuevoNodo;
        }
    }

    @Override
    public T eliminarElemento() {
        if (estaVacia()) {
            throw new RuntimeException("No se puede eliminar, la pila está vacía");
        }
        NodoPila<T> nodoEliminado = this.cima;
        this.cima = nodoEliminado.nodoAnterior;
        return nodoEliminado.dato;
    }

    @Override
    public String listaDeElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoPila<T> temp = cima;
        while (temp != null) {
            elementos.append(temp.dato).append(" ");
            temp = temp.nodoAnterior;
        }
        return elementos.toString();
    }

    @Override
    public String listaDeElementosInverso() {
        return elementosInversoRecursivo(cima);
    }

    private String elementosInversoRecursivo(NodoPila<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return elementosInversoRecursivo(nodo.nodoAnterior) + nodo.dato + " ";
    }

    @Override
    public void vaciar() {
        this.cima = null;
    }

    @Override
    public boolean estaVacia() {
        return this.cima == null;
    }
}
