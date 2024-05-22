package principal;

import modelo.vehiculo.Auto;
import modelo.vehiculo.abm.ABMAutoImpl;

public class Main {

	public static void main(String[] args) {
		
		Auto auto1= new Auto("2024","rojo",22000D,50000F,true,5,Auto.NAFTA,"FORD","AS457RT");
		Auto auto2= new Auto("2000","negro",12000D,80000F,true,5,Auto.NAFTA,"RENAULT","AW901RT");
	
		ABMAutoImpl abmAutoImpl=new ABMAutoImpl();
		
		if(abmAutoImpl.cargarVehiculoImpl(auto1))
			System.out.println("Se cargo con exito");
		else
			System.out.println("No se cargo con exito");
		
		abmAutoImpl.cargarVehiculoImpl(auto2);
		abmAutoImpl.mostrarVehiculoImpl();
	}
}
