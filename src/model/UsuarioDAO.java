package model;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends DatabaseConnection{

    private Connection conexion;

    public UsuarioDAO() {
    }

    // Crear los metodos CRUD: crear, leer, actualizar y eliminar
    //Crear
    public void CrearUsuario (Usuario usuario) {
    	
    	try {
    	  	this.conexion = getConnection();
        	String sql = "INSERT INTO usuarios (nombre, email, telefono) VALUES (?,?,?)";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setString(1, usuario.getNombre());
    		sentencia.setString(2, usuario.getEmail());
    		sentencia.setString(3, usuario.getTelefono());
    		sentencia.execute();
    		JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
    		
    		sentencia.close();
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "No se pudo crear el usuario: "+e.getMessage());
    		
    	} finally {
    		closeConnection();
    	}
    }
    
    public void LeerUsuario (DefaultTableModel modelo) {
    	
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
    		sentencia.close();
    		resultado.close();
    		
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "No se pudo mostrar la tabla de usuarios: " + e.getMessage());
    	
    	}finally {
    		closeConnection();
    	}
    }
    
    
    public void ModificarUsuario (Usuario usuario) {
    	
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
    		JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
    		
    		sentencia.close();
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "No se pudo realizar la actualizacion: " + e.getMessage());
    	
    	} finally {
    		closeConnection();
    	}
    }
    
    public void EliminarUsuario (Usuario usuario) {
    
    	try {
    		this.conexion = getConnection();
        	String sql = "DELETE FROM usuarios WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setInt(1, usuario.getId());
    		
    		sentencia.execute();
    		JOptionPane.showMessageDialog(null, "Se elimino el usuario exitosamente");
    		
    		sentencia.close();
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario: " +e.getMessage() );
    	
    	} finally {
    		closeConnection();
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
