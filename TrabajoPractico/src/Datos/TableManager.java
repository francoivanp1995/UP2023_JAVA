package Datos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableManager {
	
	public void crearTablaUsuarios() {
		
		//Todo poner DNI como PKey.
		Connection c = DBManager.connect();
		String sql = "CREATE TABLE USUARIOS ( dni VARCHAR(256), nombre VARCHAR(256), apellido VARCHAR(256), nombreDeUsuario VARCHAR(256), email VARCHAR (256), contrasenia VARCHAR(25), tipo VARCHAR (5))";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void eliminarTablaUsuarios() {
		Connection c = DBManager.connect();
		String sql = "DROP TABLE USUARIOS";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public boolean tablaUsuariosExiste() {
		Connection connection = DBManager.connect();
	    try {
	        DatabaseMetaData metaData = connection.getMetaData();
	        ResultSet result = metaData.getTables(null, null, "USUARIOS", null);
	        return result.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	 public void insertarUsuarioAdmin() {
	        Connection connection = DBManager.connect();
	        String sql = "INSERT INTO USUARIOS (dni, nombre, apellido, nombreDeUsuario, email, contrasenia, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, "");
	            preparedStatement.setString(2, "admin");
	            preparedStatement.setString(3, "admin");
	            preparedStatement.setString(4, "admin");
	            preparedStatement.setString(5, "admin@example.com");
	            preparedStatement.setString(6, "admin");
	            preparedStatement.setString(7, "ADMIN");

	            preparedStatement.executeUpdate();
	            connection.commit();
	        } catch (SQLException e) {
	            try {
	                connection.rollback();
	                e.printStackTrace();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e2) {
	                e2.printStackTrace();
	            }
	        }
	    }
	 
	 public boolean usuarioAdminExiste() {
	        Connection connection = DBManager.connect();
	        try {
	            String sql = "SELECT * FROM USUARIOS WHERE nombreDeUsuario = 'admin'";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ResultSet result = preparedStatement.executeQuery();
	            return result.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public void prerequisitosTabla() {
	        if (!tablaUsuariosExiste()) {
	            crearTablaUsuarios();
	        }

	        if (!usuarioAdminExiste()) {
	            insertarUsuarioAdmin();
	        }
	    }
}
