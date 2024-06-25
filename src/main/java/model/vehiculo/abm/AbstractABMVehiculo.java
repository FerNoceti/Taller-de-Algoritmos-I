package model.vehiculo.abm;

import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;

public abstract class AbstractABMVehiculo<T extends Vehiculo> implements IAbmVehiculo {

    @Override
    public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
        if (RepositorioDatos.indice < RepositorioDatos.TAMANIO_ARREGLO) {
            T v = (T) vehiculo;
            if (validarVehiculo(v)) {
                if (!existeVehiculo(v)) {
                    RepositorioDatos.vehiculos[RepositorioDatos.indice++] = v;
                    return true;
                } else {
                    System.out.println("El vehículo ingresado ya existe");
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
        T v = (T) vehiculo;
        if (validarVehiculo(v)) {
            int index = buscarIndicePorPatente(v.getPatente());
            if (index != -1) {
                RepositorioDatos.vehiculos[index] = v;
                return true;
            } else {
                System.out.println("El vehículo ingresado no existe");
            }
        } else {
            System.out.println("Faltan cargar datos");
        }
        return false;
    }

    @Override
    public void eliminarVehiculoPorPosicionImpl(int posicion) {
        if (posicion >= 0 && posicion < RepositorioDatos.indice) {
            if (RepositorioDatos.vehiculos[posicion] != null && RepositorioDatos.vehiculos[posicion].getClass().equals(getVehiculoClass())) {
                RepositorioDatos.vehiculos[posicion] = null;
                compactarArreglo(posicion);
                RepositorioDatos.indice--;
            } else {
                System.out.println("No hay un vehículo del tipo esperado en la posición indicada");
            }
        } else {
            System.out.println("Posición fuera de los límites del arreglo");
        }
    }

    public abstract String listaDeVehiculos();

    protected abstract boolean validarVehiculo(T vehiculo);

    protected abstract Class<T> getVehiculoClass();

    private boolean existeVehiculo(T vehiculo) {
        return buscarIndicePorPatente(vehiculo.getPatente()) != -1;
    }

    private int buscarIndicePorPatente(String patente) {
        for (int i = 0; i < RepositorioDatos.indice; i++) {
            if (RepositorioDatos.vehiculos[i] != null && RepositorioDatos.vehiculos[i].getClass().equals(getVehiculoClass())) {
                T v = (T) RepositorioDatos.vehiculos[i];
                if (v.getPatente().equals(patente)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void compactarArreglo(int desdePosicion) {
        for (int i = desdePosicion; i < RepositorioDatos.indice - 1; i++) {
            RepositorioDatos.vehiculos[i] = RepositorioDatos.vehiculos[i + 1];
        }
        RepositorioDatos.vehiculos[RepositorioDatos.indice - 1] = null;
    }
}
