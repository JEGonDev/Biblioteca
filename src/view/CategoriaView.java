package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CategoriaDAO;
import model.DatabaseConnection;

public class CategoriaView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textIDEliminarCategoria;
	private JTable table;
	private DefaultTableModel modelo;
	public JButton btnMostrarCategoria;
	private Connection connection;
	public JButton btnCrearCategoria;
	public JButton btnEliminarCategoria;
	public JButton btnModificarCategoria;
	private Connection conexion;

	/**
	 * Create the frame.
	 * @param conexion 
	 */
	public CategoriaView(Connection conexion) throws SQLException {
		DatabaseConnection connection = new DatabaseConnection();
		connection.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarCategoria = new JLabel("CATEGORIAS");
		lblModificarCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblModificarCategoria.setForeground(Color.RED);
		lblModificarCategoria.setBounds(232, 0, 113, 29);
		contentPane.add(lblModificarCategoria);
		
		btnCrearCategoria = new JButton("CREAR Categoria");
		btnCrearCategoria.setBounds(298, 265, 271, 36);
		contentPane.add(btnCrearCategoria);
		
		JLabel lblEliminarCategoria = new JLabel("Ingresar el ID de la categoria que deseas eliminar:");
		lblEliminarCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarCategoria.setBounds(10, 216, 398, 14);
		contentPane.add(lblEliminarCategoria);
		
		btnEliminarCategoria = new JButton("ELIMINAR");
		btnEliminarCategoria.setBounds(418, 231, 151, 23);
		contentPane.add(btnEliminarCategoria);
		
		textIDEliminarCategoria = new JTextField();
		textIDEliminarCategoria.setColumns(10);
		textIDEliminarCategoria.setBounds(10, 231, 398, 23);
		contentPane.add(textIDEliminarCategoria);
		
		btnMostrarCategoria = new JButton("Mostrar categorias existentes");
		btnMostrarCategoria.setBounds(148, 36, 271, 23);
		contentPane.add(btnMostrarCategoria);
		
		btnModificarCategoria = new JButton("MODIFICAR categoria");
		btnModificarCategoria.setBounds(10, 265, 271, 36);
		contentPane.add(btnModificarCategoria);
		/* PREGUNTAR QUE HACE ESO SE GENERO SOLO Y ESTABA DENTRO EL ANTERIOR BOTON
		 * btnActualizarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 559, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		
		
		
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrarCategoria) {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.LeerCategorias( connection , modelo);
			
		}
		
	}*/
}
