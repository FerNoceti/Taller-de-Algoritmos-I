package model.vehiculo;

public class Moto extends Vehiculo {

    // Constantes de cilindrada de la moto
    public static final int BAJA = 200;
    public static final int MEDIA = 300;
    public static final int ALTA = 400;

    // Atributos privados
    private int cilindrada;
    private String marca;;

    // Constructores
    public Moto() {
        super();
    }

    public Moto(String modelo, String color, double precio, float kilometro, boolean usado, int cilindrada, String marca, String patente) {
        super(modelo, color, precio, kilometro, usado, patente);
        this.cilindrada = cilindrada;
        this.marca = marca;
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

    // Método toString() sobreescrito
    @Override
    public String toString() {
        return "Moto {" +
                "\n  Modelo: " + getModelo() +
                "\n  Marca: " + getMarca() +
                "\n  Color: " + getColor() +
                "\n  Cilindrada: " + getCilindrada() + " cc" +
                "\n  Kilómetros: " + getKilometro() +
                "\n  Precio: " + getPrecio() +
                "\n  Patente: " + getPatente() +
                "\n}";
    }
}
