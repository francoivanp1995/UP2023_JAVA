package Presentacion;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Datos.BotoneraPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import Servicios.PanelInicioSesionListener;

public class PanelInicioSesion extends JPanel {

    private JPanel tituloPanel;
    private JLabel nombreTitulo;

    private JPanel formularioCamposPanel;
    private JPanel camposPanel;
    private JLabel loginLabel;
    private JTextField loginCampo;
    private JLabel passwordLabel;
    private JPasswordField passwordCampo;

    private JPanel mensajeValidacionPanel;
    private JLabel mensajeValidacionLabel;

    private BotoneraPanel botoneraPanel;

    private PanelManager panelManager;

    public PanelInicioSesion(PanelManager panelManager) {
        this.panelManager = panelManager;
        iniciarComponentes();
        setupLayout();
        addActionListeners();
    }

    private void iniciarComponentes() {
        tituloPanel = new JPanel();
        nombreTitulo = new JLabel("SISTEMA DE ALUMNOS");
        tituloPanel.add(nombreTitulo);

        formularioCamposPanel = new JPanel();
        camposPanel = new JPanel(new GridLayout(2, 2));
        loginLabel = new JLabel("Login");
        loginCampo = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordCampo = new JPasswordField();
        camposPanel.add(loginLabel);
        camposPanel.add(loginCampo);
        camposPanel.add(passwordLabel);
        camposPanel.add(passwordCampo);
        formularioCamposPanel.add(camposPanel);

        botoneraPanel = new BotoneraPanel(panelManager);

        mensajeValidacionPanel = new JPanel();
        mensajeValidacionLabel = new JLabel();
        mensajeValidacionPanel.add(mensajeValidacionLabel);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(tituloPanel, BorderLayout.NORTH);
        add(formularioCamposPanel, BorderLayout.CENTER);
        add(botoneraPanel, BorderLayout.SOUTH);
        add(mensajeValidacionPanel, BorderLayout.EAST);
    }

    private void addActionListeners() {
        botoneraPanel.getOkBtn().addActionListener(new PanelInicioSesionListener(this, panelManager));
        botoneraPanel.getCancelBtn().addActionListener(new PanelInicioSesionListener(this, panelManager));
    }

    public JTextField getLoginCampo() {
        return loginCampo;
    }

    public JPasswordField getPasswordCampo() {
        return passwordCampo;
    }

    public void setMensajeValidacion(String mensaje) {
        mensajeValidacionLabel.setText(mensaje);
    }

    public void limpiarPanel() {
        loginCampo.setText("");
        passwordCampo.setText("");
    }
    
    public BotoneraPanel getBotoneraPanel() {
        return botoneraPanel;
    }

}
