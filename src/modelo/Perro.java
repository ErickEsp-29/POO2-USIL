package modelo;

import java.util.Date;

public class Perro extends Mascota {

	private String clase;
	
	public Perro() {
		clase = "Canino";
	}

	public Perro(int codigo, String nombre, int edad, char genero, Date fecha, boolean[] hobbies) {
		setCodigo(codigo);
		setNombre(nombre);
		setTipo("Perro");
		setEdad(edad);
		clase = "Canino";
		setGenero(genero);
		setFecha(fecha);
		setHobbies(hobbies);
	}
	
	public String getClase() {
		return clase;
	}
}
