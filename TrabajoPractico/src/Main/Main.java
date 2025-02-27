package Main;

import Datos.Iniciador;
import Datos.DBManager;
import Datos.UsuarioDAO;
import Datos.UsuarioDAOH2Impl;
import Presentacion.PanelManager;
import Datos.TableManager;
import Datos.UsuarioAlumno;

public class Main {

	public static void main(String[] args) {

		try {
			TableManager tablaManager = new TableManager();
			tablaManager.prerequisitosTablas();
			Iniciador iniciador = new Iniciador();
			iniciador.iniciarManager();
			iniciador.showFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
