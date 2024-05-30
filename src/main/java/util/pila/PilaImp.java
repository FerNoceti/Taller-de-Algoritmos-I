package util.pila;

public class PilaImp implements IPila {

    NodoPila top;

    public PilaImp() {
        this.top = null;
    }

    @Override
    public void insertarElemento(NodoPila nodoPila) {
        if (esVacia()) {
            this.top = nodoPila;
        } else {
            nodoPila.ant = top;
            this.top = nodoPila;
        }
    }

    @Override
    public NodoPila eliminarElemnto() {
        NodoPila nodoPilaEliminado = null;

        if (esVacia()) {
            System.out.println("No se puede eliminar");
        } else {
            nodoPilaEliminado = this.top;
            this.top = nodoPilaEliminado.ant;
        }
        return nodoPilaEliminado;
    }

    @Override
    public void listarElementos() {
        String elementos = "";

        NodoPila temp = top;
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

    private String elementosInversoRecursivo(NodoPila nodoPila) {
        String elementos = "";
        if (nodoPila != null) {
            elementos += elementosInversoRecursivo(nodoPila.ant) + nodoPila.dato + " ";
        }
        return elementos;
    }

    private boolean esVacia() {
        return this.top == null;
    }

    public static void main(String[] args) {
        PilaImp pilaImp = new PilaImp();

        pilaImp.insertarElemento(new NodoPila(2));
        pilaImp.insertarElemento(new NodoPila(5));
        pilaImp.insertarElemento(new NodoPila(7));
        pilaImp.insertarElemento(new NodoPila(9));

        pilaImp.listarElementos();

        System.out.println("Elemento eliminado: " + pilaImp.eliminarElemnto().dato);

        pilaImp.listarElementos();

        pilaImp.listarElementosInverso();
    }
}