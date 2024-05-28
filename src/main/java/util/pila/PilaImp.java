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
        String elementos = "";

        Nodo temp = top;
        while (temp != null) {
            elementos += temp.dato + " ";
            temp = temp.ant;
        }

        System.out.println(elementos);
    }

    @Override
    public void listarElementosInverso() {
        System.out.println(elementosInversoRecursivo(top));
    }

    private String elementosInversoRecursivo(Nodo nodo) {
        String elementos = "";
        if (nodo != null) {
            elementos += elementosInversoRecursivo(nodo.ant) + nodo.dato + " ";
        }
        return elementos;
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

        System.out.println("Elemento eliminado: " + pilaImp.eliminarElemnto().dato);

        pilaImp.listarElementos();

        pilaImp.listarElementosInverso();
    }
}