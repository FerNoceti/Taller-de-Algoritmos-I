package main;

import model.vehiculo.Auto;
import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;
import util.listaDoble.ListaDobleImpl;
import util.listaDoble.NodoDoble;
import util.pila.PilaImp;

import java.util.Random;
import java.util.Scanner;

import static repository.RepositorioDatos.*;

public class Menu {
    private final Scanner scanner;
    private final Random random;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public void displayMenu() {
        String menuOptions = "1. Cargar auto\n2. Cargar moto\n3. Eliminar vehiculo por posición\n4. Deshacer" +
                "\n5. Rehacer\n6. Listar autos\n7. Listar motos\n8. Listar vehiculos ascendente" +
                "\n9. Listar vehiculos descendente \n10.Ordenar con Quicksort\n11. Salir";

        int opcion = 0;

        while (opcion != 11) {
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
                listarVehiculosAsc();
                break;
            case 9:
                listarVehiculosDesc();
                break;
            case 10:
                ordenarVehiculos();
                break;
            case 11:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    private void cargarAutoAleatorio() {
        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        String[] modelos = {"Modelo 1", "Modelo 2", "Modelo 3"};
        String[] colores = {"Rojo", "Azul", "Negro"};
        String[] combustibles = {Auto.NAFTA, Auto.GASOIL, Auto.ELECTRICO};
        String[] marcas = {"Toyota", "Fiat", "Ford"};

        String modelo = modelos[random.nextInt(modelos.length)];
        String color = colores[random.nextInt(colores.length)];

        double precio = 5000 + Math.round((100000 - 5000) * random.nextDouble());
        float kilometro = Math.round((200000) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cantPuerta = 2 + random.nextInt(5 - 2 + 1);
        String tipoCombustible = combustibles[random.nextInt(combustibles.length)];
        String marca = marcas[random.nextInt(marcas.length)];

        // Generar patente aleatoria
        String patente = generarPatenteAleatoria();

        Auto auto = new Auto(modelo, color, precio, kilometro, usado, cantPuerta, tipoCombustible, marca, patente);

        abmAuto.cargarVehiculoImpl(auto);
    }

    private void cargarMotoAleatoria() {
        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        String[] modelos = {"Modelo 1", "Modelo 2", "Modelo 3"};
        String[] colores = {"Rojo", "Azul", "Negro"};
        String[] marcas = {"Honda", "Yamaha", "Suzuki"};

        String modelo = modelos[random.nextInt(modelos.length)];
        String color = colores[random.nextInt(colores.length)];

        double precio = 2000 + Math.round((50000 - 2000) * random.nextDouble());
        float kilometro = Math.round((50000) * random.nextFloat());
        boolean usado = random.nextBoolean();
        int cilindrada = Moto.BAJA + random.nextInt((Moto.ALTA - Moto.BAJA) + 1);

        String marca = marcas[random.nextInt(marcas.length)];

        // Generar patente aleatoria
        String patente = generarPatenteAleatoria();

        Moto moto = new Moto(modelo, color, precio, kilometro, usado, cilindrada, marca, patente);

        abmMoto.cargarVehiculoImpl(moto);
    }

    private String generarPatenteAleatoria() {
        // Generar 3 letras aleatorias
        char[] letras = new char[3];
        for (int i = 0; i < 3; i++) {
            letras[i] = (char) ('A' + random.nextInt(26));
        }

        // Generar 3 números aleatorios
        int numero = random.nextInt(1000);

        // Formar la patente
        return new String(letras) + String.format("%03d", numero);
    }

    private void eliminarVehiculoPorPosicion() {
        System.out.print("Ingrese la posición del vehículo a eliminar: ");
        int posicion = scanner.nextInt();

        if (posicion < 0 || posicion >= RepositorioDatos.vehiculos.getTamanio()) {
            System.out.println("Posición inválida");
            return;
        }

        guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
        pilaRehacer.vaciar();

        Vehiculo vehiculoAEliminar = getVehiculoEnPosicion(posicion);
        if (vehiculoAEliminar instanceof Auto) {
            abmAuto.eliminarVehiculoPorPosicionImpl(posicion);
        } else if (vehiculoAEliminar instanceof Moto) {
            abmMoto.eliminarVehiculoPorPosicionImpl(posicion);
        } else {
            System.out.println("El tipo de vehículo no es soportado");
        }
    }

    private void deshacer() {
        if (!pilaDeshacer.estaVacia()) {
            guardarEstadoEnPila(pilaRehacer, clonarVehiculos(RepositorioDatos.vehiculos));
            RepositorioDatos.vehiculos = pilaDeshacer.eliminarElemento();
        } else {
            System.out.println("No hay operaciones para deshacer");
        }
    }

    private void rehacer() {
        if (!pilaRehacer.estaVacia()) {
            guardarEstadoEnPila(pilaDeshacer, clonarVehiculos(RepositorioDatos.vehiculos));
            RepositorioDatos.vehiculos = pilaRehacer.eliminarElemento();
        } else {
            System.out.println("No hay operaciones para rehacer");
        }
    }

    private void listarAutos() {
        System.out.println(abmAuto.listaDeVehiculos());
    }

    private void listarMotos() {
        System.out.println(abmMoto.listaDeVehiculos());
    }

    private void guardarEstadoEnPila(PilaImp<ListaDobleImpl<Vehiculo>> pila, ListaDobleImpl<Vehiculo> estado) {
        pila.insertarElemento(clonarVehiculos(estado));
    }

    private ListaDobleImpl<Vehiculo> clonarVehiculos(ListaDobleImpl<Vehiculo> vehiculos) {
        ListaDobleImpl<Vehiculo> clone = new ListaDobleImpl<>();
        NodoDoble<Vehiculo> nodoActual = vehiculos.getPrimerNodo();
        while (nodoActual != null) {
            clone.insertarAlFinal(nodoActual.dato);
            nodoActual = nodoActual.nodoSiguiente;
        }
        return clone;
    }

    private Vehiculo getVehiculoEnPosicion(int posicion) {
        NodoDoble<Vehiculo> nodoActual = RepositorioDatos.vehiculos.getPrimerNodo();
        int indice = 0;
        while (nodoActual != null) {
            if (indice == posicion) {
                return nodoActual.dato;
            }
            nodoActual = nodoActual.nodoSiguiente;
            indice++;
        }
        return null;
    }

    private void listarVehiculosAsc() {
        if (vehiculos.estaVacia()) {
            System.out.println("No hay vehículos cargados");
        } else {
            vehiculos.listarElementos("ASC");
        }
    }

    private void listarVehiculosDesc() {
        if (vehiculos.estaVacia()) {
            System.out.println("No hay vehículos cargados");
        } else {
            vehiculos.listarElementos("DES");
        }
    }

    private void ordenarVehiculos() {
        if (vehiculos.estaVacia()) {
            System.out.println("No hay vehículos cargados");
        } else {
            vehiculos.quicksort();
        }
    }
}
