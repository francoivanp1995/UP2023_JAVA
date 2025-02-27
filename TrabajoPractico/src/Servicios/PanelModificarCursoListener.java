package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.CursoClase;
import Presentacion.PanelModificarCurso;
import Presentacion.PanelManager;

public class PanelModificarCursoListener implements ActionListener {

    private PanelModificarCurso panelModificarCurso;
    private PanelManager panelManager;
    private CursoClase cursoClase;
    private LibreriaValidaciones libreriaValidaciones;
    private CursoServicio cursoServicio;

    public PanelModificarCursoListener(PanelModificarCurso panelModificarCurso, PanelManager panelManager) {
        this.panelModificarCurso = panelModificarCurso;
        this.panelManager = panelManager;
        this.cursoServicio = new CursoServicio();
        this.libreriaValidaciones = new LibreriaValidaciones();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelModificarCurso.getBuscarBoton()) {
            buscarCurso();
        } else if (e.getSource() == panelModificarCurso.getBotoneraPanel().getOkBtn()) {
            procesarModificacionCurso();
        } else if (e.getSource() == panelModificarCurso.getBotoneraPanel().getCancelBtn()) {
            cancelarModificacionCurso();
        }
    }

    private void buscarCurso() {
    	boolean encontrado;
    	
        String nombreCurso =  panelModificarCurso.obtenerCursoIngresadoEnPanel().getNombreCurso();
        try {
			libreriaValidaciones = new LibreriaValidaciones();
			libreriaValidaciones.validarTextoVacio(nombreCurso);
			cursoServicio = new CursoServicio();
			encontrado = cursoServicio.buscarNombreCurso(nombreCurso);
			if(encontrado) {
				cursoClase = cursoServicio.muestraCurso(nombreCurso);
				panelModificarCurso.setNombreCurso(cursoClase.getNombreCurso());
	            panelModificarCurso.setPrecioCurso(cursoClase.getPrecioCurso());
	            panelModificarCurso.setDescripcionCurso(cursoClase.getDescripcionCurso());
	            panelModificarCurso.setCupoCurso(cursoClase.getCupoMaximoCurso());
	            panelModificarCurso.setParametroAprobacionCurso(cursoClase.getParametroAprobacionCurso());
			} else {
                JOptionPane.showMessageDialog(panelModificarCurso, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panelModificarCurso, "Error al buscar el curso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
		}
    }
    
    private void procesarModificacionCurso() {
        CursoClase cursoModificado = panelModificarCurso.obtenerCursoIngresadoEnPanel();

        try {

            cursoServicio.actualizarCurso(cursoModificado);

            JOptionPane.showMessageDialog(panelModificarCurso, "Curso modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            panelModificarCurso.limpiarPanel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panelModificarCurso, "Error al modificar curso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    private void cancelarModificacionCurso() {
        try {
        	panelModificarCurso.limpiarPanel();
            panelManager.mostrarPantallaAdministrador();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
