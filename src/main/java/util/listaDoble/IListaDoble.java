package util.listaDoble;

public interface IListaDoble {

    void insertarNodo(String dato);

    NodoDoble eliminarNodo(String dato);

    void listarListaDoble(String tipoOrden);

    NodoDoble buscarNodo(String dato);

}
