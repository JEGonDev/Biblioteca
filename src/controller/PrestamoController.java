package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Prestamo;
import model.PrestamoDAO;
import view.BibliotecaView;
import view.CrearPrestamoView;
import view.ModificarPrestamoView;
import view.PrestamoView;

public class PrestamoController implements ActionListener{
    private PrestamoView vista;
    private PrestamoDAO modelo;
	private ModificarPrestamoView modificar;
	private CrearPrestamoView crear;
	private BibliotecaView biblioteca = new BibliotecaView();
	private Prestamo prestamo = new Prestamo();

    public PrestamoController(PrestamoView vista, PrestamoDAO modelo, ModificarPrestamoView modificar, CrearPrestamoView crear, BibliotecaView biblioteca) {
        this.vista = vista;
        this.modelo = modelo;
        this.modificar = modificar;
        this.crear = crear;
        this.biblioteca = biblioteca;
        
        //Ventana centrada y de tamaño fijo
        vista.setLocationRelativeTo(null);
    	vista.setResizable(false);
    	modificar.setLocationRelativeTo(null);
    	modificar.setResizable(false);
    	crear.setLocationRelativeTo(null);
    	crear.setResizable(false);
        
    	//listeners vista principal
        this.vista.btnModificarPrestamo.addActionListener(this);
        this.vista.btnCrearNuevoPrestamo.addActionListener(this);
        this.vista.btnEliminarPrestamo.addActionListener(this);
        this.vista.btnMostrarPrestamos.addActionListener(this);
        this.vista.btnVolverPrestamos.addActionListener(this);
       
        //listeners vista creacion
        this.crear.btnCrearNuevoPrestamo.addActionListener(this);
        this.crear.btnVolverCrearPrestamo.addActionListener(this);
    
        //listeners vista modificacion
        this.modificar.btnBuscarIDPrestamo.addActionListener(this);
        this.modificar.btnGuardarModificacionPrestamo.addActionListener(this);
        this.modificar.btnVolverModificarPrestamo.addActionListener(this);
    }

	@Override //Metodo que permite que los botones sean escuchados
	public void actionPerformed(ActionEvent e) {
		
		//Carga la tabla categorias de la base de datos
				if (e.getSource() == vista.btnMostrarPrestamos) {
					modelo.LeerPrestamo(vista.model);
				}
				
				//volver ventana principal
				if (e.getSource() == vista.btnVolverPrestamos) {
					biblioteca.setVisible(true);
					vista.setVisible(false);
				}
				
				//Abre la ventana vista crear
				if (e.getSource() == vista.btnCrearNuevoPrestamo) {
					crear.setVisible(true);
					vista.dispose();
				}
				
				//Abre la ventana vista modificar
				if (e.getSource() == vista.btnModificarPrestamo) {
					modificar.setVisible(true);
					vista.dispose();
				}
				
				//regresa a la ventana principal de categoria
				if (e.getSource() == modificar.btnVolverModificarPrestamo) {
					vista.setVisible(true);
					modificar.setVisible(false);
				}
					
				//regresa a la ventana principal de categoria
				if (e.getSource() == crear.btnVolverCrearPrestamo) {
					vista.setVisible(true);
					crear.setVisible(false);
				}
				
				//Accion del texto eliminar y btn eliminar
				if (e.getSource() == vista.btnEliminarPrestamo) {
					int id = Integer.parseInt(vista.textCodigoEliminarPrestamo.getText());
					prestamo.setId(id);
					modelo.EliminarPrestamo(prestamo);
					vista.textCodigoEliminarPrestamo.setText("");
				}
				
				//Accion guardar campos al oprimir boton crearNuevoLibro
				if (e.getSource() == crear.btnCrearNuevoPrestamo) {
					//obtener valores
					String libroID = crear.textIDLibroPrestamo.getText();
					int libro_id = Integer.parseInt(libroID);
					String usuarioID = crear.textIDClientePrestamo.getText();
					int usuario_id = Integer.parseInt(usuarioID);
					String fecha_prestamo = crear.textCrearFechaInicioPrestamo.getText();
					String fecha_devolucion = crear.textCrearFechaDevolucion.getText();
					
					//asignar valores al objeto libro
					prestamo.setLibro_id(libro_id);
					prestamo.setUsuario_id(usuario_id);
					prestamo.setFecha_prestamo(fecha_prestamo);
					prestamo.setFecha_devolucion(fecha_devolucion);
					
					//Crear la categoria en el modelo
					modelo.CrearPrestamo(prestamo);
					
					//limpiar campos de texto despues de crear
					crear.textCrearFechaDevolucion.setText("");
					crear.textCrearFechaInicioPrestamo.setText("");
					crear.textIDClientePrestamo.setText("");
					crear.textIDLibroPrestamo.setText("");
				}
					
				//Accion para traer el contenido segun el id de la categoira
				if (e.getSource() == modificar.btnBuscarIDPrestamo) {
					int id = Integer.parseInt(modificar.textIDBuscarPrestamo.getText()); 
					prestamo.setId(id);
					modelo.TraerContenidoPrestamo(prestamo);
					
					//Asignar valores obtenidos al formulario de modificacion
					modificar.textIDBuscarPrestamo.setText(String.valueOf(prestamo.getId()));
					modificar.textModificarLibroID.setText(String.valueOf(prestamo.getLibro_id()));
					modificar.textModificarUsuarioID.setText(String.valueOf(prestamo.getUsuario_id()));
					modificar.textModificarFechaInicioPrestamo.setText(prestamo.getFecha_prestamo());
					modificar.textModificarFechaDevolucionPrestamo.setText(prestamo.getFecha_devolucion());
					
				}
				
				//Accion para guardar las modificaciones en la base de datos
				if (e.getSource() == modificar.btnGuardarModificacionPrestamo) {
				    String prestamoID = modificar.textIDBuscarPrestamo.getText(); // ID del préstamo a modificar
				    int id = Integer.parseInt(prestamoID);
				    String libroID = modificar.textModificarLibroID.getText();
				    int libro_id = Integer.parseInt(libroID);
				    String usuarioID = modificar.textModificarUsuarioID.getText();
				    int usuario_id = Integer.parseInt(usuarioID);
				    String fecha_prestamo = modificar.textModificarFechaInicioPrestamo.getText();
				    String fecha_devolucion = modificar.textModificarFechaDevolucionPrestamo.getText();
				    
				    // Asignar valores al objeto prestamo
				    prestamo.setId(id); // establecer ID del préstamo
				    prestamo.setLibro_id(libro_id);
				    prestamo.setUsuario_id(usuario_id);
				    prestamo.setFecha_prestamo(fecha_prestamo);
				    prestamo.setFecha_devolucion(fecha_devolucion);
				    
				    // Modificar el préstamo en el modelo
				    modelo.ModificarPrestamo(prestamo);
				    
				    // Limpiar campos de texto después de modificar
				    modificar.textModificarFechaDevolucionPrestamo.setText("");
				    modificar.textIDBuscarPrestamo.setText("");
				    modificar.textModificarUsuarioID.setText("");
				    modificar.textModificarLibroID.setText("");
				    modificar.textModificarFechaInicioPrestamo.setText("");
				}

}}



