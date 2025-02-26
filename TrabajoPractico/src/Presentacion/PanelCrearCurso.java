package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Datos.BotoneraPanel;
import Datos.CursoClase;
import Servicios.PanelCrearCursoListener;
import Servicios.PanelInicioSesionListener;

public class PanelCrearCurso extends JPanel {

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

    private JPanel nombreCursoPanel;
    private JPanel precioCursoPanel;
    private JPanel descripcionCursoPanel;
    private JPanel cupoCursoPanel;
    private JPanel parametroAprobacionCursoPanel;

    public PanelCrearCurso(PanelManager panelManager) {
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

        precioCursoPanel = new JPanel();
        precioCursoPanel.setLayout(new GridLayout(1, 2));
        precioCursoLabel = new JLabel("Precio");
        precioCursoCampo = new JTextField();
        precioCursoPanel = createLabeledField(precioCursoLabel, precioCursoCampo);
        precioCursoPanel.add(precioCursoLabel);
        precioCursoPanel.add(precioCursoCampo);

        descripcionCursoPanel = new JPanel();
        descripcionCursoPanel.setLayout(new GridLayout(1, 2));
        descripcionCursoLabel = new JLabel("Descripcion");
        descripcionCursoCampo = new JTextField();
        descripcionCursoPanel = createLabeledField(descripcionCursoLabel, descripcionCursoCampo);
        descripcionCursoPanel.add(descripcionCursoLabel);
        descripcionCursoPanel.add(descripcionCursoCampo);

        cupoCursoPanel = new JPanel();
        cupoCursoPanel.setLayout(new GridLayout(1, 2));
        cupoCursoLabel = new JLabel("Cupo");
        cupoCursoCampo = new JTextField();
        cupoCursoPanel = createLabeledField(cupoCursoLabel, cupoCursoCampo);
        cupoCursoPanel.add(cupoCursoLabel);
        cupoCursoPanel.add(cupoCursoCampo);

        parametroAprobacionCursoPanel = new JPanel();
        parametroAprobacionCursoPanel.setLayout(new GridLayout(1, 2));
        parametroAprobacionCursoLabel = new JLabel("Parametro aprobacion");
        parametroAprobacionCursoCampo = new JTextField();
        parametroAprobacionCursoPanel = createLabeledField(parametroAprobacionCursoLabel, parametroAprobacionCursoCampo);
        parametroAprobacionCursoPanel.add(parametroAprobacionCursoLabel);
        parametroAprobacionCursoPanel.add(parametroAprobacionCursoCampo);

        botoneraPanel = new BotoneraPanel(panelManager);
    }

    private void setupLayout() {
    	
        setLayout(new GridLayout(6, 1));
        
        add(nombreCursoPanel);
        add(precioCursoPanel);
        add(descripcionCursoPanel);
        add(cupoCursoPanel);
        add(parametroAprobacionCursoPanel);
        add(botoneraPanel);
        
    }

    private void addActionListeners() {
        botoneraPanel.getOkBtn().addActionListener(new PanelCrearCursoListener(this, panelManager));
        botoneraPanel.getCancelBtn().addActionListener(new PanelCrearCursoListener(this, panelManager));
    }

    public BotoneraPanel getBotoneraPanel() {
        return botoneraPanel;
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
        curso.setNombreCurso(nombreCursoCampo.getText());
        curso.setDescripcionCurso(descripcionCursoCampo.getText());
        try {
            int precioCurso = Integer.parseInt(precioCursoCampo.getText());
            int cupoMaxCurso = Integer.parseInt(cupoCursoCampo.getText());
            curso.setPrecioCurso(precioCurso);
            curso.setCupoMaximoCurso(cupoMaxCurso);
        } catch (NumberFormatException e) {
            // Manejar el caso en que la entrada no sea un número válido
            // Aquí puedes mostrar un mensaje de error o tomar alguna otra acción apropiada
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
}
