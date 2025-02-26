package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelEditarCamposAlumno;
import Presentacion.PanelManager;
import Presentacion.PanelModificarAlumno;

public class PanelModificarAlumnoListener implements ActionListener{

	private PanelModificarAlumno panelModificarAlumno;
	private PanelManager panelManager;
	private UsuarioAlumno usuario;
	private UsuarioDAO dao;
	private Boolean encontrado;
	
	public PanelModificarAlumnoListener(PanelModificarAlumno panelModificarAlumno, PanelManager panelManager) {
		this.panelModificarAlumno = panelModificarAlumno;
		this.panelManager = panelManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panelModificarAlumno.getConsultarBoton()) {
			//Todo llamar a método que va a consultar la base de datos.
			//Si encuentra el usuario, habilita el boton editar. Si no lo encuentra, debe enviar mensaje al usuario.
			dao = new UsuarioDAOH2Impl();
			usuario = new UsuarioAlumno();
			usuario = panelModificarAlumno.obtenerUsuarioIngresadoEnPanel();
			encontrado = dao.buscarUsuario(usuario);
			manejarResultadoBusqueda();
		}
		else if(e.getSource() == panelModificarAlumno.getEditarBoton()) {
			
		} else if (e.getSource() == panelModificarAlumno.getCancelarBoton()) {
			panelManager.mostrarPantallaAdministrador();
		}
	}
	
	private void manejarResultadoBusqueda() {
        if (encontrado) {
            JOptionPane.showMessageDialog(panelModificarAlumno, "Alumno encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            panelManager.mostrarPantallaEditarCamposAlumno();
            panelModificarAlumno.limpiarPanel();
            
        } else {
        	JOptionPane.showMessageDialog(panelModificarAlumno, "Alumno no encontrado", "Mensaje", JOptionPane.WARNING_MESSAGE);
        	panelModificarAlumno.limpiarPanel();
        }
    }

}
