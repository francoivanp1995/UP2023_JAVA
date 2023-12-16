package Presentacion;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.h2.jdbc.JdbcBatchUpdateException;

import Datos.UsuarioAlumno;
import Servicios.LibreriaValidaciones;
import Servicios.PanelCrearAlumnoListener;

public class PanelCrearAlumno extends JPanel{
	
	
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JTextField dniCampo; 
	private JLabel nombreDeUsuarioLabel;
	private JLabel emailLabel;
	private JLabel contraseniaLabel;
	private JLabel tipoLabel;
	private JTextField tipoCampo;
	private JTextField nombreCampo;
	private JTextField apellidoCampo;
	private JTextField nombreDeUsuarioCampo;
	private JTextField emailCampo;
	private JPasswordField contraseniaCampo;

	private JButton crearBoton;
	private JButton cancelarBoton;
	
	@SuppressWarnings("deprecation")
	
	public PanelCrearAlumno(PanelManager panelManager) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nombreLabel = new JLabel("Nombre");
        nombreCampo = new JTextField();
        JPanel nombrePanel = createLabeledField(nombreLabel, nombreCampo);
        

        apellidoLabel = new JLabel("Apellido");
        apellidoCampo = new JTextField();
        JPanel apellidoPanel = createLabeledField(apellidoLabel, apellidoCampo);

        dniLabel = new JLabel("DNI");
        dniCampo = new JTextField();
        JPanel dniPanel = createLabeledField(dniLabel, dniCampo);
        
        nombreDeUsuarioLabel = new JLabel("Nombre de usuario");
        nombreDeUsuarioCampo = new JTextField();
        JPanel usuarioPanel = createLabeledField(nombreDeUsuarioLabel, nombreDeUsuarioCampo);

        emailLabel = new JLabel("Email");
        emailCampo = new JTextField();
        JPanel emailPanel = createLabeledField(emailLabel, emailCampo);

        contraseniaLabel = new JLabel("Contrasenia");
        contraseniaCampo = new JPasswordField();
        JPanel contraseniaPanel = createLabeledField(contraseniaLabel, contraseniaCampo);

        tipoLabel = new JLabel("Tipo");
        tipoCampo = new JTextField();
        JPanel tipoPanel = createLabeledField(tipoLabel, tipoCampo);
        
        crearBoton = new JButton("Crear");
        crearBoton.addActionListener(new PanelCrearAlumnoListener(this,panelManager));
        cancelarBoton = new JButton("Cancelar");
        cancelarBoton.addActionListener(new PanelCrearAlumnoListener(this, panelManager));
        JPanel botoneraPanel = new JPanel();
        botoneraPanel.setLayout(new FlowLayout());
        botoneraPanel.add(crearBoton);
        botoneraPanel.add(cancelarBoton);
        

        add(Box.createVerticalStrut(10)); 
        add(nombrePanel);
        add(apellidoPanel);
        add(dniPanel);
        add(usuarioPanel);
        add(emailPanel);
        add(contraseniaPanel);
        add(tipoPanel);
        add(botoneraPanel);
	}
	
	public UsuarioAlumno obtenerUsuarioIngresadoEnPanel() {
        UsuarioAlumno usuario = new UsuarioAlumno();
        usuario.setDni(dniCampo.getText());
        usuario.setNombre(nombreCampo.getText());
        usuario.setApellido(apellidoCampo.getText());
        usuario.setNombreDeUsuario(nombreDeUsuarioCampo.getText());
        usuario.setEmail(emailCampo.getText());
        usuario.setContrasenia(contraseniaCampo.getText());
        usuario.setTipo(tipoCampo.getText());
        return usuario;
    }
	
	private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(textField);
        return panel;
	}
	
	public JButton getCrearBoton() {
		return crearBoton;
	}
	
	public JButton getCancelarBoton() {
		return cancelarBoton;
	}
	
	public void limpiarPanel() {
		dniCampo.setText("");
	    nombreCampo.setText("");
	    apellidoCampo.setText("");
	    nombreDeUsuarioCampo.setText("");
	    emailCampo.setText("");
	    contraseniaCampo.setText("");
	}
}
