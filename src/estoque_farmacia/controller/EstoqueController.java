package estoque_farmacia.controller;

import java.util.ArrayList;
import java.util.Scanner;

import conta_bancaria.repository.EstoqueRepository;
import estoque_farmacia.model.Produto;

public class EstoqueController implements EstoqueRepository{
	
	//Criar collection array list
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	//Variável para controlar o numero das contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var produto = buscarNaCollection(numero);
		
		if(produto != null) 
			produto.visualizar();
		else
			System.out.println("O Produto não foi encontrado");
		
			
	}

	@Override
	public void listarTodas() {
		for(var produto : listaProdutos)
			produto.visualizar();
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto adicionado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto produto) {
	    Scanner leia = new Scanner(System.in);

	    Produto existente = buscarNaCollection(produto.getId());

	    if (existente != null) {
	        int opcao;

	        do {
	            System.out.println("\nO que deseja atualizar no produto ID " + produto.getId() + "?");
	            System.out.println("1 - Tipo");
	            System.out.println("2 - Nome");
	            System.out.println("3 - Preço");
	            System.out.println("0 - Sair");
	            System.out.print("Opção: ");
	            opcao = leia.nextInt();
	            leia.nextLine(); // limpar o buffer

	            switch (opcao) {
	                case 1:
	                    System.out.print("Novo tipo: ");
	                    int novoTipo = leia.nextInt();
	                    existente.setTipo(novoTipo);
	                    System.out.println("Tipo atualizado com sucesso!");
	                    break;
	                case 2:
	                    System.out.print("Novo nome: ");
	                    String novoNome = leia.nextLine();
	                    existente.setNome(novoNome);
	                    System.out.println("Nome atualizado com sucesso!");
	                    break;
	                case 3:
	                    System.out.print("Novo preço: ");
	                    float novoPreco = leia.nextFloat();
	                    existente.setPreco(novoPreco);
	                    System.out.println("Preço atualizado com sucesso!");
	                    break;
	                case 0:
	                    System.out.println("Saindo da atualização...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        } while (opcao != 0);

	    } else {
	        System.out.println("Produto não encontrado.");
	    }
	}



	@Override
	public void deletar(int numero) {
		var produto = buscarNaCollection(numero);
		
		if(produto != null) {
			listaProdutos.remove(produto);
			System.out.println("Produto removido com sucesso");
		}else
			System.out.println("O produto não foi encontrado");
			
		
	}
	
	
	public Produto buscarNaCollection(int numero) {
		for(var produto: listaProdutos) {
			if(produto.getId() == numero)
				return produto;
		}
		return null;
	}
}
