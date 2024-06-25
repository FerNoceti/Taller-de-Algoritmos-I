package model.vehiculo.abm;

import model.vehiculo.Moto;

public class ABMMotoImpl extends AbstractABMVehiculo<Moto> {

    @Override
    protected boolean validarVehiculo(Moto moto) {
        return moto != null && !moto.getMarca().isEmpty() && !moto.getModelo().isEmpty() && !moto.getPatente().isEmpty() && moto.getCilindrada() != 0;
    }

    @Override
    protected Class<Moto> getVehiculoClass() {
        return Moto.class;
    }
}