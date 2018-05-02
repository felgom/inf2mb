package br.senai.sp.jandira.app;

import br.senai.sp.jandira.layout.Tela;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class App {

	public static void main(String[] args) {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		Tela layout = new Tela();
		
	}

}
