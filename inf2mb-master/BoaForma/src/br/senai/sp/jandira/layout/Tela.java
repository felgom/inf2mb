package br.senai.sp.jandira.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.senai.sp.jandira.cliente.Cliente;

public class Tela extends JFrame {

	public Tela() {

		// CRIANDO JFRAME
		setSize(800, 500);
		setLayout(null);
		setTitle("Academia Boa Forma");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color cinza = new Color(199, 203, 199);
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setLayout(null);
		getContentPane().add(pnlTitulo);
		pnlTitulo.setBackground(cinza);
		DecimalFormat dfUmCasa = new DecimalFormat("0.#");
		DecimalFormat dfSemCasa = new DecimalFormat("0");

		// PANEL DA ESQUERDA
		JPanel pnlEsquerda = new JPanel();
		pnlEsquerda.setLayout(null);
		pnlEsquerda.setBorder(BorderFactory.createTitledBorder("Dados:"));
		pnlEsquerda.setBounds(10, 110, 325, 345);
		getContentPane().add(pnlEsquerda);

		// CRIANDO O OBJETO A SER COLOCADO NO PANEL
		Font Arial = new Font("Arial", 1, 20);
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblSexo = new JLabel("Sexo:");
		JLabel lblPeso = new JLabel("Peso:");
		JLabel lblAltura = new JLabel("Altura:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblNivelDeAtividade = new JLabel("Nível de atividade:");
		JTextField txtNome = new JTextField();
		JRadioButton radioHomem = new JRadioButton("Homem");
		JRadioButton radioMulher = new JRadioButton("Mulher");
		JTextField txtPeso = new JTextField();
		JTextField txtAltura = new JTextField();
		JTextField txtIdade = new JTextField();
		JButton buttonCalcular = new JButton();
		ImageIcon img = new ImageIcon(getClass().getResource("calc.png"));
		ImageIcon image = new ImageIcon(getClass().getResource("academy.png"));
		JLabel lblLogo = new JLabel(image);
		JLabel lblBoaforma = new JLabel("Boa Forma");
		ButtonGroup group = new ButtonGroup();
		

		// ***** CONSTRUINDO UM COMBOBOX*********************
		JComboBox<String> cbNivelAtivi = new JComboBox<>();
		// **** CRIANDO A MATRIX DE CIDADES****
		// ***** QUE PREENCHERÁ O COMBOBOX
		String[] nivelAtivCombo = new String[5];
		nivelAtivCombo[0] = "Sedentário";
		nivelAtivCombo[1] = "Levemente Ativo";
		nivelAtivCombo[2] = "Moderadamente Ativo";
		nivelAtivCombo[3] = "Bastante Ativo";
		nivelAtivCombo[4] = "Muito Ativo";
		// *** CRIAR O MODELO DE DADOS DO COMBO**
		DefaultComboBoxModel<String> modelCombo = new DefaultComboBoxModel<>(nivelAtivCombo);

		// DENTRO DO PAINEL DE CONTEUDO
		cbNivelAtivi.setModel(modelCombo);
		// DENTRO DO PAINEL DE CONTEUDO
		cbNivelAtivi.setBounds(15, 210, 200, 20);
		// COLOCANDO NO PANEL
		pnlEsquerda.add(cbNivelAtivi);
		

		// COLOCANDO ELE DE ACORDO COM AS COORDENADAS
		pnlTitulo.setBounds(0, 0, 800, 100);
		lblNome.setBounds(25, 10, 50, 50);
		lblSexo.setBounds(25, 40, 50, 50);
		lblPeso.setBounds(20, 70, 50, 50);
		lblAltura.setBounds(20, 100, 50, 50);
		lblIdade.setBounds(20, 130, 50, 50);
		lblNivelDeAtividade.setBounds(20, 170, 150, 50);
		txtNome.setBounds(60, 25, 250, 25);
		txtPeso.setBounds(60, 85, 50, 25);
		txtAltura.setBounds(60, 115, 50, 25);
		txtIdade.setBounds(60, 145, 50, 25);
		radioHomem.setBounds(60, 55, 70, 20);
		radioMulher.setBounds(130, 55, 70, 20);
		buttonCalcular.setBounds(80, 260, 130, 50);
		lblLogo.setBounds(10, 0, 100, 100);
		lblBoaforma.setBounds(100, 10, 200, 100);
		
		// COLOCANDO O OBJETO NA PANEL DA ESQUERDA
		lblBoaforma.setFont(Arial);
		pnlEsquerda.add(lblNome);
		pnlEsquerda.add(lblSexo);
		pnlEsquerda.add(lblPeso);
		pnlEsquerda.add(lblAltura);
		pnlEsquerda.add(lblIdade);
		pnlEsquerda.add(lblNivelDeAtividade);
		pnlEsquerda.add(txtNome);
		pnlEsquerda.add(txtPeso);
		pnlEsquerda.add(txtAltura);
		pnlEsquerda.add(txtIdade);
		pnlEsquerda.add(radioHomem);
		pnlEsquerda.add(radioMulher);
		pnlEsquerda.add(buttonCalcular);
		buttonCalcular.setIcon(img);
		buttonCalcular.setText("Calcular");
		pnlTitulo.add(lblLogo);
		pnlTitulo.add(lblBoaforma);
		group.add(radioHomem);
		group.add(radioMulher);
		
		radioHomem.setActionCommand("Homem");
		radioMulher.setActionCommand("Mulher");
		 
		
		JPanel pnlDireita = new JPanel();// PAINEL DA DIREITA
		pnlDireita.setLayout(null);
		pnlDireita.setBorder(BorderFactory.createTitledBorder("Resultado:"));
		pnlDireita.setBounds(350, 110, 420, 345);
		getContentPane().add(pnlDireita);

		// CRIANDO O OBJETO A SER COLOCADO NO PANEL DIREITA
		JLabel lblNome1 = new JLabel("Nome:");
		JLabel lblPeso1 = new JLabel("Peso:");
		JLabel lblAltura1 = new JLabel("Altura:");
		JLabel lblIdade1 = new JLabel("Idade:");
		JLabel lblNivelDeAtividade1 = new JLabel("Nível de atividade:");
		JLabel lblImc = new JLabel("IMC:");
		JLabel lblTmb = new JLabel("TMB:");
		JLabel lblFcm = new JLabel("FCM:");
		JTextArea txtImc = new JTextArea();
		Cliente cliente = new Cliente();
		JLabel lblNomeResposta = new JLabel();
		JLabel lblPesoResposta = new JLabel();
		JLabel lblAlturaResposta = new JLabel();
		JLabel lblIdadeResposta = new JLabel();
		JLabel lblNivelAtividadeRespota = new JLabel ();
		JLabel lblImcResposta = new JLabel ();
		JLabel lblTmbResposta = new JLabel ();
		JLabel lblFcmResposta = new JLabel ();

		

		// COLOCANDO O OBJETO NA PANEL DA DIREITA
		pnlDireita.add(lblNome1);
		pnlDireita.add(lblPeso1);
		pnlDireita.add(lblAltura1);
		pnlDireita.add(lblIdade1);
		pnlDireita.add(lblNivelDeAtividade1);
		pnlDireita.add(lblImc);
		pnlDireita.add(lblTmb);
		pnlDireita.add(lblFcm);
		pnlDireita.add(txtImc);
		pnlDireita.add(lblNomeResposta);
		pnlDireita.add(lblPesoResposta);
		pnlDireita.add(lblIdadeResposta);
		pnlDireita.add(lblAlturaResposta);
		pnlDireita.add(lblNivelAtividadeRespota);
		pnlDireita.add(lblImcResposta);
		pnlDireita.add(lblFcmResposta);
		pnlDireita.add(lblTmbResposta);
		

		// COLOCANDO ELE DE ACORDO COM AS COORDENADAS
		lblNome1.setBounds(103, 10, 50, 50);
		lblPeso1.setBounds(107, 100, 50, 50); 
		lblAltura1.setBounds(105, 70, 50, 50);
		lblIdade1.setBounds(105, 40, 50, 50);
		lblNivelDeAtividade1.setBounds(40, 130, 100, 50);
		lblImc.setBounds(114, 150, 100, 50);
		lblTmb.setBounds(114, 270, 100, 50);
		lblFcm.setBounds(114, 250, 100, 50);
		txtImc.setBounds(140, 190, 250, 75);
		lblNomeResposta.setBounds(145, 10, 50, 50);
		lblPesoResposta.setBounds(145, 100, 50, 50);
		lblIdadeResposta.setBounds(145, 40, 50, 50);
		lblAlturaResposta.setBounds(145, 70, 50, 50);
		lblNivelAtividadeRespota.setBounds(145, 130, 250, 50);
		lblImcResposta.setBounds(140, 150, 100, 50);
		lblTmbResposta.setBounds(145, 270, 100, 50);
		lblFcmResposta.setBounds(145, 250, 100, 50);
		
		// AÇÃO DO BOTÃO
		
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// INSERIR O VALOR DOS ATRIBUTOS
				
				cliente.setNome(txtNome.getText());
				cliente.setSexo(group.getSelection().getActionCommand());
				cliente.setPeso(Integer.parseInt(txtPeso.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				cliente.calcImc();
				cliente.getImc();
				cliente.calcFcm();
				cliente.calcTmb();

				lblNomeResposta.setText(cliente.getNome());
				lblAlturaResposta.setText(String.valueOf(cliente.getAltura()));
				lblPesoResposta.setText(String.valueOf(cliente.getPeso()));
				lblIdadeResposta.setText(String.valueOf(cliente.getIdade()));
				lblNivelAtividadeRespota.setText(cbNivelAtivi.getSelectedItem().toString());
				txtImc.setText(String.valueOf(cliente.calcImc()));
				lblImcResposta.setText(dfUmCasa.format(cliente.getImc()));
				lblFcmResposta.setText(dfSemCasa.format(cliente.calcFcm()));
				lblTmbResposta.setText(dfSemCasa.format(cliente.getTmb()));
				
				
				
			}
		});
		
			
		
		setVisible(true);
	}
}
