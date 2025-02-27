package Servicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Datos.CursoClase;
import Presentacion.PanelAlumnoUsuario;

public class PanelAlumnoUsuarioListener {
    private PanelAlumnoUsuario panel;

    public PanelAlumnoUsuarioListener(PanelAlumnoUsuario panel) {
        this.panel = panel;
    }

    public void mostrarCursosDisponibles(JScrollPane scrollPane) {
        CursoServicio cursoServicio = new CursoServicio();
        ArrayList<CursoClase> cursosDisponibles = (ArrayList<CursoClase>) cursoServicio.listaTodosLosCursos();

        JPanel panelCursosDisponibles = new JPanel();
        panelCursosDisponibles.setLayout(new GridLayout(0, 1));

        for (CursoClase curso : cursosDisponibles) {
            JButton botonCurso = new JButton(curso.getNombreCurso());
            botonCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CursoClase cursoSeleccionado = cursoServicio.muestraCurso(curso.getNombreCurso());
                    if (cursoSeleccionado != null) {
//                        System.out.println("BUSCARME EN PANELALUMNOUSUARIO CLASE");
                    } else {
//                        JOptionPane.showMessageDialog(null, "No se encontró el curso seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            panelCursosDisponibles.add(botonCurso);
        }

        scrollPane.setViewportView(panelCursosDisponibles);
    }
}