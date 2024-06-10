package util.cola;

public class ColaImp<T> implements ICola<T> {
    private NodoCola<T> inicio;
    private NodoCola<T> fin;

    public ColaImp() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public void insertarElemento(NodoCola<T> nodoCola) {
        if (inicio == null) {
            inicio = nodoCola;
        } else {
            fin.sig = nodoCola;
        }
        fin = nodoCola;
    }

    @Override
    public NodoCola<T> eliminarElemnto() {
        NodoCola<T> nodoColaEliminado = null;
        if (inicio == null) {
            System.out.println("La cola esta vacia");
        } else {
            nodoColaEliminado = inicio;
            inicio = inicio.sig;
            if (inicio == null) {
                fin = null;
            }
        }
        return nodoColaEliminado;
    }

    @Override
    public void listarElementos() {
        StringBuilder elementos = new StringBuilder();
        NodoCola<T> temp = inicio;
        while (temp != null) {
            elementos.append(temp.dato).append(" ");
            temp = temp.sig;
        }
        System.out.println(elementos);
    }

    @Override
    public void listarElementosInverso() {
        System.out.println(elementosInversoRecursivo(inicio));
    }

    private String elementosInversoRecursivo(NodoCola<T> nodoCola) {
        String elementos = "";
        if (nodoCola != null) {
            elementos = STR."\{elementosInversoRecursivo(nodoCola.sig)}\{nodoCola.dato} ";
        }
        return elementos;
    }

    private boolean esVacia() {
        return this.inicio == null;
    }

    public static void main(String[] args) {
        ColaImp cola = new ColaImp();
        cola.insertarElemento(new NodoCola<Integer>(1));
        cola.insertarElemento(new NodoCola<Integer>(2));
        cola.insertarElemento(new NodoCola<Integer>(3));
        cola.insertarElemento(new NodoCola<Integer>(4));
        cola.insertarElemento(new NodoCola<Integer>(5));

        cola.listarElementos();

        System.out.println(STR."Elemento eliminado: \{cola.eliminarElemnto().dato}");

        cola.listarElementos();

        cola.listarElementosInverso();
    }
}
