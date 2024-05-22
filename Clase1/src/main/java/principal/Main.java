package principal;

import modelo.vehiculo.Auto;
import modelo.vehiculo.Moto;
import modelo.vehiculo.abm.ABMAutoImpl;
import modelo.vehiculo.abm.ABMMotoImpl;

public class Main {

    public static void main(String[] args) {
        // Creación de instancias de vehículos
        Auto auto1 = new Auto("2024", "rojo", 22000D, 50000F, true, 5, Auto.NAFTA, "FORD", "AS457RT");
        Auto auto2 = new Auto("2000", "negro", 12000D, 80000F, true, 5, Auto.GASOIL, "RENAULT", "AW901RT");

        Moto moto1 = new Moto("2024", "azul", 8000D, 10000F, false, Moto.ALTA, "Yamaha", "YZF123");
        Moto moto2 = new Moto("2018", "verde", 5000D, 15000F, true, Moto.MEDIA, "Kawasaki", "NIN456");

        // Creación de instancias de las clases ABM
        ABMAutoImpl abmAutoImpl = new ABMAutoImpl();
        ABMMotoImpl abmMotoImpl = new ABMMotoImpl();

        // Carga de autos
        if (abmAutoImpl.cargarVehiculoImpl(auto1))
            System.out.println("Auto 1 cargado con éxito");
        else
            System.out.println("Error al cargar Auto 1");

        if (abmAutoImpl.cargarVehiculoImpl(auto2))
            System.out.println("Auto 2 cargado con éxito");
        else
            System.out.println("Error al cargar Auto 2");

        // Carga de motos
        if (abmMotoImpl.cargarVehiculoImpl(moto1))
            System.out.println("Moto 1 cargada con éxito");
        else
            System.out.println("Error al cargar Moto 1");

        if (abmMotoImpl.cargarVehiculoImpl(moto2))
            System.out.println("Moto 2 cargada con éxito");
        else
            System.out.println("Error al cargar Moto 2");

        // Mostrar todos los autos
        System.out.println("Listado de Autos:");
        abmAutoImpl.mostrarVehiculoImpl();

        // Mostrar todas las motos
        System.out.println("Listado de Motos:");
        abmMotoImpl.mostrarVehiculoImpl();
    }
}
