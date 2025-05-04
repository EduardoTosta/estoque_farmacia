package estoque_farmacia.repository;

import estoque_farmacia.model.Produto;

public interface EstoqueRepository {
	
	//Métodos do CRUD (Create, Read, Update e Delete)
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
}
