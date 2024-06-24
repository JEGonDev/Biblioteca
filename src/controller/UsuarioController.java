package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;
import model.UsuarioDAO;
import view.BibliotecaView;
import view.CrearUsuarioView;
import view.ModificarUsuarioView;
import view.UsuarioView;

public class UsuarioController implements ActionListener{
    private UsuarioView vista;
    private UsuarioDAO modelo;
    private ModificarUsuarioView modificar;
    private CrearUsuarioView crear;
    private Usuario usuario = new Usuario();
    private BibliotecaView biblioteca = new BibliotecaView();
	

    public UsuarioController(UsuarioView vista, UsuarioDAO modelo, ModificarUsuarioView modificar, CrearUsuarioView crear, BibliotecaView biblioteca) {
        this.vista = vista;
        this.modelo = modelo;
        this.crear = crear;
        this.modificar = modificar;
        this.biblioteca = biblioteca;
        
        vista.setLocationRelativeTo(null);
		vista.setResizable(false);
		crear.setLocationRelativeTo(null);
		crear.setResizable(false);
		modificar.setLocationRelativeTo(null);
		modificar.setResizable(false);
        
        this.vista.btnModificarUsuario.addActionListener(this);
        this.vista.btnCrearNuevoUsuario.addActionListener(this);
        this.vista.btnEliminarUsuario.addActionListener(this);
        this.vista.btnMostrarUsuarios.addActionListener(this);
        this.vista.btnVolverUsuarios.addActionListener(this);
        
        this.crear.btnCrearNuevoUsuario.addActionListener(this);
        this.crear.btnVolverCrearUsuario.addActionListener(this);
        
        this.modificar.btnBuscarIDUsuario.addActionListener(this);
        this.modificar.btnGuardarModificacionUsuario.addActionListener(this);
        this.modificar.btnVolverModificarUsuarios.addActionListener(this);
    }

	@Override //Metodo que permite que los botones sean escuchados
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnMostrarUsuarios) {
			modelo.LeerUsuario(vista.modelo);
		}
		
		//volver ventana principal
		if (e.getSource() == vista.btnVolverUsuarios) {
			biblioteca.setVisible(true);
			vista.setVisible(false);
		}
		
		//Abre la ventana vista crear
		if (e.getSource() == vista.btnCrearNuevoUsuario) {
			crear.setVisible(true);
			vista.dispose();
		}
		
		//Abre la ventana vista modificar
		if (e.getSource() == vista.btnModificarUsuario) {
			modificar.setVisible(true);
			vista.dispose();
		}
		
		//regresa a la ventana principal de categoria
		if (e.getSource() == modificar.btnVolverModificarUsuarios) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
			
		//regresa a la ventana principal de categoria
		if (e.getSource() == crear.btnVolverCrearUsuario) {
			vista.setVisible(true);
			crear.setVisible(false);
		}
		
		//Accion del texto eliminar y btn eliminar
		if (e.getSource() == vista.btnEliminarUsuario) {
			int id = Integer.parseInt(vista.textCodigoEliminarUsuario.getText());
			usuario.setId(id);
			modelo.EliminarUsuario(usuario);
			vista.textCodigoEliminarUsuario.setText("");
		}
		
		//Accion guardar campos al oprimir boton crearNuevoLibro
		if (e.getSource() == crear.btnCrearNuevoUsuario) {
			//obtener valores
			String nombre = crear.textCrearNombreUsuario.getText();
			String email = crear.textCrearEmailUsuario.getText();
			String telefono = crear.textCrearTelefonoUsuario.getText();
			//asignar valores al objeto libro
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			
			//Crear la categoria en el modelo
			modelo.CrearUsuario(usuario);
			
			crear.textCrearEmailUsuario.setText("");
			crear.textCrearNombreUsuario.setText("");
			crear.textCrearTelefonoUsuario.setText("");
		}
			
		//Accion para traer el contenido segun el id de la categoira
		if (e.getSource() == modificar.btnBuscarIDUsuario) {
			int id = Integer.parseInt(modificar.textIDBuscarUsuario.getText()); 
			usuario.setId(id);
			modelo.TraerContenidoUsuario(usuario);
			
			//Asignar valores obtenidos al formulario de modificacion
			modificar.textIDBuscarUsuario.setText(String.valueOf(usuario.getId()));
			modificar.textModificarNombreUsuario.setText(usuario.getNombre());
			modificar.textModificarEmailUsuario.setText(usuario.getEmail());
			modificar.textModificarTelefonoUsuario.setText(usuario.getTelefono());
			}
		
		//Accion para guardar las modificaciones en la base de datos
		if (e.getSource() == modificar.btnGuardarModificacionUsuario) {
			String nombre = modificar.textModificarNombreUsuario.getText();
			String email = modificar.textModificarEmailUsuario.getText();
			String telefono = modificar.textModificarTelefonoUsuario.getText();			
		//Actualiza la base de datos en el campo del id
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);			
		//Guardar cambios en el modelo (tabla)
			modelo.ModificarUsuario(usuario);
			
			modificar.textIDBuscarUsuario.setText("");
			modificar.textModificarEmailUsuario.setText("");
			modificar.textModificarNombreUsuario.setText("");
			modificar.textModificarTelefonoUsuario.setText("");
		}
		
	}

}
