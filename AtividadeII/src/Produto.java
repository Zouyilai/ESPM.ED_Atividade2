
public class Produto {
	String nome;
	String validade;
	int estoque;
	
	public Produto(String nome, String validade, int estoque) {
		this.nome = nome;
		this.validade = validade;
		this.estoque = estoque;
	}
	
	public Produto(String nome) {
		this.nome = nome;
	}
	
	public boolean verificarEstoque(int quantidade) {
		if(estoque >= quantidade&&quantidade > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void baixarEstoque(int quantidade) {
		estoque = estoque - quantidade;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Produto aux = (Produto) obj; 
		
		if(aux.nome.equalsIgnoreCase(nome)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String dados = "";
		dados += "Nome  -> " + this.nome + "\n";
		dados += "Validade -> " + this.validade + "\n";
		dados += "Estoque ->  " + this.estoque + "\n";
		dados += "-----------" + "\n";
		return dados;
	}
}
