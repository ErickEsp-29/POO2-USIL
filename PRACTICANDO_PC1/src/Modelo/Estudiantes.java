package Modelo;

public class Estudiantes {
	private double peso1, peso2, nota1, nota2;
	private String nombre;
	
	public Estudiantes() {
		super();
	}

	public Estudiantes(double peso1, double peso2, double nota1, double nota2, String nombre) {
		super();
		this.peso1 = peso1;
		this.peso2 = peso2;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nombre = nombre;
	}
	
	public double getPeso1() {
		return peso1;
	}
	
	public void setPeso1(double peso1) {
		this.peso1 = peso1;
	}
	
	public double getPeso2() {
		return peso2;
	}
	
	public void setPeso2(double peso2) {
		this.peso2 = peso2;
	}
	
	public double getNota1() {
		return nota1;
	}
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}
	
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPromedioPonderado() {
	    double promedioPonderado = (peso1 * nota1 + peso2 * nota2) / (peso1 + peso2);
	    return (int) Math.round(promedioPonderado);
	}
	
	@Override
	public String toString() {
	   return nombre + ": " + getPromedioPonderado();
	}
}
