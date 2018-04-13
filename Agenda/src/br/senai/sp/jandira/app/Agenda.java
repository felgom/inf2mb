package br.senai.sp.jandira.app;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.view.FrmAgenda;
import br.senai.sp.jandira.view.FrmContato;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class Agenda {

	public static void main(String[] args) {
		
		
		/*
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
		*/
		FrmAgenda agenda = new FrmAgenda();
		agenda.setVisible(true);
		
		
		
	}

}
