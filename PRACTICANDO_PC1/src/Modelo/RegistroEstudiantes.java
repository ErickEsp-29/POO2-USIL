package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiantes{
	private ArrayList<Estudiantes> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        estudiantes.add(estudiante);
    }

    public ArrayList<Estudiantes> obtenerEstudiantes() {
        return estudiantes;
    }
}

