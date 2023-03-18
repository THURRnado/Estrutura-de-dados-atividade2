package atividadeListas;

public class No {

	//definição dos atributos
	private int conteudo;
	private No proximo;
	
	//fazendo com que, quando um objeto No for instanciado, aponte para null
	public No() {
		 this.proximo = null;
	}

	//pega o conteudo contino no No
	public int getConteudo() {
		return conteudo;
	}

	//atribui o conteudo do No
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	//aponta para o proximo no (de maneira mais simples: anda uma casa)
	public No getProximo() {
		return proximo;
	}

	//escolhe para qual No apontar
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
	
}
