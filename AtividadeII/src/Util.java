import javax.swing.JOptionPane;

public class Util {

	static Lista<Produto> lista = new Lista<Produto>();
	
	public static void cadastrarProduto() {
		String nome;
		
		nome = JOptionPane.showInputDialog("Informe o nome do produto: ");
		Produto produto = new Produto(nome);
		
		if(lista.pesquisar(produto) != null) {
			JOptionPane.showMessageDialog(null, "Produto existente!");
		} else {
			String validade;
			int estoque = 0;
			validade = JOptionPane.showInputDialog("Informe a data de validade do produto(yyyy/mm/dd): ");
			estoque = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de estoque do produto:"));
			
			while(estoque <= 0) {
				estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de estoque deve ser maior que 0!\nInforme a quantidade de estoque do produto:"));
			}
	
			Produto produto_lista = new Produto(nome, validade, estoque);
			lista.inserir(produto_lista);
		}		
		
	}

	public static void listarProduto() {
		lista.imprimir();
		
	}

	public static void venderProduto() {
		String nome;
		nome = JOptionPane.showInputDialog("Informe o nome do produto: ");
		Produto produto = new Produto(nome);
		No aux = lista.pesquisar(produto);
		
		if(aux != null) {
			int quantidade;
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produto a ser comercializada: "));
			produto = (Produto)aux.dado;
			
			if(produto.verificarEstoque(quantidade)) {
				produto.baixarEstoque(quantidade);
				if(produto.estoque == 0) {
					lista.remover(produto);
				}
			} else {
				if(quantidade <= 0) {
					JOptionPane.showMessageDialog(null, "Erro! Quantidade deve ser maior que 0!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro! Quantidade insuficiênte");
				}	
			}
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}
	
}
