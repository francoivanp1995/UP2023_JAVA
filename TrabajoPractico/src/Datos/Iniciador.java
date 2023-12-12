package Datos;

import Presentacion.PanelManager;

public class Iniciador {

	private PanelManager manager;
	
	public void iniciarManager() {
		manager = new PanelManager();
		manager.armarManager();
		manager.mostrarInicioPanel();
	}
	
	public void showFrame() {
		manager.showFrame();
	}
	
}
