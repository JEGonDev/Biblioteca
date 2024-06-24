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
		
		//boton volver ventana principal
		if (e.getSource() == vista.btnVolverPrestamos) {
			biblioteca.setVisible(true);
			vista.setVisible(false);
		}
		
		//mostrar tabla 
		if (e.getSource() == vista.btnMostrarPrestamos) {
			modelo.LeerPrestamo(vista.model);
		}
		
    	//toma id del campo de texto y elimina segun ese id
		if (e.getSource() == vista.btnEliminarPrestamo) {
			int id = Integer.parseInt(vista.textCodigoEliminarPrestamo.getText());
			prestamo.setId(id);
			modelo.EliminarPrestamo(prestamo);
			vista.textCodigoEliminarPrestamo.setText("");
		}
		
		//ventana crear prestamo
		if (e.getSource() == vista.btnCrearNuevoPrestamo) {
			crear.setVisible(true);
			vista.dispose();
		}
		
		//atras crear prestamo
		if (e.getSource() == crear.btnVolverCrearPrestamo) {
			vista.setVisible(true);
			crear.setVisible(false);
		}
		
		//guardar datos suministrados y crear prestamo
		if (e.getSource() == crear.btnCrearNuevoPrestamo) {
			//otiene valores de los campos de texto
			String libroID = crear.textIDClientePrestamo.getText();
			int libro_id = Integer.parseInt(libroID);
			String usuarioID = crear.textIDLibroPrestamo.getText();
			int usuario_id = Integer.parseInt(usuarioID);
			String fecha_prestamo = crear.textCrearFechaInicioPrestamo.getText();
			String fecha_devolucion = crear.textCrearFechaDevolucion.getText();		
			
			//asigna los valores
			prestamo.setLibro_id(libro_id);
			prestamo.setUsuario_id(usuario_id);
			prestamo.setFecha_prestamo(fecha_prestamo);
			prestamo.setFecha_devolucion(fecha_devolucion);
			
			//crea el libro
			modelo.CrearPrestamo(prestamo);
		}
		
		//abrir ventana modificar prestamos
		if (e.getSource() == vista.btnModificarPrestamo) {
			modificar.setVisible(true);
			vista.dispose();
		}
		
		//Volver a la ventana principal
		if (e.getSource() == modificar.btnVolverModificarPrestamo) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
		
		//obtiene el contenido segun el id del prestamo
		if (e.getSource() == modificar.btnBuscarIDPrestamo) {
			int id = Integer.parseInt(modificar.textIDBuscarPrestamo.getText());
			prestamo.setId(id);
			modelo.TraerContenidoPrestamo(prestamo);
			
			modificar.textModificarLibroID.setText(String.valueOf(prestamo.getLibro_id()));
			modificar.textModificarUsuarioID.setText(String.valueOf(prestamo.getUsuario_id()));
			modificar.textModificarFechaInicioPrestamo.setText(prestamo.getFecha_prestamo());
			modificar.textModificarFechaDevolucionPrestamo.setText(prestamo.getFecha_devolucion());
			
			
		}
		//guardar las modificaciones del usuario
		if (e.getSource() == modificar.btnGuardarModificacionPrestamo) {
			//obtener valores modificados del formulario
			String libroID = crear.textIDClientePrestamo.getText();
			int libro_id = Integer.parseInt(libroID);
			String usuarioID = crear.textIDLibroPrestamo.getText();
			int usuario_id = Integer.parseInt(usuarioID);
			String fecha_prestamo = crear.textCrearFechaInicioPrestamo.getText();
			String fecha_devolucion = crear.textCrearFechaDevolucion.getText();		
			//asigna los valores
			prestamo.setLibro_id(libro_id);
			prestamo.setUsuario_id(usuario_id);
			prestamo.setFecha_prestamo(fecha_prestamo);
			prestamo.setFecha_devolucion(fecha_devolucion);
			
			//crea el libro
			modelo.ModificarPrestamo(prestamo);
		}
	}

}



