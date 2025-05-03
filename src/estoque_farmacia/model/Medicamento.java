package estoque_farmacia.model;

public class Medicamento extends Produto {
	
	private String generico;

	
	//Metodo Construtor
	public Medicamento(int id, int tipo, String nome, float preco, String generico) {
		super(id, tipo, nome, preco);
		this.generico = generico;
	}


	//Metodos 
	public void visualizar() {
		super.visualizar();
		System.out.println(getGenerico());
	}
	

	//Getters e Setters
	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}
	
	
	
}
