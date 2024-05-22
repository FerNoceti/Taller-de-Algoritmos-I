package modelo.vehiculo;

public abstract class Vehiculo {//implements IAbmVehiculo {

    private String modelo;
    private String color;
    private double precio;
    private float kilometro;
    private boolean usado;

    public Vehiculo() {
        super();
    }

    public Vehiculo(String modelo, String color, double precio, float kilometro, boolean usado) {
        super();
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.kilometro = kilometro;
        this.usado = usado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public float getKilometro() {
        return kilometro;
    }

    public void setKilometro(float kilometro) {
        this.kilometro = kilometro;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public abstract boolean cargarVehiculo(Vehiculo vehiculo);

    public abstract boolean modificarVehiculo(Vehiculo vehiculo);

    public abstract void eliminarVehiculo(Vehiculo vehiculo);

}
