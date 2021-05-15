package projetoFinalOO;




import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Estacionamento {

	private List<Cliente> clientes; 
	private List<Veiculo> veiculosNaoMensalista;
	private List<ControleGaragem> garagem;
	private Cobranca cobranca; 
	// teste
	
	public Estacionamento () {
		clientes = new ArrayList<Cliente>();
		veiculosNaoMensalista = new ArrayList<Veiculo>();
		garagem = new ArrayList<ControleGaragem>();
		cobranca = new Cobranca();
		
	}
	
	public static void main(String[] args) throws DadosPessoaisIncompletoException, DadosVeiculosIncompletosException,  
		EstacionamentoFechadoException, PeriodoInvalidoException {
		
		System.out.println("HELLO!!!");
		
		Estacionamento estacionamento = new Estacionamento();
		 
		rodarMenu();

		
		if (!estacionamento.cadastrarCliente(null)) {
			throw new DadosPessoaisIncompletoException();
		}
		if (!estacionamento.cadastrarVeiculo(null)) {
			throw new DadosVeiculosIncompletosException();
		}
		if(!estacionamento.registrarEntradaVeiculo(null)) {
			throw new EstacionamentoFechadoException();
		}
		if(!estacionamento.registrarSaidaVeiculo(null)) {
			throw new PeriodoInvalidoException();
		}
		
	}

	/* Sequência de código para criação do menu de visualização da interface
	 *
	 * Funcionamento
	 * 1) Int menu: primeira tela 
	 * 2) void rodarMenu: funcionamento do menu  
	 * 3) rodarMenu: chamada na main 
	 * 
	 */
	public static int menu(){
		//Variável para botão 
		int valorDoBotao = 0;
		
		// Alocar botoes 
		Object[]  funcoes = { "Consultar Placa","Cadastrar Veículo", "Cadastrar Cliente", "Vincular Veículo", "Registrar Entrada", 
				"Registrar Saída", "Cobrar"};
		int funcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			
		}
		
		//Cadastrar Veiculo
		if (funcao == 1) {
			
		}
		
		//Cadastrar Cliente 
		if (funcao == 2) {
			
		}
		
		//Vincular Veículo 
		if (funcao == 3) {
			
		}
		
		//Registrar Entrada
		if (funcao == 4) {
			
		}
		
		//Registrar Saída 
		if (funcao == 5) {
			
		}
		
		//Cobrar 
		if (funcao == 6) {
			
		}
		
		// Cancelar operação 
		else if (funcao == -1){
			valorDoBotao = -1;
		}
		
		return valorDoBotao;
	}
	
	/**
	 * Função responsável peleo funcionamento do menu até que a interface seja inserida 
	 */
	private static void rodarMenu() {
		int condicao = menu();
		while (condicao >=0 ) {
			condicao = menu();
		}
		
	}

	

	
	public Veiculo consultarPlaca(String placa) {
		return new Veiculo(); 
	}
	
	public boolean cadastrarVeiculo (Veiculo veiculo) {
		return false;
	}
	
	public boolean cadastrarCliente (Cliente cliente) {
		return false; 
	}
	
	public boolean vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		return false;
	}
	
	public boolean registrarEntradaVeiculo(Veiculo veiculo) {
		return false; 
	}
	
	public boolean registrarSaidaVeiculo(Veiculo veiculo) {
		return false; 
	}
	
	public double cobrar(ControleGaragem controle) {
		return 0.0;
	}
}
