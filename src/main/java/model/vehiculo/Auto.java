package model.vehiculo;

public class Auto extends Vehiculo {

    public static final String NAFTA = "nafta";
    public static final String GASOIL = "gasoil";
    public static final String ELECTRICO = "electrico";

    private int cantPuerta;
    private String tipoCombustible;
    private String marca;
    private String patente;

    public Auto() {
        super();
    }

    public Auto(String modelo, String color, double precio, float kilometro, boolean usado, int cantPuerta,
                String tipoCombustible, String marca, String patente) {
        super(modelo, color, precio, kilometro, usado);
        this.cantPuerta = cantPuerta;
        this.tipoCombustible = tipoCombustible;
        this.marca = marca;
        this.patente = patente;
    }

    public int getCantPuerta() {
        return cantPuerta;
    }

    public void setCantPuerta(int cantPuerta) {
        this.cantPuerta = cantPuerta;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean cargarAuto(Auto auto) {
        return false;
    }

    public boolean modificarAuto(Auto auto) {
        return false;
    }

    public void eliminarAuto(Auto auto) {

    }

    //To String
    @Override
    public String toString() {
        return "Modelo: " + getModelo() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Combustible: " + getTipoCombustible() + "\n" +
                "Color: " + getColor() + "\n" +
                "Cant. Puertas: " + getCantPuerta() + "\n" +
                "Kilómetros: " + getKilometro() + "\n" +
                "Precio: " + getPrecio() + "\n" +
                "Patente: " + getPatente() + "\n";
    }

}
