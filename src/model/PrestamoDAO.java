package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;


public class PrestamoDAO extends DatabaseConnection{
	

    private Connection conexion;

    public PrestamoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Crear los metodos CRUD: crear, leer, actualizar y eliminar
    public boolean CrearPrestamo (Prestamo prestamo) {
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?,?,?,?)";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		sentencia.setInt(1, prestamo.getLibro_id());
    		sentencia.setInt(2, prestamo.getUsuario_id());
    		sentencia.setString(3, prestamo.getFecha_prestamo());
    		sentencia.setString(4, prestamo.getFecha_devolucion());
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
    
    public boolean LeerPrestamo (Prestamo prestamo, DefaultTableModel modelo) {
    	PreparedStatement sentencia = null;
    	ResultSet resultado = null;
    	Connection connection = getConnection();
    	
    	String sql = "SELECT * FROM prestamos";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		resultado = sentencia.executeQuery();
    		
    		//establece el numero de filas en 0
    		modelo.setRowCount(0);
    		
    		//metodo while para recorrer y recuperar los datos de las columnas id y nombre
    		while(resultado.next()) {
    			int id = resultado.getInt("id");
    			int libro_id = resultado.getInt("libro_id");
    			int usuario_id = resultado.getInt("usuario_id");
    			String fecha_prestamo = resultado.getString("fecha_prestamo");
    			String fecha_devolucion = resultado.getString("fecha_devolucion");
    			
    			Object[] fila = {id, libro_id, usuario_id, fecha_prestamo, fecha_devolucion};
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
    
    
    public boolean ModificarPrestamo (Prestamo prestamo) {
    	
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "UPDATE prestamos SET libro_id = ?, usuario_id = ?, fecha_prestamo = ?, fecha_devolucion = ? WHERE id = ?";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		
    		sentencia.setInt(1, prestamo.getLibro_id());
    		sentencia.setInt(2, prestamo.getUsuario_id());
    		sentencia.setString(3, prestamo.getFecha_prestamo());
    		sentencia.setString(4, prestamo.getFecha_devolucion());
    		sentencia.setInt(5 ,prestamo.getId());
    		
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
    

    public boolean EliminarPrestamo (Prestamo prestamo) {
    	
    	PreparedStatement sentencia = null;
    	Connection connection = getConnection();
    	
    	String sql = "DELETE FROM prestamos WHERE id = ?";
    	
    	try {
    		sentencia = connection.prepareStatement(sql);
    		sentencia.setInt(1, prestamo.getId());
    		
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
