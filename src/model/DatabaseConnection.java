package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
       private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
        private static final String USER = "root";
        private static final String PASSWORD = "123456789";

        private static Connection conexion;

        public DatabaseConnection() {} 

        public static Connection getConnection() {
            if (conexion == null) {
                try {
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);

                } catch (SQLException e) {
                    // manejo de excepciones
                    throw new RuntimeException("Error al conectar a la base de datos", e);
                }
            }
            return conexion;
        }

        public static void closeConnection() {
            if (conexion != null) {
                try {
                    conexion.close();

                } catch (SQLException e) {
                    // manejo de excepciones
                    throw new RuntimeException("Error al cerrar la conexiÃ³n a la base de datos", e);
                } finally {
                    conexion = null; // aqui se limpia la conexion para evitar reutilizacion incorrecta
                }
            }
        }

}