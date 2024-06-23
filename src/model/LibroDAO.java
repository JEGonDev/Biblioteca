package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroDAO extends DatabaseConnection{

	private Connection conexion;

	public LibroDAO() {
		
	}

	// Crear los metodos CRUD: crear, leer, actualizar y eliminar
    //crear
    public boolean CrearLibro (Libro libro) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "INSERT INTO libros (titulo, autor, editorial, anio_publicacion, isbn) VALUES (?,?,?,?,?)";

        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setString(1, libro.getTitulo());
    		sentencia.setString(2, libro.getAutor());
    		sentencia.setString(3, libro.getEditorial());
    		sentencia.setInt(4, libro.getAnioPublicacion());
    		sentencia.setString(5, libro.getIsbn());
    		sentencia.execute();
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println(e);
    		return false;
    	} finally {
    		conexion=null;
    	}
    }
    
    public boolean LeerLibro (DefaultTableModel modelo) {
    	
    	try {
    		this.conexion = getConnection();
    		String sql = "SELECT * FROM libros";
        	ResultSet resultado = null;
    		
        	PreparedStatement sentencia = conexion.prepareStatement(sql);
        	
        	
    		
    		sentencia = conexion.prepareStatement(sql);
    		resultado = sentencia.executeQuery();
    		
    		modelo.setRowCount(0);
    		
    		//metodo while para recorrer y recuperar los datos de las columnas id y nombre
    		while(resultado.next()) {
    			int id = resultado.getInt("id");
    			String titulo = resultado.getString("titulo");
    			String autor = resultado.getString("autor");
    			String editorial = resultado.getString("editorial");
    			int anio_publicacion = resultado.getInt("anio_publicacion");
    			String isbn = resultado.getString("isbn");
    			
    			Object[] fila = {id, titulo, autor, editorial, anio_publicacion, isbn};
    			//Se agrega la fila creada al DefaultTableModel
    			modelo.addRow(fila);
    		}
    		return true;
    		
    	} catch (SQLException e) {
    		System.err.println(e);
    		return false;
    	
    	} finally {
    		conexion=null;
    	}
    	
    }
    
    
    public void ModificarLibro (Libro libro) {
    	
    	 try {
             this.conexion = getConnection();
             String sql = "UPDATE libros SET id=?,titulo=?,autor=?,editorial=?,anio_publicacion=?,isbn=? WHERE id=? ";
             PreparedStatement sentencia = conexion.prepareStatement(sql);

             sentencia.setInt(1,libro.getId());
             sentencia.setString(2, libro.getTitulo());
             sentencia.setString(3, libro.getAutor());
             sentencia.setString(4, libro.getEditorial());
             sentencia.setInt(5, libro.getAnioPublicacion());
             sentencia.setString(6, libro.getIsbn());
             sentencia.setInt(7, libro.getId());

             sentencia.execute();
        
             // Cierra el statement
             sentencia.close();

         } catch (SQLException e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "¡el registro no se ha actualizado correctamente!" + e.getErrorCode());
         } finally {
             closeConnection();
         }
    }
    

    public boolean EliminarLibro (Libro libro) {
    	
    	try {
    		this.conexion = getConnection();
        	String sql = "DELETE FROM libros WHERE id = ?";
        	
        	PreparedStatement sentencia = conexion.prepareStatement(sql);
    		
    		sentencia = conexion.prepareStatement(sql);
    		sentencia.setInt(1, libro.getId());
    		
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
    
    public void TraerContenidoLibro (Libro libro){
    	try {
            this.conexion = getConnection();
            String sql = "SELECT * FROM libros WHERE id = ?";
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, libro.getId());
            ResultSet resultado = sentencia.executeQuery();

            if(resultado.next()) {
                libro.setId(Integer.parseInt(resultado.getString("id")));
                libro.setTitulo(resultado.getString("titulo"));
                libro.setAutor(resultado.getString("autor"));
                libro.setEditorial(resultado.getString("editorial"));
                libro.setAnioPublicacion(Integer.parseInt(resultado.getString("anio_publicacion")));
                libro.setIsbn(resultado.getString("isbn"));
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
}}


































