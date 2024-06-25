package model.vehiculo.abm;

import model.vehiculo.Auto;

public class ABMAutoImpl extends AbstractABMVehiculo<Auto> {

    @Override
    protected boolean validarVehiculo(Auto auto) {
        return auto != null && !auto.getMarca().isEmpty() && !auto.getModelo().isEmpty() && !auto.getPatente().isEmpty() && auto.getCantPuerta() != 0;
    }

    @Override
    protected Class<Auto> getVehiculoClass() {
        return Auto.class;
    }
}