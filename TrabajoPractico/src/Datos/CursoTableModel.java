package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CursoTableModel extends AbstractTableModel {

    private static final int COLUMNA_NOMBRE = 0;
    private static final int COLUMNA_ANOTADOS = 1;
    private static final int COLUMNA_RECAUDACION = 2;

    private String[] nombreColumnas = {"Nombre Curso", "Anotados", "Recaudación"};
    private Class[] tipoColumnas = {String.class, Integer.class, Double.class};
    private List<CursoClase> contenido;

    public CursoTableModel() {
        contenido = new ArrayList<>();
    }

  
    @Override
    public int getRowCount() {
        return contenido.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    public String getColumnName(int col) {
        return nombreColumnas[col];
    }

    public Class getColumnClass(int col) {
        return tipoColumnas[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CursoClase curso = contenido.get(rowIndex);
        Object result = null;
        switch (columnIndex) {
            case COLUMNA_NOMBRE:
                result = curso.getNombreCurso();
                break;
            case COLUMNA_ANOTADOS:
                result = curso.getAnotados();
                break;
            case COLUMNA_RECAUDACION:
                result = curso.getRecaudacion();
                break;
            default:
                result = new String("");
        }
        return result;
    }
    
    public void setContenido(List<CursoClase> contenido) {
        this.contenido = contenido;
        fireTableDataChanged();
    }
}
