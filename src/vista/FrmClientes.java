package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmClientes extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;
	private JDateChooser dateCliente;
	private JTable table;
	private JRadioButton rdMasculino;
	private JRadioButton rdFemenino;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnMasculino;
	private JButton btnFemenino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTotal;
	private JButton btnListar;
	private Cliente p = new Cliente();
	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	private JDateChooser dateChooser;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnGuardadoFinal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
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
	public FrmClientes() {
		setClosable(true);
		setTitle("Registro de Clientes");
		setBounds(100, 100, 555, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(26, 81, 55, 14);
		contentPane.add(lblDni);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(80, 78, 96, 20);
		contentPane.add(textDni);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(26, 52, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(80, 49, 96, 20);
		contentPane.add(textNombre);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		lblNewLabel_8.setBounds(26, 113, 55, 14);
		contentPane.add(lblNewLabel_8);
		
		dateCliente = new JDateChooser();
		dateCliente.setBounds(80, 113, 96, 20);
		contentPane.add(dateCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 23, 297, 221);
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

				textNombre.setText(model.getValueAt(fila, 0).toString());
				textDni.setText(model.getValueAt(fila, 1).toString());
				char genero = (char)model.getValueAt(fila, 2);
				
				if(genero == 'M')
					rdMasculino.setSelected(true);
				
				if(genero == 'F')
					rdFemenino.setSelected(true);
				
				dateChooser.setDate((Date)model.getValueAt(fila, 3));
				
				btnAgregar.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Género:");
		lblNewLabel_4.setBounds(26, 151, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		rdMasculino = new JRadioButton("Masculino");
		buttonGroup_1.add(rdMasculino);
		rdMasculino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdMasculino.setBounds(80, 147, 109, 23);
		contentPane.add(rdMasculino);
		
		rdFemenino = new JRadioButton("Femenino");
		buttonGroup_1.add(rdFemenino);
		rdFemenino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdFemenino.setBounds(80, 168, 109, 23);
		contentPane.add(rdFemenino);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textDni.getText().isEmpty() && !textNombre.getText().isEmpty()) {
					listaCliente.add(obtenerCliente());				
					
					cargar();
					//p.setLista(listaCliente);
					limpiar();
				}
			}
		});
		btnAgregar.setBounds(10, 279, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();
				
				if(table.isRowSelected(indice)) {
					listaCliente.set(indice, obtenerCliente());
					cargar();
					limpiar();
				}
			}
		});
		btnEditar.setBounds(109, 279, 89, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();

				if(table.isRowSelected(indice)) {
					int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
					
					if(opcion == JOptionPane.YES_OPTION)
						listaCliente.remove(indice);
					else
						table.clearSelection();
					cargar();
					limpiar();
				}
			}
		});
		btnEliminar.setBounds(208, 279, 89, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(312, 279, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnMasculino = new JButton("Masculino");
		btnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("M", table, 2);
				limpiar();
			}
		});
		btnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMasculino.setBounds(314, 323, 86, 23);
		contentPane.add(btnMasculino);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setBounds(314, 254, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(370, 254, 46, 14);
		contentPane.add(lblTotal);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar();
				limpiar();
			}
		});
		btnListar.setBounds(412, 279, 89, 23);
		contentPane.add(btnListar);
		
		btnFemenino = new JButton("Femenino");
		btnFemenino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("F", table, 2);
				limpiar();
			}
		});
		btnFemenino.setBounds(412, 323, 89, 23);
		contentPane.add(btnFemenino);
		
		btnGuardadoFinal = new JButton("Guardar Lista Final");
		btnGuardadoFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setLista(listaCliente);
				//getListaCliente();
			}
		});
		btnGuardadoFinal.setBounds(68, 324, 121, 23);
		contentPane.add(btnGuardadoFinal);
		
		ejemplo();
		cargar();
	}
	
	private Cliente obtenerCliente() {
		String nombre = textNombre.getText();
		int dni = Integer.parseInt(textDni.getText());
		boolean masculino = rdMasculino.isSelected();
		boolean femenino = rdFemenino.isSelected();
		Date fecha = dateCliente.getDate();
		char genero = ' ';
		
		if(masculino)
			genero = 'M';
		if(femenino)
			genero = 'F';
		
		Cliente c = new Cliente(nombre, dni, fecha, genero);
		//Cliente.agregarCliente(c);//relacionado al hashMap
		return c;
	}
	
	private void filtro(String consulta, JTable buscar, int columna) {
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) buscar.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
		buscar.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(consulta, columna));

		lblTotal.setText(String.valueOf(buscar.getRowCount()));
	}
	
	private void cargar() {
		DefaultTableModel model = new DefaultTableModel(
				new String[] {"Nombre", "DNI", "Género", "Fecha"}, 0) {
			private static final long serialVersionUID = 1L;
			Class<?>[] tipoColumna = new Class[] {
				String.class,
				Integer.class,
				Character.class,
				Date.class,
			};
			public Class<?> getColumnClass(int indice){
				return tipoColumna[indice];
			}
		};
		
		for(Cliente c : listaCliente) {
			model.addRow(new Object[] { c.getNombre(),
							   c.getDni(),
							   c.getGenero(),
							   c.getFecha()
			});
		}
		
		table.setModel(model);
		filtro("", table, 0);
		lblTotal.setText(String.valueOf(table.getRowCount()));
	}
	
	private void limpiar() {
		textNombre.setText("");
		textDni.setText("");
		buttonGroup.clearSelection();
		dateCliente.setCalendar(null);
		btnAgregar.setEnabled(true);
		table.clearSelection();
	}
	
	private void ejemplo() {
		try {
			listaCliente.add(new Cliente("Alejandro", 70825140, new SimpleDateFormat("dd/MM/yyyy").parse("29/03/2003"), 'M'));
			listaCliente.add(new Cliente("Dalinar", 70829658, new SimpleDateFormat("dd/MM/yyyy").parse("12/03/2010"), 'M'));
			listaCliente.add(new Cliente("Navani", 70827880, new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2019"), 'F'));
			listaCliente.add(new Cliente("Elena", 85826875, new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2004"), 'F'));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/*
	public void getListaCliente() {
		FrmFactura.setListaClientes(listaCliente);
    }
    */
	
}
