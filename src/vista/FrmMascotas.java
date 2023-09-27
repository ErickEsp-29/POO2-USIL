package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Date;

import modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class FrmMascotas extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JComboBox<String> cmbMascota;
	private JRadioButton rdMasculino;
	private JRadioButton rdFemenino;
	private JCheckBox chckPaseos;
	private JCheckBox chckPlaya;
	private JCheckBox chckAperitivos;
	private JTable table;
	
	private ArrayList<Mascota> lista = new ArrayList<Mascota>();
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textEdad;
	private JLabel lblNewLabel_6;
	private JLabel lblPromedioEdad;
	private JLabel lblNewLabel_7;
	private JLabel lblTotal;
	private JButton btnLimpiar;
	private JButton btnListar;
	private JButton btnMasculino;
	private JButton btnFemenino;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMascotas frame = new FrmMascotas();
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
	public FrmMascotas() {
		setTitle("Registro de Mascotas");
		setClosable(true);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 25, 55, 14);
		contentPane.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(64, 22, 96, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 50, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(64, 47, 96, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mascota:");
		lblNewLabel_2.setBounds(10, 75, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		cmbMascota = new JComboBox<String>();
		cmbMascota.setModel(new DefaultComboBoxModel<String>(new String[] {"Perro", "Gato"}));
		cmbMascota.setBounds(64, 71, 96, 22);
		contentPane.add(cmbMascota);

		JLabel lblNewLabel_3 = new JLabel("Hobbies:");
		lblNewLabel_3.setBounds(10, 196, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		chckPaseos = new JCheckBox("A. Paseos al Parque");
		chckPaseos.setBounds(10, 217, 144, 23);
		contentPane.add(chckPaseos);
		
		chckPlaya = new JCheckBox("B. Jugar en la Playa");
		chckPlaya.setBounds(10, 243, 144, 23);
		contentPane.add(chckPlaya);
		
		chckAperitivos = new JCheckBox("C. Comer Aperitivos");
		chckAperitivos.setBounds(10, 271, 144, 23);
		contentPane.add(chckAperitivos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 25, 491, 171);
		contentPane.add(scrollPane);
		
		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		        Component c = super.prepareRenderer(renderer, row, column);
		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);
		        return c;
		    }
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				textCodigo.setText(model.getValueAt(fila, 0).toString());
				textNombre.setText(model.getValueAt(fila, 1).toString());
				cmbMascota.setSelectedItem(model.getValueAt(fila, 2));
				textEdad.setText(model.getValueAt(fila, 3).toString());
				char genero = (char)model.getValueAt(fila, 4);
				
				if(genero == 'M')
					rdMasculino.setSelected(true);
				
				if(genero == 'F')
					rdFemenino.setSelected(true);
				
				dateChooser.setDate((Date)model.getValueAt(fila, 5));
				
				chckPaseos.setSelected((boolean)model.getValueAt(fila, 6));
				chckPlaya.setSelected((boolean)model.getValueAt(fila, 7));
				chckAperitivos.setSelected((boolean)model.getValueAt(fila, 8));
				btnAgregar.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textCodigo.getText().isEmpty() && !textNombre.getText().isEmpty()) {
					lista.add(obtenerMascota());
					cargar();
					limpiar();
				}
			}
		});
		btnAgregar.setBounds(164, 227, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();
				
				if(table.isRowSelected(indice)) {
					lista.set(indice, obtenerMascota());
					cargar();
					limpiar();
				}
			}
		});
		btnEditar.setBounds(263, 227, 89, 23);
		contentPane.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();

				if(table.isRowSelected(indice)) {
					int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
					
					if(opcion == JOptionPane.YES_OPTION)
						lista.remove(indice);
					else
						table.clearSelection();
					cargar();
					limpiar();
				}
			}
		});
		btnEliminar.setBounds(362, 227, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_4 = new JLabel("Género:");
		lblNewLabel_4.setBounds(10, 156, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		rdMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rdMasculino);
		rdMasculino.setBounds(64, 152, 109, 23);
		contentPane.add(rdMasculino);
		
		rdFemenino = new JRadioButton("Femenino");
		buttonGroup.add(rdFemenino);
		rdFemenino.setBounds(64, 173, 109, 23);
		contentPane.add(rdFemenino);
		
		JLabel lblNewLabel_5 = new JLabel("Edad:");
		lblNewLabel_5.setBounds(10, 100, 55, 14);
		contentPane.add(lblNewLabel_5);
		
		textEdad = new JTextField();
		textEdad.setBounds(64, 97, 96, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Promedio de Edad:");
		lblNewLabel_6.setBounds(179, 202, 109, 14);
		contentPane.add(lblNewLabel_6);
		
		lblPromedioEdad = new JLabel("0.0");
		lblPromedioEdad.setBounds(298, 202, 46, 14);
		contentPane.add(lblPromedioEdad);
		
		lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setBounds(468, 202, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(524, 202, 46, 14);
		contentPane.add(lblTotal);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(466, 227, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar();
				limpiar();
			}
		});
		btnListar.setBounds(566, 227, 89, 23);
		contentPane.add(btnListar);
		
		btnMasculino = new JButton("Masculino");
		btnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("M", table, 4);
				limpiar();
			}
		});
		btnMasculino.setBounds(468, 271, 86, 23);
		contentPane.add(btnMasculino);
		
		btnFemenino = new JButton("Femenino");
		btnFemenino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("F", table, 4);
				limpiar();
			}
		});
		btnFemenino.setBounds(566, 271, 89, 23);
		contentPane.add(btnFemenino);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		lblNewLabel_8.setBounds(10, 125, 55, 14);
		contentPane.add(lblNewLabel_8);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(64, 125, 96, 20);
		contentPane.add(dateChooser);
		
		ejemplo();
		cargar();
	}
	
	private Mascota obtenerMascota() {
		int codigo = Integer.parseInt(textCodigo.getText());
		String nombre = textNombre.getText();
		String mascota = cmbMascota.getSelectedItem().toString();
		int edad = Integer.parseInt(textEdad.getText().isEmpty()?"0":textEdad.getText());
		boolean a = chckPaseos.isSelected();
		boolean b = chckPlaya.isSelected();
		boolean c = chckAperitivos.isSelected();
		boolean masculino = rdMasculino.isSelected();
		boolean femenino = rdFemenino.isSelected();
		Date fecha = dateChooser.getDate();

		char genero = ' ';
		
		if(masculino)
			genero = 'M';
		if(femenino)
			genero = 'F';
		
		Mascota m = new Mascota();
		
		if(mascota.equals("Perro"))
			m = new Perro(codigo, nombre, edad, genero, fecha, new boolean [] {a, b, c});
		else if(mascota.equals("Gato"))
			m = new Gato(codigo, nombre, edad, genero, fecha, new boolean [] {a, b, c});
		
		return m;
	}
	
	private void filtro(String consulta, JTable buscar, int columna) {
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) buscar.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
		buscar.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(consulta, columna));

		double promedio = 0.0;

        for (int i = 0; i < buscar.getRowCount(); i++) {
            promedio = promedio + Double.parseDouble(buscar.getValueAt(i, 3).toString());
        }
        lblPromedioEdad.setText(String.valueOf(promedio/buscar.getRowCount()));
		lblTotal.setText(String.valueOf(buscar.getRowCount()));
	}
	
	private void cargar() {
		DefaultTableModel model = new DefaultTableModel(
				new String[] {"Código", "Nombre", "Tipo", "Edad", "Género", "Fecha", "A", "B", "C"}, 0) {
			private static final long serialVersionUID = 1L;
			Class<?>[] tipoColumna = new Class[] {
				Integer.class,
				String.class,
				String.class,
				Integer.class,
				Character.class,
				Date.class,
				Boolean.class,
				Boolean.class,
				Boolean.class
			};
			public Class<?> getColumnClass(int indice){
				return tipoColumna[indice];
			}
		};
		
		double promedioEdad = 0.0;
		
		for(Mascota m : lista) {
			model.addRow(new Object[] { m.getCodigo(),
							   m.getNombre(),
							   m.getTipo(),
							   m.getEdad(),
							   m.getGenero(),
							   m.getFecha(),
							   m.getHobbies()[0],
							   m.getHobbies()[1],
							   m.getHobbies()[2]
			});
			promedioEdad = promedioEdad + m.getEdad();
		}
		promedioEdad = promedioEdad / lista.size();
		
		table.setModel(model);
		filtro("", table, 0);
		lblPromedioEdad.setText(String.valueOf(promedioEdad));
		lblTotal.setText(String.valueOf(table.getRowCount()));
	}
	
	private void limpiar() {
		textCodigo.setText("");
		textNombre.setText("");
		textEdad.setText("");
		cmbMascota.setSelectedIndex(0);
		buttonGroup.clearSelection();
		dateChooser.setCalendar(null);
		chckPaseos.setSelected(false);
		chckPlaya.setSelected(false);
		chckAperitivos.setSelected(false);
		btnAgregar.setEnabled(true);
		table.clearSelection();
		textCodigo.requestFocus();
	}
	
	private void ejemplo() {
		try {
			lista.add(new Perro(101, "Firulais"  , 3, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2021"), new boolean[] {true, true, false }));
			lista.add(new Gato (102, "Michelin"  , 5, 'F', new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2019"), new boolean[] {false, true, true }));
			lista.add(new Perro(103, "Bobby Oddy", 2, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2020"), new boolean[] {true, false, true }));
			lista.add(new Gato (104, "Garfield"  , 4, 'M', new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2022"), new boolean[] {false, true, false}));
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
