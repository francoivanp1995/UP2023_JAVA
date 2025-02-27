package Presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
    private JTable cursoTable;
    private CursoTableModel tableModel;
    private List<CursoClase> listaCursos;
    

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

        // Inicializar el modelo de la tabla
        tableModel = new CursoTableModel();
        cursoTable = new JTable(tableModel);

        // Añadir los componentes al panel
        add(titleLabel);
        add(generarReporteButton);
        add(cancelarButton);
        add(new JScrollPane(cursoTable)); // Añadir la tabla dentro de un JScrollPane
    }

    private void setupLayout() {
        // Puedes configurar aquí el layout del panel si es necesario
    }

    private void addActionListeners() {
        // ActionListener para el botón de generar reporte
        generarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simplemente cierra el panel
                cerrarPanel();
            }
        });
    }

    private void generarReporte() {
        // Suponemos que listaCursos ha sido llenada con los datos correspondientes
        if (listaCursos != null && !listaCursos.isEmpty()) {
            tableModel.setContenido(listaCursos);
        } else {
            // Mostrar un mensaje si no hay datos para mostrar
            JOptionPane.showMessageDialog(this, "No hay datos para generar el reporte.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cerrarPanel() {
        setVisible(false);
        panelManager.mostrarPantallaAdministrador();
    }

    // Método para establecer la lista de cursos desde fuera del panel
    public void setListaCursos(List<CursoClase> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
