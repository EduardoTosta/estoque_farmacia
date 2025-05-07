package estoque_farmacia.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import estoque_farmacia.model.Produto;
import estoque_farmacia.repository.EstoqueRepository;

public class EstoqueController implements EstoqueRepository{
	
	//Criar collection array list
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
    Scanner leia = new Scanner(System.in);
	
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
		if(listaProdutos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
		}else {
			System.out.println("Produtos cadastrados: ");
			for(var produto : listaProdutos)
				produto.visualizar();
		}
		
	}
	
	@Override
	public void listarPorFiltro(int tipo) {
		List<Produto> filtraTipo = listaProdutos.stream()
				.filter(p -> p.getTipo() == tipo)
				.collect(Collectors.toList());
				
		if (filtraTipo.isEmpty()) {
			System.out.println("Nenhum produto encontrado para o tipo informado.");
	    } else {
	    	for (Produto produto : filtraTipo) 
		            produto.visualizar();        
		  }
	}
	

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto adicionado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto produto) {

	    Produto existente = buscarNaCollection(produto.getId());

	    if (existente != null) {
	        int opcao;

	        do {
	            opcao = leia.nextInt();
	            leia.nextLine(); // limpar o buffer

	            switch (opcao) {
	                case 1:
	                    System.out.print("Novo tipo: ");
	                    int novoTipo = leia.nextInt();
	                    existente.setTipo(novoTipo);
	                    System.out.println("Tipo atualizado com sucesso!");
	                    
	                    keyPress();
	                    break;
	                case 2:
	                    System.out.print("Novo nome: ");
	                    String novoNome = leia.nextLine();
	                    existente.setNome(novoNome);
	                    System.out.println("Nome atualizado com sucesso!");
	                    
	                    keyPress();
	                    break;
	                case 3:
	                    System.out.print("Novo preço: ");
	                    float novoPreco = leia.nextFloat();
	                    existente.setPreco(novoPreco);
	                    System.out.println("Preço atualizado com sucesso!");
	                    
	                    keyPress();
	                    break;
	                case 0:
	                    System.out.println("Saindo da atualização...");
	                    
	                    keyPress();
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
