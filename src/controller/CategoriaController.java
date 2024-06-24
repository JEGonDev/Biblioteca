package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Categoria;
import model.CategoriaDAO;
import view.BibliotecaView;
import view.CategoriaView;
import view.CrearCategoriaView;
import view.ModificarCategoriaView;

public class CategoriaController implements ActionListener {
	
	private CategoriaDAO modelo;
	private CategoriaView vista;
	private ModificarCategoriaView modificar;
	private CrearCategoriaView crear;
	private Categoria categoria = new Categoria();
	private BibliotecaView biblioteca = new BibliotecaView();

    public CategoriaController(CategoriaDAO modelo, CategoriaView vista, ModificarCategoriaView modificar, CrearCategoriaView crear, BibliotecaView biblioteca) {
    	this.modelo = modelo;
    	this.vista = vista;
    	this.modificar = modificar;
    	this.crear = crear;
    	this.biblioteca = biblioteca;
    	
    	//ventanas centrada y de tamaño fijo
    	vista.setLocationRelativeTo(null);
    	vista.setResizable(false);
    	modificar.setLocationRelativeTo(null);
    	modificar.setResizable(false);
    	crear.setLocationRelativeTo(null);
    	crear.setResizable(false);
    	
    	//listeners botones vista principal
    	this.vista.btnCrearCategoria.addActionListener(this);
    	this.vista.btnEliminarCategoria.addActionListener(this);
    	this.vista.btnModificarCategoria.addActionListener(this);
    	this.vista.btnMostrarCategoria.addActionListener(this);
    	this.vista.btnVolverCategoria.addActionListener(this);
    	
    	//listeners botones vista creacion
    	this.crear.btnGuardarNombreCategoria.addActionListener(this);
    	this.crear.btnVolverCrearCategoria.addActionListener(this);
    	
    	//listeners botones vista modificar
    	this.modificar.btnBuscarIDCategoria.addActionListener(this);
    	this.modificar.btnModificarNombreCategoria.addActionListener(this);
    	this.modificar.btnVolverModificarCategoria.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		//Logica manejo de eventos de los botones
		
		//Eventos que abren las vistas
		
		//Carga la tabla categorias de la base de datos
		if (e.getSource() == vista.btnMostrarCategoria) {
			modelo.mostrarCategoria(vista.modelo);
		}
		
		//volver ventana principal
		if (e.getSource() == vista.btnVolverCategoria) {
			biblioteca.setVisible(true);
			vista.setVisible(false);
		}
		
		//Abre la ventana vista crear
		if (e.getSource() == vista.btnCrearCategoria) {
			crear.setVisible(true);
			vista.dispose();
		}
		
		//Abre la ventana vista modificar
		if (e.getSource() == vista.btnModificarCategoria) {
			modificar.setVisible(true);
			vista.dispose();
		}
		
		//regresa a la ventana principal de categoria
		if (e.getSource() == modificar.btnVolverModificarCategoria) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
			
		//regresa a la ventana principal de categoria
		if (e.getSource() == crear.btnVolverCrearCategoria) {
			vista.setVisible(true);
			crear.setVisible(false);
		}
		
		//Accion del texto eliminar y btn eliminar
		if (e.getSource() == vista.btnEliminarCategoria) {
			int id = Integer.parseInt(vista.textIDEliminarCategoria.getText());
			categoria.setId(id);
			modelo.eliminarCategoria(categoria);
			vista.textIDEliminarCategoria.setText("");
		}
		
		//Accion guardar campos al oprimir boton crearNuevoLibro
		if (e.getSource() == crear.btnGuardarNombreCategoria) {
			//obtener valores
			String nombre = crear.textNombreCategoria.getText();
			
			//asignar valores al objeto libro
			categoria.setNombre(nombre);
			
			//Crear la categoria en el modelo
			modelo.crearCategoria(categoria);
			
			crear.textNombreCategoria.setText("");
		}
			
		//Accion para traer el contenido segun el id de la categoira
		if (e.getSource() == modificar.btnBuscarIDCategoria) {
			int id = Integer.parseInt(modificar.textIDModificarCategoria.getText()); 
			categoria.setId(id);
			modelo.traerContenidoCategoria(categoria);
			
			//Asignar valores obtenidos al formulario de modificacion
			modificar.textIDModificarCategoria.setText(String.valueOf(categoria.getId()));
			modificar.textModificarNombreCategoria.setText(categoria.getNombre());
			}
		
		//Accion para guardar las modificaciones en la base de datos
		if (e.getSource() == modificar.btnModificarNombreCategoria) {
			String nombre = modificar.textModificarNombreCategoria.getText();
			
		//Actualiza la base de datos en el campo del id
			categoria.setNombre(nombre);
			
		//Guardar cambios en el modelo (tabla)
			modelo.modificarCategoria(categoria);
			
			modificar.textIDModificarCategoria.setText("");
			modificar.textModificarNombreCategoria.setText("");
		}
	}  
}



