package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class ModificarCategoriaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIDModificarCategoria;
	private JTextField textModificarNombreCategoria;

	/**
	 * Create the frame.
	 */
	public ModificarCategoriaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOprimeElBoton_1 = new JLabel("MODIFICAR CATEGORIA");
		lblOprimeElBoton_1.setForeground(Color.GREEN);
		lblOprimeElBoton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOprimeElBoton_1.setBounds(166, 11, 168, 24);
		contentPane.add(lblOprimeElBoton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el id de la categoria que desea modificar:");
		lblNewLabel_1.setBounds(10, 53, 308, 14);
		contentPane.add(lblNewLabel_1);
		
		textIDModificarCategoria = new JTextField();
		textIDModificarCategoria.setColumns(10);
		textIDModificarCategoria.setBounds(10, 67, 304, 20);
		contentPane.add(textIDModificarCategoria);
		
		JButton btnBuscarIDCategoria = new JButton("BUSCAR");
		btnBuscarIDCategoria.setBounds(327, 66, 149, 23);
		contentPane.add(btnBuscarIDCategoria);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre categoria:");
		lblNewLabel_1_1.setBounds(10, 98, 308, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textModificarNombreCategoria = new JTextField();
		textModificarNombreCategoria.setColumns(10);
		textModificarNombreCategoria.setBounds(10, 112, 304, 20);
		contentPane.add(textModificarNombreCategoria);
		
		JButton btnModificarNombreCategoria = new JButton("MODIFICAR");
		btnModificarNombreCategoria.setBounds(327, 111, 149, 23);
		contentPane.add(btnModificarNombreCategoria);
	}

}
