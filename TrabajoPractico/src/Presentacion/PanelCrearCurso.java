package Presentacion;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCrearCurso extends JPanel{
	
	protected PanelManager panelManager;
	protected JLabel nombreCursoLabel;
	protected JTextField nombreCursoCampo;
	protected JLabel precioCursoLabel;
	protected JTextField precioCursoCampo;
	
	public PanelCrearCurso(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		setLayout(new GridLayout(2,1));
		
		JPanel nombreCursoPanel = new JPanel();
		nombreCursoPanel.setLayout(new GridLayout(1,2));
		nombreCursoLabel = new JLabel("Nombre");
        nombreCursoCampo = new JTextField();
        nombreCursoPanel=  createLabeledField(nombreCursoLabel, nombreCursoCampo);
//        nombreCursoPanel.add(nombreCursoLabel);
//        nombreCursoPanel.add(nombreCursoCampo);
        
        JPanel precioCursoPanel = new JPanel();
        precioCursoPanel.setLayout(new GridLayout(1,2));
        precioCursoLabel = new JLabel("Precio");
        precioCursoCampo = new JTextField();
        precioCursoPanel = createLabeledField(precioCursoLabel, precioCursoCampo);
//        precioCursoPanel.add(precioCursoLabel);
//        precioCursoPanel.add(precioCursoCampo);
//        
        add(nombreCursoPanel);
        add(precioCursoPanel);
        
        
	}
	
	private JPanel createLabeledField(JLabel label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(3));
        panel.add(textField);
        return panel;
	}
	
}
