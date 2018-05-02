package br.senai.sp.jandira.cliente;

public class Cliente {

	// ATRIBUTOS
	private String nome;
	private String datanasc;
	private String sexo;
	private String nivelAtividade;
	private double altura;
	private double peso;
	private int idade;
	private double tmb;
	private double fcm;
	private double imc;

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNivelAtividade() {
		return nivelAtividade;
	}

	public void setNivelAtividade(String nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getTmb() {
		return tmb;
	}

	public void setTmb(double tmb) {
		this.tmb = tmb;
	}

	public double getFcm() {
		return fcm;
	}

	public void setFcm(double fcm) {
		this.fcm = fcm;
	}

	public double getImc() {
		imc = peso / ((altura / 100) * (altura / 100));
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	// MÉTODOS DA CLASSE

	public String calcImc() {
		if (imc <= 16.9) {
			return "Muito abaixo do peso,\nQueda de cabelo, infertilidade,\nausência menstrual";
		} else if (imc >= 17 && imc <= 18.4) {
			return "Abaixo do peso,\nFadiga, stress, ansiedade";
		} else if (imc >= 18.5 && imc <= 24.9) {
			return "Peso normal\nMenor risco de doenças cardíacas\n e vasculares ";
		} else if (imc >= 25 && imc <= 29.9) {
			return "Acima do peso\nFadiga, má circulação,\n varizes ";
		} else if (imc >= 30 && imc <= 34.9) {
			return "Obesidade Grau I \nDiabetes, angina, infarto,\n aterosclerose ";
		} else if (imc >= 35 && imc <= 40) {
			return "Obesidade Grau II \nApneia do sono,\nfalta de ar";
		} else {
			return "Obesidade Grau III Refluxo,\n dificuldade para se mover,\n escaras, diabetes, infarto, AVC";
		}

	}

	public double calcTmb() {
		if (sexo == "Homem") {
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		} else {
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		}

		if (nivelAtividade == "Sedentário") {
			tmb = tmb * 1.20;
		} else if (nivelAtividade == "Levemente Ativo") {
			tmb = tmb * 1.37;
		} else if (nivelAtividade == "Moderadamente Ativo") {
			tmb = tmb * 1.55;
		} else if (nivelAtividade == "Bastante Ativo ") {
			tmb = tmb * 1.72;
		} else{
			tmb = tmb * 1.90;
		}
		return tmb;

	}

	public double calcFcm() {
		if (sexo == "Homem") {
			return (210 - (0.5 * idade) - peso * 1 / 100) + 4;
		} else {
			return (210 - (0.5 * idade) - peso * 1 / 100);
		}
	}
}
