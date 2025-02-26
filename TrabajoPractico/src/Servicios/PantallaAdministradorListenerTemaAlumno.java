package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelInicioSesion;
import Presentacion.PanelManager;
import Presentacion.PanelAdministradorUsuario;

public class PantallaAdministradorListenerTemaAlumno implements ActionListener{
	
	PanelAdministradorUsuario pantallaAdministrador;
	PanelManager panelManager;
	
	public PantallaAdministradorListenerTemaAlumno(PanelAdministradorUsuario pantallaAdministrador, PanelManager panelManager) {
        this.pantallaAdministrador = pantallaAdministrador;
        this.panelManager = panelManager;
        pantallaAdministrador.getAlumnoCrearBoton().addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pantallaAdministrador.getAlumnoCrearBoton()) {
            panelManager.mostrarPantallaCrearAlumno();
	} else if(e.getSource() == pantallaAdministrador.getAlumnoModificarBoton()) {
		panelManager.mostrarPantallaModificarAlumno();
	} else if (e.getSource() == pantallaAdministrador.getAlumnoEliminarBoton()) {
		panelManager.mostrarPantallaEliminarAlumno();
	}

}

}