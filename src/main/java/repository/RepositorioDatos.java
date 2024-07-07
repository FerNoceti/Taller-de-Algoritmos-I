package repository;

import model.vehiculo.Vehiculo;
import model.vehiculo.abm.ABMAutoImpl;
import model.vehiculo.abm.ABMMotoImpl;
import util.listaDoble.ListaDobleImpl;
import util.pila.PilaImp;

public class RepositorioDatos {
    public static ListaDobleImpl<Vehiculo> vehiculos = new ListaDobleImpl<>();
    public static PilaImp<ListaDobleImpl<Vehiculo>> pilaDeshacer = new PilaImp<>();
    public static PilaImp<ListaDobleImpl<Vehiculo>> pilaRehacer = new PilaImp<>();
    public static ABMAutoImpl abmAuto = new ABMAutoImpl();
    public static ABMMotoImpl abmMoto = new ABMMotoImpl();
}
