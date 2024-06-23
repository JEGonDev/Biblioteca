package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CrearCategoriaView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textNombreCategoria;
	public JButton btnGuardarNombreCategoria;
	public JButton btnVolverCrearCategoria;

	/**
	 * Create the frame.
	 */
	public CrearCategoriaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR CATEGORIA");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(151, 11, 142, 24);
		contentPane.add(lblNewLabel);
		
		textNombreCategoria = new JTextField();
		textNombreCategoria.setBounds(10, 60, 304, 20);
		contentPane.add(textNombreCategoria);
		textNombreCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el nombre de la categoria:");
		lblNewLabel_1.setBounds(10, 46, 225, 14);
		contentPane.add(lblNewLabel_1);
		
		btnGuardarNombreCategoria = new JButton("GUARDAR");
		btnGuardarNombreCategoria.setBounds(111, 91, 106, 23);
		contentPane.add(btnGuardarNombreCategoria);
		
		btnVolverCrearCategoria = new JButton("VOLVER");
		btnVolverCrearCategoria.setBackground(new Color(0, 255, 0));
		btnVolverCrearCategoria.setBounds(10, 12, 89, 23);
		contentPane.add(btnVolverCrearCategoria);
	}
}
