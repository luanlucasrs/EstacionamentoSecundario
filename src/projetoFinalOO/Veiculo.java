package projetoFinalOO;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {

	private String placa; //atributos privados para seguranca (não pode alterar direto)
	private String marca;
	private String modelo;
	private boolean mensalista;
	ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	ArrayList<Veiculo> veiculosMensalistas = new ArrayList<Veiculo>();
	
	
	// Método Construtor
	
	public Veiculo(String placa, String marca, String modelo, boolean mensalista) { 
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.mensalista = mensalista;
		
	}
	
		

	// getters and setters
	
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

	public void setMensalista(boolean mensalista) {
		this.mensalista = mensalista;
	}
	
	
	// outros metodos
	
	
	
	// adicionando todos dos carros a uma lista
	public void addVeiculo (Veiculo CadastroVeiculo) {
		
		if (CadastroVeiculo.mensalista == true) {
			
			veiculosMensalistas.add(CadastroVeiculo); // Adicionando a lista especifica só de mensalistas
		}
		
		veiculos.add(CadastroVeiculo); // Adicionando todos a uma outra lista (mensalistas ou não)
			
	}
	
	
	// buscar uma placa dentro das listas
	
	//Caso a busca seja feita na lista APENAS de mensalistas
	
	public Veiculo BuscaPlacaMensalista(String placa) {

        for (Veiculo veiculo : veiculosMensalistas) {

            if (veiculo.getPlaca().equals(placa)) {

                return veiculo;
            }

        }

        return null;
    }
	
	
	//Metodo de busca geral
	
	public Veiculo BuscaPlaca(String placa) {

        for (Veiculo veiculo : veiculos) {

            if (veiculo.getPlaca().equals(placa)) {

                return veiculo;
            }

        }

        return null;
    }
	
}





