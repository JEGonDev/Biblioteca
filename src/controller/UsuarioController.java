package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.UsuarioDAO;
import view.UsuarioView;

public class UsuarioController implements ActionListener{
    private UsuarioView vista;
    private UsuarioDAO modelo;
	private Connection conexion;

    public UsuarioController(UsuarioView vista, UsuarioDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnModificarUsuario.addActionListener(this);
        this.vista.btnCrearNuevoUsuario.addActionListener(this);
        this.vista.btnEliminarUsuario.addActionListener(this);
        this.vista.btnMostrarUsuarios.addActionListener(this);
    }

	public UsuarioController(Connection conexion) {
		this.conexion = conexion;
	}

	@Override //Metodo que permite que los botones sean escuchados
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    // Métodos para manejar eventos de los botones (crear, leer, actualizar, eliminar)
}
