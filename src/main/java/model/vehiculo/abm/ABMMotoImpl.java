package model.vehiculo.abm;

import model.vehiculo.Moto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;

public class ABMMotoImpl extends AbstractABMVehiculo<Moto> {

    @Override
    public String listaDeVehiculos() {
        String vehiculos = "Motos:\n";
        boolean hayMotos = false;

        for (Vehiculo vehiculo : RepositorioDatos.vehiculos) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                vehiculos += moto + "\n";
                hayMotos = true;
            }
        }

        if (!hayMotos) {
            vehiculos += "No hay motos cargadas";
        }

        return vehiculos;
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