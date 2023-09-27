package modelo;

public class Pantalon extends Producto{

	public Pantalon(String talla, String marca, String color, int id, double precio) {
		setTipo("Pantalon");
		setTalla(talla);
		setMarca(marca);
		setColor(color);
		setId(id);
		setPrecio(precio);
	}

}
