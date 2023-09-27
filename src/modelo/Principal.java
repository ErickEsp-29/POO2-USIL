package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Mascota> lista = new ArrayList<Mascota>();
		ArrayList<Persona> lista2 = new ArrayList<Persona>();
		
		try {
			lista.add(new Perro(101, "Firulais"  , 3, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2021"), new boolean[] {true, true, false }));
			lista.add(new Gato (102, "Michelin"  , 5, 'F', new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2019"), new boolean[] {false, true, true }));
			lista.add(new Perro(103, "Bobby Oddy", 2, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2020"), new boolean[] {true, false, true }));
			lista.add(new Gato (104, "Garfield"  , 4, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2022"), new boolean[] {false, true, false}));
		} catch (Exception e) {
			e.getMessage();
		}
		
		for(Mascota m : lista) {
			System.out.println(m.getCodigo() + "\t" +
							   m.getNombre() + "\t" +
							   m.getTipo() + "\t" +
							   m.getHobbies());
		}
		
	}
}