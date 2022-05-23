import javax.swing.JOptionPane;

public class Lista <T>{
	No<T> inicio, fim;
	int total;
	
	//método para inserir um elemento de forma ordenada
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado);
		Produto auxP = (Produto) aux.dado;

		if(inicio == null){//sem elemento
			inicio = aux;
			fim = aux;
		} else {//> 1 elemento
			Produto fimP = (Produto) fim.dado;
			Produto inicioP = (Produto) inicio.dado;
			
			No aux2 = inicio;
			Produto aux2P = (Produto) aux2.dado;
			
			if(auxP.validade.compareTo(fimP.validade) >= 0){ //maior ou igual que o ultimo
				fim.dir = aux;
				aux.esq = fim;
				fim = aux;
			} else if (auxP.validade.compareTo(inicioP.validade) < 0) {//menor que o primeiro
				inicio.esq = aux;
				aux.dir = inicio;
				inicio = aux;
			} else {
				while(aux2 != null){ //entre 2 elementos
					Produto aux2Dir = (Produto) aux2.dir.dado;
					if (auxP.validade.compareTo(aux2Dir.validade) <= 0 && auxP.validade.compareTo(aux2P.validade) >= 0){
						aux.esq = aux2;
						aux2.dir.esq = aux;
						aux.dir = aux2.dir;
						aux2.dir = aux;
						break;
					}
					aux2 = aux2.dir;
				}
			}
		}
		total ++;	
	}
	
	//método para pesquisar um elemento e retornar o endereço de memória
	public No<T> pesquisar(T dado) {
		No<T> aux = inicio;
		boolean achou = false;
		while(aux != null && achou == false) {
			if(aux.dado.equals(dado)) {
				achou = true;
				break;
			} 
			aux = aux.dir; 
			
		}
		return aux;
	}
	
	
	//método para remover um elemento da lista
	public void remover(T dado) {
		No<T> aux = pesquisar(dado);
		
		if(aux != null) {
			if(total == 1) {//caso tenha um único elemento
				inicio = null;
				fim = null;	
			} else if(aux == inicio) { //primeiro elemento
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if(aux == fim){//último elemento
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {//elemento do meio
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
			
			total--;
		}
	}
	
	public void imprimir() {
		No<T> aux = inicio;
		String aux2 = "";
		while(aux != null) {
			aux2 += aux.dado;
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, aux2);
	}
}
