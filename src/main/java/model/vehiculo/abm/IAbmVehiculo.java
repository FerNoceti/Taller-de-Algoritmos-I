package model.vehiculo.abm;

import model.vehiculo.Vehiculo;

/**
 * Interface para las operaciones de ABM (Alta, Baja, Modificación) de vehículos.
 */
public interface IAbmVehiculo {

    /**
     * Carga un nuevo vehículo en el repositorio.
     *
     * @param vehiculo el vehículo a cargar.
     * @return true si el vehículo fue cargado exitosamente, false en caso contrario.
     */
    boolean cargarVehiculoImpl(Vehiculo vehiculo);

    /**
     * Modifica un vehículo existente en el repositorio.
     *
     * @param vehiculo el vehículo con los datos modificados.
     * @return true si el vehículo fue modificado exitosamente, false en caso contrario.
     */
    boolean modificarVehiculoImpl(Vehiculo vehiculo);

    /**
     * Elimina un vehículo del repositorio en una posición dada.
     *
     * @param posicion la posición del vehículo a eliminar.
     */
    void eliminarVehiculoPorPosicionImpl(int posicion);

}
