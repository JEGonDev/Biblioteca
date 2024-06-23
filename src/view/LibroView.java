package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibroView extends JFrame{

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textCodigoEliminarLibro;
	public JTable table;
	public JButton btnMostrarLibros;
	public JButton btnCrearLibro;
	public JButton btnEliminarLibro;
	public JButton btnModificarLibro;
	public DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public LibroView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarLibros = new JLabel("LIBROS");
		lblModificarLibros.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarLibros.setBounds(271, 0, 137, 29);
		lblModificarLibros.setForeground(Color.RED);
		lblModificarLibros.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contentPane.add(lblModificarLibros);
		
		btnMostrarLibros = new JButton("Mostrar libros existentes");
		btnMostrarLibros.setBounds(169, 31, 271, 23);
		contentPane.add(btnMostrarLibros);
	
		btnCrearLibro = new JButton("CREAR libro");
		btnCrearLibro.setBounds(298, 271, 271, 34);
		contentPane.add(btnCrearLibro);
		
		JLabel lblEliminarLibro = new JLabel("Ingresar el ID del libro que deseas eliminar:");
		lblEliminarLibro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarLibro.setBounds(10, 212, 398, 14);
		contentPane.add(lblEliminarLibro);
		
		textCodigoEliminarLibro = new JTextField();
		textCodigoEliminarLibro.setColumns(10);
		textCodigoEliminarLibro.setBounds(10, 237, 398, 23);
		contentPane.add(textCodigoEliminarLibro);
		
		btnEliminarLibro = new JButton("ELIMINAR");
		btnEliminarLibro.setBounds(418, 237, 151, 23);
		contentPane.add(btnEliminarLibro);
		
		btnModificarLibro = new JButton("MODIFICAR libro");
		btnModificarLibro.setBounds(10, 270, 271, 34);
		contentPane.add(btnModificarLibro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 559, 136);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel ();
		model.addColumn("id");
		model.addColumn("titulo");
		model.addColumn("autor");
		model.addColumn("editorial");
		model.addColumn("Año publicacion");
		model.addColumn("ISBN");
		
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	public static void main(String[] args) {
		LibroView libroView = new LibroView();
		libroView.setVisible(true);
	}
}
