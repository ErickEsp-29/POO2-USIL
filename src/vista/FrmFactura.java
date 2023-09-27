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
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import modelo.*;
import javax.swing.DefaultComboBoxModel;

public class FrmFactura extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Producto> listaProducto = new ArrayList<Producto>();
	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> cmbDni;
	private JLabel lblNombre;
	private JComboBox<String> cmbId;
	private JLabel lblTipo;
	private JLabel lblMarca;
	private JLabel lblTalla;
	private JLabel lblPrecio;
	private JLabel lblTotal;
	private JButton btnAgregarProducto;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnLimpiar;
	private JButton btnGenerarFactura;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFactura frame = new FrmFactura();
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
	public FrmFactura() {
		setClosable(true);
		setBounds(100, 100, 566, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("DATOS DEL CLIENTE:");
		lblDatosDelCliente.setBounds(29, 10, 117, 14);
		contentPane.add(lblDatosDelCliente);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(54, 34, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbDni = new JComboBox<String>();
		cmbDni.setModel(new DefaultComboBoxModel(new String[] {"70825140", "70829658", "70827880", "85826875"}));
		cmbDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DniSeleccionado = Integer.parseInt((String) cmbDni.getSelectedItem());
		        Cliente clienteSeleccionado = obtenerCliente(DniSeleccionado);

		        // Verificar si se encontró el producto con el DNI seleccionado
		        if (clienteSeleccionado != null) {
		            // Actualizar las demás variables con los datos del producto
		        	lblNombre.setText(clienteSeleccionado.getNombre());
		        } else {
		            // No se encontró un producto con el DNI seleccionado
		        }
			}
		});
		cmbDni.setBounds(105, 31, 96, 22);
		contentPane.add(cmbDni);
		
		JLabel lbltext1 = new JLabel("Nombre:");
		lbltext1.setBounds(54, 63, 55, 14);
		contentPane.add(lbltext1);
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(105, 64, 72, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDatosDelProducto = new JLabel("DATOS DEL PRODUCTO:");
		lblDatosDelProducto.setBounds(29, 90, 129, 14);
		contentPane.add(lblDatosDelProducto);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setBounds(54, 114, 55, 14);
		contentPane.add(lblNewLabel_1_1);
		
		cmbId = new JComboBox<String>();
		cmbId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idSeleccionado = Integer.parseInt((String) cmbId.getSelectedItem());
		        Producto productoSeleccionado = obtenerProducto(idSeleccionado);

		        // Verificar si se encontró el producto con el DNI seleccionado
		        if (productoSeleccionado != null) {
		            // Actualizar las demás variables con los datos del producto
		        	lblTipo.setText(productoSeleccionado.getTipo());
		        	lblMarca.setText(productoSeleccionado.getMarca());
		        	lblTalla.setText(productoSeleccionado.getTalla());
		        	lblPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));

		            
		        } else {
		            // No se encontró un producto con el DNI seleccionado
		        }
			}
		});
		cmbId.setModel(new DefaultComboBoxModel(new String[] {"152458", "845875", "965236", "851253", "785458", "962359"}));
		cmbId.setBounds(105, 111, 96, 22);
		contentPane.add(cmbId);
		
		JLabel lblText2 = new JLabel("Tipo:");
		lblText2.setBounds(54, 143, 55, 14);
		contentPane.add(lblText2);
		
		lblTipo = new JLabel("");
		lblTipo.setBounds(105, 144, 96, 14);
		contentPane.add(lblTipo);
		
		JLabel lbltext1_1 = new JLabel("Marca:");
		lbltext1_1.setBounds(54, 167, 55, 14);
		contentPane.add(lbltext1_1);
		
		lblMarca = new JLabel("");
		lblMarca.setBounds(105, 167, 96, 14);
		contentPane.add(lblMarca);
		
		JLabel lblText4 = new JLabel("Talla:");
		lblText4.setBounds(54, 191, 55, 14);
		contentPane.add(lblText4);
		
		lblTalla = new JLabel("");
		lblTalla.setBounds(105, 192, 96, 14);
		contentPane.add(lblTalla);
		
		JLabel lbltext1_1_1 = new JLabel("Precio:");
		lbltext1_1_1.setBounds(54, 215, 55, 14);
		contentPane.add(lbltext1_1_1);
		
		lblPrecio = new JLabel("");
		lblPrecio.setBounds(105, 215, 96, 14);
		contentPane.add(lblPrecio);
		
		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el Id seleccionado del JComboBox
		        int idSeleccionado = Integer.parseInt(cmbId.getSelectedItem().toString());
		        // Obtener la marca actual del JLabel
		        String tipo = lblTipo.getText();
		        String marca = lblMarca.getText();
		        String talla = lblTalla.getText();
		        double precio = Double.parseDouble(lblPrecio.getText());

		        
		        if (idSeleccionado != 0 && !marca.isEmpty()) {
		            // Crear un nuevo producto con los datos obtenidos
		            Producto nuevoProducto = new Producto();
		            nuevoProducto.setId(idSeleccionado);
		            nuevoProducto.setTipo(tipo);
		            nuevoProducto.setMarca(marca);
		            nuevoProducto.setTalla(talla);
		            nuevoProducto.setPrecio(precio);

		            // Agregar el producto a la lista
		            listaProducto.add(nuevoProducto);

		            // Volver a cargar los datos en la tabla y limpiar los campos
		            cargar();
		            limpiar();
		        }
			}
		});
		btnAgregarProducto.setBounds(54, 269, 123, 23);
		contentPane.add(btnAgregarProducto);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = table.getSelectedRow();

				if(table.isRowSelected(indice)) {
					int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
					
					if(opcion == JOptionPane.YES_OPTION)
						listaProducto.remove(indice);
					else
						table.clearSelection();
					cargar();
					limpiar();
				}
			}
		});
		btnEliminar.setBounds(88, 302, 89, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(187, 302, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el índice de la fila seleccionada en la tabla
		        int indice = table.getSelectedRow();

		        if (indice >= 0) {
		            // Obtener el ID seleccionado del JComboBox
		            int idSeleccionado = Integer.parseInt(cmbId.getSelectedItem().toString());

		            // Obtener el producto correspondiente en la lista basándose en el ID seleccionado
		            Producto productoSeleccionado = null;
		            for (Producto producto : listaProducto) {
		                if (producto.getId() == idSeleccionado) {
		                    productoSeleccionado = producto;
		                    break;
		                }
		            }

		            if (productoSeleccionado != null) {
		                // Actualizar los datos del producto con los valores de los campos
		            	productoSeleccionado.setId(idSeleccionado);
		            	productoSeleccionado.setTipo(lblTipo.getText());
		                productoSeleccionado.setMarca(lblMarca.getText());
		                productoSeleccionado.setMarca(lblTalla.getText());
		                productoSeleccionado.setPrecio(Double.parseDouble(lblPrecio.getText()));

		                // Volver a cargar los datos en la tabla y limpiar los campos
		                cargar();
		                limpiar();
		            }
		        }
			}
		});
		btnEditar.setBounds(187, 269, 89, 23);
		contentPane.add(btnEditar);
		
		btnGenerarFactura = new JButton("Generar Factura");
		btnGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el DNI y el nombre del cliente seleccionado
				String dniClienteString = cmbDni.getSelectedItem().toString();
				int dniCliente = Integer.parseInt(dniClienteString);
		        String nombreCliente = obtenerNombreCliente(dniCliente);

		        // Obtener la cantidad total de productos y la suma de precios
		        int cantidadTotalProductos = listaProducto.size();
		        double sumaPrecios = calcularSumaPrecios();

		        // Crear una instancia del JFrame FrmPagoFinal y pasarlo la información
		        desktopPane = new JDesktopPane();
		        getContentPane().add(desktopPane); 
		        
		        FrmPagoFinal frmPagoFinal = new FrmPagoFinal(cantidadTotalProductos, cantidadTotalProductos, nombreCliente, null);
		        desktopPane.add(frmPagoFinal);  // Agrega el JInternalFrame al JDesktopPane
		        frmPagoFinal.setVisible(true);
			}
		});
		getContentPane().add(btnGenerarFactura);
		
		btnGenerarFactura.setBounds(340, 280, 123, 23);
		contentPane.add(btnGenerarFactura);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:");
		lblPrecioTotal.setBounds(327, 241, 80, 14);
		contentPane.add(lblPrecioTotal);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(417, 241, 46, 14);
		contentPane.add(lblTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 10, 284, 218);
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

				cmbId.setSelectedItem(model.getValueAt(fila, 0));
				lblTipo.setText(model.getValueAt(fila, 1).toString());
				lblMarca.setText(model.getValueAt(fila, 2).toString());
				lblTalla.setText(model.getValueAt(fila, 3).toString());
				lblPrecio.setText(model.getValueAt(fila, 4).toString());
				
				btnAgregarProducto.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);
		
		ejemploProducto();
		ejemploCliente();
		cargar();
	}
	
	private ArrayList<Integer> obtenerIDProductos() {
        ArrayList<Integer> listaProductID = new ArrayList<>();
        for (Producto producto : listaProducto) {
        	listaProductID.add(producto.getId());
        }
        return listaProductID;
    }
	
	private Producto obtenerProducto(int id) {
        for (Producto producto : listaProducto) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;  // Devolver null si no se encuentra el DNI
    }
	
	//****************************************
	private ArrayList<Integer> obtenerDniCliente() {
        ArrayList<Integer> listaClienteDni = new ArrayList<>();
        for (Cliente cliente : listaCliente) {
        	listaClienteDni.add(cliente.getDni());
        }
        return listaClienteDni;
    }
	
	private Cliente obtenerCliente(int dni) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;  // Devolver null si no se encuentra el DNI
    }
	
	private String obtenerNombreCliente(int dni) {
	    for (Cliente cliente : listaCliente) {
	        if (cliente.getDni() == dni) {
	            return cliente.getNombre();
	        }
	    }
	    return "Nombre no encontrado";  // Devolver un mensaje si no se encuentra el DNI
	}
	//****************************************
	
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
				new String[] {"ID", "Tipo", "Marca", "Talla", "Precio"}, 0) {
			private static final long serialVersionUID = 1L;
			Class<?>[] tipoColumna = new Class[] {
				Integer.class,
				String.class,
				String.class,
				String.class,
				Double.class,
			};
			public Class<?> getColumnClass(int indice){
				return tipoColumna[indice];
			}
		};
		
		for(Producto p : listaProducto) {
			model.addRow(new Object[] { p.getId(),
							   p.getTipo(),
							   p.getMarca(),
							   p.getTalla(),
							   p.getPrecio(),
			});
		}
		
		table.setModel(model);
		filtro("", table, 0);
		
		double sumaPrecio = 0.0;

		// Calcular la suma del precio de cada producto
		for (Producto producto : listaProducto) {
		    sumaPrecio += producto.getPrecio();
		}
		lblTotal.setText(String.valueOf(sumaPrecio));
	}
	
	private double calcularSumaPrecios() {
	    double sumaPrecio = 0.0;
	    for (Producto producto : listaProducto) {
	        sumaPrecio += producto.getPrecio();
	    }
	    return sumaPrecio;
	}
	
	private void limpiar() {
		cmbId.setSelectedIndex(0);
		lblTipo.setText("");
		lblMarca.setText("");
	    lblTalla.setText("");
	    lblPrecio.setText("");
		btnAgregarProducto.setEnabled(true);
		table.clearSelection();
	}
	
	private void ejemploProducto() {
		try {
			listaProducto.add(new Camisa("S", "Ipnotic", "Negro", 152458, 150.0));
			listaProducto.add(new Camisa("M", "Bruno Ferrini", "Rojo", 845875, 250.0));
			listaProducto.add(new Casaca("L", "Nike", "Azul", 965236, 80));
			listaProducto.add(new Casaca("S", "Under Armour", "Negro", 851253, 180.0));
			listaProducto.add(new Pantalon("M", "Pioner", "Verde", 785458, 95.0));
			listaProducto.add(new Pantalon("L", "Pioner", "Blanco", 962359, 120.0));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private void ejemploCliente() {
		try {
			listaCliente.add(new Cliente("Alejandro", 70825140, new SimpleDateFormat("dd/MM/yyyy").parse("29/03/2003"), 'M'));
			listaCliente.add(new Cliente("Dalinar", 70829658, new SimpleDateFormat("dd/MM/yyyy").parse("12/03/2010"), 'M'));
			listaCliente.add(new Cliente("Navani", 70827880, new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2019"), 'F'));
			listaCliente.add(new Cliente("Elena", 85826875, new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2004"), 'F'));
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
