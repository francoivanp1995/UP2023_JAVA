package Servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Presentacion.PanelInicioSesion;
import Presentacion.PanelManager;
import Servicios.ServicioAutenticacion;

public class PanelInicioSesionListener implements ActionListener {

    private PanelInicioSesion panelInicioSesion;
    private PanelManager panelManager;

    public PanelInicioSesionListener(PanelInicioSesion panelInicioSesion, PanelManager panelManager) {
        this.panelInicioSesion = panelInicioSesion;
        this.panelManager = panelManager;

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    procesarInicioSesion();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // No se necesita implementación
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No se necesita implementación
            }
        };

        panelInicioSesion.getLoginCampo().addKeyListener(keyListener);
        panelInicioSesion.getPasswordCampo().addKeyListener(keyListener);


        panelInicioSesion.getBotoneraPanel().getOkBtn().addActionListener(this);
        panelInicioSesion.getBotoneraPanel().getCancelBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelInicioSesion.getBotoneraPanel().getOkBtn()) {
            procesarInicioSesion();
        } else if (e.getSource() == panelInicioSesion.getBotoneraPanel().getCancelBtn()) {
            System.exit(0);
        }
    }

    private void procesarInicioSesion() {
        try {
            String login = panelInicioSesion.getLoginCampo().getText();
            String password = new String(panelInicioSesion.getPasswordCampo().getPassword());
            if (login.isEmpty() || password.isEmpty()) {
                panelInicioSesion.setMensajeValidacion("Ingrese un usuario y contraseña válidos.");
                return; 
            }
            ServicioAutenticacion autenticacion = new ServicioAutenticacion();
            autenticacion.validarCampo(login);
            autenticacion.validarCampo(password);
            boolean autenticado = autenticacion.autenticar(login, password);
            if (autenticado) {
                String tipo = autenticacion.getTipoUsuario(login, password);
                switch (tipo) {
                    case "adm":
                        panelManager.mostrarPantallaAdministrador();
                        break;
                    case "prof":
                        panelManager.mostrarPantallaProfesor();
                        break;
                    case "alm":
                        panelManager.mostrarPantallaAlumno();
                        break;
                }
            } else {
                panelInicioSesion.setMensajeValidacion("Usuario o contraseña incorrectos.");
                panelInicioSesion.limpiarPanel();
            }
        } catch (Exception e) {
            panelInicioSesion.setMensajeValidacion("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
