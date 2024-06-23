package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Libro;
import model.LibroDAO;
import view.CrearLibroView;
import view.LibroView;
import view.ModificarLibroView;

public class LibroController implements ActionListener {
    private LibroView vista;
    private LibroDAO modelo;
    private CrearLibroView crear;
    private ModificarLibroView modificar;
    private Libro libro = new Libro();

    public LibroController(LibroView vista, LibroDAO modelo, CrearLibroView crear, ModificarLibroView modificar) {
        this.vista = vista;
        this.modelo = modelo;
        this.crear = crear;
        this.modificar = modificar;

        // Asignar listeners a los botones de la vista principal
        this.vista.btnModificarLibro.addActionListener(this);
        this.vista.btnCrearLibro.addActionListener(this);
        this.vista.btnEliminarLibro.addActionListener(this);
        this.vista.btnMostrarLibros.addActionListener(this);
        
        // Asignar listeners a los botones de la vista de creación
        this.crear.btnCrearNuevoLibro.addActionListener(this);
        this.crear.btnVolverCrearLibro.addActionListener(this);
        
        // Asignar listeners a los botones de la vista modificar
        this.modificar.btnVolverModificarLibro.addActionListener(this);
        this.modificar.btnBuscarIDLibro.addActionListener(this);
        this.modificar.btnGuardarModificacionLibro.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica de manejo de eventos

    	//Esto lo que hace es mostrar la tabla en el formulario
    	if (e.getSource() == vista.btnMostrarLibros) {
    	    modelo.mostrarLibro(vista.model); // Lee y actualiza la tabla
    	    
    	}

    	if (e.getSource() == vista.btnEliminarLibro) {
    	    int idLibro = Integer.parseInt(vista.textCodigoEliminarLibro.getText());
    	    libro.setId(idLibro);
    	    modelo.eliminarLibro(libro);
    	    vista.textCodigoEliminarLibro.setText(""); 	        
    	    } 
    	
        //Esto lo que hace es que al oprimir el boton crear libro se muestre el formulario en cuestion
        if (e.getSource() == vista.btnCrearLibro) {
            crear.setVisible(true);
            vista.dispose();
        }
        
        if (e.getSource() == crear.btnVolverCrearLibro) {
        	vista.setVisible(true);
        	crear.setVisible(false);
        }

        //Esto permite que al oprimir el boton se guarden los datos suministrados
        if (e.getSource() == crear.btnCrearNuevoLibro) {
            // Obtener valores de la ventana de creación
            String titulo = crear.textCrearTituloLibro.getText();
            String autor = crear.textCrearAutorLibro.getText();
            String editorial = crear.textCrearEditorialLibro.getText();
            String textoAnio = crear.textCrearAnioPublicacionLibro.getText();
            int anioPublicacion = Integer.parseInt(textoAnio);
            String isbn = crear.textCrearISBNLibro.getText();

            // Asignar valores al objeto libro
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setAnioPublicacion(anioPublicacion);
            libro.setIsbn(isbn);

            // Crear el libro en el modelo
            modelo.crearLibro(libro);

            
        }

        //Esto permite que al oprimir el boton se abra el formulario en cuestion
        if (e.getSource() == vista.btnModificarLibro) {
        	modificar.setVisible(true);
        	vista.dispose();
        }
        
        if (e.getSource() == modificar.btnVolverModificarLibro) {
        	vista.setVisible(true);
        	modificar.setVisible(false);
        }
        
        	//Esto trae el contenido del libro que el usuario propocione en los campos de texto
            if (e.getSource() == modificar.btnBuscarIDLibro) {
                int id = Integer.parseInt(modificar.textIDBuscarLibro.getText());
                libro.setId(id);
                modelo.traerContenidoLibro(libro);

                // Asignar valores obtenidos al formulario de modificación
                modificar.textIDBuscarLibro.setText(String.valueOf(libro.getId()));
                modificar.textModificarTituloLibro.setText(libro.getTitulo());
                modificar.textModificarAutorLibro.setText(libro.getAutor());
                modificar.textModificarEditorialLibro.setText(libro.getEditorial());
                modificar.textModificarAnioPublicacionLibro.setText(String.valueOf(libro.getAnioPublicacion()));
                modificar.textModificarISBNLibro.setText(libro.getIsbn());

                
            }

            //Esto guarda las modificaciones del usuario
            if (e.getSource() == modificar.btnGuardarModificacionLibro) {
                // Obtener valores modificados del formulario
                String titulo = modificar.textModificarTituloLibro.getText();
                String autor = modificar.textModificarAutorLibro.getText();
                String editorial = modificar.textModificarEditorialLibro.getText();
                String textoAnio = modificar.textModificarAnioPublicacionLibro.getText();
                int anioPublicacion = Integer.parseInt(textoAnio);
                String isbn = modificar.textModificarISBNLibro.getText();

                // Actualizar la base de datos en el campo id
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setEditorial(editorial);
                libro.setAnioPublicacion(anioPublicacion);
                libro.setIsbn(isbn);

                // Guardar cambios en el modelo
                modelo.modificarLibro(libro);

                
            }
        }
    }

