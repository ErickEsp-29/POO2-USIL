package modelo;
import java.util.ArrayList;
import java.util.Date;

public class Persona {
	private String nombre;
	private int dni;
	private Date fecha;
	private char genero;
	
	
	public Persona() {
	}

	public Persona(String nombre, int dni, Date fecha, char genero) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fecha = fecha;
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona dni=" + dni + "]";
	}
	
	
	
}
