package projetoFinalOO;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String nome;
	private String enderecoCompleto;
	private String numeroCelular;
	private String numeroTelefone;
	private int numeroCNH;
	private List<Veiculo> veiculos;
	
	public Cliente() {
		this.nome = "";
		this.enderecoCompleto = "";
		this.numeroCelular = "";
		this.numeroTelefone = "";
		this.numeroCNH = 0;
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	public Cliente(String nome, String enderecoCompleto, String numeroCelular, String numeroTelefone, int numeroCNH, List<Veiculo> veiculos) {
		this.nome = nome;
		this.enderecoCompleto = enderecoCompleto;
		this.numeroCelular = numeroCelular;
		this.numeroTelefone = numeroTelefone;
		this.numeroCNH = numeroCNH;
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public int getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(int numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public void addVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}
}
