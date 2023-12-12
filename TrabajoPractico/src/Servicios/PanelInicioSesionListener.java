package Servicios;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.PanelInicioSesion;
import Presentacion.PanelManager;
import Servicios.ServicioAutenticacion;


public class PanelInicioSesionListener implements ActionListener {

    private PanelInicioSesion panelInicioSesion;
    private ServicioAutenticacion autenticacion;
    private PanelManager panelManager;

    public PanelInicioSesionListener(PanelInicioSesion panelInicioSesion, PanelManager panelManager) {
        this.panelInicioSesion = panelInicioSesion;
        this.panelManager = panelManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelInicioSesion.getAceptarBoton()) {
        	try {
        		String login = panelInicioSesion.getLoginCampo().getText();
                String password = new String(panelInicioSesion.getPasswordCampo().getPassword());
                autenticacion = new ServicioAutenticacion();
                autenticacion.validarCampo(login);
                autenticacion.validarCampo(password);
                boolean autenticado = autenticacion.autenticar(login, password);
                if (autenticado) {
                    panelManager.mostrarPantallaAdministrador();
                } else {
                	panelInicioSesion.setMensajeValidacion("Usuario o contrasenia incorrectos.");
                	panelInicioSesion.limpiarPanel();
                }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
            
        } else if(e.getSource() == panelInicioSesion.getCancelarBoton()) {
        	System.exit(0);
        } 
    }
    
    
    
}
