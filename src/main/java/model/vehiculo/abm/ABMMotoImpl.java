package model.vehiculo.abm;

import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;
import util.listaDoble.NodoDoble;

public class ABMMotoImpl extends AbstractABMVehiculo<Moto> {

    @Override
    public String listaDeVehiculos() {
        StringBuilder vehiculos = new StringBuilder("Motos:\n");
        boolean hayMotos = false;

        NodoDoble<Vehiculo> nodoActual = RepositorioDatos.vehiculos.getPrimerNodo();
        while (nodoActual != null) {
            if (nodoActual.dato instanceof Moto moto) {
                vehiculos.append(moto).append("\n");
                hayMotos = true;
            }
            nodoActual = nodoActual.nodoSiguiente;
        }

        if (!hayMotos) {
            vehiculos.append("No hay motos cargadas");
        }

        return vehiculos.toString();
    }

    @Override
    protected boolean validarVehiculo(Moto moto) {
        return moto != null && !moto.getMarca().isEmpty() && !moto.getModelo().isEmpty() && !moto.getPatente().isEmpty() && moto.getCilindrada() != 0;
    }

    @Override
    protected Class<Moto> getVehiculoClass() {
        return Moto.class;
    }
}
