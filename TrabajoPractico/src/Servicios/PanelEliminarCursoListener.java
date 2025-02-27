package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.CursoClase;
import Datos.ValidationTextoException;
import Presentacion.PanelEliminarCurso;
import Presentacion.PanelManager;

public class PanelEliminarCursoListener implements ActionListener {

    PanelEliminarCurso panelEliminarCurso;
    PanelManager panelManager;
    LibreriaValidaciones libreriaValidaciones;
    Boolean verificado; 
    CursoServicio eliminarCursoServicio;
    
    public PanelEliminarCursoListener(PanelEliminarCurso panelEliminarCurso, PanelManager panelManager) {
        super();
        this.panelEliminarCurso = panelEliminarCurso;
        this.panelManager = panelManager;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelEliminarCurso.getBotoneraPanel().getOkBtn()) {
            procesarEliminacionCurso();
        } else if (e.getSource() == panelEliminarCurso.getBotoneraPanel().getCancelBtn()) {
            cancelarEliminacionCurso();
        }
    }

    private void procesarEliminacionCurso() {
        try {
            CursoClase curso = panelEliminarCurso.obtenerCursoIngresadoEnPanel();
            libreriaValidaciones = new LibreriaValidaciones();
            boolean nombreCursoValido = false;
            try {
                libreriaValidaciones.validarTextoVacio(curso.getNombreCurso());
                nombreCursoValido = true;
            } catch (ValidationTextoException ex) {
                ex.printStackTrace();
            }
            
            if (nombreCursoValido) {
                eliminarCursoServicio = new CursoServicio();
                eliminarCursoServicio.eliminarCurso(curso);
                JOptionPane.showMessageDialog(panelEliminarCurso, "Curso eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                panelEliminarCurso.limpiarPanel();
            } else {
                JOptionPane.showMessageDialog(panelEliminarCurso, "El nombre del curso es inválido", "Atención", JOptionPane.WARNING_MESSAGE);
                panelEliminarCurso.limpiarPanel();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(panelEliminarCurso, "Error al eliminar el curso", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarEliminacionCurso() {
        try {
            panelManager.mostrarPantallaAdministrador();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
