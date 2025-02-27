package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.PanelOpcionesAlumnoProfesor;
import Presentacion.PanelManager;

public class UsuarioProfesorListener implements ActionListener {

    protected PanelManager panelManager;
    protected PanelOpcionesAlumnoProfesor botonesUsuario;

    public UsuarioProfesorListener(PanelManager panelManager, PanelOpcionesAlumnoProfesor botonesUsuario) {
        this.panelManager = panelManager;
        this.botonesUsuario = botonesUsuario;
        // Asignar este listener a los botones de opciones del usuario
        asignarListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aquí manejar las acciones de los botones según corresponda
        if (e.getSource() == botonesUsuario.getAsistenciaBoton()) {
            // Implementar la lógica para el botón de Asistencia
            // Por ejemplo, abrir una ventana para gestionar la asistencia del alumno
        } else if (e.getSource() == botonesUsuario.getCalificacionesBoton()) {
            // Implementar la lógica para el botón de Calificaciones
            // Por ejemplo, abrir una ventana para gestionar las calificaciones del alumno
        } else if (e.getSource() == botonesUsuario.getSeguimientoProgresoBoton()) {
            // Implementar la lógica para el botón de Seguimiento de Progreso
            // Por ejemplo, abrir una ventana para gestionar el seguimiento de progreso del alumno
        } else if (e.getSource() == botonesUsuario.getComunicacionBoton()) {
            // Implementar la lógica para el botón de Comunicación
            // Por ejemplo, abrir una ventana para gestionar la comunicación con el alumno
        }
    }

    // Método para asignar este listener a los botones de opciones del usuario
    private void asignarListeners() {
        botonesUsuario.getAsistenciaBoton().addActionListener(this);
        botonesUsuario.getCalificacionesBoton().addActionListener(this);
        botonesUsuario.getSeguimientoProgresoBoton().addActionListener(this);
        botonesUsuario.getComunicacionBoton().addActionListener(this);
    }
}
