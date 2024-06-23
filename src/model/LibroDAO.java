package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroDAO extends DatabaseConnection{
    private Connection conexion;

    public LibroDAO() {
       
    }
	   // Método para cargar los productos desde la base de datos y mostrarlos en la tabla
 public void mostrarLibro(DefaultTableModel modelo) {
     try {
    	 modelo.setRowCount(0);
    	 this.conexion = getConnection();
         String sql = "SELECT * FROM libros";
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();

         // Llena la tabla con los datos de la base de datos
         while (resultado.next()) {//resultado.next trae una fila completa de la tabla 
             int id = resultado.getInt("id");
             String titulo = resultado.getString("titulo");
             String autor = resultado.getString("autor");
             String editorial = resultado.getString("editorial");
             int anio_publicacion = resultado.getInt("anio_publicacion");
             String isbn = resultado.getString("isbn");
             
             modelo.addRow(new Object[]{id,titulo,autor,editorial,anio_publicacion,isbn});
         }

         // Cierra el statement y el result set
         sentencia.close();
         resultado.close();

     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Ha ocurrido un problema al intentar mostrar la tabla: "+ e.getMessage());
     }
     finally{
     	closeConnection();
     }
 }
	public void modificarLibro(Libro libro) {

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
			JOptionPane.showMessageDialog(null, "¡registro actualizado correctamente!");
			// Cierra el statement
			sentencia.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "¡el registro no se ha actualizado correctamente!" + e.getErrorCode());
		} finally {
			closeConnection();
		}
	}

	public void traerContenidoLibro(Libro libro) {
		try {
			this.conexion = getConnection();
			String sql = "SELECT * FROM libros WHERE id=?";
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
	}
	
	public void eliminarLibro(Libro libro) {
		this.conexion=getConnection();
		String sql = " DELETE FROM libros WHERE id=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, libro.getId());
			sentencia.execute();
			JOptionPane.showMessageDialog(null,"El registro se eliminó correctamente.");
			
			sentencia.close();
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Ha ocurrido un problema al intentar eliminar el registro: " + e.getMessage());
		} finally {
			closeConnection();
		}
		
		}
	
    public void crearLibro (Libro libro) {
        try {
        	this.conexion=getConnection();
            String sql = "INSERT INTO libros (titulo, autor, editorial, anio_publicacion, isbn) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, libro.getTitulo());
            sentencia.setString(2, libro.getAutor());
            sentencia.setString(3, libro.getEditorial());
            sentencia.setInt(4, libro.getAnioPublicacion());
            sentencia.setString(5, libro.getIsbn());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Libro registrado correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar registrar libro: " + e.getMessage());
        }finally {
			closeConnection();
		}
    }

}
