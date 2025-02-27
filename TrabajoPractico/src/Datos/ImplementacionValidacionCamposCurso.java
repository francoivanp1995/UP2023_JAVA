
package Datos;

public class ImplementacionValidacionCamposCurso{

    private ImplementacionValidarTextoVacio implTextoVacio;

    public boolean validaCamposCurso(CursoClase curso) throws ValidationCursoException {
        try {
            implTextoVacio = new ImplementacionValidarTextoVacio();
            boolean nombreCursoValido = implTextoVacio.validarTextoVacio(curso.getNombreCurso());

            boolean descripcionCursoValido = implTextoVacio.validarTextoVacio(curso.getDescripcionCurso());

            boolean precioCursoValido = curso.getPrecioCurso() != 0;

            boolean cupoMaxCursoValido = curso.getCupoMaximoCurso() != 0;

            boolean parametroAprobacionCursoValido = curso.getParametroAprobacionCurso() != 0;

            return nombreCursoValido && descripcionCursoValido && precioCursoValido && cupoMaxCursoValido && parametroAprobacionCursoValido;

        } catch (ValidationTextoException e) {

            e.printStackTrace();
            return false;
        }
    }


}
