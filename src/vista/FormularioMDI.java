package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioMDI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private FrmMascotas frmMascotas = new FrmMascotas();
	private FrmClientes frmClientes = new FrmClientes();
	private FrmProducto frmProducto = new FrmProducto();
	private FrmFactura frmFactura = new FrmFactura();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioMDI frame = new FormularioMDI();
					//frame.setVisible(true);
					FrmLogin l = new FrmLogin();
					l.setSize(500, 300);
					l.setLocationRelativeTo(frame);
					l.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					l.setResizable(false);
					l.setVisible(true);
					
					if(l.logeado) {
						l.dispose();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioMDI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		JMenuItem mntmMascotas = new JMenuItem("Mascotas");
		mntmMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frmMascotas.isVisible()) {
					desktopPane.add(frmMascotas);
					frmMascotas.setVisible(true);
				}
			}
		});
		mnHerramientas.add(mntmMascotas);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCliente = new JMenuItem("Clientes");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frmClientes.isVisible()) {
					desktopPane.add(frmClientes);
					frmClientes.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmCliente);
		
		JMenuItem mntmProducto = new JMenuItem("Productos");
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frmProducto.isVisible()) {
					desktopPane.add(frmProducto);
					frmProducto.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmProducto);
		
		JMenuItem mntmFactura = new JMenuItem("Factura");
		mntmFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frmFactura.isVisible()) {
					desktopPane.add(frmFactura);
					frmFactura.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmFactura);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
