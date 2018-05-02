package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;

	public FrmAgenda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/Imagem.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 523);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBounds(0, 0, 584, 104);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulodaTela = new JLabel("  Agenda");
		lblTitulodaTela.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/Imagem.png")));
		lblTitulodaTela.setFont(new Font("Myriad Pro Light", Font.PLAIN, 32));
		lblTitulodaTela.setBounds(34, 11, 184, 82);
		painelTitulo.add(lblTitulodaTela);
		
		JLabel lblData = new JLabel("New label");
		lblData.setBounds(382, 43, 171, 28);
		
		Date dataAtual = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		
		lblData.setText(df.format(dataAtual));
		
		painelTitulo.add(lblData);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painelTabela.setBounds(10, 115, 564, 246);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		montarTabela();
		
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelBotoes.setBounds(10, 370, 564, 103);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato("NOVO");
				contato.setVisible(true);
			}
		});
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setToolTipText("Adicionar Contato");
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/botao.png")));
		btnNovo.setBounds(25, 31, 89, 33);
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				abrirJanela("EDITAR");
			
			}
		});
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setToolTipText("Editar Contato");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/editar.png")));
		btnEditar.setBounds(124, 31, 89, 33);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanela("EXCLUIR");
				
			}
		});
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/fechar.png")));
		btnExcluir.setBounds(223, 31, 89, 33);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(Color.WHITE);
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/excluir.png")));
		btnSair.setBounds(447, 31, 89, 33);
		painelBotoes.add(btnSair);
		
	}
	public void montarTabela(){
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 544, 213);
		painelTabela.add(scrollTabela);
		
		
		tabelaContatos = new JTable();
		/*Passo 01 - Definir o modelo para a tabela*/
		DefaultTableModel modeloTabela = new DefaultTableModel();
		
		// Passo 02- Definir o Identificador de cada coluna da tabela
		String[] nomesColunas = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		// Passo 03 - Recuperar os dados do banco de dados, guardando esses dados em um ArrayList
		ContatoDAO contatoDAO = new ContatoDAO();
		ArrayList<Contato> contatos = new ArrayList<>();
		contatos = contatoDAO.getContatos();
		//Passo 04 - Criar todas as linha que irão compor o JTable
		Object[] linha = new Object[3];
		for(Contato contato : contatos){
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		
		tabelaContatos.setModel(modeloTabela);
		

		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollTabela.setViewportView(tabelaContatos);
	}
	public void abrirJanela(String operacao){
		try{
			int linha;
			linha = tabelaContatos.getSelectedRow();
			
			int id;
			
			id = (int) tabelaContatos.getValueAt(linha, 0);
			ContatoDAO contatoDAO= new ContatoDAO();
			Contato contato = contatoDAO.getContato(id);
			
			FrmContato frmContato = new FrmContato(operacao);
			frmContato.setTxtID(String.valueOf(contato.getId()));
			frmContato.setTxtNome(contato.getNome());
			frmContato.setTxtDtNasc(contato.getDtNasc());
			frmContato.setTxtEmail(contato.getEmail());
			frmContato.setTxtEndereco(contato.getEndereco());
			frmContato.setTxtTelefone(contato.getTelefone());
			frmContato.setTxtCelular(contato.getCelular());
			frmContato.setCbSexo(contato.getSexo());

			
			
			frmContato.setVisible(true);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Por favor, selecione um contato!", "Atenção", JOptionPane.ERROR_MESSAGE);
		}
	}
}
