package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UsuarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textCodigoEliminarUsuario;
	public JTable table;
	public JButton btnMostrarUsuarios;
	public JButton btnCrearNuevoUsuario;
	public JButton btnEliminarUsuario;
	public JButton btnModificarUsuario;
	public DefaultTableModel modelo;
	public JButton btnVolverUsuarios;

	
	/**
	 * Create the frame.
	 */
	public UsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarUsuario = new JLabel("USUARIOS");
		lblModificarUsuario.setBounds(249, 0, 123, 21);
		lblModificarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarUsuario.setForeground(new Color(0, 0, 0));
		lblModificarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contentPane.add(lblModificarUsuario);
		
		btnMostrarUsuarios = new JButton("Mostrar usuarios existentes");
		btnMostrarUsuarios.setBounds(153, 32, 271, 23);
		contentPane.add(btnMostrarUsuarios);
		
		btnCrearNuevoUsuario = new JButton("CREAR usuario");
		btnCrearNuevoUsuario.setBounds(299, 296, 271, 39);
		contentPane.add(btnCrearNuevoUsuario);
		
		JLabel lblEliminarUsuario = new JLabel("Ingresar el codigo del usuario que deseas eliminar:");
		lblEliminarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarUsuario.setBounds(10, 229, 398, 14);
		contentPane.add(lblEliminarUsuario);
		
		textCodigoEliminarUsuario = new JTextField();
		textCodigoEliminarUsuario.setColumns(10);
		textCodigoEliminarUsuario.setBounds(10, 254, 398, 23);
		contentPane.add(textCodigoEliminarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.setBackground(new Color(255, 128, 128));
		btnEliminarUsuario.setBounds(418, 254, 151, 23);
		contentPane.add(btnEliminarUsuario);
		
		btnModificarUsuario = new JButton("MODIFICAR usuario");
		btnModificarUsuario.setBounds(10, 296, 271, 39);
		contentPane.add(btnModificarUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 559, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("EMAIL");
		modelo.addColumn("Telefono");
		
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		
		btnVolverUsuarios = new JButton("ATRAS");
		btnVolverUsuarios.setBackground(Color.GREEN);
		btnVolverUsuarios.setBounds(10, 11, 89, 23);
		contentPane.add(btnVolverUsuarios);
	}
}
