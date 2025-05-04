package estoque_farmacia.controller;

import java.util.ArrayList;

import conta_bancaria.repository.EstoqueRepository;
import estoque_farmacia.model.Produto;

public class EstoqueController implements EstoqueRepository{
	
	//Criar collection array list
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	//Variável par a controlar o nmero das contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		
	}

	@Override
	public void listarTodas() {
		for(var produto : listaProdutos)
			produto.visualizar();
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto adcionado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		
	}
	
}
