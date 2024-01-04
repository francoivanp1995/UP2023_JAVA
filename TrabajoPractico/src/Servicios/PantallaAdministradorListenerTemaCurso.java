package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Presentacion.PanelAdministradorUsuario;
import Presentacion.PanelManager;

public class PantallaAdministradorListenerTemaCurso implements ActionListener {

	protected PanelAdministradorUsuario pantallaAdministrador;
	protected PanelManager panelManager;

	public PantallaAdministradorListenerTemaCurso(PanelAdministradorUsuario pantallaAdministrador, PanelManager panelManager) {
        this.panelManager = panelManager;
        this.pantallaAdministrador = pantallaAdministrador;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pantallaAdministrador.getcursoCrearBoton()) {
            panelManager.mostrarPantallaCrearCurso();
	} else if(e.getSource() == pantallaAdministrador.getCursoModificarBoton()) {
		panelManager.mostarPantallaModificarCurso();
	} else if (e.getSource() == pantallaAdministrador.getCursoEliminarBoton()) {
		panelManager.mostrarPantallaEliminarCurso();
	} else if (e.getSource() == pantallaAdministrador.getCursoReporteBoton()) {
		panelManager.mostrarPantallaReporteCurso();
	}
}
}
