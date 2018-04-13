package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmContato extends JFrame {

	private JPanel PainelPrincipal;
	private JTextField textId;
	private JTextField textNomeContato;
	private JTextField textEmail;
	private JTextField textCelular;
	private JTextField textTelefone;
	private JTextField textDataNasc;

	
	public FrmContato(String operacao) {
		setBounds(100, 100, 318, 471);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBackground(Color.WHITE);
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PainelPrincipal);
		PainelPrincipal.setLayout(null);
		
		JPanel PainelTitulo = new JPanel();
		PainelTitulo.setBackground(Color.WHITE);
		PainelTitulo.setBounds(10, 11, 290, 59);
		PainelPrincipal.add(PainelTitulo);
		PainelTitulo.setLayout(null);
		
		JLabel lblNovoContato = new JLabel(" Contato");
		lblNovoContato.setBackground(Color.WHITE);
		lblNovoContato.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/Contato48.png")));
		lblNovoContato.setFont(new Font("Arial", Font.BOLD, 32));
		lblNovoContato.setBounds(0, 0, 290, 59);
		PainelTitulo.add(lblNovoContato);
		
		JLabel lblNovo = new JLabel(operacao);
		lblNovo.setForeground(Color.GREEN);
		lblNovo.setFont(new Font("Arial", Font.BOLD, 15));
		lblNovo.setBounds(202, 11, 78, 18);
		PainelTitulo.add(lblNovo);
		
		JPanel PainelDados = new JPanel();
		PainelDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		PainelDados.setBounds(10, 81, 290, 275);
		PainelPrincipal.add(PainelDados);
		PainelDados.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 26, 46, 14);
		PainelDados.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(117, 23, 46, 20);
		PainelDados.add(textId);
		textId.setColumns(10);
		
		JLabel lblNomeDoContato = new JLabel("Nome do Contato:");
		lblNomeDoContato.setBounds(10, 57, 96, 14);
		PainelDados.add(lblNomeDoContato);
		
		textNomeContato = new JTextField();
		textNomeContato.setBounds(117, 54, 159, 20);
		PainelDados.add(textNomeContato);
		textNomeContato.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 86, 46, 14);
		PainelDados.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(117, 83, 159, 20);
		PainelDados.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 114, 46, 14);
		PainelDados.add(lblCelular);
		
		textCelular = new JTextField();
		textCelular.setBounds(117, 111, 159, 20);
		PainelDados.add(textCelular);
		textCelular.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(117, 142, 159, 20);
		PainelDados.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 145, 46, 14);
		PainelDados.add(lblTelefone);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 176, 99, 14);
		PainelDados.add(lblDataDeNascimento);
		
		textDataNasc = new JTextField();
		textDataNasc.setBounds(117, 173, 159, 20);
		PainelDados.add(textDataNasc);
		textDataNasc.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 201, 62, 14);
		PainelDados.add(lblEndereo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 204, 163, 60);
		PainelDados.add(scrollPane);
		
		JTextArea textEndreco = new JTextArea();
		textEndreco.setWrapStyleWord(true);
		textEndreco.setLineWrap(true);
		scrollPane.setViewportView(textEndreco);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(173, 26, 46, 14);
		PainelDados.add(lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M ", "F"}));
		comboBox.setBounds(214, 23, 46, 20);
		PainelDados.add(comboBox);
		
		JPanel bntBotoes = new JPanel();
		bntBotoes.setBounds(10, 356, 290, 54);
		PainelPrincipal.add(bntBotoes);
		bntBotoes.setLayout(null);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/salvar24.png")));
		btnSair.setToolTipText("Salva contato");
		btnSair.setBounds(10, 11, 47, 32);
		bntBotoes.add(btnSair);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/sair24.png")));
		btnNewButton_1.setToolTipText("Sair");
		btnNewButton_1.setBounds(233, 11, 47, 32);
		bntBotoes.add(btnNewButton_1);
	}
}
