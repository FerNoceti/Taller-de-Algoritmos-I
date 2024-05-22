package modelo.vehiculo.abm;

import modelo.vehiculo.Vehiculo;

public interface IAbmVehiculo {

    boolean cargarVehiculoImpl(Vehiculo vehiculo);

    boolean modificarVehiculoImpl(Vehiculo vehiculo);

    void eliminarVehiculoImpl(Vehiculo vehiculo);

    void mostrarVehiculoImpl();

}
