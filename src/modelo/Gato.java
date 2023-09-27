package modelo;

import java.util.Date;

public class Gato extends Mascota {

	private String clase;
	
	public Gato() {
		clase = "Felino";
	}

	public Gato (int codigo, String nombre, int edad, char genero, Date fecha, boolean[] hobbies) {
		setCodigo(codigo);
		setNombre(nombre);
		setTipo("Gato");
		setEdad(edad);
		clase = "Felino";
		setGenero(genero);
		setFecha(fecha);
		setHobbies(hobbies);
	}
	
	public String getClase() {
		return clase;
	}
}
