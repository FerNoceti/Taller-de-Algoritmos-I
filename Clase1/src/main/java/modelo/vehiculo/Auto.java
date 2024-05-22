package modelo.vehiculo;

public class Auto extends Vehiculo {

    public static final String NAFTA = "nafta";
    public static final String GASOIL = "gasoil";
    public static final String ELECTRICO = "electrico";

    private int cantPuerta;
    private String tipoConbustible;
    private String marca;
    private String patente;

    public Auto() {
        super();
    }

    public Auto(String modelo, String color, double precio, float kilometro, boolean usado, int cantPuerta,
                String tipoConbustible, String marca, String patente) {
        super(modelo, color, precio, kilometro, usado);
        this.cantPuerta = cantPuerta;
        this.tipoConbustible = tipoConbustible;
        this.marca = marca;
        this.patente = patente;
    }

    public int getCantPuerta() {
        return cantPuerta;
    }

    public void setCantPuerta(int cantPuerta) {
        this.cantPuerta = cantPuerta;
    }

    public String getTipoConbustible() {
        return tipoConbustible;
    }

    public void setTipoConbustible(String tipoConbustible) {
        this.tipoConbustible = tipoConbustible;
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

    // En esta seccions emuestra como hacer metodos y funciones en una clase concreta
    public boolean cargarAuto(Auto auto) {
        return false;
    }

    public boolean modificarAuto(Auto auto) {
        return false;
    }

    public void eliminarAuto(Auto auto) {

    }

    // En esta seccion se muestra como implementar los metodos y fuciones definidos en la clase abstracta
    @Override
    public boolean cargarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub

    }
	/* En esta seccion mostramo como implemetar los métodos y funcoines a traves de una interfaz.
	 * Esta las coentamos para implementarlas en otra clase ABMAutos. 
	@Override
	public boolean cargarVehiculoImpl(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarVehiculoImpl(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarVehiculoImpl(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}
	*/
}
