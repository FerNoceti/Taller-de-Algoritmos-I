package util.pila;

public class PilaImp implements IPila {

    NodoPila tope;

    public PilaImp() {
        this.tope = null;
    }

    @Override
    public void insertarElemento(NodoPila nodoPila) {
        if (esVacia()) {
            this.tope = nodoPila;
        } else {
            nodoPila.ant = tope;
            this.tope = nodoPila;
        }
    }

    @Override
    public NodoPila eliminarElemnto() {
        NodoPila nodoEliminado = null;

        if (esVacia()) {
            System.out.println("No se puede eliminar");
        } else {
            nodoEliminado = this.tope;
            this.tope = nodoEliminado.ant;
        }
        return nodoEliminado;
    }

    @Override
    public void listarElementos() {
        PilaImp pilaAMostrar = new PilaImp();
        pilaAMostrar.tope = this.tope;

        while (!pilaAMostrar.esVacia()){
            System.out.println(pilaAMostrar.tope.dato);
            pilaAMostrar.eliminarElemnto();
        }
    }

    private boolean esVacia() {
        return this.tope == null;
    }

    public static void main(String[] args) {
        PilaImp pilaImp = new PilaImp();

        pilaImp.insertarElemento(new NodoPila(2));
        pilaImp.insertarElemento(new NodoPila(5));

        pilaImp.listarElementos();

        pilaImp.eliminarElemnto();

        pilaImp.listarElementos();
    }
}
