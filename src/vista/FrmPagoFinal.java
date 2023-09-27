package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import modelo.*;

public class FrmPagoFinal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblCantProductos;
	private JLabel lblPagoTotal;
	private int dni, cantProducto;
	private String nombre;
	private Double pagoTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPagoFinal frame = new FrmPagoFinal();
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
	
	
	
	public FrmPagoFinal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacturaDeCompra = new JLabel("FACTURA DE COMPRA");
		lblFacturaDeCompra.setBounds(93, 10, 222, 27);
		lblFacturaDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblFacturaDeCompra);
		
		JLabel lblDniDelCliente = new JLabel("DNI del Cliente:");
		lblDniDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniDelCliente.setBounds(93, 67, 106, 27);
		contentPane.add(lblDniDelCliente);
		
		lblDni = new JLabel("");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(209, 67, 106, 27);
		contentPane.add(lblDni);
		
		JLabel lblDniDelCliente_1 = new JLabel("Nombre del Cliente:");
		lblDniDelCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniDelCliente_1.setBounds(73, 108, 126, 27);
		contentPane.add(lblDniDelCliente_1);
		
		lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(209, 108, 106, 27);
		contentPane.add(lblNombre);
		
		JLabel lbltext5 = new JLabel("Cant de Productos:");
		lbltext5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltext5.setBounds(73, 151, 126, 27);
		contentPane.add(lbltext5);
		
		lblCantProductos = new JLabel("");
		lblCantProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantProductos.setBounds(209, 151, 106, 27);
		contentPane.add(lblCantProductos);
		
		JLabel lblDniDelCliente_6 = new JLabel("Pago Total:");
		lblDniDelCliente_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniDelCliente_6.setBounds(93, 188, 106, 27);
		contentPane.add(lblDniDelCliente_6);
		
		lblPagoTotal = new JLabel("");
		lblPagoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPagoTotal.setBounds(209, 188, 106, 27);
		contentPane.add(lblPagoTotal);
		
		int dni = 70825140; 
	    int cantidadProductos = 6; 
	    String nombreCliente = "Alejandro";
	    double totalPago = 875.0; 
	    
		lblDni.setText(String.valueOf(dni));
	    lblNombre.setText(nombreCliente);
	    lblCantProductos.setText(String.valueOf(cantidadProductos));
	    lblPagoTotal.setText(String.valueOf(totalPago));
		
	}

	public FrmPagoFinal(int dni, int cantProducto, String nombre, Double pagoTotal) {
		this.dni = dni;
		this.cantProducto = cantProducto;
		this.nombre = nombre;
		this.pagoTotal = pagoTotal;
		
		lblDni = new JLabel(String.valueOf(dni));
		lblCantProductos = new JLabel(String.valueOf(dni));
		configurarFactura();
	}
	
	private void configurarFactura() {
	    // Configura los JLabels con los datos obtenidos
	    /*lblDni.setText(String.valueOf(this.dni));
	    lblNombre.setText(this.nombre);
	    lblCantProductos.setText(String.valueOf(this.cantProducto));
	    lblPagoTotal.setText(String.valueOf(this.pagoTotal));*/
		
		lblDni = new JLabel(String.valueOf(dni));
		lblCantProductos = new JLabel(String.valueOf(dni));
		lblNombre = new JLabel(String.valueOf(dni));
		lblPagoTotal = new JLabel(String.valueOf(dni));
	}

}
