package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Presentacion.PanelAdministradorUsuario;
import Presentacion.PanelManager;

public class PantallaAdministradorListenerTemaCurso implements ActionListener {

	PanelAdministradorUsuario pantallaAdministrador;
	PanelManager panelManager;
	
	public PantallaAdministradorListenerTemaCurso(PanelAdministradorUsuario pantallaAdministrador, PanelManager panelManager) {
        this.pantallaAdministrador = pantallaAdministrador;
        this.panelManager = panelManager;
//        pantallaAdministrador.getAlumnoCrearBoton().addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == pantallaAdministrador.getAlumnoCrearBoton()) {
//            panelManager.mostrarPantallaCrearAlumno();
//	} else if(e.getSource() == pantallaAdministrador.getAlumnoModificarBoton()) {
//		panelManager.mostrarPantallaModificarAlumno();
//	} else if (e.getSource() == pantallaAdministrador.getAlumnoEliminarBoton()) {
//		panelManager.mostrarPantallaEliminarAlumno();
//	}
}
}
