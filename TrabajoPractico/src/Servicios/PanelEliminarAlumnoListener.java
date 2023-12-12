package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.UsuarioAlumno;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelEliminarAlumno;
import Presentacion.PanelManager;

public class PanelEliminarAlumnoListener implements ActionListener{

	private PanelEliminarAlumno panelEliminarAlumno;
	private PanelManager panelManager;
	private UsuarioDAO dao;
	private UsuarioAlumno usuario;
	private Boolean encontrado;
	
	public PanelEliminarAlumnoListener(PanelEliminarAlumno panelEliminarAlumno, PanelManager panelManager) {
		this.panelEliminarAlumno = panelEliminarAlumno;
		this.panelManager = panelManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panelEliminarAlumno.getCancelarBoton()) {
			panelManager.mostrarPantallaAdministrador();
		} else if (e.getSource() == panelEliminarAlumno.getBuscarBoton()) {
			dao = new UsuarioDAOH2Impl();
			usuario = new UsuarioAlumno();
			usuario = panelEliminarAlumno.obtenerUsuarioIngresadoEnPanel();
			encontrado = dao.buscarUsuario(usuario);
			manejarResultadoBusqueda();
		} 
	}
	
	private void manejarResultadoBusqueda() {
        if (encontrado) {
            // TODO Si se encontró el usuario, habilitar el botón de editar
//            panelModificarAlumno.getEditarBoton().setEnabled(true);
            JOptionPane.showMessageDialog(panelEliminarAlumno, "Alumno encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            int resultado = JOptionPane.showConfirmDialog(panelEliminarAlumno, "Desea eliminar al usuario?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                dao.eliminarUsuario(usuario);
                JOptionPane.showMessageDialog(panelEliminarAlumno, "Alumno eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                panelEliminarAlumno.limpiarPanel();
                panelManager.mostrarPantallaEliminarAlumno();    
            }else if (resultado == JOptionPane.NO_OPTION) {
            	panelEliminarAlumno.limpiarPanel();
            	panelManager.mostrarPantallaEliminarAlumno();
                }
        
        }else {
        	JOptionPane.showMessageDialog(panelEliminarAlumno, "Alumno no encontrado", "Mensaje", JOptionPane.WARNING_MESSAGE);
        	panelEliminarAlumno.limpiarPanel();
        }
    
	}
	
}

