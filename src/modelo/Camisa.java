package modelo;

public class Camisa extends Producto{

	public Camisa(String talla, String marca, String color, int id, double precio) {
		setTipo("Camisa");
		setTalla(talla);
		setMarca(marca);
		setColor(color);
		setId(id);
		setPrecio(precio);
	}

}
