package run;

import controller.LibroController;
import model.LibroDAO;
import view.CrearLibroView;
import view.LibroView;
import view.ModificarLibroView;

public class BibliotecaApp {
    public static void main(String[] args) {
        try {
            // Crear instancias del modelo, vista y controlador
            LibroView libroView = new LibroView();
            LibroDAO libroDAO = new LibroDAO();
            CrearLibroView crearLibroView = new CrearLibroView();
            ModificarLibroView modificarLibroView = new ModificarLibroView();

            // Verificar que modificarLibroView no sea null antes de pasarlo al controlador
            if (modificarLibroView == null) {
                System.out.println("Error: 'modificarLibroView' es null en BibliotecaApp");
            } else {
                System.out.println("modificarLibroView inicializado correctamente.");
            }

            // Crear el controlador con todas las vistas y el modelo
            LibroController libroController = new LibroController(libroView, libroDAO, crearLibroView, modificarLibroView);
            
            // Mostrar la vista de libros
            libroView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
