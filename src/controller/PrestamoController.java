package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.PrestamoDAO;
import view.PrestamoView;

public class PrestamoController implements ActionListener{
    private PrestamoView vista;
    private PrestamoDAO modelo;
	private Connection conexion;

    public PrestamoController(PrestamoView vista, PrestamoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnModificarPrestamo.addActionListener(this);
        this.vista.btnCrearNuevoPrestamo.addActionListener(this);
        this.vista.btnEliminarPrestamo.addActionListener(this);
        this.vista.btnMostrarPrestamos.addActionListener(this);
    }

	public PrestamoController(Connection conexion) {
		this.conexion = conexion;
	}

	@Override //Metodo que permite que los botones sean escuchados
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    // Métodos para manejar eventos de los botones (crear, leer, actualizar, eliminar)
}