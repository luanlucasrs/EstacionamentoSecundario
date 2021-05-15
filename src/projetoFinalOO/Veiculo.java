package projetoFinalOO;

public class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private boolean mensalista;
	
	public Veiculo() {
	}
	
	public Veiculo(String placa, String marca, String modelo, boolean mensalista) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.mensalista = mensalista;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isMensalista() {
		return mensalista;
	}

	public void setMensalista(boolean mensalista) {
		this.mensalista = mensalista;
	}
}
