package Servicios;

import Servicios.LibreriaValidaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.AutenticationUsuarioException;
import Datos.DBManager;
import Datos.UsuarioAlumno;
import Datos.ValidationTextoException;

public class ServicioAutenticacion {
	
	public boolean autenticar(String nombreDeUsuario, String contrasenia) throws AutenticationUsuarioException{
		
		Connection c = new DBManager().connect();
		String sql = "SELECT * FROM usuarios WHERE nombreDeUsuario = ? AND contrasenia = ?";
		try {
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setString(1, nombreDeUsuario);
        statement.setString(2, contrasenia);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            c.close();
            return true;
        }
        c.close();
        return false;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
    	try {
    		c.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			}
    	}
	}

	public void validarCampo(String campo) throws ValidationTextoException {
	    LibreriaValidaciones libreriaValidaciones = new LibreriaValidaciones();
	    libreriaValidaciones.validarTextoVacio(campo);
	}

	
	public String getTipoUsuario(String nombreDeUsuario, String contrasenia) {
		Connection c = new DBManager().connect();
		String sql = "SELECT * FROM usuarios WHERE nombreDeUsuario = ? AND contrasenia = ?";
		try {
			PreparedStatement statement = c.prepareStatement(sql);
	        statement.setString(1, nombreDeUsuario);
	        statement.setString(2, contrasenia);
	        ResultSet result = statement.executeQuery();
	        if (result.next()) {
	            String tipoUsuario = result.getString("TIPO");
	            c.close();
	            return tipoUsuario;
	        }
        c.close();
        return null;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
    	try {
    		c.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			}
    	}
	}
}
