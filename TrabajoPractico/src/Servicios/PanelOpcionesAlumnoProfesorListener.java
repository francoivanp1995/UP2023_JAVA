package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Presentacion.PanelManager;

import Presentacion.PanelOpcionesAlumnoProfesor;

public class PanelOpcionesAlumnoProfesorListener implements ActionListener {

    private PanelOpcionesAlumnoProfesor panelOpcionesAlumnoProfesor;
    private PanelManager panelManager;

    public PanelOpcionesAlumnoProfesorListener(PanelOpcionesAlumnoProfesor panelOpcionesAlumnoProfesor, PanelManager panelManager) {
        this.panelOpcionesAlumnoProfesor = panelOpcionesAlumnoProfesor;
        this.panelManager = panelManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelOpcionesAlumnoProfesor.getCalificacionesBoton()) {
        	//Escribir logica para las calificaciones. Llamar a otro Panel?
        }
    }
}
