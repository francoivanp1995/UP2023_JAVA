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
import Servicios.PanelModificarCursoListener;

public class PanelModificarCurso extends JPanel{
    
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
    }
    
    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel nombreCursoPanel = createLabeledField(nombreCursoLabel, nombreCursoCampo);
        JPanel precioCursoPanel = createLabeledField(precioCursoLabel, precioCursoCampo);
        JPanel descripcionCursoPanel = createLabeledField(descripcionCursoLabel, descripcionCursoCampo);
        JPanel cupoCursoPanel = createLabeledField(cupoCursoLabel, cupoCursoCampo);
        JPanel parametroAprobacionCursoPanel = createLabeledField(parametroAprobacionCursoLabel, parametroAprobacionCursoCampo);
        
        add(Box.createVerticalStrut(7));
        add(nombreCursoPanel);
        add(precioCursoPanel);
        add(descripcionCursoPanel);
        add(cupoCursoPanel);
        add(parametroAprobacionCursoPanel);
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
        botoneraPanel.getOkBtn().addActionListener(new PanelModificarCursoListener(this, panelManager));
        botoneraPanel.getCancelBtn().addActionListener(new PanelModificarCursoListener(this, panelManager));
    }
    
    public BotoneraPanel getBotoneraPanel() {
        return botoneraPanel;
    }
    
    public CursoClase obtenerCursoIngresadoEnPanel() {
        CursoClase curso = new CursoClase();
        curso.setNombreCurso(nombreCursoCampo.getText());
        curso.setDescripcionCurso(descripcionCursoCampo.getText());
     // Convertir valores de JTextField a int
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
