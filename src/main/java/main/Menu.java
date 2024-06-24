package main;

import model.vehiculo.Auto;
import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import util.cola.ColaImp;
import util.pila.PilaImp;

import java.util.Scanner;
import java.util.Random;

public class Menu {

    private Scanner scanner;
    private Random random;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public void displayMenu() {
        String menuOptions = "1. Cargar auto\n2. Cargar moto\n3. Eliminar vehiculo\n4. Deshacer\n5. Rehacer\n6. Listar vehiculos\n7. Salir";
        int opcion = 0;

        while (opcion != 7) {
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
                listarVehiculos();
                break;
            case 7:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    private ColaImp<Vehiculo> colaVehiculos = new ColaImp<>();
    private PilaImp<ColaImp<Vehiculo>> pilaDeshacer = new PilaImp<>();
    private PilaImp<ColaImp<Vehiculo>> pilaRehacer = new PilaImp<>();

    //Opcion 1
    private void cargarAuto() {
        System.out.println("Ingrese el modelo: ");
        String modelo = scanner.next();
        System.out.println("Ingrese el color: ");
        String color = scanner.next();
        System.out.println("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese el kilometraje: ");
        float kilometro = scanner.nextFloat();
        System.out.println("¿Es usado? (true/false): ");
        boolean usado = scanner.nextBoolean();
        System.out.println("Ingrese la cantidad de puertas: ");
        int cantPuerta = scanner.nextInt();
        System.out.println("Ingrese el tipo de combustible: ");
        String tipoCombustible = scanner.next();
        System.out.println("Ingrese la marca: ");
        String marca = scanner.next();
        System.out.println("Ingrese la patente: ");
        String patente = scanner.next();

        Auto auto = new Auto(modelo, color, precio, kilometro, usado, cantPuerta, tipoCombustible, marca, patente);

        guardarEstadoEnPila(pilaDeshacer);
        colaVehiculos.insertarElemento(auto);
        pilaRehacer.vaciar();
    }

    private void cargarAutoAleatorio() {
        Auto auto = new Auto();
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

        auto.setModelo(modelo);
        auto.setColor(color);
        auto.setPrecio(precio);
        auto.setKilometro(kilometro);
        auto.setUsado(usado);
        auto.setCantPuerta(cantPuerta);
        auto.setTipoCombustible(tipoCombustible);
        auto.setMarca(marca);
        auto.setPatente(patente);

        guardarEstadoEnPila(pilaDeshacer);
        colaVehiculos.insertarElemento(auto);
        pilaRehacer.vaciar();
    }

    //Opcion 2
    private void cargarMoto() {
        System.out.println("Ingrese el modelo: ");
        String modelo = scanner.next();
        System.out.println("Ingrese el color: ");
        String color = scanner.next();
        System.out.println("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese el kilometraje: ");
        float kilometro = scanner.nextFloat();
        System.out.println("¿Es usado? (true/false): ");
        boolean usado = scanner.nextBoolean();
        System.out.println("Ingrese la cilindrada: ");
        int cilindrada = scanner.nextInt();
        System.out.println("Ingrese la marca: ");
        String marca = scanner.next();
        System.out.println("Ingrese la patente: ");
        String patente = scanner.next();

        Moto moto = new Moto(modelo, color, precio, kilometro, usado, cilindrada, marca, patente);

        guardarEstadoEnPila(pilaDeshacer);
        colaVehiculos.insertarElemento(moto);
        pilaRehacer.vaciar();
    }

    private void cargarMotoAleatoria() {
        String[] modelos = {"Modelo 1", "Modelo 2", "Modelo 3"};
        String[] colores = {"Rojo", "Azul", "Negro"};
        String[] marcas = {"Honda", "Yamaha", "Suzuki"};
        String[] patentes = {"ABC123", "DEF456", "GHI789"};

        String modelo = modelos[random.nextInt(modelos.length)];
        String color = colores[random.nextInt(colores.length)];

        double precio = 2000 + Math.round((50000 - 2000) * random.nextDouble()); // Precio entre 2000 y 50000

        float kilometro = Math.round((50000 - 0) * random.nextFloat()); // Kilometraje entre 0 y 50000

        boolean usado = random.nextBoolean();
        int cilindrada = Moto.BAJA + random.nextInt((Moto.ALTA - Moto.BAJA) + 1); // Cilindrada entre BAJA y ALTA
        String marca = marcas[random.nextInt(marcas.length)];
        String patente = patentes[random.nextInt(patentes.length)];

        Moto moto = new Moto(modelo, color, precio, kilometro, usado, cilindrada, marca, patente);

        guardarEstadoEnPila(pilaDeshacer);
        colaVehiculos.insertarElemento(moto);
        pilaRehacer.vaciar();
    }

    // Opcion 3

    private void eliminarVehiculo() {
        guardarEstadoEnPila(pilaDeshacer);
        Vehiculo vehiculoEliminado = colaVehiculos.eliminarElemento();
        if (vehiculoEliminado != null) {
            System.out.println("Vehiculo eliminado: " + vehiculoEliminado);
        }
        pilaRehacer.vaciar();
    }

    //Opcion 4
    private void deshacer() {
        if (!pilaDeshacer.estaVacia()) {
            guardarEstadoEnPila(pilaRehacer);
            ColaImp<Vehiculo> estadoAnterior = pilaDeshacer.eliminarElemento();
            colaVehiculos = estadoAnterior;
            System.out.println("Accion deshecha");
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }

    //Opcion 5
    private void rehacer() {
        if (!pilaRehacer.estaVacia()) {
            guardarEstadoEnPila(pilaDeshacer);
            ColaImp<Vehiculo> estadoAnterior = pilaRehacer.eliminarElemento();
            colaVehiculos = estadoAnterior;
            System.out.println("Accion rehecha");
        } else {
            System.out.println("No hay acciones para rehacer");
        }
    }

    //Opcion 6
    private void listarVehiculos() {
        if (colaVehiculos.estaVacia()) {
            System.out.println("No hay vehiculos cargados");
        } else {
            System.out.println("Vehiculos en la cola:\n\n" + colaVehiculos.listaDeElementos());
        }
    }

    private void guardarEstadoEnPila(PilaImp<ColaImp<Vehiculo>> pila) {
        ColaImp<Vehiculo> estadoActual = new ColaImp<>(colaVehiculos);
        pila.insertarElemento(estadoActual);
    }
}
