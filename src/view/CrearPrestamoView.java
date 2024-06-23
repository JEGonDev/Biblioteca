package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearPrestamoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textCrearFechaInicioPrestamo;
	public JTextField textCrearFechaDevolucion;
	public JTextField textIDLibroPrestamo;
	public JTextField textIDClientePrestamo;
	public JButton btnCrearNuevoPrestamo;

	/**
	 * Create the frame.
	 */
	public CrearPrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParaCrearEl = new JLabel("CREA UN NUEVO PRESTAMO");
		lblParaCrearEl.setForeground(Color.GREEN);
		lblParaCrearEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParaCrearEl.setBounds(176, 25, 177, 24);
		contentPane.add(lblParaCrearEl);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa la fecha en la que inicia el prestamo del libro (YYYY-MM-DD):");
		lblNewLabel_1.setBounds(10, 151, 344, 14);
		contentPane.add(lblNewLabel_1);
		
		textCrearFechaInicioPrestamo = new JTextField();
		textCrearFechaInicioPrestamo.setColumns(10);
		textCrearFechaInicioPrestamo.setBounds(10, 170, 384, 20);
		contentPane.add(textCrearFechaInicioPrestamo);
		
		btnCrearNuevoPrestamo = new JButton("GUARDAR");
		btnCrearNuevoPrestamo.setBounds(416, 119, 89, 71);
		contentPane.add(btnCrearNuevoPrestamo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese la fecha en la que debe hacerse la devolucion del libro (YYYY-MM-DD):");
		lblNewLabel_1_1.setBounds(10, 201, 384, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textCrearFechaDevolucion = new JTextField();
		textCrearFechaDevolucion.setColumns(10);
		textCrearFechaDevolucion.setBounds(10, 216, 384, 20);
		contentPane.add(textCrearFechaDevolucion);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ingresa el ID del libro que se prestara:");
		lblNewLabel_1_2.setBounds(10, 60, 344, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textIDLibroPrestamo = new JTextField();
		textIDLibroPrestamo.setColumns(10);
		textIDLibroPrestamo.setBounds(10, 80, 384, 20);
		contentPane.add(textIDLibroPrestamo);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ingresa el ID del cliente que solicita el prestamo:");
		lblNewLabel_1_2_1.setBounds(10, 108, 344, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		textIDClientePrestamo = new JTextField();
		textIDClientePrestamo.setColumns(10);
		textIDClientePrestamo.setBounds(10, 120, 384, 20);
		contentPane.add(textIDClientePrestamo);
	}
}
