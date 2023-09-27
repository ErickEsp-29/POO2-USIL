package modelo;

public class Producto {
	private String tipo, talla, marca, color;
	private int id;
	private double precio;
	
	public Producto() {
		super();
	}

	public Producto(String tipo, String talla, String marca, String color, int id, double precio) {
		super();
		this.tipo = tipo;
		this.talla = talla;
		this.marca = marca;
		this.color = color;
		this.id = id;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
