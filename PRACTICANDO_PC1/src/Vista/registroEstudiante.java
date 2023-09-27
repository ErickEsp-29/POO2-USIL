package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import Modelo.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class registroEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField textEstudiante;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textPeso1;
	private JTextField textPeso2;
	private JTextField textNombreExportar;
	private JButton btnRegistrar;
	private JButton btnExportar;
	private JTable table;
	private Estudiantes es = new Estudiantes();
	private RegistroEstudiantes r = new RegistroEstudiantes();
	private ArrayList<Estudiantes> lista = new ArrayList<Estudiantes>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroEstudiante frame = new registroEstudiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registroEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstudiante = new JLabel("Estudiante:");
		lblEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstudiante.setBounds(301, 23, 119, 25);
		contentPane.add(lblEstudiante);
		
		textEstudiante = new JTextField();
		textEstudiante.setColumns(10);
		textEstudiante.setBounds(410, 25, 235, 25);
		contentPane.add(textEstudiante);
		
		JLabel lblListadoDeEstudiantes = new JLabel("Listado de Estudiantes:");
		lblListadoDeEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListadoDeEstudiantes.setBounds(20, 23, 219, 25);
		contentPane.add(lblListadoDeEstudiantes);
		
		JLabel lblNota = new JLabel("Nota 1:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNota.setBounds(350, 76, 74, 25);
		contentPane.add(lblNota);
		
		textNota1 = new JTextField();
		textNota1.setColumns(10);
		textNota1.setBounds(339, 111, 87, 25);
		contentPane.add(textNota1);
		
		JLabel lblNota_2 = new JLabel("Nota 2:");
		lblNota_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNota_2.setBounds(521, 76, 74, 25);
		contentPane.add(lblNota_2);
		
		textNota2 = new JTextField();
		textNota2.setColumns(10);
		textNota2.setBounds(510, 111, 87, 25);
		contentPane.add(textNota2);
		
		JLabel lblPesoNota = new JLabel("Peso Nota 1:");
		lblPesoNota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPesoNota.setBounds(335, 174, 119, 25);
		contentPane.add(lblPesoNota);
		
		textPeso1 = new JTextField();
		textPeso1.setColumns(10);
		textPeso1.setBounds(339, 209, 87, 25);
		contentPane.add(textPeso1);
		
		JLabel lblPesoNota_2 = new JLabel("Peso Nota 2:");
		lblPesoNota_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPesoNota_2.setBounds(501, 174, 119, 25);
		contentPane.add(lblPesoNota_2);
		
		textPeso2 = new JTextField();
		textPeso2.setColumns(10);
		textPeso2.setBounds(505, 209, 87, 25);
		contentPane.add(textPeso2);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textEstudiante.getText();
				double nota1 = Double.parseDouble(textNota1.getText());
				double nota2 = Double.parseDouble(textNota2.getText());
				double peso1 = Double.parseDouble(textPeso1.getText());
				double peso2 = Double.parseDouble(textPeso2.getText());
				
				es = new Estudiantes(peso1, peso2, nota1, nota2, nombre);
				
				lista.add(es);
				cargar();

				// Limpiar campos de texto
		        textEstudiante.setText("");
		        textNota1.setText("");
		        textNota2.setText("");
		        textPeso1.setText("");
		        textPeso2.setText("");
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(335, 282, 115, 28);
		contentPane.add(btnRegistrar);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreArchivo = textNombreExportar.getText();
		        
		        if (!nombreArchivo.isEmpty()) {
		            try { // Es una función especial que permite manejar un errora
		                // Crear el archivo de texto
		                FileWriter writer = new FileWriter(nombreArchivo + ".txt");
		                BufferedWriter bufferedWriter = new BufferedWriter(writer);
		                
		                // Escribir el contenido del reporte
		                for (Estudiantes estudiante : lista) {
		                    bufferedWriter.write(estudiante.getNombre() + ": " + estudiante.getPromedioPonderado());
		                    bufferedWriter.newLine();
		                }
		                
		                // Cerrar el archivo
		                bufferedWriter.close();
		                
		                JOptionPane.showMessageDialog(null, "Reporte exportado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(null, "Error al exportar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Ingrese un nombre de archivo válido.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnExportar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExportar.setBounds(501, 282, 115, 28);
		contentPane.add(btnExportar);
		
		textNombreExportar = new JTextField();
		textNombreExportar.setColumns(10);
		textNombreExportar.setBounds(350, 344, 253, 28);
		contentPane.add(textNombreExportar);
		
		JScrollPane scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(20, 58, 259, 254);
		contentPane.add(scrollPaneLista);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() { //Los datos que se den click se cargaran en los espacios para completar
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				textEstudiante.setText(model.getValueAt(fila, 0).toString());
				textNota1.setText(model.getValueAt(fila, 1).toString());
			}
		});
		scrollPaneLista.setViewportView(table);
	}
	
	private void cargar() {
		DefaultTableModel model = new DefaultTableModel(
				new String[] {"Nombre", "Promedio"}, 0) {
			private static final long serialVersionUID = 1L;
			Class<?>[] tipoColumna = new Class[] {
					String.class,
					Integer.class,
				
			};
			public Class<?> getColumnClass(int indice){
				return tipoColumna[indice];
			}
		};
		
		for(Estudiantes es : lista) {
			model.addRow(new Object[] {
					es.getNombre(),
					es.getPromedioPonderado()
			});
		}
		
		table.setModel(model);
	}
}
