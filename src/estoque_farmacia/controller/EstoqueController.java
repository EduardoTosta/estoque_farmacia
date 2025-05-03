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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}
	
}
