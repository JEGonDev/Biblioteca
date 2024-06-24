package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

	

public class ModificarPrestamoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textModificarLibroID;
	public JTextField textModificarUsuarioID;
	public JTextField textModificarFechaInicioPrestamo;
	public JTextField textModificarFechaDevolucionPrestamo;
	public JButton btnGuardarModificacionPrestamo;
	public JTextField textIDBuscarPrestamo;
	public JButton btnBuscarIDPrestamo;
	public JButton btnVolverModificarPrestamo;

	/**
	 * Create the frame.
	 */
	public ModificarPrestamoView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParaCrearEl = new JLabel("MODIFICAR PRESTAMOS EXISTENTES");
		lblParaCrearEl.setBackground(new Color(0, 0, 0));
		lblParaCrearEl.setForeground(new Color(0, 0, 0));
		lblParaCrearEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParaCrearEl.setBounds(129, 11, 241, 47);
		contentPane.add(lblParaCrearEl);
		
		JLabel lblNewLabel_1 = new JLabel("Libro ID:");
		lblNewLabel_1.setBounds(10, 120, 225, 14);
		contentPane.add(lblNewLabel_1);
		
		textModificarLibroID = new JTextField();
		textModificarLibroID.setColumns(10);
		textModificarLibroID.setBounds(10, 134, 304, 20);
		contentPane.add(textModificarLibroID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario ID:");
		lblNewLabel_1_1.setBounds(10, 172, 225, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textModificarUsuarioID = new JTextField();
		textModificarUsuarioID.setColumns(10);
		textModificarUsuarioID.setBounds(10, 185, 304, 20);
		contentPane.add(textModificarUsuarioID);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha inicio del prestamo:");
		lblNewLabel_1_1_1.setBounds(10, 228, 225, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textModificarFechaInicioPrestamo = new JTextField();
		textModificarFechaInicioPrestamo.setColumns(10);
		textModificarFechaInicioPrestamo.setBounds(10, 241, 304, 20);
		contentPane.add(textModificarFechaInicioPrestamo);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha devolucion del prestamo:");
		lblNewLabel_1_1_1_1.setBounds(10, 281, 304, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textModificarFechaDevolucionPrestamo = new JTextField();
		textModificarFechaDevolucionPrestamo.setColumns(10);
		textModificarFechaDevolucionPrestamo.setBounds(10, 293, 304, 20);
		contentPane.add(textModificarFechaDevolucionPrestamo);
		
		btnGuardarModificacionPrestamo = new JButton("MODIFICAR");
		btnGuardarModificacionPrestamo.setBounds(324, 157, 100, 77);
		contentPane.add(btnGuardarModificacionPrestamo);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ingresa el id del prestamo que desea modificar:");
		lblNewLabel_1_3.setBounds(10, 75, 271, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textIDBuscarPrestamo = new JTextField();
		textIDBuscarPrestamo.setColumns(10);
		textIDBuscarPrestamo.setBounds(10, 89, 304, 20);
		contentPane.add(textIDBuscarPrestamo);
		
		btnBuscarIDPrestamo = new JButton("BUSCAR");
		btnBuscarIDPrestamo.setBounds(324, 88, 100, 23);
		contentPane.add(btnBuscarIDPrestamo);
		
		btnVolverModificarPrestamo = new JButton("VOLVER");
		btnVolverModificarPrestamo.setBackground(Color.GREEN);
		btnVolverModificarPrestamo.setBounds(10, 25, 89, 23);
		contentPane.add(btnVolverModificarPrestamo);
	
	}

}
