package model.vehiculo.abm;

import model.vehiculo.Vehiculo;

public interface IAbmVehiculo {

    boolean cargarVehiculoImpl(Vehiculo vehiculo);

    boolean modificarVehiculoImpl(Vehiculo vehiculo);

    void eliminarVehiculoImpl(Vehiculo vehiculo);

    void mostrarVehiculoImpl();

}
