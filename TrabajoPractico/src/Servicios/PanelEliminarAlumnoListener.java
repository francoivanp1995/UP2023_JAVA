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
			usuario = new UsuarioAlumno();
			UsuarioAlumnoServicio usuarioAlumnoServicio = new UsuarioAlumnoServicio();
			usuario = panelEliminarAlumno.obtenerUsuarioIngresadoEnPanel();
			encontrado = usuarioAlumnoServicio.buscarUsuario(usuario);
			manejarResultadoBusqueda();
		} 
	}
	
//Es mejor crear un metodo para manejar el resultado de la busqueda? Ese metodo no lo he implementado en crearAlumnoListener y actualizarAlumnoListener.
	
	private void manejarResultadoBusqueda() {
		
        if (encontrado) {
            // TODO Si se encontró el usuario, habilitar el botón de editar
//            panelModificarAlumno.getEditarBoton().setEnabled(true);
            JOptionPane.showMessageDialog(panelEliminarAlumno, "Alumno encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            int resultado = JOptionPane.showConfirmDialog(panelEliminarAlumno, "Desea eliminar al usuario?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                UsuarioAlumnoServicio usuarioAlumnoServicio = new UsuarioAlumnoServicio();
                usuarioAlumnoServicio.eliminarUsuario(usuario);
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

