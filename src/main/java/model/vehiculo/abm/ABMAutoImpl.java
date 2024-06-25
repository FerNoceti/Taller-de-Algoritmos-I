package model.vehiculo.abm;

import model.vehiculo.Auto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;

public class ABMAutoImpl extends AbstractABMVehiculo<Auto> {

    @Override
    public String listaDeVehiculos() {
        String vehiculos = "Autos:\n";
        boolean hayAutos = false;

        for (Vehiculo vehiculo : RepositorioDatos.vehiculos) {
            if (vehiculo instanceof Auto) {
                Auto auto = (Auto) vehiculo;
                vehiculos += auto + "\n";
                hayAutos = true;
            }
        }

        if (!hayAutos) {
            vehiculos += "No hay autos cargados";
        }

        return vehiculos;
    }

    @Override
    protected boolean validarVehiculo(Auto auto) {
        return auto != null && !auto.getMarca().isEmpty() && !auto.getModelo().isEmpty() && !auto.getPatente().isEmpty() && auto.getCantPuerta() != 0;
    }

    @Override
    protected Class<Auto> getVehiculoClass() {
        return Auto.class;
    }
}