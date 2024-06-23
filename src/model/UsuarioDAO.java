package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends DatabaseConnection{

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
    }

    // Crear los metodos CRUD: crear, leer, actualizar y eliminar
    //Crear
    public boolean CrearUsuario (Usuario usuario) {
    	
    	try {
    	  	this.conexion = getConnection();
        	String sql = "INSERT INTO usuarios (nombre, email, telefono) VALUES (?,?,?)";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    public boolean LeerUsuario (Usuario usuario, DefaultTableModel modelo) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "SELECT * FROM usuarios";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
        	ResultSet resultado = null;
    		
    		sentencia = conexion.prepareStatement(sql);
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    
    
    public boolean ModificarUsuario (Usuario usuario) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "UPDATE usuarios SET nombre = ?, email = ?, telefono = ? WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		
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
    			conexion.close();
    		} catch (SQLException e) {
    			System.err.println("Error al cerrar la conexion: " +e.getMessage());
    		}
    	}
    }
    

    public boolean EliminarUsuario (Usuario usuario) {
    
    	try {
    		this.conexion = getConnection();
        	String sql = "DELETE FROM usuarios WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setInt(1, usuario.getId());
    		
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
     
     public void TraerContenidoUsuario (Usuario usuario){
     	try {
             this.conexion = getConnection();
             String sql = "SELECT * FROM usuarios WHERE id = ?";
             
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             sentencia.setInt(1, usuario.getId());
             ResultSet resultado = sentencia.executeQuery();

             if(resultado.next()) {
            	 usuario.setId(Integer.parseInt(resultado.getString("id")));
            	 usuario.setNombre(resultado.getString("Nombre"));
            	 usuario.setEmail(resultado.getString("Email"));
            	 usuario.setTelefono(resultado.getString("Telefono"));
            	 
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
