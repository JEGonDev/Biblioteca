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
import javax.swing.JTable;

public class UsuarioView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigoEliminarUsuario;
	private JTable table;
	public JButton btnMostrarUsuarios;
	public JButton btnCrearNuevoUsuario;
	public JButton btnEliminarUsuario;
	public JButton btnModificarUsuario;
	private Connection conexion;
	
	/**
	 * Create the frame.
	 * @param conexion 
	 */
	public UsuarioView(Connection conexion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarUsuario = new JLabel("Modificar prestamos");
		lblModificarUsuario.setBounds(211, 0, 161, 21);
		lblModificarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarUsuario.setForeground(Color.RED);
		lblModificarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contentPane.add(lblModificarUsuario);
		
		btnMostrarUsuarios = new JButton("Mostrar usuarios existentes");
		btnMostrarUsuarios.setBounds(153, 32, 271, 23);
		contentPane.add(btnMostrarUsuarios);
		
		btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setBounds(291, 248, 166, 116);
		contentPane.add(btnCrearNuevoUsuario);
		
		JLabel lblEliminarUsuario = new JLabel("Ingresar el codigo del usuario que deseas eliminar:");
		lblEliminarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarUsuario.setBounds(10, 189, 398, 14);
		contentPane.add(lblEliminarUsuario);
		
		textCodigoEliminarUsuario = new JTextField();
		textCodigoEliminarUsuario.setColumns(10);
		textCodigoEliminarUsuario.setBounds(10, 214, 398, 23);
		contentPane.add(textCodigoEliminarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.setBounds(418, 214, 151, 23);
		contentPane.add(btnEliminarUsuario);
		
		btnModificarUsuario = new JButton("Modificar usuario");
		btnModificarUsuario.setBounds(104, 248, 161, 116);
		contentPane.add(btnModificarUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 559, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
