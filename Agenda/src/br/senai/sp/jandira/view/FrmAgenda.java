package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	JScrollPane scrollTabela;
	JPanel painelTabela;

	public FrmAgenda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/angenda48.png")));
		setTitle("Agenda de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 384);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 434, 66);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel(" Agenda");
		lblTituloTela.setForeground(Color.BLACK);
		lblTituloTela.setBackground(Color.WHITE);
		lblTituloTela.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/angenda48.png")));
		lblTituloTela.setFont(new Font("Arial", Font.BOLD, 32));
		lblTituloTela.setBounds(10, 0, 414, 66);
		painelTitulo.add(lblTituloTela);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 204)));
		painelTabela.setBounds(10, 64, 434, 197);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(10, 272, 434, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.setToolTipText("Adicionar contato");
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/novo32.png")));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContato contato = new FrmContato("NOVO");
				contato.setVisible(true);
			}
		});
		btnNovo.setBounds(10, 11, 53, 44);
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContato contato = new FrmContato ("EDITAR");
				contato.setVisible(true);
			}
		});
		btnEditar.setToolTipText("Editar contato selecionado");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/edit32.png")));
		btnEditar.setBounds(73, 11, 53, 44);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato ("EXCLUIR");
				contato.setVisible(true);
				
			}
		});
		btnExcluir.setToolTipText("Excluir contato selecionado");
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/delete32.png")));
		btnExcluir.setBounds(136, 11, 53, 44);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair da aplica\u00E7\u00E3o");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setBounds(317, 11, 89, 44);
		painelBotoes.add(btnSair);
		
		criarTabela();
		
		/*
		tabelaContatos = new JTable();
		tabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOME", "E-MAIL"
			}
		));
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(45);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(261);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(308);
		scrollTabela.setViewportView(tabelaContatos);
		
		*/
	}
	
	public void criarTabela(){
		DefaultTableModel modeloTabela = new DefaultTableModel();
		Object[] linhas = new Object[3];
		
		int i = 0;
		while(i < 5){
			linhas [0] = "1";
			linhas [1] = "Maria";
			linhas [2] = "maria@teste.com.br";
			modeloTabela.addRow(linhas);
			i++;
		}
		String[] titulo = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(titulo);
		
		tabelaContatos.setModel(modeloTabela);
		scrollTabela.setViewportView(tabelaContatos);
		
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 24, 414, 145);
		painelTabela.add(scrollTabela);
	}
}