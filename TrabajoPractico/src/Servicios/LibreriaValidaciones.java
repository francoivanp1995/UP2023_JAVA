package Servicios;

import Datos.CursoClase;
import Datos.ImplementacionValidacionCamposCurso;
import Datos.ImplementacionValidacionCamposUsuario;
import Datos.ImplementacionValidarLongitudTextoMax;
import Datos.ImplementacionValidarLongitudTextoMin;
import Datos.ImplementacionValidarTextoVacio;
import Datos.ImplementacionValidarValorNegativo;
import Datos.ImplementacionValidarValorPositivo;
import Datos.UsuarioBase;
import Datos.ValidationCursoException;
import Datos.UsuarioAlumno;
import Datos.ValidationNumeroException;
import Datos.ValidationTextoException;
import Datos.ValidationUsuarioException;

public class LibreriaValidaciones {
	
	private ImplementacionValidarLongitudTextoMax longTextoMax;
	private ImplementacionValidarLongitudTextoMin longTextoMin;
	private ImplementacionValidarTextoVacio textoVacio;
	private ImplementacionValidarValorPositivo valorPositivo;
	private ImplementacionValidarValorNegativo valorNegativo;
	private ImplementacionValidacionCamposUsuario validaCamposUsuario;
	private ImplementacionValidacionCamposCurso validaCamposCurso;
	
	
	public LibreriaValidaciones() {
		this.longTextoMax = new ImplementacionValidarLongitudTextoMax();
		this.longTextoMin = new ImplementacionValidarLongitudTextoMin();
		this.textoVacio = new ImplementacionValidarTextoVacio();
		this.valorPositivo = new ImplementacionValidarValorPositivo();
		this.valorNegativo = new ImplementacionValidarValorNegativo();
		this.validaCamposUsuario = new ImplementacionValidacionCamposUsuario();
	}
	
	public void validarLongitudTextoMax(String texto, int max)throws ValidationTextoException {
		longTextoMax.validarLongitudTexto(texto, max);
	}
	
	public void validarLongitudTextoMin(String texto, int min) throws ValidationTextoException {
		longTextoMin.validarLongitudTexto(texto, min);
	}
	
	public void validarTextoVacio(String texto) throws ValidationTextoException {
		textoVacio.validarTextoVacio(texto);
	}
	
	public void validarValorPositivo(int num) throws ValidationNumeroException {
        valorPositivo.validarValorPositivo(num);
    }
	
	public void validarValorNegativo(int num) throws ValidationNumeroException {
        valorNegativo.validarValorNegativo(num);
    }
	
	public boolean validarUsuario(UsuarioAlumno usuario) throws ValidationUsuarioException {
		return (validaCamposUsuario.validaCamposUsuario(usuario));
		}
	
	public boolean validarCurso(CursoClase curso)  throws ValidationCursoException {
		return (validaCamposCurso.validaCamposCurso(curso));
	}
}
