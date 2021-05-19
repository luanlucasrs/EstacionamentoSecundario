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
		
		// Fun��o para rodar o menu
		rodarMenu();

		//Ainda n�o fa�o ideia de como lidar com isso 
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

	
	

	/** 
	 * Sequ�ncia de c�digo para cria��o do menu de visualiza��o da interface
	 *
	 * Funcionamento
	 * 1) Int menu: primeira tela 
	 * 2) void rodarMenu: funcionamento do menu  
	 * 3) rodarMenu: chamada na main 
	 * 
	 */
	
	
	public static int menu(){
		//Vari�vel para bot�o 
		int valorDoBotao = 0;
		
		// Alocar botoes 
		Object[]  funcoes = { "Consultar Placa","Cadastrar Ve�culo"};
		int funcao = JOptionPane.showOptionDialog(null, "Bem-vindos ao servi�o ", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			consultarPlaca(null); // My: /eu não achei esse método no seu codigo aqui, mas adicionar dentro dele o método BuscaPlaca 
						
			/**
			 * Passo-a-passo  dessa fun��o 
			 * 
			 * 1) Insere Placa 
			 * 2) Cadastrada? (s/n)
			 *  
			 *  2.1)Caso sim: 
			 *  	Registrar entrada ou saida?  
			 *  		Caso entrada 
			 *  			registrarEntradaVeiculo()
			 *  		Caso saida
			 *  			registrarSaidaVeiculo()
			 * 	2.2)Caso n�o:
			 * 		Cadastrar vieculo novo?(s/n)
			 * 			Caso sim 
			 * 				cadastrarVeiculo()
			 * 			Caso n�o
			 * 				Encerra
			 *  
			 */
			
		}
		
		//Cadastrar Veiculo
		if (funcao == 1) {
			cadastrarVeiculo();
			
			/**
			 * Passo-a-passo  dessa fun��o 
			 * 
			 * 1) Dados Veiculo 
			 * 2) Ele � mensalista? (s/n)
			 * 	
			 * 	2.1) Caso sim 
			 * 		a) Insira CNH (existe/ou n)
			 * 			a.1)Caso exista
			 * 				vinculcarVeiculoCliente();
			 * 			a.2) Caso nao exista
			 * 				cadastrarCliente();
			 * 	2.2) Caso n�o 
			 * 		Deseja registrar entrada? (s/n)
			 * 			Caso sim 
			 * 				registrarEntradaVeiculo()
			 * 			Caso nao
			 * 				sair
			 *
			 */
			
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
		while (condicao >= 0 ) {
			condicao = menu();
		}
		
	}


	/**
	 * Sequencia de chamada de fun��es predeterminadas na UML 
	 * 
	 */
	
	
	
	
	
	
	
	public static  Veiculo consultarPlaca(String placa) {

		/**
		 * Rotina simplesmente representativa para entender o final do codigo
		 * Esta rotina deve ser alterada para testar se realmente existe e n�o por uma option pane 
		 * e checando os arquivos txt
		 * 
		 */
		
		
		//JOptionPane.showMessageDialog(null, "Informe Placa "); 
		Object[] testePlaca = {"Sim", "N�o"};
		int tipoPlaca = JOptionPane.showOptionDialog(null, "A placa esta cadastrada?", "Checar placa", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, testePlaca, testePlaca[0]);
		
		
		// My: Chamar método Buscaplaca aqui, pra você checar se a placa existe
		
		if (tipoPlaca == 0) { // Se placa existir 
			
			Object[] funcoes = {"Entrada", "Sa�da"};
			int tipoRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar uma entrada ou sa�da?", "Registro", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
			
				if(tipoRegistro == 0) {
					registrarEntradaVeiculo(null);
					
				} else if (tipoRegistro ==1) {
					registrarSaidaVeiculo(null);
					
					/** 
					 * Nessa fun��o � feita a cobran�a 
					 * 
					 */
				}
			
		} else if (tipoPlaca == 1) { // Se n�o existir 
			
			
			Object[] placaNaoExiste = {"Sim", "N�o"};
			int testaCadastro = JOptionPane.showOptionDialog(null, "Deseja cadastrar um carro novo?", "Checar desejo de cadastro", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, placaNaoExiste, placaNaoExiste[0]);
			
				if (testaCadastro == 0) {// Se deseja fazer o cadastro
					cadastrarVeiculo();  
					
				} else if(testaCadastro == 1) {
					//sai do codigo 
					
				}
				
		}
		
		
		/**
		 * Checar realmente como retornar aqui 
		 * 
		 */
		
		return null; 
	}
	
	

	public static boolean cadastrarVeiculo () {
		
		/**
		 * Interface bem trabalhada, no entanto ela precisa ser finalizada no momento de decis�o se existe ou nao CNH
		 * Precisa checar nos arquivos txt se existe ou nao CNH
		 * 
		 */
		
		
		// My: instaciar um objeto do tipo veiculo e chamar o método addVeiculo para poder adicionar ele no array, você tá pedindo os dados
		// mas não parece estar adicionando eles em um objeto.
		
		
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
		
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Ve�culo", JOptionPane.OK_CANCEL_OPTION);
			
			//Validacao 
			
			int sair = 1;
			
			while (sair !=0) {
				if (valorDoBotao == 2 || valorDoBotao == -1) {
					sair =0;
				} else if(campoPlaca.getText().isEmpty() || campoMarca.getText().isEmpty()
						|| campoModelo.getText().isEmpty() ) {
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Ve�culo", JOptionPane.OK_CANCEL_OPTION);
				} else if (valorDoBotao == 0) {
					sair = 0;
				}
					
				
			}
			
			if(valorDoBotao == 0) {
				String placa = campoPlaca.getText();
				String marca = campoMarca.getText();
				String modelo = campoModelo.getText();
				
				/**
				 * Como transformar mensalista em booleano ??
				 * Aqui encontro um poblema de inserir se � mensalista ou nao, mas se eu colocar o construtor veiculo, 
				 * n�o consigo definir como booleano, codigo abaixo comentado segue como seria se desse certo 
				 */
				
				//String mensalista = campoMensalista.getText();
				//veiculo = new Veiculo (placa, marca, modelo, null);
				
				/**
				 * Momento de arquivar -- receber variaveis, escrever em um txt e salvar
				 * exemplo de chamar esse tipo de fun�ao abaixo
				 */
				
				// lerEscrever.escreverVeiculo (veiculo);
				
				
			}
		}
		
		
		//Botoes 
		
		
		Object[] funcoes = {"Sim", "N�o"};
		int tipoDeVeiculo = JOptionPane.showOptionDialog(null, "O Veiculo � mensalista?", "Cadastro", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		
			if (tipoDeVeiculo == 0 ) { // se o veiculo for mentalista 
				
				int valorPainel = 0;
				
				if (valorPainel == 0) { // Checar se CNH Existe -- problema critico 
					
					
					JTextField campoCnh = new JTextField (10);
					
					
					myPanel.add(new JLabel("CNH: "));
					myPanel.add(campoCnh);
					valorPainel = JOptionPane.showConfirmDialog(null, myPanel, "Checa CNH", JOptionPane.OK_CANCEL_OPTION);
					
					int sair = 1;
					
					while (sair !=0) {
						if (valorPainel == 2 || valorPainel == -1) {
							sair =0;
						} else if(campoCnh.getText().isEmpty() ) {
							
							valorPainel = JOptionPane.showConfirmDialog(null, myPanel, "Checa CNH", JOptionPane.OK_CANCEL_OPTION);
						} else if (valorPainel == 0) {
							sair = 0;
						}
						
						
						if(valorPainel == 0) {
							
							int checaCnh = Integer.parseInt(campoCnh.getText()); 
							
			
							
						}
				}
				
					/**
					 * ROTINA TER QUE FAZER DEPOIS DE SALVAR
					 */
				
			// Se existe no cadastro 		
			//	  if (checaCnh == 0 ) {
					
				//	vincularVeiculosCliente(null, veiculo);
					
			// Se n�o existe 	
			//	} else if {
					
					
					//cadastrarCliente();
			//	}
					
				
				
			
			} else if (tipoDeVeiculo == 1) {
				
				Object[] blocoRegistro = {"Sim", "N�o"};
				int checaRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar entrada de carro?", "Registro de Entrada", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, blocoRegistro, blocoRegistro[0]);
				
				if (checaRegistro == 0 ) {
					
					registrarEntradaVeiculo(veiculo);
					
				} else if ( checaRegistro == 1) {
					
					String message = "Cadastro de Ve�culo feito com sucesso";
					
					JOptionPane.showMessageDialog(null, message);
					
				}
			
			}
			
		// return veiculo 
			// corrigir dpois de transformar mensalista em boolean 
				
			}
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
			myPanel.add(new JLabel("Endere�o: "));
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
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Ve�culo", JOptionPane.OK_CANCEL_OPTION);
				} else if (valorDoBotao == 0) {
					sair = 0;
				}
				
				
				if(valorDoBotao == 0) {
					String nome = campoNome.getText();
					String endereco = campoEndereco.getText();
					String numeroCelular = campoNumeroCelular.getText();
					String numeroTelefone = campoNumeroTelefone.getText();
					int numeroCnh = Integer.parseInt(campoNumeroCnh.getText()); 
					//ArrayList <Integer> arrayCnh = new ArrayList <Integer>();
					//arrayCnh.add (numeroCnh);
					//Transformar veiculo em list
					String veiculo = campoVeiculo.getText();
					//ArrayList <String> arrayVeiculo = new ArrayList <String>();
					//arrayVeiculo.add (veiculo);
					
					
					cliente = new Cliente ();
					
					
					/**
					 * Momento de arquivar -- receber variaveis, escrever em um txt e salvar
					 * exemplo de chamar esse tipo de fun�ao abaixo
					 */
					
					// lerEscrever.escreverCliente (cliente);
					
					
				}
			
		}
		
				
		}
		
		return false; 
	}
	

	
	
	public static boolean vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		
		/** 
		 * Vincular fica mais facil de fazer apos arquivos salvos e saber como puxar eles 
		 */
		
		
		return false;
	}
	
	public static boolean registrarEntradaVeiculo(Veiculo veiculo) {
		
		JTextField campoDataEntrada = new JTextField (10);
		/**
		 * Fazer interface com variaveis
		 * 
		 */
	
		
		return false; 
	}
	
	public static boolean registrarSaidaVeiculo(Veiculo veiculo) {
		
		JTextField campoDataSaida = new JTextField (10);
		/**
		 * Fazer interface com variaveis
		 * 
		 */
		
		
		return false; 
	}
	
	public double cobrar(ControleGaragem controle) {
		
		
		
		return 0.0;
	}
	
	// Corre��o de ve�culo? ?????????????????????????? ALO AMIGOS 
	private Veiculo veiculo() {
		// TODO Auto-generated method stub
		return null;
	}
}
