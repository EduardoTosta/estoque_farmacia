package estoque_farmacia.model;

public class Cosmeticos extends Produto{
	
	private String fragrancia;

	//Metodo Construtor
	public Cosmeticos(int id, int tipo, String nome, float preco, String fragrancia) {
		super(id, tipo, nome, preco);
		this.fragrancia = fragrancia;
	}


	//Metodos
	public void visualizar() {
		super.visualizar();
		System.out.println(getFragrancia());
	}
	
	
	//Getters e Setters
	public String getFragrancia() {
		return fragrancia;
	}

	public void setFragancia(String fragrancia) {
		this.fragrancia = fragrancia;
	}
	
	
	
}
