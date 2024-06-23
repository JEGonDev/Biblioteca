package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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

        // Verificar que modificar no sea null antes de asignar listeners
        if (this.modificar != null) {
            this.modificar.btnBuscarIDLibro.addActionListener(this);
            this.modificar.btnGuardarModificacionLibro.addActionListener(this);
        } else {
            System.out.println("Warning: 'modificar' es null y no se han podido asignar ActionListeners.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica de manejo de eventos

        if (e.getSource() == vista.btnMostrarLibros) {
            modelo.LeerLibro(vista.model);
        }

        if (e.getSource() == vista.btnEliminarLibro) {
            int idLibro = Integer.parseInt(vista.textCodigoEliminarLibro.getText());
            libro.setId(idLibro);
            modelo.EliminarLibro(libro);
            JOptionPane.showMessageDialog(null, "Libro eliminado");
        }

        if (e.getSource() == vista.btnCrearLibro) {
            crear.setVisible(true);
            vista.dispose();
        }

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
            modelo.CrearLibro(libro);

            JOptionPane.showMessageDialog(null, "Libro creado exitosamente");
        }

        if (e.getSource() == vista.btnModificarLibro) {
        	modificar.setVisible(true);
        	vista.dispose();
        }
        
        
            if (e.getSource() == modificar.btnBuscarIDLibro) {
                int id = Integer.parseInt(modificar.textIDBuscarLibro.getText());
                libro.setId(id);
                modelo.TraerContenidoLibro(libro);

                // Asignar valores obtenidos al formulario de modificación
                modificar.textIDBuscarLibro.setText(String.valueOf(libro.getId()));
                modificar.textModificarTituloLibro.setText(libro.getTitulo());
                modificar.textModificarAutorLibro.setText(libro.getAutor());
                modificar.textModificarEditorialLibro.setText(libro.getEditorial());
                modificar.textModificarAnioPublicacionLibro.setText(String.valueOf(libro.getAnioPublicacion()));
                modificar.textModificarISBNLibro.setText(libro.getIsbn());

                JOptionPane.showMessageDialog(null, "Libro cargado para modificación.");
            }

            if (e.getSource() == modificar.btnGuardarModificacionLibro) {
                // Obtener valores modificados del formulario
                String titulo = modificar.textModificarTituloLibro.getText();
                String autor = modificar.textModificarAutorLibro.getText();
                String editorial = modificar.textModificarEditorialLibro.getText();
                String textoAnio = modificar.textModificarAnioPublicacionLibro.getText();
                int anioPublicacion = Integer.parseInt(textoAnio);
                String isbn = modificar.textModificarISBNLibro.getText();

                // Actualizar el objeto libro
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setEditorial(editorial);
                libro.setAnioPublicacion(anioPublicacion);
                libro.setIsbn(isbn);

                // Guardar cambios en el modelo
                modelo.ModificarLibro(libro);

                JOptionPane.showMessageDialog(null, "Libro modificado exitosamente");
            }
        }
    }

