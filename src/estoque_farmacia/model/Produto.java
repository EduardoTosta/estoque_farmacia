package estoque_farmacia.model;

public abstract class Produto {
	
	private int id, tipo;
	private String nome;
	private float preco;
	
	public Produto(int id, int tipo, String nome, float preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;
	}


	//Metodos 
	public void visualizar() {
	    System.out.println("-----------------------------");
	    System.out.println("ID: " + this.id);
	    System.out.println("Tipo: " + this.tipo);
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Preço: R$ " + this.preco);
	    System.out.println("-----------------------------");
	}

	
	
	//Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	
}
