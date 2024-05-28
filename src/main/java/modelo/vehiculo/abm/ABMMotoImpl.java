package modelo.vehiculo.abm;

import modelo.vehiculo.Moto;
import modelo.vehiculo.Vehiculo;
import repositorio.RepositorioDatos;

public class ABMMotoImpl implements IAbmVehiculo {

    @Override
    public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
        if (RepositorioDatos.indice < RepositorioDatos.TAMANIO_ARREGLO) {
            Moto moto = (Moto) vehiculo;
            if (validarMoto(moto)) {
                if (existeMoto(moto) == -1) {
                    RepositorioDatos.vehiculos[RepositorioDatos.indice] = vehiculo;
                    RepositorioDatos.indice++;
                    return true;
                } else {
                    System.out.println("La moto ingresada ya existe");
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
        Moto moto = (Moto) vehiculo;
        if (validarMoto(moto)) {
            int i = existeMoto(moto);
            if (i != -1) {
                RepositorioDatos.vehiculos[i] = vehiculo;
                return true;
            } else {
                System.out.println("La moto ingresada no existe");
            }
        } else {
            System.out.println("Faltan cargar datos");
        }
        return false;
    }

    @Override
    public void eliminarVehiculoImpl(Vehiculo vehiculo) {
        Moto moto = (Moto) vehiculo;
        int i = existeMoto(moto);
        if (i != -1) {
            RepositorioDatos.vehiculos[i] = null;
        } else {
            System.out.println("No se encontró la moto que quiere eliminar");
        }
    }

    @Override
    public void mostrarVehiculoImpl() {
        for (int i = 0; i < RepositorioDatos.vehiculos.length; i++) {
            if (RepositorioDatos.vehiculos[i] instanceof Moto) {
                Moto moto = (Moto) RepositorioDatos.vehiculos[i];
                if (moto != null) {
                    System.out.println("Modelo: " + moto.getModelo());
                    System.out.println("Marca: " + moto.getMarca());
                    System.out.println("Cilindrada: " + moto.getCilindrada());
                    System.out.println("Color: " + moto.getColor());
                    System.out.println("Kilómetros: " + moto.getKilometro());
                    System.out.println("Precio: " + moto.getPrecio());
                    System.out.println("Patente: " + moto.getPatente());
                    System.out.println();
                }
            }
        }
    }

    private boolean validarMoto(Moto moto) {
        return moto != null && !moto.getMarca().isEmpty() && !moto.getModelo().isEmpty() && !moto.getPatente().isEmpty() && moto.getCilindrada() != 0;
    }

    private int existeMoto(Moto moto) {
        for (int i = 0; i < RepositorioDatos.vehiculos.length; i++) {
            if (RepositorioDatos.vehiculos[i] instanceof Moto) {
                Moto motoAux = (Moto) RepositorioDatos.vehiculos[i];
                if (motoAux != null && motoAux.getPatente().equals(moto.getPatente())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
