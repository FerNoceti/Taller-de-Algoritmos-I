package modelo.vehiculo.abm;

import modelo.vehiculo.Auto;
import modelo.vehiculo.Vehiculo;
import repositorio.RepositorioDatos;

public class ABMAutoImpl implements IAbmVehiculo {

	@Override
	public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
		if(RepositorioDatos.indice<=RepositorioDatos.TAMANIO_ARREGLO) {
			Auto auto=(Auto)vehiculo;
			if(validarAuto(auto)) {
				if(existeAuto(auto)==-1) {
					RepositorioDatos.vehiculos[RepositorioDatos.indice]=vehiculo;
					RepositorioDatos.indice++;
					return true;
				}else
					System.out.println("El auto ingresado ya existe");
			}else
				System.out.println("Faltan cargar datos");
		}else
			System.out.println("Se supero la capacidad del arreglo de vehiculos");
		
		return false;
	}

	@Override
	public boolean modificarVehiculoImpl(Vehiculo vehiculo) {
		
		Auto auto=(Auto)vehiculo;
		if(validarAuto(auto)) {
			int i=existeAuto(auto);
			if(i!=-1) {
				RepositorioDatos.vehiculos[i]=vehiculo;
				return true;
			}else
				System.out.println("El auto ingresado no existe");
		}else
			System.out.println("Faltan cargar datos");
	
		return false;
	}

	@Override
	public void eliminarVehiculoImpl(Vehiculo vehiculo) {
		Auto auto=(Auto)vehiculo;
		int i=existeAuto(auto);
		if(i!=-1) {
			RepositorioDatos.vehiculos[i]=null;
		}else
			System.out.println("No se encontro el auto que quiere eliminar");
	}

	@Override
	public void mostrarVehiculoImpl() {
		for (int i=0;i<RepositorioDatos.vehiculos.length;i++) {
			Auto auto=(Auto)RepositorioDatos.vehiculos[i];
			if(auto!=null && auto instanceof Auto ) {
				System.out.println("Modelo: "+auto.getModelo());
				System.out.println("Marca: "+auto.getMarca());
				System.out.println("Combustible: "+auto.getTipoConbustible());
				System.out.println("Color: "+auto.getColor());
				System.out.println("Cabt. Puertas: "+auto.getCantPuerta());
				System.out.println("Kilómetros: "+auto.getKilometro());
				System.out.println("Precio: "+auto.getPrecio());
				System.out.println("Patente: "+auto.getPatente());
			}
		}		
	}
	
	private boolean validarAuto(Auto auto) {
		if(auto== null)
			return false;
		else {
			if(auto.getMarca().equals(""))
				return false;
			if(auto.getModelo().equals(""))
				return false;
			if(auto.getTipoConbustible().equals(""))
				return false;
			if(auto.getCantPuerta()==0)
				return false;
		}
		return true;
	}
	private int existeAuto(Auto auto) {
		for(int i=0;i<RepositorioDatos.vehiculos.length;i++) {
			Auto a=(Auto)RepositorioDatos.vehiculos[i];
			if(a!=null && auto.getPatente().equals(a.getPatente()))
					return i;
		}
		return -1;
	}
}
