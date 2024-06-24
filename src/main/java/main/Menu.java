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
        String menuOptions = "1. Cargar auto\n2. Cargar moto\n3. Eliminar auto\n4. Eliminar moto\n5. Deshacer\n6. Rehacer\n7. Listar autos\n8. Listar motos\n9. Listar vehiculos\n10. Salir";
        int opcion = 0;

        while (opcion != 10) {
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
                //eliminarAuto();
                break;
            case 4:
                //eliminarMoto();
                break;
            case 5:
                //deshacer();
                break;
            case 6:
                //rehacer();
                break;
            case 7:
                //listarAutos();
                break;
            case 8:
                //listarMotos();
                break;
            case 9:
                listarVehiculos();
                break;
            case 10:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    private ColaImp<Vehiculo> colaVehiculos = new ColaImp<>();
    private PilaImp<Vehiculo> pilaDeshacer = new PilaImp<>();
    private PilaImp<Vehiculo> pilaRehacer = new PilaImp<>();

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

        colaVehiculos.insertarElemento(auto);
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

        colaVehiculos.insertarElemento(auto);
    }

    //Opcion 2
    private void cargarMoto() {
        //TODO
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

        colaVehiculos.insertarElemento(moto);
    }


    //Opcion 9
    private void listarVehiculos() {
        System.out.println("Vehiculos en la cola:\n\n" + colaVehiculos.listaDeElementos());
    }
}