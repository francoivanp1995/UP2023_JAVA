package Presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Datos.CursoClase;
import Datos.CursoTableModel;

public class PanelReporteCurso extends JPanel {

    protected PanelManager panelManager;
    private JButton generarReporteButton;
    private JButton cancelarButton;
    private List<CursoClase> listaCursos; // Supongamos que tienes una lista de cursos

    public PanelReporteCurso(PanelManager panelManager) {
        this.panelManager = panelManager;
        initComponents();
        setupLayout();
        addActionListeners();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Reporte de Cursos");
        generarReporteButton = new JButton("Generar Reporte");
        cancelarButton = new JButton("Cancelar");
        
        // Añadir los componentes al panel
        add(titleLabel);
        add(generarReporteButton);
        add(cancelarButton);
    }

    private void setupLayout() {
        // Puedes configurar aquí el layout del panel si es necesario
    }

    private void addActionListeners() {
        // ActionListener para el botón de generar reporte
        generarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes generar y mostrar el reporte
                generarReporte();
            }
        });

        // ActionListener para el botón de cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simplemente cierra el panel
                cerrarPanel();
            }
        });
    }

    private void generarReporte() {
        // Crear una instancia de CursoTableModel con la lista de cursos
        CursoTableModel tableModel = new CursoTableModel();

        // Luego puedes usar esta instancia para mostrar los datos en una tabla o en otro componente visual
        // Por ejemplo, podrías crear una tabla y establecer el modelo de tabla como el CursoTableModel
        // O cualquier otro método de visualización que prefieras
    }

    private void cerrarPanel() {
        setVisible(false);
    }
}
