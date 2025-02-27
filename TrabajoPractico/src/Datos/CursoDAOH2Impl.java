package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOH2Impl implements CursoDAO {

    @Override
    public void crearCurso(CursoClase unCurso) {
        Connection connection = DBManager.connect();
        String sql = "INSERT INTO CURSO (Nombre, Descripcion, Precio, CupoMaximo, ParametroAprobacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, unCurso.getNombreCurso());
            preparedStatement.setString(2, unCurso.getDescripcionCurso());
            preparedStatement.setInt(3, unCurso.getPrecioCurso());
            preparedStatement.setInt(4, unCurso.getCupoMaximoCurso());
            preparedStatement.setInt(5, unCurso.getParametroAprobacionCurso());
            
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

    @Override
    public void eliminarCurso(CursoClase unCurso) {
        Connection connection = DBManager.connect();
        String sql = "DELETE FROM CURSO WHERE Nombre = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, unCurso.getNombreCurso());
            
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

    @Override
    public void actualizarCurso(CursoClase unCurso) {
        Connection connection = DBManager.connect();
        String sql = "UPDATE CURSO SET Descripcion = ?, Precio = ?, CupoMaximo = ?, ParametroAprobacion = ? WHERE Nombre = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, unCurso.getDescripcionCurso());
            preparedStatement.setInt(2, unCurso.getPrecioCurso());
            preparedStatement.setInt(3, unCurso.getCupoMaximoCurso());
            preparedStatement.setInt(4, unCurso.getParametroAprobacionCurso());
            preparedStatement.setString(5, unCurso.getNombreCurso());
            
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

    @Override
    public CursoClase muestraCurso(String nombreCurso) {
        Connection connection = DBManager.connect();
        String sql = "SELECT * FROM CURSO WHERE Nombre = ?";
        CursoClase curso = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreCurso);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                curso = new CursoClase(
                    resultSet.getString("Nombre"),
                    resultSet.getString("Descripcion"),
                    resultSet.getInt("Precio"),
                    resultSet.getInt("CupoMaximo"),
                    resultSet.getInt("ParametroAprobacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        
        return curso;
    }

    @Override
    public List<CursoClase> listaTodosLosCursos() {
        Connection connection = DBManager.connect();
        String sql = "SELECT * FROM CURSO";
        List<CursoClase> cursos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                CursoClase curso = new CursoClase(
                    resultSet.getString("Nombre"),
                    resultSet.getString("Descripcion"),
                    resultSet.getInt("Precio"),
                    resultSet.getInt("CupoMaximo"),
                    resultSet.getInt("ParametroAprobacion")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        
        return cursos;
    }

    @Override
    public boolean buscarCurso(String nombreCurso) {
        Connection connection = DBManager.connect();
        String sql = "SELECT * FROM CURSO WHERE Nombre = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreCurso); // Aquí se corrige
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
    

}
