package main;

import model.vehiculo.Auto;
import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import model.vehiculo.abm.ABMAutoImpl;
import model.vehiculo.abm.ABMMotoImpl;
import repository.RepositorioDatos;
import util.pila.PilaImp;

import java.util.Scanner;
import java.util.Random;

public class Menu {

    private Scanner scanner;
    private Random random;

    private ABMAutoImpl abmAuto = new ABMAutoImpl();
    private ABMMotoImpl abmMoto = new ABMMotoImpl();

    private PilaImp<Vehiculo[]> pilaDeshacer = new PilaImp<>();
    private PilaImp<Vehiculo[]> pilaRehacer = new PilaImp<>();


    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public void displayMenu() {
        String menuOptions = "1. Cargar auto\n2. Cargar moto\n3. Eliminar vehiculo\n4. Deshacer\n5. Rehacer\n6. Listar autos\n7. Listar motos\n8. Salir";
        int opcion = 0;

        while (opcion != 8) {
            System.out.println(menuOptions);
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            handleMenuOption(opcion);
        }
    }

    private void handleMenuOption(int opcion) {
        switch (opcion) {
            case 1:
                //cargarAuto();
                cargarAutoAleatorio();
                break;
            case 2:
                //cargarMoto();
                cargarMotoAleatoria();
                break;
            case 3:
                eliminarVehiculo();
                break;
            case 4:
                deshacer();
                break;
            case 5:
                rehacer();
                break;
            case 6:
                listarAutos();
                break;
            case 7:
                listarMotos();
                break;
            case 8:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    private void guardarEstadoEnPila(PilaImp<Vehiculo[]> pila, Vehiculo[] estado) {
        pila.insertarElemento(estado.clone());
    }

    private Vehiculo[] clonarVehiculos(Vehiculo[] vehiculos) {
        Vehiculo[] clone = new Vehiculo[vehiculos.length];
        for (int i = 0; i < vehiculos.length; i++) {
            clone[i] = vehiculos[i];
        }
        return clone;
    }

    //Opcion 1
    private void cargarAutoAleatorio() {
        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        String[] modelos = {"Modelo 1", "Modelo 2", "Modelo 3"};
        String[] colores = {"Rojo", "Azul", "Negro"};
        String[] combustibles = {Auto.NAFTA, Auto.GASOIL, Auto.ELECTRICO};
        String[] marcas = {"Toyota", "Fiat", "Ford"};
        String[] patentes = {"ABC123", "DEF456", "GHI789"};

        String modelo = modelos[random.nextInt(modelos.length)];
        String color = colores[random.nextInt(colores.length)];

        double precio = 5000 + Math.round((100000 - 5000) * random.nextDouble());
        float kilometro = Math.round((200000 - 0) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cantPuerta = 2 + random.nextInt(5 - 2 + 1);
        String tipoCombustible = combustibles[random.nextInt(combustibles.length)];
        String marca = marcas[random.nextInt(marcas.length)];
        String patente = patentes[random.nextInt(patentes.length)];

        Auto auto = new Auto(modelo, color, precio, kilometro, usado, cantPuerta, tipoCombustible, marca, patente);

        abmAuto.cargarVehiculoImpl(auto);
    }

    //Opcion 2
    private void cargarMotoAleatoria() {
        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        String[] modelos = {"Modelo 1", "Modelo 2", "Modelo 3"};
        String[] colores = {"Rojo", "Azul", "Negro"};
        String[] marcas = {"Honda", "Yamaha", "Suzuki"};
        String[] patentes = {"ABC123", "DEF456", "GHI789"};

        String modelo = modelos[random.nextInt(modelos.length)];
        String color = colores[random.nextInt(colores.length)];

        double precio = 2000 + Math.round((50000 - 2000) * random.nextDouble());
        float kilometro = Math.round((50000 - 0) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cilindrada = Moto.BAJA + random.nextInt((Moto.ALTA - Moto.BAJA) + 1);

        String marca = marcas[random.nextInt(marcas.length)];
        String patente = patentes[random.nextInt(patentes.length)];

        Moto moto = new Moto(modelo, color, precio, kilometro, usado, cilindrada, marca, patente);

        abmMoto.cargarVehiculoImpl(moto);
    }

    // Opcion 3

    private void eliminarVehiculo() {
        //ToDo
    }

    //Opcion 4
    private void deshacer() {
        if (!pilaDeshacer.estaVacia()) {
            guardarEstadoEnPila(pilaRehacer, clonarVehiculos(RepositorioDatos.vehiculos));
            RepositorioDatos.vehiculos = pilaDeshacer.eliminarElemento();
        } else {
            System.out.println("No hay operaciones para deshacer");
        }
    }


    //Opcion 5
    private void rehacer() {
        if (!pilaRehacer.estaVacia()) {
            guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
            RepositorioDatos.vehiculos = pilaRehacer.eliminarElemento();
        } else {
            System.out.println("No hay operaciones para rehacer");
        }
    }

    //Opcion 6
    private void listarAutos() {
        abmAuto.mostrarVehiculoImpl();
    }

    //Opcion 7
    private void listarMotos() {
        abmMoto.mostrarVehiculoImpl();
    }

}
