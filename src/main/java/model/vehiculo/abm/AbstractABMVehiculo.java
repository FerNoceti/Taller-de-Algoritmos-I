package model.vehiculo.abm;

import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;
import util.listaDoble.NodoDoble;

public abstract class AbstractABMVehiculo<T extends Vehiculo> implements IAbmVehiculo {

    @Override
    public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
        T v = (T) vehiculo;
        if (validarVehiculo(v)) {
            if (!existeVehiculo(v)) {
                RepositorioDatos.vehiculos.insertarAlFinal(v);
                return true;
            } else {
                System.out.println("El vehículo ingresado ya existe");
            }
        } else {
            System.out.println("Faltan cargar datos");
        }
        return false;
    }

    @Override
    public boolean modificarVehiculoImpl(Vehiculo vehiculo) {
        T v = (T) vehiculo;
        if (validarVehiculo(v)) {
            NodoDoble<Vehiculo> nodo = buscarNodoPorPatente(v.getPatente());
            if (nodo != null) {
                nodo.dato = v;
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
        NodoDoble<Vehiculo> nodoActual = RepositorioDatos.vehiculos.getPrimerNodo();
        int indice = 0;
        while (nodoActual != null) {
            if (indice == posicion) {
                if (nodoActual.dato.getClass().equals(getVehiculoClass())) {
                    RepositorioDatos.vehiculos.eliminarNodo(nodoActual.dato);
                    return;
                } else {
                    System.out.println("No hay un vehículo del tipo esperado en la posición indicada");
                    return;
                }
            }
            nodoActual = nodoActual.nodoSiguiente;
            indice++;
        }
        System.out.println("Posición fuera de los límites de la lista");
    }

    public abstract String listaDeVehiculos();

    protected abstract boolean validarVehiculo(T vehiculo);

    protected abstract Class<T> getVehiculoClass();

    private boolean existeVehiculo(T vehiculo) {
        return buscarNodoPorPatente(vehiculo.getPatente()) != null;
    }

    private NodoDoble<Vehiculo> buscarNodoPorPatente(String patente) {
        NodoDoble<Vehiculo> nodoActual = RepositorioDatos.vehiculos.getPrimerNodo();
        while (nodoActual != null) {
            if (nodoActual.dato.getClass().equals(getVehiculoClass())) {
                T v = (T) nodoActual.dato;
                if (v.getPatente().equals(patente)) {
                    return nodoActual;
                }
            }
            nodoActual = nodoActual.nodoSiguiente;
        }
        return null;
    }
}
