package modelo;

import java.util.Date;

public class Mascota {
	
	private int codigo;
	private String nombre;
	private String tipo;
	private int edad;
	private char genero;
	private Date fecha;
	private boolean[] hobbies;
	
	public Mascota() {
		codigo = 0;
		nombre = "";
		tipo = "";
		edad = 0;
		genero = ' ';
		hobbies = null;
	}

	public Mascota(int codigo, String nombre, String tipo, int edad, char genero, Date fecha, boolean[] hobbies) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.genero = genero;
		this.fecha = fecha;
		this.hobbies = hobbies;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(boolean[] hobbies) {
		this.hobbies = hobbies;
	}
}
