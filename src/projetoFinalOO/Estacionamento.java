package projetoFinalOO;



import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;



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
		
		
		
		Estacionamento estacionamento = new Estacionamento();
		 
		rodarMenu();

		
		if (!estacionamento.cadastrarCliente(null)) {
			throw new DadosPessoaisIncompletoException();
		}
		if (!estacionamento.cadastrarVeiculo()) {
			throw new DadosVeiculosIncompletosException();
		}
		if(!estacionamento.registrarEntradaVeiculo(null)) {
			throw new EstacionamentoFechadoException();
		}
		if(!estacionamento.registrarSaidaVeiculo(null)) {
			throw new PeriodoInvalidoException();
		}
		
	}

	/** 
	 * Sequ�ncia de c�digo para cria��o do menu de visualiza��o da interface
	 *
	 * Funcionamento
	 * 1) Int menu: primeira tela 
	 * 2) void rodarMenu: funcionamento do menu  
	 * 3) rodarMenu: chamada na main 
	 * .
	 */
	public static int menu(){
		//Vari�vel para bot�o 
		int valorDoBotao = 0;
		
		// Alocar botoes 
		Object[]  funcoes = { "Consultar Placa","Cadastrar Ve�culo", "Cadastrar Cliente", "Vincular Ve�culo", "Registrar Entrada", 
				"Registrar Sa�da", "Cobrar"};
		int funcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			consultarPlaca();
		}
		
		//Cadastrar Veiculo
		if (funcao == 1) {
			cadastrarVeiculo();
		}
		
		//Cadastrar Cliente 
		if (funcao == 2) {
			cadastrarCliente();
		}
		
		//Vincular Ve�culo 
		if (funcao == 3) {
			vincularVeiculosCliente();
		}
		
		//Registrar Entrada
		if (funcao == 4) {
			registrarEntradaVeiculo();
		}
		
		//Registrar Sa�da 
		if (funcao == 5) {
			registrarSaidaVeiculo();
		}
		
		//Cobrar 
		if (funcao == 6) {
			cobrar();
		}
		
		// Cancelar opera��o 
		else if (funcao == -1){
			valorDoBotao = -1;
		}
		
		return valorDoBotao;
	}
	
	

	/**
	 * Fun��o respons�vel peo funcionamento do menu at� que a interface seja fechada
	 */
	public static void rodarMenu() {
		int condicao = menu();
		while (condicao >=0 ) {
			condicao = menu();
		}
		
	}

	

	/**
	 * Sequencia de chamada de fun��es 
	 * 
	 */
	public  Veiculo consultarPlaca(String placa) {

		JTextField campoPlaca = new JTextField(10);
		
		return veiculo(); 
	}
	
	

	public static boolean cadastrarVeiculo () {
		
		//Inicializar
		JTextField campoPlaca = new JTextField(10);
		JTextField campoMarca = new JTextField(10);
		JTextField campoModelo = new JTextField(10);
		JTextField campoMensalista = new JTextField(10);
		Veiculo veiculo = new Veiculo(null, null, null, false);
		JPanel myPanel = new JPanel();
		
		//Botoes 
		
		
		return false;
	}
	
	public boolean cadastrarCliente (Cliente cliente) {
		
		//Inicializar 
		JTextField campoNome = new JTextField(10);
		JTextField campoEndereco = new JTextField(10);
		JTextField campoNumeroCelular = new JTextField (10);
		JTextField campoNumeroTelefone = new JTextField (10);
		JTextField campoCnh = new JTextField (10);
		//  JTextField campoVeiculo = new JTextField (10);
		//  Como botar isso ?
		// Cilente cliente 
		
		
		return false; 
	}
	
	public boolean vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		
		return false;
	}
	
	public boolean registrarEntradaVeiculo(Veiculo veiculo) {
		
		JTextField campoDataEntrada = new JTextField (10);
		
		//JTextField campoVeiculo = new JTextField (10);
		
		return false; 
	}
	
	public boolean registrarSaidaVeiculo(Veiculo veiculo) {
		
		JTextField campoDataSaida = new JTextField (10);
		
		//JTextField campoVeiculo = new JTextField (10);
		
		return false; 
	}
	
	public double cobrar(ControleGaragem controle) {
		
		//JTextField campoEntradaHo
		
		
		return 0.0;
	}
	
	// Corre��o de ve�culo? ?????????????????????????? ALO AMIGOS 
	private Veiculo veiculo() {
		// TODO Auto-generated method stub
		return null;
	}
}
