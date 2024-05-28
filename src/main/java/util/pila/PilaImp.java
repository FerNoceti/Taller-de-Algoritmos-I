package util.pila;

public class PilaImp implements IPila {

    Nodo top;

    public PilaImp() {
        this.top = null;
    }

    @Override
    public void insertarElemento(Nodo nodo) {
        if (esVacia()) {
            this.top = nodo;
        } else {
            nodo.ant = top;
            this.top = nodo;
        }
    }

    @Override
    public Nodo eliminarElemnto() {
        Nodo nodoEliminado = null;

        if (esVacia()) {
            System.out.println("No se puede eliminar");
        } else {
            nodoEliminado = this.top;
            this.top = nodoEliminado.ant;
        }
        return nodoEliminado;
    }

    @Override
    public void listarElementos() {
        Nodo temp = top;
        while (temp != null) {
            System.out.println(temp.dato);
            temp = temp.ant;
        }
    }

    @Override
    public void listarElementosInverso() {
        listarElementosInversoRecursivo(top);
    }

    private void listarElementosInversoRecursivo(Nodo nodo) {
        if (nodo != null) {
            listarElementosInversoRecursivo(nodo.ant);
            System.out.println(nodo.dato);
        }
    }

    private boolean esVacia() {
        return this.top == null;
    }

    public static void main(String[] args) {
        PilaImp pilaImp = new PilaImp();

        pilaImp.insertarElemento(new Nodo(2));
        pilaImp.insertarElemento(new Nodo(5));
        pilaImp.insertarElemento(new Nodo(7));
        pilaImp.insertarElemento(new Nodo(9));

        pilaImp.listarElementos();

        pilaImp.eliminarElemnto();

        pilaImp.listarElementos();

        pilaImp.listarElementosInverso();
    }
}