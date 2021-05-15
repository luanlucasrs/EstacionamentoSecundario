package projetoFinalOO;

public class Cobranca {

	private double porMinuto;
	private double porFracao;
	private double porHora;
	private double porDiaria;
	private double porPerNoite;
	private double porMes;
	
	public Cobranca() {
	}
	
	public Cobranca (double porMinuto, double porFracao, double porHora, double porDiaria, double porPerNoite, double porMes){
		this.porMinuto = porMinuto;
		this.porFracao = porFracao;
		this.porHora = porHora;
		this.porDiaria = porDiaria;
		this.porPerNoite = porPerNoite;
		this.porMes = porMes;
	}
	
	public double getPorMinuto() {
		return porMinuto;
	}

	public double getPorFracao() {
		return porFracao;
	}

	public double getPorHora() {
		return porHora;
	}

	public double getPorDiaria() {
		return porDiaria;
	}

	public double getPorPerNoite() {
		return porPerNoite;
	}

	public double getPorMes() {
		return porMes;
	}
	
	
}