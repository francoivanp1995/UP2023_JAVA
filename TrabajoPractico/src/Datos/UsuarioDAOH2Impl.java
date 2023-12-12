package Datos;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioDAOH2Impl implements UsuarioDAO{

	@Override
	public void crearUsuario(UsuarioAlumno unUsuario) {
		String dni = unUsuario.getDni();
		String nombre = unUsuario.getNombre();
		String apellido = unUsuario.getApellido();
		String nombreDeUsuario = unUsuario.getNombreDeUsuario();
		String email = unUsuario.getEmail();
		String contrasenia = unUsuario.getContrasenia();
		String tipo = unUsuario.getTipo();
		
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO usuarios (dni, nombre, apellido, nombreDeUsuario, email, contrasenia) VALUES ('" + dni + "', '" + nombre + "', '" + apellido + "', '" + nombreDeUsuario + "', '" + email + "', '" + contrasenia + "')";
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				c.rollback();
			} catch (SQLException e1) {
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

	@Override
	public void eliminarUsuario(UsuarioAlumno unUsuario) {
		String dni = unUsuario.getDni();
		String sql = "DELETE FROM usuarios WHERE dni = '" + dni + "'";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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

	@Override
	public void actualizarUsuario(UsuarioAlumno unUsuario) {
		String dni = unUsuario.getDni();
		String nombre = unUsuario.getNombre();
		String apellido = unUsuario.getApellido();
		String nombreDeUsuario = unUsuario.getNombreDeUsuario();
		String email = unUsuario.getEmail();
		String contrasenia = unUsuario.getContrasenia();
		
		String sql = "UPDATE usuarios SET nombre = '" + nombre + "', apellido = '" + apellido + "', email = '" + email + "', contrasenia = '" + contrasenia + "', nombreDeUsuario = '" + nombreDeUsuario + "' WHERE dni = '" + dni + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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

	@Override
	public UsuarioAlumno muestraUsuario(String dni) {
		String sql = "SELECT * FROM usuarios WHERE dni = '" + dni + "'";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String contrasenia = rs.getString("contrasenia");
			}
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
		return null;
	}

	@Override
	public List<UsuarioAlumno> listaTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscarUsuario(UsuarioAlumno usuario) {
		String apellido = usuario.getApellido();
		String dni = usuario.getDni();
		String sql = "SELECT * FROM usuarios WHERE apellido = ? AND dni = ?";
		Connection c = DBManager.connect();
		try {
			 PreparedStatement ps = c.prepareStatement(sql);
		        ps.setString(1, apellido);
		        ps.setString(2, dni);

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            return true;
		}
		}catch (SQLException e) {
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
		return false;
	}

}
