package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearUsuarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textCrearEmailUsuario;
	public JButton btnCrearNuevoPrestamo;
	public JTextField textCrearTelefonoUsuario;
	public JTextField textCrearNombreUsuario;
	public JTextField textIDClientePrestamo;

	/**
	 * Create the frame.
	 */
	public CrearUsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParaCrearEl = new JLabel("CREA UN NUEVO USUARIO");
		lblParaCrearEl.setForeground(Color.GREEN);
		lblParaCrearEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParaCrearEl.setBounds(176, 25, 177, 24);
		contentPane.add(lblParaCrearEl);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el telefono del usuario: ");
		lblNewLabel_1.setBounds(10, 151, 344, 14);
		contentPane.add(lblNewLabel_1);
		
		textCrearEmailUsuario = new JTextField();
		textCrearEmailUsuario.setColumns(10);
		textCrearEmailUsuario.setBounds(10, 120, 384, 20);
		contentPane.add(textCrearEmailUsuario);
		
		btnCrearNuevoPrestamo = new JButton("GUARDAR");
		btnCrearNuevoPrestamo.setBounds(416, 94, 89, 71);
		contentPane.add(btnCrearNuevoPrestamo);
		
		textCrearTelefonoUsuario = new JTextField();
		textCrearTelefonoUsuario.setColumns(10);
		textCrearTelefonoUsuario.setBounds(10, 165, 384, 20);
		contentPane.add(textCrearTelefonoUsuario);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ingresa el nombre del usuario:");
		lblNewLabel_1_2.setBounds(10, 60, 344, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textCrearNombreUsuario = new JTextField();
		textCrearNombreUsuario.setColumns(10);
		textCrearNombreUsuario.setBounds(10, 80, 384, 20);
		contentPane.add(textCrearNombreUsuario);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ingresa el EMAIL del usuario:");
		lblNewLabel_1_2_1.setBounds(10, 108, 344, 14);
		contentPane.add(lblNewLabel_1_2_1);
	}

}
