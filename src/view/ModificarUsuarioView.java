package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarUsuarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textModificarNombreUsuario;
	public JTextField textModificarEmailUsuario;
	public JTextField textModificarTelefonoUsuario;
	public JButton btnGuardarModificacionUsuario;
	public JTextField textIDBuscarUsuario;
	public JButton btnBuscarIDUsuario;
	public JButton btnVolverModificarUsuarios;

	/**
	 * Create the frame.
	 */
	public ModificarUsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParaCrearEl = new JLabel("MODIFICAR USUARIOS EXISTENTES");
		lblParaCrearEl.setForeground(Color.GREEN);
		lblParaCrearEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParaCrearEl.setBounds(131, 11, 241, 47);
		contentPane.add(lblParaCrearEl);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del usuario:");
		lblNewLabel_1.setBounds(10, 120, 225, 14);
		contentPane.add(lblNewLabel_1);
		
		textModificarNombreUsuario = new JTextField();
		textModificarNombreUsuario.setColumns(10);
		textModificarNombreUsuario.setBounds(10, 134, 304, 20);
		contentPane.add(textModificarNombreUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email del usuario:");
		lblNewLabel_1_1.setBounds(10, 172, 225, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textModificarEmailUsuario = new JTextField();
		textModificarEmailUsuario.setColumns(10);
		textModificarEmailUsuario.setBounds(10, 185, 304, 20);
		contentPane.add(textModificarEmailUsuario);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono del usuario: ");
		lblNewLabel_1_1_1.setBounds(10, 228, 225, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textModificarTelefonoUsuario = new JTextField();
		textModificarTelefonoUsuario.setColumns(10);
		textModificarTelefonoUsuario.setBounds(10, 241, 304, 20);
		contentPane.add(textModificarTelefonoUsuario);
		
		btnGuardarModificacionUsuario = new JButton("MODIFICAR");
		btnGuardarModificacionUsuario.setBounds(324, 157, 100, 77);
		contentPane.add(btnGuardarModificacionUsuario);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ingresa el id del ususario que desea modificar:");
		lblNewLabel_1_3.setBounds(10, 75, 271, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textIDBuscarUsuario = new JTextField();
		textIDBuscarUsuario.setColumns(10);
		textIDBuscarUsuario.setBounds(10, 89, 304, 20);
		contentPane.add(textIDBuscarUsuario);
		
		btnBuscarIDUsuario = new JButton("BUSCAR");
		btnBuscarIDUsuario.setBounds(324, 88, 100, 23);
		contentPane.add(btnBuscarIDUsuario);
		
		btnVolverModificarUsuarios = new JButton("ATRAS");
		btnVolverModificarUsuarios.setBackground(Color.GREEN);
		btnVolverModificarUsuarios.setBounds(10, 25, 89, 23);
		contentPane.add(btnVolverModificarUsuarios);
	}

}
