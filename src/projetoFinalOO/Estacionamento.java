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
import java.text.ParseException;

public class Estacionamento {

	//private List<Cliente> clientes; 
	private List<Veiculo> veiculosNaoMensalista;
	private List<ControleGaragem> garagem;
	private Cobranca cobranca; 
	
	public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	public static ArrayList<Veiculo> veiculosMensalistas = new ArrayList<Veiculo>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<ControleGaragem> listaData = new ArrayList<ControleGaragem>();
	
	public Estacionamento () {
		clientes = new ArrayList<Cliente>();
		veiculosNaoMensalista = new ArrayList<Veiculo>();
		garagem = new ArrayList<ControleGaragem>();
		cobranca = new Cobranca();
		
	}
	
	public static void main(String[] args) throws DadosPessoaisIncompletoException, DadosVeiculosIncompletosException,  
		EstacionamentoFechadoException, PeriodoInvalidoException {
		
		
		Estacionamento estacionamento = new Estacionamento();
		
		// FunÃ§Ã£o para rodar o menu
		rodarMenu();

		//Ainda nÃ£o faÃ§o ideia de como lidar com isso 
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
	 * SequÃªncia de cÃ³digo para criaÃ§Ã£o do menu de visualizaÃ§Ã£o da interface
	 *
	 * Funcionamento
	 * 1) Int menu: primeira tela 
	 * 2) void rodarMenu: funcionamento do menu  
	 * 3) rodarMenu: chamada na main 
	 * 
	 */
	
	
	public static int menu(){
		//variavel para botao
		int valorDoBotao = 0;
		
		// Alocar botÃµes 
		Object[]  funcoes = { "Iniciar serviço",};
		int funcao = JOptionPane.showOptionDialog(null, "Bem-vindos ao serviço EstacioneX", "O que deseja fazer?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
		
		//Consultar Placa
		if (funcao == 0 ) {
			consultarPlaca(null); // My: /eu nÃ£o achei esse mÃ©todo no seu codigo aqui, mas adicionar dentro dele o mÃ©todo BuscaPlaca 
						
			/**
			 * Passo-a-passo  dessa funÃ§Ã£o 
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
			 * 	2.2)Caso nÃ£o:
			 * 		Cadastrar veiculo novo?(s/n)
			 * 			Caso sim 
			 * 				cadastrarVeiculo()
			 * 			Caso nÃ£o
			 * 				Encerra
			 *  
			 */
			
		}
		
		//Cadastrar Veiculo
		//if (funcao == 1) {
		//	cadastrarVeiculo();
			
			/**
			 * Passo-a-passo  dessa funÃ§Ã£o 
			 * 
			 * 1) Dados Veiculo 
			 * 2) Ele Ã© mensalista? (s/n)
			 * 	
			 * 	2.1) Caso sim 
			 * 		a) Insira CNH (existe/ou n)
			 * 			a.1)Caso exista
			 * 				vinculcarVeiculoCliente();
			 * 			a.2) Caso nao exista
			 * 				cadastrarCliente();
			 * 	2.2) Caso nÃ£o 
			 * 		Deseja registrar entrada? (s/n)
			 * 			Caso sim 
			 * 				registrarEntradaVeiculo()
			 * 			Caso nao
			 * 				sair
			 *
			 */
			
		//}

		
		// Cancelar operaÃ§Ã£o 
		else if (funcao == -1){
			valorDoBotao = -1;
		}
		
		return valorDoBotao;
	}
	
	

	/**
	 * FunÃ§Ã£o responsÃ¡vel pelo funcionamento do menu atÃ© que a interface seja fechada
	 */
	public static void rodarMenu() {
		int condicao = menu();
		while (condicao >= 0 ) {
			condicao = menu();
		}
		
	}


	/**
	 * Sequencia de chamada de funÃ§Ãµes predeterminadas na UML 
	 * 
	 */
	

	public static  Veiculo consultarPlaca(String placa) {

		/**
		 * Rotina simplesmente representativa para entender o final do codigo
		 * Esta rotina deve ser alterada para testar se realmente existe e nÃ£o por uma option pane 
		 * e checando os arquivos txt
		 * 
		 */
		int valorDoBotao = 0;
		JTextField campoTestePlaca = new JTextField (10);
		
		JPanel myPanel = new JPanel();
		if (valorDoBotao == 0) {
			myPanel.setLayout(new GridLayout(1,2));
			myPanel.add(new JLabel("Insira a placa do veículo: "));
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
				
				Object[] funcoes = {"Entrada", "Saída"};
				int tipoRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar uma entrada ou saídaa?", "Registro", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, funcoes, funcoes[0]);
				
					if(tipoRegistro == 0) {
						registrarEntradaVeiculo(null);
						
					} else if (tipoRegistro ==1) {
						registrarSaidaVeiculo(null);
						
						
					}
				
			} else if (BuscaPlaca(placa2) == null) { // Se nÃ£o existir 
				
				
				Object[] placaNaoExiste = {"Sim", "Não"};
				int testaCadastro = JOptionPane.showOptionDialog(null, "Deseja cadastrar um carro novo?", "Checar desejo de cadastro", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, placaNaoExiste, placaNaoExiste[0]);
				
					if (testaCadastro == 0) {// Se deseja fazer o cadastro
						cadastrarVeiculo();  
						
					} else if(testaCadastro == 1) {
						
						
					}
					
			}
		
			
		}
			
		

		return null; 
	}
	
	

	public static boolean cadastrarVeiculo () {
		
		/**
		 * Interface bem trabalhada, no entanto ela precisa ser finalizada no momento de decisÃ£o se existe ou nao CNH
		 * Precisa checar nos arquivos txt se existe ou nao CNH
		 * 
		 */

		
		
		//Inicializar
		JTextField campoPlaca = new JTextField(10);
		JTextField campoMarca = new JTextField(10);
		JTextField campoModelo = new JTextField(10);
		JTextField campoMensalista = new JTextField(10);
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
			myPanel.add(new JLabel ("Vai ser mensalista? (s/n): "));
			myPanel.add(campoMensalista);
			
		
		
			
			valorDoBotao = JOptionPane.showConfirmDialog(null, myPanel, "Cadastro de Veíulo", JOptionPane.OK_CANCEL_OPTION);
			
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
				String mensalista = campoMensalista.getText();
				
				boolean mensal = true;
				if (mensalista.equals('s') ) {
					mensal = true;
				} else if (mensalista.equals('n')) {
					 mensal = false; 
				}
			
	
				Veiculo veiculo = new Veiculo (placa, marca, modelo, mensal);
				
				addVeiculo(veiculo);
				
				
				
				if (mensal = true) { /// SIM VAI SER MENSALISTA
					
					int valorPainel = 0;
					
					if (valorPainel == 0) { // Checar se CNH Existe -- problema critico 
						
						
						JTextField campoCnh = new JTextField (10);
						
						
						myPanel.add(new JLabel("CNH: "));
						myPanel.add(campoCnh);
						valorPainel = JOptionPane.showConfirmDialog(null, myPanel, "Checa CNH", JOptionPane.OK_CANCEL_OPTION);
						
						int sair1 = 1;
						
						while (sair1 !=0) {
							if (valorPainel == 2 || valorPainel == -1) {
								sair1 =0;
							} else if(campoCnh.getText().isEmpty() ) {
								
								valorPainel = JOptionPane.showConfirmDialog(null, myPanel, "Checa CNH", JOptionPane.OK_CANCEL_OPTION);
							} else if (valorPainel == 0) {
								sair1 = 0;
							}
							
							
							if(valorPainel == 0) {
								
							int checaCnh = Integer.parseInt(campoCnh.getText()); 
							
							

							if (buscaCNH(checaCnh) != null ) { // Se existir algo 
								
								Cliente	cliente = buscaCNH(checaCnh);
								
								vincularVeiculosCliente(cliente, veiculo);
								
								Object[] blocoRegistro = {"Sim", "Não"};
								int checaRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar entrada de carro?", "Registro de Entrada", 
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, blocoRegistro, blocoRegistro[0]);
								
								if (checaRegistro == 0 ) { // se sim desja 
									
									String message1 = "Você sera direcionado para Registro de Entrada";
									
									JOptionPane.showMessageDialog(null, message1);
									
									registrarEntradaVeiculo(veiculo);
									
								} else if ( checaRegistro == 1) {// e nao deseja
									
									String message1 = "Cadastro de Veículo feito com sucesso.";
									
									JOptionPane.showMessageDialog(null, message1);
									
								}
								
								
								
								
							} else if (buscaCNH(checaCnh) == null ) { // Se não existir nada
								
								
								cadastrarCliente ();
							}
			
			
								
								}
							}
						
			
					
					
						} 
				
				
					
				
					} else if (mensal = false) { /// NAO NAO VAI SER MENSALISTA 
					JOptionPane.showMessageDialog(null, placa);
					
					Object[] blocoRegistro = {"Sim", "Não"};
					int checaRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar entrada de carro?", "Registro de Entrada", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, blocoRegistro, blocoRegistro[0]);
					
					if (checaRegistro == 0 ) {
						
						String message = "Cadastro de Veículo feito com sucesso, você sera direcionado para Registro de Entrada";
						
						JOptionPane.showMessageDialog(null, message);
						
						registrarEntradaVeiculo(veiculo);
						
					} else if ( checaRegistro == 1) {
						
						String message = "Cadastro de Veículo feito com sucesso.";
						
						JOptionPane.showMessageDialog(null, message);
						
					}
				}
				
				
				
			}// check 
		}//check 
		
		
		
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
					String nPlaca = campoPlaca.getText();
				
			
					Cliente cliente = new Cliente (nome, endereco, numeroCelular, numeroTelefone, 
							numeroCnh, listaVeiculos(BuscaPlaca(nPlaca)));
					
					addCliente(cliente);
					
					
			

					Object[] blocoRegistro = {"Sim", "Não"};
					int checaRegistro = JOptionPane.showOptionDialog(null, "Deseja registrar entrada de carro?", "Registro de Entrada", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, blocoRegistro, blocoRegistro[0]);
					
					if (checaRegistro == 0 ) { // se sim desja 
						
						String message1 = "Você sera direcionado para Registro de Entrada";
						
						JOptionPane.showMessageDialog(null, message1);
						
						registrarEntradaVeiculo(BuscaPlaca(nPlaca));
						
					} else if ( checaRegistro == 1) {// e nao deseja
						
						String message1 = "Cadastro de Cliente feito com sucesso.";
						
						JOptionPane.showMessageDialog(null, message1);
						
					}
					
					
					
	
				}
	
				
			
		}
		
				
		}
		
		
	return false;
	}
	

	
	
	public static void vincularVeiculosCliente (Cliente cliente, Veiculo veiculo) {
		
		cliente.addVeiculo(veiculo);  
		
		
		String message = "Veiculo vinculado com sucesso.";
		
		JOptionPane.showMessageDialog(null, message);
		
		/** 
		 * Vincular fica mais facil de fazer apos arquivos salvos e saber como puxar eles 
		 */
		

		
	
	}
	
	public static boolean registrarEntradaVeiculo(Veiculo veiculo) {
		
		Calendar dataEntrada = Calendar.getInstance();
		ControleGaragem controleGaragem = new ControleGaragem (dataEntrada, null, veiculo);
		 
	
		
		return false; 
	}
	
	public static boolean registrarSaidaVeiculo(Veiculo veiculo) {
		
		//JTextField campoDataSaida = new JTextField (10);
		/**
		 * Fazer interface com variaveis
		 * 
		 */
		String message = "Regis out ";
		
		JOptionPane.showMessageDialog(null, message);
		
		return false; 
	}
	
	public double cobrar(ControleGaragem controle) {
		
		
		
		return 0.0;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////// FUNÇOES                    ////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public static  Veiculo BuscaPlaca(String placa) {

        for (Veiculo veiculo : veiculos) {

            if (veiculo.getPlaca().equals(placa)) {

                return veiculo;
            }

        }

        return null;
    }
	
	public static void addVeiculo (Veiculo CadastroVeiculo) {
		
		if (CadastroVeiculo.getMensalista() == true) {
			
			veiculosMensalistas.add(CadastroVeiculo); // Adicionando a lista especifica sÃ³ de mensalistas
		}
		
		veiculos.add(CadastroVeiculo); // Adicionando todos a uma outra lista (mensalistas ou nÃ£o)
		
		
			
	}
	
	
	// MÃ©todo para adicionar todos os clientes em uma lista
		public static void addCliente(Cliente cliente) {
			clientes.add(cliente); 		
		}
	
	
	
	//MÃ©todo para buscar cliente pela CNH
	public static Cliente buscaCNH(int CNH) {

        for (Cliente cliente : clientes) {

            if (cliente.getNumeroCNH() == CNH) {
                return cliente;
            }

        }
        
        return null;
	}
	
	//MÃ©todo para criar a lista de VeÃ­culos
	public static List<Veiculo> listaVeiculos(Veiculo veiculo) {
		ArrayList<Veiculo> novoVeiculo = new ArrayList<Veiculo>();
		novoVeiculo.add(veiculo);
		return novoVeiculo;
	}

	
public ControleGaragem buscaData(Veiculo veiculo) {
	for (ControleGaragem controleGaragem : listaData) {
	    if (controleGaragem.getVeiculo().equals(veiculo)) {
		return controleGaragem;
	    }
	}

    	return null;
    }
}	
	

