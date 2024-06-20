package model.vehiculo.abm;

import model.vehiculo.Auto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;

public class ABMAutoImpl implements IAbmVehiculo {

    @Override
    public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
        if (RepositorioDatos.indice < RepositorioDatos.TAMANIO_ARREGLO) {
            Auto auto = (Auto) vehiculo;
            if (validarAuto(auto)) {
                if (existeAuto(auto) == -1) {
                    RepositorioDatos.vehiculos[RepositorioDatos.indice] = vehiculo;
                    RepositorioDatos.indice++;
                    return true;
                } else {
                    System.out.println("El auto ingresado ya existe");
                }
            } else {
                System.out.println("Faltan cargar datos");
            }
        } else {
            System.out.println("Se superó la capacidad del arreglo de vehículos");
        }
        return false;
    }

    @Override
    public boolean modificarVehiculoImpl(Vehiculo vehiculo) {
        Auto auto = (Auto) vehiculo;
        if (validarAuto(auto)) {
            int i = existeAuto(auto);
            if (i != -1) {
                RepositorioDatos.vehiculos[i] = vehiculo;
                return true;
            } else {
                System.out.println("El auto ingresado no existe");
            }
        } else {
            System.out.println("Faltan cargar datos");
        }
        return false;
    }

    @Override
    public void eliminarVehiculoImpl(Vehiculo vehiculo) {
        Auto auto = (Auto) vehiculo;
        int i = existeAuto(auto);
        if (i != -1) {
            RepositorioDatos.vehiculos[i] = null;
        } else {
            System.out.println("No se encontró el auto que quiere eliminar");
        }
    }

    @Override
    public void mostrarVehiculoImpl() {
        for (int i = 0; i < RepositorioDatos.vehiculos.length; i++) {
            if (RepositorioDatos.vehiculos[i] instanceof Auto) {
                Auto auto = (Auto) RepositorioDatos.vehiculos[i];
                if (auto != null) {
                    System.out.println("Modelo: " + auto.getModelo());
                    System.out.println("Marca: " + auto.getMarca());
                    System.out.println("Combustible: " + auto.getTipoConbustible());
                    System.out.println("Color: " + auto.getColor());
                    System.out.println("Cant. Puertas: " + auto.getCantPuerta());
                    System.out.println("Kilómetros: " + auto.getKilometro());
                    System.out.println("Precio: " + auto.getPrecio());
                    System.out.println("Patente: " + auto.getPatente());
                    System.out.println();
                }
            }
        }
    }

    private boolean validarAuto(Auto auto) {
        if (auto == null) {
            return false;
        }
        return !auto.getMarca().isEmpty() && !auto.getModelo().isEmpty() && !auto.getTipoConbustible().isEmpty() && auto.getCantPuerta() != 0;
    }

    private int existeAuto(Auto auto) {
        for (int i = 0; i < RepositorioDatos.vehiculos.length; i++) {
            if (RepositorioDatos.vehiculos[i] instanceof Auto) {
                Auto a = (Auto) RepositorioDatos.vehiculos[i];
                if (a != null && auto.getPatente().equals(a.getPatente())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
