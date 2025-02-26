package Presentacion;

import javax.swing.JFrame;

import Datos.PanelProfesorUsuario;

public class PanelManager {
    
    private JFrame frame;
    private PanelInicioSesion pantallaInicioSesion;
    private PanelAdministradorUsuario pantallaAdministrador;
    private PanelProfesorUsuario pantallaProfesor;
    private PanelAlumnoUsuario pantallaAlumno;
    private PanelCrearAlumno panelCrearAlumno;
    private PanelEliminarAlumno panelEliminarAlumno;
    private PanelModificarAlumno panelModificarAlumno;
    private PanelEditarCamposAlumno panelEditarCamposAlumno;
    private PanelCrearCurso panelCrearCurso;
    private PanelModificarCurso panelModificarCurso;
    private PanelEliminarCurso panelEliminarCurso;
    private PanelReporteCurso panelReporteCurso;

    public PanelManager() {
        armarManager();
        inicializarPaneles();
    }

    public void armarManager() {
        try {
            frame = new JFrame("SISTEMA DE ALUMNOS");
            frame.setBounds(100, 100, 500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inicializarPaneles() {
        try {
            pantallaInicioSesion = new PanelInicioSesion(this);
            pantallaAdministrador = new PanelAdministradorUsuario(this);
            pantallaProfesor = new PanelProfesorUsuario(this);
            pantallaAlumno = new PanelAlumnoUsuario(this);

            panelCrearAlumno = new PanelCrearAlumno(this);
            panelEliminarAlumno = new PanelEliminarAlumno(this);
            panelModificarAlumno = new PanelModificarAlumno(this);
            panelEditarCamposAlumno = new PanelEditarCamposAlumno(this);

            panelCrearCurso = new PanelCrearCurso(this);
            panelModificarCurso = new PanelModificarCurso(this);
            panelEliminarCurso = new PanelEliminarCurso(this);
            panelReporteCurso = new PanelReporteCurso(this);

            frame.add(pantallaInicioSesion);
            frame.add(pantallaAdministrador);
            frame.add(pantallaProfesor);
            frame.add(pantallaAlumno);
            frame.add(panelCrearAlumno);
            frame.add(panelEliminarAlumno);
            frame.add(panelModificarAlumno);
            frame.add(panelCrearCurso);
            frame.add(panelEliminarCurso);
            frame.add(panelModificarAlumno);
            frame.add(panelReporteCurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void mostrarInicioPanel() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(pantallaInicioSesion);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaAdministrador() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(pantallaAdministrador);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaProfesor() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(pantallaProfesor);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaAlumno() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(pantallaAlumno);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaCrearAlumno() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelCrearAlumno);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaModificarAlumno() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelModificarAlumno);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaEliminarAlumno() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelEliminarAlumno);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaEditarCamposAlumno() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelEditarCamposAlumno);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaCrearCurso() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelCrearCurso);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostarPantallaModificarCurso() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelModificarCurso);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaEliminarCurso() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelEliminarCurso);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPantallaReporteCurso() {
        try {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(panelReporteCurso);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
