package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class Cliente extends Persona{
	private ArrayList<Cliente> lista = new ArrayList<Cliente>();
	//private static HashMap<Integer, Cliente> clientesPorDni = new HashMap<>();
	Hashtable<Integer,Cliente> ListaCli = new Hashtable<Integer, Cliente>();
	//hashtable
	public Cliente()
	{		
	}
	
	public Cliente(String nombre, int dni, Date fecha, char genero) {
		super(nombre, dni, fecha, genero);
		setNombre(nombre);
		setDni(dni);
		setFecha(fecha);
		setGenero(genero);
	}
	
	
	public void setLista (ArrayList<Cliente> listaPersona )
	{
		this.lista = listaPersona;
		System.out.println(this.lista);
	}	
	
	public String getNombreFromDni(int dni) {
        for (Cliente cliente : lista) {
            if (cliente.getDni() == dni) {
                return cliente.getNombre();
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
	
	
	
	/*
	public static void agregarCliente(Cliente cliente) {
        clientesPorDni.put(cliente.getDni(), cliente);
    }

    public static Cliente obtenerClientePorDni(int dni) {
        return clientesPorDni.get(dni);
    }
    */
}
