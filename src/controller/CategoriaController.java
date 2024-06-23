package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.CategoriaDAO;
import view.CategoriaView;

public class CategoriaController implements ActionListener {
    private CategoriaView vista;
    private CategoriaDAO modelo;
	private Connection conexion;

    public CategoriaController(CategoriaView vista, CategoriaDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCrearCategoria.addActionListener(this);
        this.vista.btnEliminarCategoria.addActionListener(this);
        this.vista.btnMostrarCategoria.addActionListener (this);
        this.vista.btnModificarCategoria.addActionListener(this);    
    }

	public CategoriaController(Connection conexion) {
		this.conexion = conexion;
	}

	@Override //Metodo que permite que los botones sean escuchados
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    // Métodos para manejar eventos de los botones (crear, leer, actualizar, eliminar)
}
