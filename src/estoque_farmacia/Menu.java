package estoque_farmacia;

import java.io.IOException;
import java.util.Scanner;

import estoque_farmacia.controller.EstoqueController;
import estoque_farmacia.model.Cosmeticos;
import estoque_farmacia.model.Medicamento;
import estoque_farmacia.model.Produto;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EstoqueController controller = new EstoqueController();

        int opcao, id, tipo;
        String nome;
        float preco;

        do {
            menuPrincipal();

            while (!scanner.hasNextInt()) {
                System.out.print("Digite uma opção válida: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Produto ---");
                    System.out.print("ID do Produto: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer
                    
                    System.out.print("Nome do Produto: ");
                    nome = scanner.nextLine();
               
                    System.out.print("Preço do Produto: ");
                    preco = scanner.nextFloat();
                    scanner.nextLine(); // Limpa buffer
                    
                    System.out.print("Tipo do Produto (1-Medicamento || 2-Cosmético): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // limpa buffer
                    
                    switch(tipo) {
                    	case 1: 
                    		System.out.println("Digite a fragancia: ");
                    		String generico = scanner.nextLine();
                    		 Medicamento medicamento = new Medicamento(id, tipo, nome, preco, generico);
                             controller.cadastrar(medicamento);
                    		keyPress();
                            break;
                    	case 2: 
                    		System.out.println("Digite a fragancia: ");
                    		String fragrancia = scanner.nextLine();
                    		Cosmeticos cosmetico = new Cosmeticos(id, tipo, nome, preco, fragrancia);
                            controller.cadastrar(cosmetico);
                    		keyPress();
                            break;
                    }
               
                    keyPress();
                    break;

                case 2:
                    System.out.println("\n--- Lista de Produtos ---");
                    System.out.print("1 - Listar todos || 2 - filtrar por tipo ");
                    opcao = scanner.nextInt();
                    
                    switch(opcao) {
                    case 1:
                    	 controller.listarTodas();
                         
                         keyPress();
                         break;
                         
                    case 2:
                        System.out.print("Tipo do Produto (1-Medicamento || 2-Cosmético): ");
                        tipo = scanner.nextInt();
                    	controller.listarPorFiltro(tipo);
                    }
                    keyPress();
                    break;

                case 3:
                    System.out.print("\nDigite o ID do produto a buscar: ");
                    id = scanner.nextInt();
                    controller.procurarPorNumero(id);
                    
                    keyPress();
                    break;

                case 4:
                    System.out.print("\nDigite o ID do produto a atualizar: ");
                    id = scanner.nextInt();
                    Produto atualizarProduto = new Produto(id, 0, "", 0f) {};
                   	System.out.println("\nO que deseja atualizar no produto ID " + atualizarProduto.getId() + "?");
                   	menuAtualizar();
                    controller.atualizar(atualizarProduto);
                    
                    keyPress();
                    break;

                case 5:
                    System.out.print("\nDigite o ID do produto a remover: ");
                    id = scanner.nextInt();
                    controller.deletar(id);
                    
                    keyPress();
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Obrigado!");
                    sobre();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
    
    public static void menuPrincipal() {
    	System.out.println("=================================");
        System.out.println("       ESTOQUE DA FARMÁCIA       ");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar os Produtos");
        System.out.println("3 - Buscar Produto por ID");
        System.out.println("4 - Atualizar Produto");
        System.out.println("5 - Remover Produto");
        System.out.println("0 - Sair");
        System.out.print("Digite a opção desejada: ");
    }
    
    public static void menuAtualizar() {
        System.out.println("1 - Tipo");
        System.out.println("2 - Nome");
        System.out.println("3 - Preço");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }
    
    public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Eduardo Tosta");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/EduardoTosta");
		System.out.println("*********************************************************");
	}
    
  //Antes de cada break do switch case, deve-se colocar uma chamada para o KeyPress
  		public static void keyPress() {
  	 		try {
  	  
  	 			System.out.println("\n\nPressione Enter para Continuar...");
  	 			System.in.read();
  	  
  	 		} catch (IOException e) {
  	  
  	 			System.err.println("Ocorreu um erro ao tentar ler o teclado");
  	  
  	 		}
  		}
}
