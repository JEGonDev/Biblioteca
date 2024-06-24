package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CrearLibroView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textCrearTituloLibro;
	public JTextField textCrearAutorLibro;
	public JTextField textCrearEditorialLibro;
	public JTextField textCrearAnioPublicacionLibro;
	public JTextField textCrearISBNLibro;
	public JButton btnCrearNuevoLibro;
	public JButton btnVolverCrearLibro;

	/**
	 * Create the frame.
	 */
	public CrearLibroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParaCrearEl = new JLabel("CREA UN NUEVO LIBRO");
		lblParaCrearEl.setForeground(new Color(0, 0, 0));
		lblParaCrearEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParaCrearEl.setBounds(151, 26, 163, 24);
		contentPane.add(lblParaCrearEl);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el titulo del libro:");
		lblNewLabel_1.setBounds(10, 81, 225, 14);
		contentPane.add(lblNewLabel_1);
		
		textCrearTituloLibro = new JTextField();
		textCrearTituloLibro.setColumns(10);
		textCrearTituloLibro.setBounds(10, 96, 304, 20);
		contentPane.add(textCrearTituloLibro);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingresa el autor del libro:");
		lblNewLabel_1_1.setBounds(10, 127, 225, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textCrearAutorLibro = new JTextField();
		textCrearAutorLibro.setColumns(10);
		textCrearAutorLibro.setBounds(10, 142, 304, 20);
		contentPane.add(textCrearAutorLibro);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ingresa la editorial del libro:");
		lblNewLabel_1_1_1.setBounds(10, 173, 225, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textCrearEditorialLibro = new JTextField();
		textCrearEditorialLibro.setColumns(10);
		textCrearEditorialLibro.setBounds(10, 188, 304, 20);
		contentPane.add(textCrearEditorialLibro);
		
		btnCrearNuevoLibro = new JButton("CREAR");
		btnCrearNuevoLibro.setBounds(324, 161, 89, 71);
		contentPane.add(btnCrearNuevoLibro);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ingresa el año de publicacion del libro:");
		lblNewLabel_1_1_1_1.setBounds(10, 219, 304, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textCrearAnioPublicacionLibro = new JTextField();
		textCrearAnioPublicacionLibro.setColumns(10);
		textCrearAnioPublicacionLibro.setBounds(10, 234, 304, 20);
		contentPane.add(textCrearAnioPublicacionLibro);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ingresa el ISBN del libro:");
		lblNewLabel_1_2.setBounds(10, 265, 225, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textCrearISBNLibro = new JTextField();
		textCrearISBNLibro.setColumns(10);
		textCrearISBNLibro.setBounds(10, 280, 304, 20);
		contentPane.add(textCrearISBNLibro);
		
		btnVolverCrearLibro = new JButton("ATRAS");
		btnVolverCrearLibro.setBackground(new Color(0, 255, 0));
		btnVolverCrearLibro.setBounds(10, 29, 83, 23);
		contentPane.add(btnVolverCrearLibro);
	}
}
