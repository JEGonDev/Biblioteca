package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrestamoView extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigoEliminarPrestamo;
	private JTable table;
	public JButton btnMostrarPrestamos;
	public JButton btnCrearNuevoPrestamo;
	public JButton btnEliminarPrestamo;
	public JButton btnModificarPrestamo;
	public DefaultTableModel model;


	/**
	 * Create the frame.
	 */
	public PrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarPrestamos = new JLabel("PRESTAMOS");
		lblModificarPrestamos.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarPrestamos.setForeground(Color.RED);
		lblModificarPrestamos.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblModificarPrestamos.setBounds(227, 0, 107, 29);
		contentPane.add(lblModificarPrestamos);
		
		btnMostrarPrestamos = new JButton("Mostrar prestamos de los libros");
		btnMostrarPrestamos.setBounds(140, 25, 271, 23);
		contentPane.add(btnMostrarPrestamos);
		
		btnCrearNuevoPrestamo = new JButton("CREAR prestamo");
		btnCrearNuevoPrestamo.setBounds(298, 264, 271, 29);
		contentPane.add(btnCrearNuevoPrestamo);
		
		JLabel lblEliminarLibro = new JLabel("Ingresar el ID del prestamo que deseas eliminar:");
		lblEliminarLibro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarLibro.setBounds(10, 205, 398, 14);
		contentPane.add(lblEliminarLibro);
		
		textCodigoEliminarPrestamo = new JTextField();
		textCodigoEliminarPrestamo.setColumns(10);
		textCodigoEliminarPrestamo.setBounds(10, 230, 398, 23);
		contentPane.add(textCodigoEliminarPrestamo);
		
		btnEliminarPrestamo = new JButton("Eliminar registro");
		btnEliminarPrestamo.setBounds(418, 230, 151, 23);
		contentPane.add(btnEliminarPrestamo);
		
		btnModificarPrestamo = new JButton("MODIFICAR prestamo");
		btnModificarPrestamo.setBounds(10, 264, 271, 29);
		contentPane.add(btnModificarPrestamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 559, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Libro ID");
		model.addColumn("Usuario ID");
		model.addColumn("Fecha Prestamo");
		model.addColumn("Fecha Devolucion");
		
		table.setModel(model);
	
		scrollPane.setViewportView(table);
	}
}
