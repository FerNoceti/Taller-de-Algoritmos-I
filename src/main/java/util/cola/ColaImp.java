package util.cola;

public class ColaImp implements ICola {
    private NodoCola inicio;
    private NodoCola fin;

    public ColaImp() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public void insertarElemento(NodoCola nodoCola) {
        if (inicio == null) {
            inicio = nodoCola;
        } else {
            fin.sig = nodoCola;
        }
        fin = nodoCola;
    }

    @Override
    public NodoCola eliminarElemnto() {
        NodoCola nodoColaEliminado = null;
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
        NodoCola temp = inicio;
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

    private String elementosInversoRecursivo(NodoCola nodoCola) {
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
        cola.insertarElemento(new NodoCola(1));
        cola.insertarElemento(new NodoCola(2));
        cola.insertarElemento(new NodoCola(3));
        cola.insertarElemento(new NodoCola(4));
        cola.insertarElemento(new NodoCola(5));

        cola.listarElementos();

        System.out.println(STR."Elemento eliminado: \{cola.eliminarElemnto().dato}");

        cola.listarElementos();

        cola.listarElementosInverso();
    }
}
