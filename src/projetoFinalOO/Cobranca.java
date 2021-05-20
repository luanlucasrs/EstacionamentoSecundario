package projetoFinalOO;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Cobranca {

	private double porMinuto;
	private double porFracao;
	private double porHora;
	private double porDiaria;
	private double porPerNoite;
	private double porMes;
	
	public Cobranca() {
		porMinuto = 0.50;
		porFracao = -0.50;
		porHora = -1.00;
		porDiaria = 110.00;
		porPerNoite = 30.00;
	}
	
	public Cobranca (double porMinuto, double porFracao, double porHora, double porDiaria, double porPerNoite, double porMes){
		this.porMinuto = porMinuto;
		this.porFracao = porFracao;
		this.porHora = porHora;
		this.porDiaria = porDiaria;
		this.porPerNoite = porPerNoite;
		this.porMes = porMes;
	}
	
	public double cobrar(Calendar entrada, Calendar saida) {
		double valorCobrado = 0.00;
		
		// Calcula q quantidade de minutos
		long minutos = ChronoUnit.MINUTES.between(entrada.toInstant(), saida.toInstant());
		
		int quantidadeNoites = 0;
		
		// Teste para verificar passagem de ano
		int quantidadeAnos = saida.get(Calendar.DAY_OF_YEAR) - entrada.get(Calendar.DAY_OF_YEAR);
		
		// Caso o automóvel fique na virada de ano ou mais de 1 ano
		if (quantidadeAnos > 1) {
			quantidadeNoites = saida.get(Calendar.DAY_OF_YEAR) * (quantidadeAnos * 365) - entrada.get(Calendar.DAY_OF_YEAR);
		
		} else {
			quantidadeNoites = saida.get(Calendar.DAY_OF_YEAR) - entrada.get(Calendar.DAY_OF_YEAR);
		}
		
		// Calcula a quantidade de per noites
		
		if (quantidadeNoites > 0) {
			valorCobrado = quantidadeNoites * porPerNoite;
			
			Calendar fechamento = Calendar.getInstance();
			fechamento.set(Calendar.DAY_OF_MONTH, entrada.get(Calendar.DAY_OF_MONTH));
			fechamento.set(Calendar.MONTH, entrada.get(Calendar.MONTH));
			fechamento.set(Calendar.YEAR, entrada.get(Calendar.YEAR));
			fechamento.set(Calendar.HOUR_OF_DAY, 20);
			fechamento.set(Calendar.MINUTE, 0);
			fechamento.set(Calendar.SECOND, 0);
			
			minutos = ChronoUnit.MINUTES.between(entrada.toInstant(), fechamento.toInstant());
			
			Calendar abertura = Calendar.getInstance();
			abertura.set(Calendar.DAY_OF_MONTH, saida.get(Calendar.DAY_OF_MONTH));
			abertura.set(Calendar.MONTH, saida.get(Calendar.MONTH));
			abertura.set(Calendar.YEAR, saida.get(Calendar.YEAR));
			abertura.set(Calendar.HOUR_OF_DAY, 6);
			abertura.set(Calendar.MINUTE, 0);
			abertura.set(Calendar.SECOND, 0);
			
			minutos = minutos + ChronoUnit.MINUTES.between(abertura.toInstant(), saida.toInstant());
			
			if (quantidadeNoites > 1) {
				minutos = minutos + (840 * (quantidadeNoites - 1));
			}
		}

		// Calcula o valor por minutos
		valorCobrado = valorCobrado + (minutos * porMinuto);
		
		// Verifica a quantidade de horas cheias para desconto
		int quantidadeHoras = (int) (minutos / 60);
		
		// Verifica de será contabilizado diária
		if (quantidadeHoras >= 9) {
			quantidadeHoras = quantidadeHoras - 9;
			valorCobrado = porDiaria;
			minutos = minutos - (9 * 60);

			valorCobrado = valorCobrado + (minutos * porMinuto);
		}

		// Calcula desconto por hora
		valorCobrado = valorCobrado + (quantidadeHoras * porHora);
		minutos = minutos - (quantidadeHoras * 60);
		
		// Calcula desconto por fração
		int quantidadeFracao = (int) (minutos / 15);
		valorCobrado = valorCobrado + (quantidadeFracao * porFracao);
		
		return valorCobrado;
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