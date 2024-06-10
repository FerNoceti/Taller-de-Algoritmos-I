package util.lista;

public class ListaImp<T> implements ILista<T> {

    private NodoLista<T> primero, ultimo;

    public ListaImp() {
        this.primero = this.ultimo = null;
    }

    @Override
    public void agregarNodo(NodoLista<T> nodoLista) {
        if (esVacio())
            this.primero = this.ultimo = nodoLista;
        else {
        }
    }

    @Override
    public NodoLista<T> eliminarNodo(NodoLista<T> nodoLista) {
        return null;
    }

    @Override
    public void listar() {

    }

    @Override
    public void buscarElemento(NodoLista<T> nodoLista) {

    }

    @Override
    public boolean esVacio(){
        return this.primero == null && this.ultimo == null;
    }

    public NodoLista<T> getPrimero() {
        return primero;
    }

    public NodoLista<T> getUltimo() {
        return ultimo;
    }

}