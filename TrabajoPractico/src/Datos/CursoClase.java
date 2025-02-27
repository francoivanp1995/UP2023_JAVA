package Datos;

public class CursoClase {

    private String nombreCurso;
    private String descripcionCurso;
    private int precioCurso;
    private int cupoMaximoCurso;
    private int parametroAprobacionCurso;
    private int anotados;
    private int recaudacion;
    private float calificacionFinal;

    public CursoClase() {}

    public CursoClase(String nombreCurso, String descripcionCurso, int precioCurso, int cupoMaximoCurso, int parametroAprobacionCurso) {
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.precioCurso = precioCurso;
        this.cupoMaximoCurso = cupoMaximoCurso;
        this.parametroAprobacionCurso = parametroAprobacionCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public int getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(int precioCurso) {
        this.precioCurso = precioCurso;
    }

    public int getCupoMaximoCurso() {
        return cupoMaximoCurso;
    }

    public void setCupoMaximoCurso(int cupoMaximoCurso) {
        this.cupoMaximoCurso = cupoMaximoCurso;
    }

    public int getParametroAprobacionCurso() {
        return parametroAprobacionCurso;
    }

    public void setParametroAprobacionCurso(int parametroAprobacionCurso) {
        this.parametroAprobacionCurso = parametroAprobacionCurso;
    }

    public int getAnotados() {
        return anotados;
    }

    public int getRecaudacion() {
        return recaudacion;
    }
    
    public void setAnotados(int anotados) {
        this.anotados = anotados;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void establecerCalificacionFinal(float calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }
}
