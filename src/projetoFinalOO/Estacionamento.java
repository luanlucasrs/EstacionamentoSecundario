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

	//private List<Cliente> clientes; 
	private List<Veiculo> veiculosNaoMensalista;
	private List<ControleGaragem> garagem;
	private Cobranca cobranca; 
	
	public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	public ArrayList<Veiculo> veiculosMensalistas = new ArrayList<Veiculo>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Estacionamento () {
		clientes = new ArrayList<Cliente>();
		veiculosNaoMensalista = new ArrayList<Veiculo>();
		garagem = new ArrayList<ControleGaragem>();
		cobranca = new Cobranca();
		
	}
	
	public static void main(String[] args) throws DadosPessoaisIncompletoException, DadosVeiculosIncompletosException,  
		EstacionamentoFechadoException, PeriodoInvalidoException {
		
		
		Estacionamento estacionamento = new Estacionamento();
		
		// Função para rodar o menu
		rodarMenu();

		//Ainda não faço ideia de como lidar com isso 
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
	 * Sequência de código para criação do menu de visualização da interface
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
		
		// Alocar botões 
		Object[]  funcoes = { "Consultar Placa","Cadastrar Veículo"};
		int funcao = JOptionPane.showOptionDialog(null, "Bem-vindos ao serviço ", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			consultarPlaca(null); // My: /eu não achei esse método no seu codigo aqui, mas adicionar dentro dele o método BuscaPlaca 
						
			/**
			 * Passo-a-passo  dessa função 
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
			 * 	2.2)Caso não:
			 * 		Cadastrar veiculo novo?(s/n)
			 * 			Caso sim 
			 * 				cadastrarVeiculo()
			 * 			Caso não
			 * 				Encerra
			 *  
			 */
			
		}
		
		//Cadastrar Veiculo
		if (funcao == 1) {
			cadastrarVeiculo();
			
			/**
			 * Passo-a-passo  dessa função 
			 * 
			 * 1) Dados Veiculo 
			 * 2) Ele é mensalista? (s/n)
			 * 	
			 * 	2.1) Caso sim 
			 * 		a) Insira CNH (existe/ou n)
			 * 			a.1)Caso exista
			 * 				vinculcarVeiculoCliente();
			 * 			a.2) Caso nao exista
			 * 				cadastrarCliente();
			 * 	2.2) Caso não 
			 * 		Deseja registrar entrada? (s/n)
			 * 			Caso sim 
			 * 				registrarEntradaVeiculo()
			 * 			Caso nao
			 * 				sair
			 *
			 */
			
		}

		
		// Cancelar operação 
		else if (funcao == -1){
			valorDoBotao = -1;
		}
		
		return valorDoBotao;
	}
	
	

	/**
	 * Função responsável pelo funcionamento do menu até que a interface seja fechada
	 */
	public static void rodarMenu() {
		int condicao = menu();
		while (condicao >= 0 ) {
			condicao = menu();
		}
		
	}


	/**
	 * Sequencia de chamada de funções predeterminadas na UML 
	 * 
	 */
	

	public static  Veiculo consultarPlaca(String placa) {

		/**
		 * Rotina simplesmente representativa para entender o final do codigo
		 * Esta rotina deve ser alterada para testar se realmente existe e não por uma option pane 
		 * e checando os arquivos txt
		 * 
		 */
		int valorDoBotao = 0;
		JTextField campoTestePlaca = new JTextField (10);
		
		JPanel myPanel = new JPanel();
		if (valorDoBotao == 0) {
			myPanel.setLayout(new GridLayout(1,2));
			myPanel.add(new JLabel("Insira a placa do ve�culo: "));
			myPanel.add(campoTestePlaca);
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Checar placa", JOptionPane.OK_CANCEL_OPTION);
			
			
			int sair = 1;
			
			while (sair !=0) {
				if (valorDoBotao == 2 || valorDoBotao == -1) {
					sair =0;
				} else if(campoTestePlaca.getText().isEmpty()  ) {
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Checar placa", JOptionPane.OK_CANCEL_OPTION);
				} else if (valorDoBotao == 0) {
					sair = 0;
				}
					
				
			}
					
					
		}
		
		if (valorDoBotao == 0) {
			String placa2 = campoTestePlaca.getText();
			BuscaPlaca(placa2);
			
			if (BuscaPlaca(placa2) != null) { // Se placa existir 
				
				Object[] funcoes = {"Entrada", "Saï¿½da"};
				int tipoRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar uma entrada ou saï¿½da?", "Registro", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
				
					if(tipoRegistro == 0) {
						registrarEntradaVeiculo(null);
						
					} else if (tipoRegistro ==1) {
						registrarSaidaVeiculo(null);
						
						
					}
				
			} else if (BuscaPlaca(placa2) == null) { // Se não existir 
				
				
				Object[] placaNaoExiste = {"Sim", "Não"};
				int testaCadastro = JOptionPane.showOptionDialog(null, "Deseja cadastrar um carro novo?", "Checar desejo de cadastro", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, placaNaoExiste, placaNaoExiste[0]);
				
					if (testaCadastro == 0) {// Se deseja fazer o cadastro
						cadastrarVeiculo();  
						
					} else if(testaCadastro == 1) {
						//sai do codigo 
						
					}
					
			}
		
			
		}
			
		

		return null; 
	}
	
	

	public static  boolean cadastrarVeiculo () {
		
		/**
		 * Interface bem trabalhada, no entanto ela precisa ser finalizada no momento de decisão se existe ou nao CNH
		 * Precisa checar nos arquivos txt se existe ou nao CNH
		 * 
		 */
		
		
		// My: instaciar um objeto do tipo veiculo e chamar o método addVeiculo para poder adicionar ele no array, você ta pedindo os dados
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
				
				/**
				 * Como transformar mensalista em booleano ??
				 * Aqui encontro um poblema de inserir se é mensalista ou nao, mas se eu colocar o construtor veiculo, 
				 * não consigo definir como booleano, codigo abaixo comentado segue como seria se desse certo 
				 */
				
				//String mensalista = campoMensalista.getText();
				//veiculo = new Veiculo (placa, marca, modelo, null);
				
				/**
				 * Momento de arquivar -- receber variaveis, escrever em um txt e salvar
				 * exemplo de chamar esse tipo de funï¿½ao abaixo
				 */
				
				// lerEscrever.escreverVeiculo (veiculo);
				
				
			}
		}
		
		
		//Botoes 
		
		
		Object[] funcoes = {"Sim", "Não"};
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
						
						

						if (buscaCNH(checaCnh) != null ) { // Se existir algo 
							vincularVeiculosCliente(null, veiculo);
							
						} else if (buscaCNH(checaCnh) == null ) { // Se n�o existir nada
							cadastrarCliente ();
						}
		
		
						
						}
					}
								
		
				
				
					
				
				
			
			} else if (tipoDeVeiculo == 1) { // se nao for mensalista 
				
				
				/**
				 * Deseja ser mensalista?
				 * 		caso sim:
				 * 			cadastra cliente
				 * 		caso nao 
				 * 			registrar entrada 
				 * 
				 */
				
				
				
				
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
		
		JTextField campoPlaca = new JTextField (10);
		//  Como botar isso ?
		//Cliente cliente = new Cliente();
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
			myPanel.add(new JLabel("Placa: "));
			myPanel.add(campoPlaca);
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Cliente", JOptionPane.OK_CANCEL_OPTION);
			
			//Validacao 
			
			int sair = 1;
			
			while (sair !=0) {
				if (valorDoBotao == 2 || valorDoBotao == -1) {
					sair =0;
				} else if(campoNome.getText().isEmpty() || campoEndereco.getText().isEmpty()
						|| campoNumeroCelular.getText().isEmpty() || campoNumeroTelefone.getText().isEmpty() 
						|| campoNumeroCnh.getText().isEmpty()|| campoPlaca.getText().isEmpty()) {
					
					valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Veï¿½culo", JOptionPane.OK_CANCEL_OPTION);
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
					String nPlaca = campoPlaca.getText();
					//ArrayList <String> arrayVeiculo = new ArrayList <String>();
					//arrayVeiculo.add (veiculo);
					
					//Mari: usar aqui o BuscaPlacaMensalista(nplaca) para pegar os dados do veículo, depois usar o listaVeiculos()
					//para mudar o dado para List<Veiculos> e só depois disso incluir no construtor do cliente
										
					Cliente cliente = new Cliente ();
					
					
					/**
					 * Momento de arquivar -- receber variaveis, escrever em um txt e salvar
					 * exemplo de chamar esse tipo de funï¿½ao abaixo
					 */
					
					// lerEscrever.escreverCliente (cliente);
					
					//Mari: chamar o addCliente() para salvar os dados do cliente na memória
					
					
				}
			
		}
		
				
		}
		
		return false; 
	}
	

	
	
	public static boolean vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		
		/** 
		 * Vincular fica mais facil de fazer apos arquivos salvos e saber como puxar eles 
		 */
		
		// Mari: para vincular um veiculo a um cliente já existente, é só usar addVeiculo()
		
		
		return false;
	}
	
	public static boolean registrarEntradaVeiculo(Veiculo veiculo) {
		
		
		System.out.println("Entra ai carai");
		//JTextField campoDataEntrada = new JTextField (10);
		/**
		 * Fazer interface com variaveis
		 * 
		 */
	
		
		return false; 
	}
	
	public static boolean registrarSaidaVeiculo(Veiculo veiculo) {
		
		//JTextField campoDataSaida = new JTextField (10);
		/**
		 * Fazer interface com variaveis
		 * 
		 */
		System.out.println("Saia da minha vida");
		
		return false; 
	}
	
	public double cobrar(ControleGaragem controle) {
		
		
		
		return 0.0;
	}
	
	// Correção de veículo? ?????????????????????????? ALO AMIGOS 
	private Veiculo veiculo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static  Veiculo BuscaPlaca(String placa) {

        for (Veiculo veiculo : veiculos) {

            if (veiculo.getPlaca().equals(placa)) {

                return veiculo;
            }

        }

        return null;
    }
	
	public void addVeiculo (Veiculo CadastroVeiculo) {
		
		if (CadastroVeiculo.getMensalista() == true) {
			
			veiculosMensalistas.add(CadastroVeiculo); // Adicionando a lista especifica só de mensalistas
		}
		
		veiculos.add(CadastroVeiculo); // Adicionando todos a uma outra lista (mensalistas ou não)
			
	}
	
	
	// Método para adicionar todos os clientes em uma lista
		public void addCliente(Cliente cliente) {
			clientes.add(cliente); 		
		}
	
	
	
	//Método para buscar cliente pela CNH
	public static Cliente buscaCNH(int CNH) {

        for (Cliente cliente : clientes) {

            if (cliente.getNumeroCNH() == CNH) {
                return cliente;
            }

        }
        
        return null;
	}
	
	//Método para criar a lista de Veículos
	public List<Veiculo> listaVeiculos(Veiculo veiculo) {
		ArrayList<Veiculo> novoVeiculo = new ArrayList<Veiculo>();
		novoVeiculo.add(veiculo);
		return novoVeiculo;
	}
}
	
	
	

