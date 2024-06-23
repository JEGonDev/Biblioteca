package run;

import controller.CategoriaController;
import controller.LibroController;
import model.CategoriaDAO;
import model.LibroDAO;
import view.CategoriaView;
import view.CrearCategoriaView;
import view.CrearLibroView;
import view.LibroView;
import view.ModificarCategoriaView;
import view.ModificarLibroView;

public class BibliotecaApp {
    public static void main(String[] args) {
        try {
            // Crear instancias del modelo, vista y controlador
            /*LibroView libroView = new LibroView();
            LibroDAO libroDAO = new LibroDAO();
            CrearLibroView crearLibroView = new CrearLibroView();
            ModificarLibroView modificarLibroView = new ModificarLibroView();

            // Crear el controlador con todas las vistas y el modelo
            LibroController libroController = new LibroController(libroView, libroDAO, crearLibroView, modificarLibroView);
            
            // Mostrar la vista de libros
            libroView.setVisible(true);*/
            
            CategoriaView categoriaView = new CategoriaView();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            CrearCategoriaView crearCategoriaView = new CrearCategoriaView();
            ModificarCategoriaView modificarCategoriaView = new ModificarCategoriaView();
            
            CategoriaController categoriaController = new CategoriaController( categoriaDAO,categoriaView, modificarCategoriaView, crearCategoriaView );
            
            categoriaView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
