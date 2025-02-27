package Presentacion;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Datos.BotoneraPanel;
import Datos.CursoClase;
import Servicios.PanelModificarCursoListener;

public class PanelModificarCurso extends JPanel {

    protected PanelManager panelManager;
    protected JLabel nombreCursoLabel;
    protected JTextField nombreCursoCampo;
    protected JLabel precioCursoLabel;
    protected JTextField precioCursoCampo;
    protected JLabel cupoCursoLabel;
    protected JTextField cupoCursoCampo;
    protected JLabel descripcionCursoLabel;
    protected JTextField descripcionCursoCampo;
    protected JLabel parametroAprobacionCursoLabel;
    protected JTextField parametroAprobacionCursoCampo;

    private BotoneraPanel botoneraPanel;
    private JButton modificarBoton;
    private JButton cancelarBoton;
    private JButton buscarBoton;

    public PanelModificarCurso(PanelManager panelManager) {
        this.panelManager = panelManager;

        initComponents();
        setupLayout();
        addActionListeners();
    }

    private void initComponents() {
        nombreCursoLabel = new JLabel("Nombre");
        nombreCursoCampo = new JTextField();

        precioCursoLabel = new JLabel("Precio");
        precioCursoCampo = new JTextField();

        descripcionCursoLabel = new JLabel("Descripcion");
        descripcionCursoCampo = new JTextField();

        cupoCursoLabel = new JLabel("Cupo");
        cupoCursoCampo = new JTextField();

        parametroAprobacionCursoLabel = new JLabel("Parametro aprobacion");
        parametroAprobacionCursoCampo = new JTextField();

        botoneraPanel = new BotoneraPanel(panelManager);

        buscarBoton = new JButton("Buscar");
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel nombreCursoPanel = createLabeledField(nombreCursoLabel, nombreCursoCampo);
        JPanel precioCursoPanel = createLabeledField(precioCursoLabel, precioCursoCampo);
        JPanel descripcionCursoPanel = createLabeledField(descripcionCursoLabel, descripcionCursoCampo);
        JPanel cupoCursoPanel = createLabeledField(cupoCursoLabel, cupoCursoCampo);
        JPanel parametroAprobacionCursoPanel = createLabeledField(parametroAprobacionCursoLabel,
                parametroAprobacionCursoCampo);

        add(Box.createVerticalStrut(7));
        add(nombreCursoPanel);
        add(precioCursoPanel);
        add(descripcionCursoPanel);
        add(cupoCursoPanel);
        add(parametroAprobacionCursoPanel);
        add(buscarBoton);
        add(botoneraPanel);
    }

    private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(3));
        panel.add(textField);
        return panel;
    }

    private void addActionListeners() {
    	PanelModificarCursoListener listenerCurso = new PanelModificarCursoListener(this, panelManager);
        buscarBoton.addActionListener(new PanelModificarCursoListener(this, panelManager));
        botoneraPanel.getOkBtn().addActionListener(new PanelModificarCursoListener(this, panelManager));
        botoneraPanel.getCancelBtn().addActionListener(new PanelModificarCursoListener(this, panelManager));
    }

    public BotoneraPanel getBotoneraPanel() {
        return botoneraPanel;
    }

    public CursoClase obtenerCursoIngresadoEnPanel() {
        CursoClase curso = new CursoClase();
        curso.setNombreCurso(nombreCursoCampo.getText().trim());
        curso.setDescripcionCurso(descripcionCursoCampo.getText().trim());

        try {

            if (!precioCursoCampo.getText().trim().isEmpty()) {
                int precioCurso = Integer.parseInt(precioCursoCampo.getText().trim());
                curso.setPrecioCurso(precioCurso);
            } else {
                curso.setPrecioCurso(0);
            }

            if (!cupoCursoCampo.getText().trim().isEmpty()) {
                int cupoMaxCurso = Integer.parseInt(cupoCursoCampo.getText().trim());
                curso.setCupoMaximoCurso(cupoMaxCurso);
            } else {
                curso.setCupoMaximoCurso(0);
            }
            
            if (!parametroAprobacionCursoCampo.getText().trim().isEmpty()) {
                int parametroAprobacionCurso = Integer.parseInt(parametroAprobacionCursoCampo.getText().trim());
                curso.setParametroAprobacionCurso(parametroAprobacionCurso);
            } else {
                curso.setParametroAprobacionCurso(0);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para precio, cupo y parámetro de aprobación.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return curso;
    }

    public void limpiarPanel() {
        nombreCursoCampo.setText("");
        descripcionCursoCampo.setText("");
        parametroAprobacionCursoCampo.setText("");
        precioCursoCampo.setText("");
        cupoCursoCampo.setText("");
    }

    public JButton getBuscarBoton() {
    	return buscarBoton;
    }
    
    public void setNombreCurso(String nombre) {
        nombreCursoCampo.setText(nombre);
    }

    public void setPrecioCurso(int precio) {
        precioCursoCampo.setText(String.valueOf(precio));
    }

    public void setDescripcionCurso(String descripcion) {
        descripcionCursoCampo.setText(descripcion);
    }

    public void setCupoCurso(int cupo) {
        cupoCursoCampo.setText(String.valueOf(cupo));
    }

    public void setParametroAprobacionCurso(int parametro) {
        parametroAprobacionCursoCampo.setText(String.valueOf(parametro));
    }
}
