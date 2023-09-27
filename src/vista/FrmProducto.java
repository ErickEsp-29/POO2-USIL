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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import modelo.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class FrmProducto extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Producto> lista = new ArrayList<Producto>();
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textMarca;
	private JTextField textColor;
	private JTextField textPrecio;
	private JTable table;
	private JComboBox<String> cmbTipo;
	private JComboBox<String> cmbTalla;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnListar;
	private JButton btnCamisa;
	private JButton btnCasaca;
	private JButton btnPantalon;
	private JLabel lblTotal;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setClosable(true);
		setTitle("Registro de Productos");
		setBounds(100, 100, 503, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetLayout = new JLabel("Tipo:");
		lblSetLayout.setBounds(10, 32, 55, 14);
		contentPane.add(lblSetLayout);
		
		cmbTipo = new JComboBox<String>();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Camisa", "Casaca", "Pantalon"}));
		cmbTipo.setBounds(58, 25, 96, 22);
		contentPane.add(cmbTipo);
		
		JLabel lblsetlayout2 = new JLabel("ID:");
		lblsetlayout2.setBounds(10, 57, 55, 14);
		contentPane.add(lblsetlayout2);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(58, 51, 96, 20);
		contentPane.add(textId);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 84, 55, 14);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(58, 78, 96, 20);
		contentPane.add(textMarca);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(10, 112, 55, 14);
		contentPane.add(lblTalla);
		
		cmbTalla = new JComboBox<String>();
		cmbTalla.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L"}));
		cmbTalla.setBounds(58, 105, 96, 22);
		contentPane.add(cmbTalla);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 166, 55, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 139, 55, 14);
		contentPane.add(lblColor);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(58, 133, 96, 20);
		contentPane.add(textColor);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(58, 160, 96, 20);
		contentPane.add(textPrecio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 25, 302, 160);
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

				cmbTipo.setSelectedItem(model.getValueAt(fila, 0));
				textId.setText(model.getValueAt(fila, 1).toString());
				textMarca.setText(model.getValueAt(fila, 2).toString());
				cmbTalla.setSelectedItem(model.getValueAt(fila, 3));
				textColor.setText(model.getValueAt(fila, 4).toString());
				textPrecio.setText(model.getValueAt(fila, 5).toString());
				
				btnAgregar.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textId.getText().isEmpty() && !textMarca.getText().isEmpty()) {
					lista.add(obtenerProducto());
					cargar();
					limpiar();
				}
			}
		});
		btnAgregar.setBounds(10, 231, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();
				
				if(table.isRowSelected(indice)) {
					lista.set(indice, obtenerProducto());
					cargar();
					limpiar();
				}
			}
		});
		btnEditar.setBounds(109, 231, 89, 23);
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
		btnEliminar.setBounds(208, 231, 89, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(307, 230, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar();
				limpiar();
			}
		});
		btnListar.setBounds(406, 230, 80, 23);
		contentPane.add(btnListar);
		
		btnCamisa = new JButton("Camisa");
		btnCamisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("Camisa", table, 0);
				limpiar();
			}
		});
		btnCamisa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCamisa.setBounds(109, 265, 86, 23);
		contentPane.add(btnCamisa);
		
		btnCasaca = new JButton("Casaca");
		btnCasaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("Casaca", table, 0);
				limpiar();
			}
		});
		btnCasaca.setBounds(207, 265, 89, 23);
		contentPane.add(btnCasaca);
		
		btnPantalon = new JButton("Pantalon");
		btnPantalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtro("Pantalon", table, 0);
				limpiar();
			}
		});
		btnPantalon.setBounds(307, 263, 89, 23);
		contentPane.add(btnPantalon);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(334, 195, 46, 14);
		contentPane.add(lblTotal);
		
		lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(278, 195, 46, 14);
		contentPane.add(lblNewLabel);
		
		ejemplo();
		cargar();
	}
	
	private Producto obtenerProducto() {
		String tipo = cmbTipo.getSelectedItem().toString();
		int id = Integer.parseInt(textId.getText());
		String marca = textMarca.getText();
		String talla = cmbTalla.getSelectedItem().toString();
		String color = textColor.getText();
		Double precio = Double.parseDouble(textPrecio.getText());
				
		Producto p = new Producto();
		
		if(tipo.equals("Camisa"))
			p = new Camisa(talla, marca, color, id, precio);
		else if(tipo.equals("Casaca"))
			p = new Casaca(talla, marca, color, id, precio);
		else if(tipo.equals("Pantalon"))
			p = new Pantalon(talla, marca, color, id, precio);
		
		return p;
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
				new String[] {"Tipo", "ID", "Marca", "Talla", "Color", "Precio"}, 0) {
			private static final long serialVersionUID = 1L;
			Class<?>[] tipoColumna = new Class[] {
				String.class,
				Integer.class,
				String.class,
				String.class,
				String.class,
				Integer.class,
			};
			public Class<?> getColumnClass(int indice){
				return tipoColumna[indice];
			}
		};
		
		for(Producto p : lista) {
			model.addRow(new Object[] { p.getTipo(),
							   p.getId(),
							   p.getMarca(),
							   p.getTalla(),
							   p.getColor(),
							   p.getPrecio(),
			});
		}
		
		table.setModel(model);
		filtro("", table, 0);
		lblTotal.setText(String.valueOf(table.getRowCount()));
	}
	
	private void limpiar() {
		cmbTipo.setSelectedIndex(0);
		textId.setText("");
		textMarca.setText("");
		cmbTalla.setSelectedIndex(0);
		textColor.setText("");
		textPrecio.setText("");
		btnAgregar.setEnabled(true);
		table.clearSelection();
	}
	
	private void ejemplo() {
		try {
			lista.add(new Camisa("S", "Ipnotic", "Negro", 152458, 150.0));
			lista.add(new Camisa("M", "Bruno Ferrini", "Rojo", 845875, 250.0));
			lista.add(new Casaca("L", "Nike", "Azul", 965236, 80));
			lista.add(new Casaca("S", "Under Armour", "Negro", 851253, 180.0));
			lista.add(new Pantalon("M", "Pioner", "Verde", 785458, 95.0));
			lista.add(new Pantalon("L", "Pioner", "Blanco", 962359, 120.0));
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
