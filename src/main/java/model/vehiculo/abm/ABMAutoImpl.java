package model.vehiculo.abm;

import model.vehiculo.Auto;
import model.vehiculo.Vehiculo;
import repository.RepositorioDatos;
import util.listaDoble.NodoDoble;

public class ABMAutoImpl extends AbstractABMVehiculo<Auto> {

    @Override
    public String listaDeVehiculos() {
        StringBuilder vehiculos = new StringBuilder("Autos:\n");
        boolean hayAutos = false;

        NodoDoble<Vehiculo> nodoActual = RepositorioDatos.vehiculos.getPrimerNodo();
        while (nodoActual != null) {
            if (nodoActual.dato instanceof Auto auto) {
                vehiculos.append(auto).append("\n");
                hayAutos = true;
            }
            nodoActual = nodoActual.nodoSiguiente;
        }

        if (!hayAutos) {
            vehiculos.append("No hay autos cargados");
        }

        return vehiculos.toString();
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