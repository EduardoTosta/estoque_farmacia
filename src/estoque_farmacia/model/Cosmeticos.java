package estoque_farmacia.model;

public class Cosmeticos extends Produto{
	
	private String fragancia;

	//Metodo Construtor
	public Cosmeticos(int id, int tipo, String nome, float preco, String fragancia) {
		super(id, tipo, nome, preco);
		this.fragancia = fragancia;
	}


	//Metodos
	public void visualizar() {
		super.visualizar();
		System.out.println(getFragancia());
	}
	
	
	
	
	//Getters e Setters
	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	
	
	
}
