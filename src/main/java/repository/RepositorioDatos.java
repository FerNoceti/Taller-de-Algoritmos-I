package repository;

import model.vehiculo.Vehiculo;

public abstract class RepositorioDatos {

    public static final int TAMANIO_ARREGLO = 20;

    public static Vehiculo[] vehiculos = new Vehiculo[TAMANIO_ARREGLO];

    public static int indice = 0;
}
