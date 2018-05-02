package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class FrmContato extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	//private JTextField txtDtNasc;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextArea txtEndereco;
	private JComboBox cbSexo;
	private JFormattedTextField txtDtNasc;
	

	public void setCbSexo(String cbSexo) {
		this.cbSexo.setSelectedItem(cbSexo);
	}

	public void setTxtID(String txtID) {
		this.txtID.setText(txtID);
	}
	
	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);
	}

	public void setTxtDtNasc(String txtDtNasc) {
		this.txtDtNasc.setText(txtDtNasc);
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	public void setTxtTelefone(String txtTelefone) {
		this.txtTelefone.setText(txtTelefone);
	}

	public void setTxtCelular(String txtCelular) {
		this.txtCelular.setText(txtCelular);
	}

	public void setTxtEndereco(String txtEndereco) {
		this.txtEndereco.setText(txtEndereco);
	}

	public FrmContato(String operacao) {
		setTitle("  ");
		setResizable(false);
		setBounds(100, 100, 483, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(135, 206, 250));
		painelTitulo.setBounds(0, 0, 479, 115);
		contentPane.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/contato.png")));
		lblContato.setFont(new Font("Myriad Pro Light", Font.PLAIN, 32));
		lblContato.setBounds(47, 11, 188, 81);
		painelTitulo.add(lblContato);
		
		JLabel lblStatus = new JLabel(operacao);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(128, 128, 0));
		lblStatus.setBackground(new Color(135, 206, 235));
		lblStatus.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblStatus.setBounds(343, 33, 96, 35);
		painelTitulo.add(lblStatus);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelPrincipal.setBounds(10, 126, 459, 364);
		contentPane.add(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		lblID.setBounds(43, 27, 46, 30);
		painelPrincipal.add(lblID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(43, 68, 46, 23);
		painelPrincipal.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(43, 148, 46, 23);
		painelPrincipal.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(43, 182, 57, 30);
		painelPrincipal.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(216, 182, 46, 30);
		painelPrincipal.add(lblCelular);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco.setBounds(43, 234, 57, 35);
		painelPrincipal.add(lblEndereco);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(43, 102, 120, 35);
		painelPrincipal.add(lblDataDeNascimento);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(74, 33, 86, 20);
		painelPrincipal.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(84, 70, 306, 20);
		painelPrincipal.add(txtNome);
		txtNome.setColumns(10);
		//Definir mascara da data
		MaskFormatter dateMask = null;
		try {
			dateMask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtDtNasc = new JFormattedTextField(dateMask);
		txtDtNasc.setBounds(162, 110, 120, 20);
		painelPrincipal.add(txtDtNasc);
		txtDtNasc.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(99, 150, 233, 20);
		painelPrincipal.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(99, 188, 107, 20);
		painelPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(283, 188, 107, 20);
		painelPrincipal.add(txtCelular);
		txtCelular.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 234, 280, 92);
		painelPrincipal.add(scrollPane);
		
		txtEndereco = new JTextArea();
		txtEndereco.setLineWrap(true);
		txtEndereco.setWrapStyleWord(true);
		scrollPane.setViewportView(txtEndereco);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(313, 112, 38, 14);
		painelPrincipal.add(lblSexo);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cbSexo.setBounds(347, 110, 61, 20);
		painelPrincipal.add(cbSexo);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBotoes.setBounds(10, 505, 459, 60);
		contentPane.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat toDate = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat toDataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");
					Date usuarioDate = null;
					String dateBanco  = null;
					try {
						usuarioDate = toDate.parse(txtDtNasc.getText());
						dateBanco = toDataBase.format(usuarioDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				
					Contato contato = new Contato();
					contato.setNome(txtNome.getText());
					contato.setEmail(txtEmail.getText());
					contato.setDtNasc(dateBanco);
					contato.setCelular(txtCelular.getText());
					contato.setTelefone(txtTelefone.getText());
					contato.setEndereco(txtEndereco.getText());
					contato.setSexo(cbSexo.getSelectedItem().toString());
					ContatoDAO contatoDAO = new ContatoDAO();
					contatoDAO.setContato(contato);
					
					
					
					if(lblStatus.getText().equals("NOVO")){
						contatoDAO.gravar();
						limparControles();
						System.out.println("Gravando...");
					}
					else if (lblStatus.getText().equals("EDITAR")){
						contatoDAO.atualizar(Integer.parseInt(txtID.getText()));
						System.out.println("Editando...");
					}
					else if(lblStatus.getText().equals("EXCLUIR")){
						int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir" + contato.getNome() + "?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
						if(resposta == 0){
							contatoDAO.excluir(Integer.parseInt(txtID.getText()));
						}
						
						System.out.println("Deletar...");
					}

						
					
			}
		});
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/salvar.png")));
		btnSalvar.setBounds(78, 11, 66, 38);
		painelBotoes.add(btnSalvar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/sair.png")));
		button.setBounds(341, 11, 66, 38);
		painelBotoes.add(button);
	}
	private void limparControles(){
		txtNome.setText("");
		txtEmail.setText("");
		txtDtNasc.setText("");
		txtCelular.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
	}
}
