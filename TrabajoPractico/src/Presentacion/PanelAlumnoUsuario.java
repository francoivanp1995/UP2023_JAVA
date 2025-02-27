package Presentacion; 
import javax.swing.*;

import Servicios.CursoServicio;
import Servicios.PanelAlumnoUsuarioListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Datos.CursoClase;
import java.util.ArrayList;


public class PanelAlumnoUsuario extends JPanel {

    private PanelManager panelManager;

    public PanelAlumnoUsuario(PanelManager panelManager) {
        this.panelManager = panelManager;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel("Panel de Usuario");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelTitulo, BorderLayout.NORTH);

        JPanel panelCursosDisponibles = new JPanel();
        panelCursosDisponibles.setLayout(new BorderLayout());

        JLabel labelCursosDisponibles = new JLabel("Cursos Disponibles");
        labelCursosDisponibles.setFont(new Font("Arial", Font.BOLD, 14));
        labelCursosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursosDisponibles.add(labelCursosDisponibles, BorderLayout.NORTH);

        JPanel panelBotonesCursos = new JPanel();
        panelBotonesCursos.setLayout(new FlowLayout(FlowLayout.LEFT));

        JScrollPane scrollPaneCursosDisponibles = new JScrollPane();
        panelBotonesCursos.add(scrollPaneCursosDisponibles);

        panelCursosDisponibles.add(panelBotonesCursos, BorderLayout.CENTER);

        PanelAlumnoUsuarioListener listener = new PanelAlumnoUsuarioListener(this);
        listener.mostrarCursosDisponibles(scrollPaneCursosDisponibles);

        add(panelCursosDisponibles, BorderLayout.CENTER);

        // Panel para cursos inscritos
//        JPanel panelCursosInscritos = new JPanel();
//        panelCursosInscritos.setLayout(new BorderLayout());
//
//        JLabel labelCursosInscritos = new JLabel("Cursos Inscriptos");
//        labelCursosInscritos.setFont(new Font("Arial", Font.BOLD, 14));
//        labelCursosInscritos.setHorizontalAlignment(SwingConstants.CENTER);
//        panelCursosInscritos.add(labelCursosInscritos, BorderLayout.NORTH);

//        add(panelCursosInscritos, BorderLayout.SOUTH);
    }


//    private void inscribirAlumnoEnCurso(String curso) {
//        JOptionPane.showMessageDialog(this, "Has sido inscrito en el curso: " + curso, "Inscripción exitosa", JOptionPane.INFORMATION_MESSAGE);
//    }
}
