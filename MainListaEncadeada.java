package atividadeListas;

public class MainListaEncadeada {

	public static void main(String[] args) {

		//instanciando a classe
		ListaEncadeada l = new ListaEncadeada();
		
		//inserido três dados na lista
		l.insere(1,10);
		l.insere(2,20);
		l.insere(3,30);
		
		//printando na tela todos os elementos da lista
		System.out.print("Lista: ");
		for(int i = 1 ; i <= l.tamanho() ; i++) {	
			System.out.print(l.elemento(i) + ", ");
		}
		
		System.out.println();
		
		//verificando se a lista está vazia
		System.out.println("A lista está vazia?  " + l.vazia());
		
		//Obtendo o tamanho da lista
		System.out.println("Qual o tamanho da lista? " + l.tamanho());
		
		//modificando um elemento da lista
		l.modificaElemento(25, 2);
		System.out.print("Lista modificada: ");
		for(int i = 1 ; i <= l.tamanho() ; i++) {	
			System.out.print(l.elemento(i) + ", ");
		}
		
		//Removendo um elemento da lista
		l.remove(1);
		System.out.print("\nLista com o elemento removido: ");
		for(int i = 1 ; i <= l.tamanho() ; i++) {	
			System.out.print(l.elemento(i) + ", ");
		}
		
	}

}
