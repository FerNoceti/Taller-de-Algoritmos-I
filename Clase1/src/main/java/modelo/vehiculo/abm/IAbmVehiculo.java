package modelo.vehiculo.abm;

import modelo.vehiculo.Vehiculo;

public interface IAbmVehiculo {
	
	public boolean cargarVehiculoImpl(Vehiculo vehiculo);
	
	public boolean modificarVehiculoImpl(Vehiculo vehiculo);
	
	public void eliminarVehiculoImpl(Vehiculo vehiculo);
	
	public void mostrarVehiculoImpl();
	
}
