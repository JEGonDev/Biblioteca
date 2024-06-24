package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BibliotecaView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnUsuario;
	public JButton btnPrestamos;
	public JButton btnCategorias;
	public JButton btnLibros;


	/**
	 * Create the frame.
	 */
	public BibliotecaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIBLIOTECA");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(128, 255, 128));
		lblNewLabel.setBounds(58, 11, 130, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ONDE JUANITO");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(45, 36, 143, 30);
		contentPane.add(lblNewLabel_1);
		
		btnLibros = new JButton("LIBROS");
		btnLibros.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnLibros.setBounds(35, 92, 163, 30);
		contentPane.add(btnLibros);
		
		btnCategorias = new JButton("CATEGORIAS");
		btnCategorias.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnCategorias.setBounds(35, 133, 163, 30);
		contentPane.add(btnCategorias);
		
		btnPrestamos = new JButton("PRESTAMOS");
		btnPrestamos.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnPrestamos.setBounds(35, 177, 163, 30);
		contentPane.add(btnPrestamos);
		
		btnUsuario = new JButton("USUARIOS");
		btnUsuario.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnUsuario.setBounds(35, 219, 163, 30);
		contentPane.add(btnUsuario);
	}
}
