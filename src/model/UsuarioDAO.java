package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends DatabaseConnection{

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Crear los metodos CRUD: crear, leer, actualizar y eliminar
    //Crear
    public boolean CrearUsuario (Usuario usuario) {
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "INSERT INTO usuarios (nombre, email, telefono) VALUES (?,?,?)";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		sentencia.setString(1, usuario.getNombre());
    		sentencia.setString(2, usuario.getEmail());
    		sentencia.setString(3, usuario.getTelefono());
    		sentencia.execute();
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println(e);
    		return false;
    	} finally {
    		try {
    			connection.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    public boolean LeerUsuario (Usuario usuario, DefaultTableModel modelo) {
    	PreparedStatement sentencia = null;
    	ResultSet resultado = null;
    	Connection connection = getConnection();
    	
    	String sql = "SELECT * FROM usuarios";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		resultado = sentencia.executeQuery();
    		
    		//establece el numero de filas en 0
    		modelo.setRowCount(0);
    		
    		//metodo while para recorrer y recuperar los datos de las columnas id y nombre
    		while(resultado.next()) {
    			int id = resultado.getInt("id");
    			String nombre = resultado.getString("nombre");
    			String email = resultado.getString("email");
    			String telefono = resultado.getString("telefono");
    			
    			Object[] fila = {id, nombre, email, telefono};
    			//Se agrega la fila creada al DefaultTableModel
    			modelo.addRow(fila);
    		}
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println(e);
    		return false;
    	
    	}finally {
    		try {
    			connection.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    
    public boolean ModificarUsuario (Usuario usuario) {
    	
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "UPDATE usuarios SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		
    		sentencia.setString(1, usuario.getNombre());
    		sentencia.setString(2, usuario.getEmail());
    		sentencia.setString(3, usuario.getTelefono());
    		sentencia.setInt(4, usuario.getId());
    		
    		sentencia.execute();
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println("Error al actualizar: " + e.getMessage());
    		return false;
    	
    	} finally {
    		try {
    			connection.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    

    public boolean EliminarUsuario (Usuario usuario) {
    	
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "DELETE FROM usuarios WHERE id = ?";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		sentencia.setInt(1, usuario.getId());
    		
    		sentencia.execute();
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println("Error al actualizar: " + e.getMessage());
    		return false;
    	
    	} finally {
    		try {
    			connection.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }	
  
}
