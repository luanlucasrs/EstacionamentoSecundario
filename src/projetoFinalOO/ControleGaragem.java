package projetoFinalOO;

import java.util.Calendar;

public class ControleGaragem {
 
	
	private Calendar dataEntrada;
	private Calendar dataSaida;
	private Veiculo veiculo; 
	//ArrayList<ControleGaragem> listaData = new ArrayList<ControleGaragem>();
	
	public ControleGaragem() {
		this.dataEntrada = Calendar.getInstance();
		this.dataSaida = Calendar.getInstance();
		this.veiculo = new Veiculo(null, null, null, false);
		
	}
	
	public ControleGaragem (Calendar dataEntrada, Calendar dataSaida, Veiculo veiculo) {
		super();
		this.dataEntrada = dataEntrada; 
		this.dataSaida = dataSaida; 
		this.veiculo = veiculo; 
	}
	
	
	public Calendar getDataEntrada() {
		return dataEntrada; 
	}
	
	public void SetDataEntrada (Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
		
	}
	
	public Calendar getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida (Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Veiculo getVeiculo() {
		return veiculo; 
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo; 
	}
}
