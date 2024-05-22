package modelo.vehiculo;

public class Moto extends Vehiculo {

    // Cilindradas de la moto
    public static final int BAJA = 200;
    public static final int MEDIA = 300;
    public static final int ALTA = 400;

    // Atributos
    private int cilindrada;
    private String marca;
    private String patente;

    // Constructores
    public Moto() {
        super();
    }

    public Moto(String modelo, String color, double precio, float kilometro, boolean usado, int cilindrada, String marca, String patente) {
        super(modelo, color, precio, kilometro, usado);
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.patente = patente;
    }

    // Getters y Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
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

}
