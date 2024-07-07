package main;

import model.vehiculo.Auto;
import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import model.vehiculo.abm.ABMAutoImpl;
import model.vehiculo.abm.ABMMotoImpl;
import repository.RepositorioDatos;
import util.pila.PilaImp;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Random random;
    private final PilaImp<Vehiculo[]> pilaDeshacer = new PilaImp<>();
    private final PilaImp<Vehiculo[]> pilaRehacer = new PilaImp<>();
    private final ABMAutoImpl abmAuto = new ABMAutoImpl();
    private final ABMMotoImpl abmMoto = new ABMMotoImpl();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public void displayMenu() {
        String menuOptions = "1. Cargar auto\n2. Cargar moto\n3. Eliminar vehiculo por posición\n4. Deshacer\n5. Rehacer\n6. Listar autos\n7. Listar motos\n8. Salir";
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
                cargarAutoAleatorio();
                break;
            case 2:
                cargarMotoAleatoria();
                break;
            case 3:
                eliminarVehiculoPorPosicion();
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

    // Opcion 1
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
        float kilometro = Math.round((200000) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cantPuerta = 2 + random.nextInt(5 - 2 + 1);
        String tipoCombustible = combustibles[random.nextInt(combustibles.length)];
        String marca = marcas[random.nextInt(marcas.length)];
        String patente = patentes[random.nextInt(patentes.length)];

        Auto auto = new Auto(modelo, color, precio, kilometro, usado, cantPuerta, tipoCombustible, marca, patente);

        abmAuto.cargarVehiculoImpl(auto);
    }

    // Opcion 2
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
        float kilometro = Math.round((50000) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cilindrada = Moto.BAJA + random.nextInt((Moto.ALTA - Moto.BAJA) + 1);

        String marca = marcas[random.nextInt(marcas.length)];
        String patente = patentes[random.nextInt(patentes.length)];

        Moto moto = new Moto(modelo, color, precio, kilometro, usado, cilindrada, marca, patente);

        abmMoto.cargarVehiculoImpl(moto);
    }

    //Opcion 3
    private void eliminarVehiculoPorPosicion() {
        System.out.print("Ingrese la posición del vehículo a eliminar: ");
        int posicion = scanner.nextInt();

        if (posicion < 0 || posicion >= RepositorioDatos.vehiculos.length) {
            System.out.println("Posición inválida");
            return;
        }

        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        Vehiculo vehiculoAEliminar = RepositorioDatos.vehiculos[posicion];
        if (vehiculoAEliminar instanceof Auto) {
            abmAuto.eliminarVehiculoPorPosicionImpl(posicion);
        } else if (vehiculoAEliminar instanceof Moto) {
            abmMoto.eliminarVehiculoPorPosicionImpl(posicion);
        } else {
            System.out.println("El tipo de vehículo no es soportado");
        }
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
        System.out.println(abmAuto.listaDeVehiculos());
    }

    //Opcion 7
    private void listarMotos() {
        System.out.println(abmMoto.listaDeVehiculos());
    }

    private void guardarEstadoEnPila(PilaImp<Vehiculo[]> pila, Vehiculo[] estado) {
        pila.insertarElemento(estado.clone());
    }

    private Vehiculo[] clonarVehiculos(Vehiculo[] vehiculos) {
        Vehiculo[] clone = new Vehiculo[vehiculos.length];
        System.arraycopy(vehiculos, 0, clone, 0, vehiculos.length);
        return clone;
    }
}