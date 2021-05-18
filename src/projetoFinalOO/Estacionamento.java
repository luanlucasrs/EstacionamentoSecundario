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
//import java.awt.List;
import java.util.*;
import java.util.List;



public class Estacionamento {

	private List<Cliente> clientes; 
	private List<Veiculo> veiculosNaoMensalista;
	private List<ControleGaragem> garagem;
	private Cobranca cobranca; 
	
	
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

		
		if (!estacionamento.cadastrarCliente()) {
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

	
	
	// BLALALALALAL 
	/** 
	 * Sequência de código para criação do menu de visualização da interface
	 *
	 * Funcionamento
	 * 1) Int menu: primeira tela 
	 * 2) void rodarMenu: funcionamento do menu  
	 * 3) rodarMenu: chamada na main 
	 * .
	 */
	public static int menu(){
		//Variável para botão 
		int valorDoBotao = 0;
		
		// Alocar botoes 
		Object[]  funcoes = { "Consultar Placa","Cadastrar Veículo"};
		int funcao = JOptionPane.showOptionDialog(null, "Bem-vindos ao serviço ", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			//consultarPlaca();
			System.out.println("Função não funcionando");
		}
		
		//Cadastrar Veiculo
		if (funcao == 1) {
			cadastrarVeiculo();
			//cadastrarCliente();
			//vincularVeiculosCliente();
		}
		
		//Registrar Entrada
	//	if (funcao == 2) {
			//registrarEntradaVeiculo();
		//	System.out.println("Função não funcionando");
	//	}
		
		//Registrar Saída 
	//	if (funcao == 3) {
		//	registrarSaidaVeiculo();
			//System.out.println("Função não funcionando");
		//}
		
		//Cobrar 
		//if (funcao == 4) {
		//	cobrar();
			//System.out.println("Função não funcionando");
		//}
		
		
		// Cancelar operação 
		//else if (funcao == -1){
			//valorDoBotao = -1;
		//}
		
		return valorDoBotao;
	}
	
	

	/**
	 * Função responsável peo funcionamento do menu até que a interface seja fechada
	 */
	public static void rodarMenu() {
		int condicao = menu();
		while (condicao >=0 ) {
			condicao = menu();
		}
		
	}

	

	/**
	 * Sequencia de chamada de funções 
	 * 
	 */
	public  Veiculo consultarPlaca(String placa) {

		JTextField campoPlaca = new JTextField(10);
		
		return veiculo(); 
	}
	
	

	public static boolean cadastrarVeiculo () {
		
		// cadastra
		// checa 
		
		
		//Inicializar
		JTextField campoPlaca = new JTextField(10);
		JTextField campoMarca = new JTextField(10);
		JTextField campoModelo = new JTextField(10);
		JTextField campoMensalista = new JTextField(10);
		Veiculo veiculo = new Veiculo(null, null, null, false);
		JPanel myPanel = new JPanel();
		
		int valorDoBotao = 0;
		
		if (valorDoBotao == 0) {
			myPanel.setLayout(new GridLayout(4,2));
			myPanel.add(new JLabel("Placa: "));
			myPanel.add(campoPlaca);
			myPanel.add(new JLabel("Marca: "));
			myPanel.add(campoMarca);
			myPanel.add(new JLabel("Modelo: "));
			myPanel.add(campoModelo);
		
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Veículo", JOptionPane.OK_CANCEL_OPTION);
			
			//Validacao 
			
			int sair = 1;
			
			while (sair !=0) {
				if (valorDoBotao == 2 || valorDoBotao == -1) {
					sair =0;
				} else if(campoPlaca.getText().isEmpty() || campoMarca.getText().isEmpty()
						|| campoModelo.getText().isEmpty() ) {
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Veículo", JOptionPane.OK_CANCEL_OPTION);
				} else if (valorDoBotao == 0) {
					sair = 0;
				}
					
				
			}
			
			if(valorDoBotao == 0) {
				String placa = campoPlaca.getText();
				String marca = campoMarca.getText();
				String modelo = campoModelo.getText();
				//Transformar mensalista em boolean 
				//String mensalista = campoMensalista.getText();
				
				//veiculo = new Veiculo (placa, marca, modelo, null);
				
				
				//Arquivo -- formatar forma de receber e salvar variavel 
				
				// lerEscrever.escreverVeiculo (veiculo);
				
				
			}
		}
		
		
		//Botoes 
		
		
		Object[] funcoes = {"Sim", "Não"};
		int tipoDeVeiculo = JOptionPane.showOptionDialog(null, "O Veiculo é mensalista?", "Cadastro", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
			if (tipoDeVeiculo == 0 ) {
				
				JTextField campoCnh = new JTextField (10);
				
				myPanel.setLayout(new GridLayout(1,2));
				myPanel.add(new JLabel("CNH: "));
				myPanel.add(campoCnh);
				
				// = JOptionPane.showInputDialog("Digite CNH: ");
				
				
			//	  if (checaCnh == 0 ) {
					// Se existe no cadastro 
				//	vincularVeiculosCliente(null, veiculo);
				
			//	} else if {
					// Se não existe 
					
					//cadastrarCliente();
			//	}
					
				
				
			
			
			} else if (tipoDeVeiculo == 1) {
				
				Object[] blocoRegistro = {"Sim", "Não"};
				int checaRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar entrada de carro?", "Registro de Entrada", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, blocoRegistro, blocoRegistro[0]);
				
				if (checaRegistro == 0 ) {
					
					registrarEntradaVeiculo(veiculo);
					
				} else if ( checaRegistro == 1) {
					
					String message = "Cadastro de Veículo feito com sucesso";
					
					JOptionPane.showMessageDialog(null, message);
					
				}
			
			}
			
		// return veiculo 
			// corrigir dpois de transformar mensalista em boolean 
		return false;
	}
	
	public static boolean cadastrarCliente () {
		
		//Inicializar 
		JTextField campoNome = new JTextField(10);
		JTextField campoEndereco = new JTextField(10);
		JTextField campoNumeroCelular = new JTextField (10);
		JTextField campoNumeroTelefone = new JTextField (10);
		JTextField campoNumeroCnh = new JTextField (10);
		
		JTextField campoVeiculo = new JTextField (10);
		//  Como botar isso ?
		Cliente cliente = new Cliente();
		JPanel myPanel = new JPanel();
		
		int valorDoBotao = 0;
		
		if (valorDoBotao == 0) {
			
			myPanel.setLayout(new GridLayout(6,2));
			myPanel.add(new JLabel("Nome: "));
			myPanel.add(campoNome);
			myPanel.add(new JLabel("Endereço: "));
			myPanel.add(campoEndereco);
			myPanel.add(new JLabel("Numero do celular: "));
			myPanel.add(campoNumeroCelular);
			myPanel.add(new JLabel("Numero de telefone: "));
			myPanel.add(campoNumeroTelefone);
			myPanel.add(new JLabel("CNH: "));
			myPanel.add(campoNumeroCnh);
			myPanel.add(new JLabel("Veiculo: "));
			myPanel.add(campoVeiculo);
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Cliente", JOptionPane.OK_CANCEL_OPTION);
			
			//Validacao 
			
			int sair = 1;
			
			while (sair !=0) {
				if (valorDoBotao == 2 || valorDoBotao == -1) {
					sair =0;
				} else if(campoNome.getText().isEmpty() || campoEndereco.getText().isEmpty()
						|| campoNumeroCelular.getText().isEmpty() || campoNumeroTelefone.getText().isEmpty() 
						|| campoNumeroCnh.getText().isEmpty()|| campoVeiculo.getText().isEmpty()) {
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Veículo", JOptionPane.OK_CANCEL_OPTION);
				} else if (valorDoBotao == 0) {
					sair = 0;
				}
				
				
				if(valorDoBotao == 0) {
					String nome = campoNome.getText();
					String endereco = campoEndereco.getText();
					String numeroCelular = campoNumeroCelular.getText();
					String numeroTelefone = campoNumeroTelefone.getText();
					int numeroCnh = Integer.parseInt(campoNumeroCnh.getText()); 
					//Transformar veiculo em list
					String veiculo = campoVeiculo.getText();
					
					cliente = new Cliente ();
					
					
					//Arquivo -- formatar forma de receber e salvar variavel 
					
					// lerEscrever.escreverCliente (veiculo);
					
					
				}
			
		}
		
		
		
	
				
		}
		
		return false; 
	}
	
	public static boolean vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		
		return false;
	}
	
	public static boolean registrarEntradaVeiculo(Veiculo veiculo) {
		
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
	
	// Correção de veículo? ?????????????????????????? ALO AMIGOS 
	private Veiculo veiculo() {
		// TODO Auto-generated method stub
		return null;
	}
}
