package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaDAO extends DatabaseConnection{
	
    private Connection conexion;

	public CategoriaDAO() {
    	
	}

	public void crearCategoria (Categoria categoria) {
    	
    	try {
        	this.conexion = getConnection();
        	String sql = "INSERT INTO categorias (nombre) VALUES (?)";
    		//Prepara la consulta
        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		//Se prepara y se envia la variable sql
    		sentencia = conexion.prepareStatement(sql);
    		//Se envian los datos
    		sentencia.setString(1, categoria.getNombre());
    		//Se ejecuta 
    		sentencia.execute();
            JOptionPane.showMessageDialog(null, "¡Categoria registrada correctamente!");

    		sentencia.close();
    		
    	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar registrar categoria: " + e.getMessage());
    	
    	//finally para cerrar conexion
    	} finally {
    		closeConnection();
    	}
    }
    
    public void mostrarCategoria (DefaultTableModel modelo) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "SELECT * FROM categorias";

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
    			
    			Object[] fila = {id,nombre};
    			//Se agrega la fila creada al DefaultTableModel
    			modelo.addRow(fila);
    		}
    		resultado.close();
    		sentencia.close();
    		
    	} catch (SQLException e) {
    		System.err.println(e);
    	
    	}finally {
    		closeConnection(); 
    	}
    }

    public void modificarCategoria (Categoria categoria) {
    	
    	try {
    	 	this.conexion = getConnection();
        	String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		
    		sentencia.setString(1, categoria.getNombre());
    		sentencia.setInt(2, categoria.getId());
    		
    		sentencia.execute();
			JOptionPane.showMessageDialog(null, "¡Categoria actulizada correctamente!");

    		
    		sentencia.close();
    	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "¡el registro no se ha actualizado correctamente!" + e.getErrorCode());    	
    	} finally {
    		closeConnection();
    	}
    }

    public void eliminarCategoria (Categoria categoria) {
    	try {
    		this.conexion = getConnection();
        	String sql = "DELETE FROM categorias WHERE id = ?";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setInt(1, categoria.getId());
    		
    		sentencia.execute();
			JOptionPane.showMessageDialog(null,"La categoria se eliminó correctamente.");

    		sentencia.close();
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Ha ocurrido un problema al intentar eliminar el registro: " + e.getMessage());
    	
    	} finally {
    		closeConnection();
    	}
    }
    
    //Metodo adicional para traer el contenido de un libro  
    // y luego modificar ese mismo libro en una nueva ventana
     
     public void traerContenidoCategoria (Categoria categoria){
     	try {
             this.conexion = getConnection();
             String sql = "SELECT * FROM categorias WHERE id = ?";
             
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             sentencia.setInt(1, categoria.getId());
             ResultSet resultado = sentencia.executeQuery();

             if(resultado.next()) {
            	 categoria.setId(Integer.parseInt(resultado.getString("id")));
            	 categoria.setNombre(resultado.getString("Nombre"));
            	 
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
    		
    			
        
