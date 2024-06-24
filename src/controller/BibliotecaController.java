package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BibliotecaView;
import view.CategoriaView;
import view.LibroView;
import view.PrestamoView;
import view.UsuarioView;

public class BibliotecaController implements ActionListener{
	private BibliotecaView biblioteca;
	private CategoriaView categoria;
	private LibroView libro;
	private PrestamoView prestamo;
	private UsuarioView usuario;
	
	public BibliotecaController(BibliotecaView biblioteca ,CategoriaView categoria, 
			LibroView libro, PrestamoView prestamo, UsuarioView usuario) {
		this.biblioteca = biblioteca;
		this.categoria = categoria;
		this.libro = libro;
		this.prestamo = prestamo;
		this.usuario = usuario;
		
		//Ventana centrada y de tamaño fijo
		biblioteca.setLocationRelativeTo(null);
		biblioteca.setResizable(false);
		
		//listener botones
		this.biblioteca.btnCategorias.addActionListener(this);
		this.biblioteca.btnLibros.addActionListener(this);
		this.biblioteca.btnPrestamos.addActionListener(this);
		this.biblioteca.btnUsuario.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == biblioteca.btnCategorias) {
			categoria.setVisible(true);
			biblioteca.setVisible(false);
		}
		
		if (e.getSource() == biblioteca.btnLibros) {
			libro.setVisible(true);
			biblioteca.setVisible(false);
		}
		
		if (e.getSource() == biblioteca.btnPrestamos) {
			prestamo.setVisible(true);
			biblioteca.setVisible(false);
		}
		
		if (e.getSource() == biblioteca.btnUsuario) {
			usuario.setVisible(true);
			biblioteca.setVisible(false);
		}
	}
	
}
