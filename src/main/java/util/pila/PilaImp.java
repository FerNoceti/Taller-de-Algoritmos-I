package util.pila;

public class PilaImp<T> implements IPila<T> {
    private NodoPila<T> cima;

    public PilaImp() {
        this.cima = null;
    }

    @Override
    public void insertarElemento(NodoPila<T> nuevoNodo) {
        if (estaVacia()) {
            this.cima = nuevoNodo;
        } else {
            nuevoNodo.nodoAnterior = cima;
            this.cima = nuevoNodo;
        }
    }

    @Override
    public NodoPila<T> eliminarElemento() {
        NodoPila<T> nodoEliminado = null;
        if (estaVacia()) {
            System.out.println("No se puede eliminar, la pila está vacía");
        } else {
            nodoEliminado = this.cima;
            this.cima = nodoEliminado.nodoAnterior;
        }
        return nodoEliminado;
    }

    @Override
    public void listarElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoPila<T> temp = cima;
        while (temp != null) {
            elementos.append(temp.dato).append(" ");
            temp = temp.nodoAnterior;
        }
        System.out.println(elementos);
    }

    @Override
    public void listarElementosInverso() {
        System.out.println(elementosInversoRecursivo(cima));
    }

    private String elementosInversoRecursivo(NodoPila<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return elementosInversoRecursivo(nodo.nodoAnterior) + nodo.dato + " ";
    }

    @Override
    public boolean estaVacia() {
        return this.cima == null;
    }
}
