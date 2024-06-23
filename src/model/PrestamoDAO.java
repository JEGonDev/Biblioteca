package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PrestamoDAO extends DatabaseConnection{
	

    private Connection conexion;

    public PrestamoDAO() {
    }

    // Crear los metodos CRUD: crear, leer, actualizar y eliminar
    public boolean CrearPrestamo (Prestamo prestamo) {
    	
    	try {
    		this.conexion = getConnection();    	
        	String sql = "INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?,?,?,?)";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    public boolean LeerPrestamo (Prestamo prestamo, DefaultTableModel modelo) {
    	
    	try {
        	this.conexion = getConnection();
        	String sql = "SELECT * FROM prestamos";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
        	ResultSet resultado = null;
    		
    		sentencia = conexion.prepareStatement(sql);
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    
    public boolean ModificarPrestamo (Prestamo prestamo) {
    	
    	try {
    	 	this.conexion = getConnection();
        	String sql = "UPDATE prestamos SET libro_id = ?, usuario_id = ?, fecha_prestamo = ?, fecha_devolucion = ? WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    

    public boolean EliminarPrestamo (Prestamo prestamo) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "DELETE FROM prestamos WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setInt(1, prestamo.getId());
    		
    		sentencia.execute();
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println("Error al actualizar: " + e.getMessage());
    		return false;
    	
    	} finally {
    		try {
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }	
  
    //Metodo adicional para traer el contenido de un libro  
    // y luego modificar ese mismo libro en una nueva ventana
     
     public void TraerContenidoPrestamo (Prestamo prestamo){
     	try {
             this.conexion = getConnection();
             String sql = "SELECT * FROM prestamos WHERE id = ?";
             
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             sentencia.setInt(1, prestamo.getId());
             ResultSet resultado = sentencia.executeQuery();

             if(resultado.next()) {
            	 prestamo.setId(Integer.parseInt(resultado.getString("id")));
            	 prestamo.setLibro_id(Integer.parseInt(resultado.getString("Libro ID")));
            	 prestamo.setUsuario_id(Integer.parseInt(resultado.getString("Usuario ID")));
            	 prestamo.setFecha_prestamo(resultado.getString("Fecha prestamo"));
            	 prestamo.setFecha_devolucion(resultado.getString("Fecha devolucion"));
            	 
             }
             else {
                 JOptionPane.showMessageDialog(null, "¡no existe un registro con ese id, intentalo de nuevo!");
             }
             // Cierra el statement y result
             sentencia.close();
             resultado.close();

         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,
                     "Ha ocurrido un problema al intentar mostrar los registros: " + e.getMessage());
         } finally {
             closeConnection();
         }
 }   
}
