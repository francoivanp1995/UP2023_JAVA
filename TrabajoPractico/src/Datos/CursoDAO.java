package Datos;

import java.util.List;

public interface CursoDAO {

	void crearCurso(CursoClase unCurso);
	void eliminarCurso(CursoClase unCurso);
	void actualizarCurso(CursoClase unCurso);
	CursoClase muestraCurso(String nombreCurso);
	List<CursoClase> listaTodosLosCursos();
	boolean buscarCurso(String unCurso);
}
