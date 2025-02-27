package Presentacion;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.BotoneraPanel;
import Datos.CursoClase;
import Servicios.PanelEliminarCursoListener;

public class PanelEliminarCurso extends JPanel {

    protected PanelManager panelManager;
    protected JLabel nombreCursoLabel;
    protected JTextField nombreCursoCampo;
    private JButton eliminarBoton;
    private JButton cancelarBoton;
    private BotoneraPanel botoneraPanel;
    private JPanel nombreCursoPanel;

    public PanelEliminarCurso(PanelManager panelManager) {
        this.panelManager = panelManager;
        initComponents();
        setupLayout();
        addActionListeners();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nombreCursoPanel = new JPanel();
        nombreCursoPanel.setLayout(new GridLayout(1, 2));
        nombreCursoLabel = new JLabel("Nombre");
        nombreCursoCampo = new JTextField();
        nombreCursoPanel = createLabeledField(nombreCursoLabel, nombreCursoCampo);
        nombreCursoPanel.add(nombreCursoLabel);
        nombreCursoPanel.add(nombreCursoCampo);

        eliminarBoton = new JButton("Eliminar");
        eliminarBoton.addActionListener(new PanelEliminarCursoListener(this, panelManager));
        cancelarBoton = new JButton("Cancelar");
        cancelarBoton.addActionListener(new PanelEliminarCursoListener(this, panelManager));

        botoneraPanel = new BotoneraPanel(panelManager);
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(7));
        add(nombreCursoPanel);
        add(botoneraPanel);
    }

    private void addActionListeners() {
        botoneraPanel.getOkBtn().addActionListener(new PanelEliminarCursoListener(this, panelManager));
        botoneraPanel.getCancelBtn().addActionListener(new PanelEliminarCursoListener(this, panelManager));
    }

    private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(3));
        panel.add(textField);
        return panel;
    }

    public CursoClase obtenerCursoIngresadoEnPanel() {
    	CursoClase curso = new CursoClase();
    	try {
    		curso.setNombreCurso(nombreCursoCampo.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return curso;
    }

    public void limpiarPanel() {
        nombreCursoCampo.setText("");
    }

    public BotoneraPanel getBotoneraPanel() {
        return botoneraPanel;
    }
}
