package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		RegistroEstudiantes registro = new RegistroEstudiantes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nombre del estudiante: ");
            String nombre = scanner.nextLine();

            System.out.print("Nota 1: ");
            double nota1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Peso 1: ");
            double peso1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota 2: ");
            double nota2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Peso 2: ");
            double peso2 = Double.parseDouble(scanner.nextLine());

            Estudiantes estudiante = new Estudiantes(peso1, peso2, nota1, nota2, nombre);
            registro.agregarEstudiante(estudiante);

            System.out.println("Estudiante agregado.");

            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equals("s")) {
                break;
            }
        }

        System.out.println("\nLista de estudiantes y promedios ponderados:");
        for (Estudiantes estudiante : registro.obtenerEstudiantes()) {
            System.out.println(estudiante.getNombre() + ": " + estudiante.getPromedioPonderado());
        }
	}
}
