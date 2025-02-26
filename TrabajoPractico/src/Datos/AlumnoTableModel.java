package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.table.AbstractTableModel;

public class AlumnoTableModel extends AbstractTableModel{
	
	private static final int COLUMNA_DNI = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_APELLIDO = 2;
	private static final int COLUMNA_EMAIL = 3;
	
	private String [] nombreColumnas = {"DNI", "NOMBRE", "APELLIDO", "EMAIL"};
	
	private Class [] tipoColumnas = {String.class, String.class, String.class, String.class};
	
	private List<UsuarioAlumno>contenido;
	
	public AlumnoTableModel() {
		contenido = new ArrayList<UsuarioAlumno>();
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
		UsuarioAlumno usuario = contenido.get(rowIndex);
		Object result = null;
		switch (columnIndex) {
		case COLUMNA_DNI: {
			result = usuario.getDni();
			break;
		}
		case COLUMNA_NOMBRE:  {
			result = usuario.getNombre();
			break;
		}
		case COLUMNA_APELLIDO: {
			result = usuario.getApellido();
			break;
		}
		case COLUMNA_EMAIL: {
			result = usuario.getEmail();
			break;
		}
		default:
			result = new String("");
		}
		return result;
	}
}
