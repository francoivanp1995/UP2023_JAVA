package Servicios;

import java.util.List;

import Datos.CursoClase;
import Datos.CursoDAO;
import Datos.CursoDAOH2Impl;

public class CursoServicio {

public CursoServicio() {
		
	}
	
	public void crearCurso(CursoClase curso) {
		CursoDAO dao = new CursoDAOH2Impl();
		dao.crearCurso(curso);
	}
	
	public void actualizarCurso(CursoClase curso) {
		CursoDAO dao = new CursoDAOH2Impl();
		dao.actualizarCurso(curso);
	}
	
	public void eliminarCurso(CursoClase curso) {
		CursoDAO dao = new CursoDAOH2Impl();
		dao.eliminarCurso(curso);
	}
	
	public boolean buscarNombreCurso(String cursoNombre) {
		CursoDAO dao = new CursoDAOH2Impl();
		return (dao.buscarCurso(cursoNombre));
	}
	
	public CursoClase muestraCurso(String nombreCurso) {
		CursoDAO dao = new CursoDAOH2Impl();
		return (dao.muestraCurso(nombreCurso));
	}

	public List<CursoClase> listaTodosLosCursos() {
		CursoDAO dao = new CursoDAOH2Impl();
		return (dao.listaTodosLosCursos());
	}
}
