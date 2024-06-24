package run;

import controller.BibliotecaController;
import controller.CategoriaController;
import controller.LibroController;
import controller.PrestamoController;
import controller.UsuarioController;
import model.CategoriaDAO;
import model.LibroDAO;
import model.PrestamoDAO;
import model.UsuarioDAO;
import view.BibliotecaView;
import view.CategoriaView;
import view.CrearCategoriaView;
import view.CrearLibroView;
import view.CrearPrestamoView;
import view.CrearUsuarioView;
import view.LibroView;
import view.ModificarCategoriaView;
import view.ModificarLibroView;
import view.ModificarPrestamoView;
import view.ModificarUsuarioView;
import view.PrestamoView;
import view.UsuarioView;

public class BibliotecaApp {
    public static void main(String[] args) {
        try {
        	//Inicia en la ventana principal
        	BibliotecaView biblioteca = new BibliotecaView();
        	//
        	PrestamoView prestamoView = new PrestamoView(); 
        	PrestamoDAO prestamoDAO = new PrestamoDAO();
        	CrearPrestamoView crearPrestamoView = new CrearPrestamoView();
        	ModificarPrestamoView modificarPrestamoView = new ModificarPrestamoView();
        	
        	PrestamoController prestamoController = new PrestamoController(prestamoView, prestamoDAO, modificarPrestamoView, crearPrestamoView, biblioteca);
        	//
        	UsuarioView usuarioView = new UsuarioView();
        	UsuarioDAO usuarioDAO = new UsuarioDAO();
        	CrearUsuarioView crearUsuarioView = new CrearUsuarioView();
        	ModificarUsuarioView modificarUsuarioView = new ModificarUsuarioView();
        	
        	UsuarioController usuarioController = new UsuarioController(usuarioView, usuarioDAO, modificarUsuarioView, crearUsuarioView, biblioteca);
        	
            // Crear instancias del modelo, vista y controlador
            LibroView libroView = new LibroView();
            LibroDAO libroDAO = new LibroDAO();
            CrearLibroView crearLibroView = new CrearLibroView();
            ModificarLibroView modificarLibroView = new ModificarLibroView();
            
            LibroController libroController = new LibroController(libroView, libroDAO, crearLibroView, modificarLibroView, biblioteca);

            // Crear el controlador con todas las vistas y el modelo
            
            CategoriaView categoriaView = new CategoriaView();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            CrearCategoriaView crearCategoriaView = new CrearCategoriaView();
            ModificarCategoriaView modificarCategoriaView = new ModificarCategoriaView();
            
            CategoriaController categoriaController = new CategoriaController( categoriaDAO,categoriaView, modificarCategoriaView, crearCategoriaView , biblioteca);
            
            BibliotecaController bibliotecaController = new BibliotecaController(biblioteca,categoriaView,libroView,prestamoView,usuarioView);
            biblioteca.setVisible(true);
        	
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
