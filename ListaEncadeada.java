package atividadeListas;

public class ListaEncadeada extends No implements Lista  {
	
	//definindo os atributos
	private No cabeca;
	private int tamanho;
	
	//fazendo com que a variavel No cabeca aponte para null e que a lista receba tamanho 0
	public ListaEncadeada() {
		
		this.cabeca = null;
		this.tamanho = 0;
		
	}
	
//se tamanho da lista for igual a 0 então retorna true
@Override
public boolean vazia() {
	if(this.tamanho == 0) return true; else return false;
}


//Esse método não é necessário em Listas encadeadas, pois elas não possuem um tamanho máximo
@Override
public boolean cheia() {
	return false;
}


//retorna o tamanho da lista
@Override
public int tamanho() {
	return this.tamanho;
}


/*
 * verifica se a lista esta vazia, se estiver, retorna -1, caso contrario
 * verifica se a posição é valida, se tambem não for, retorna 1, caso também não ocorra
 * percorre a lista até achar a posição inserida, enquanto isso faz a variavel No auxiliar
 * ir andando de No em No.
 * Quando a posição requerida é encontrada, retorna-se o conteudo contido na variavel auxiliar;
 */
@Override
public int elemento(int pos) {
	No aux = this.cabeca;
	int cont = 1;
	
	if(vazia()) return -1;
	
	if(pos < 1 || pos > this.tamanho) return -1;
	
	while(cont < pos) {
		
		aux = aux.getProximo();
		cont++;
	}
	
	return aux.getConteudo();
	
}
	
/*
 * verifica se a lista esta vazia, se estiver, retorna -1, caso contrario
 * verifica se a posição é valida, se tambem não for, retorna 1, caso também não ocorra
 * percorre a lista até achar a posição inserida, enquanto isso faz a variavel No auxiliar
 * ir andando de No em No.
 * Quando a posição requerida é encontrada, modifica o valor da posição encontrada pelo valor passado
 */
public boolean modificaElemento(int valor, int pos) {
	No aux = this.cabeca;
	int cont = 1;
	
	if(vazia()) return false;
	
	if(pos < 1 || pos > this.tamanho) return false;
	
	while(cont < pos) {
		
		aux = aux.getProximo();
		cont++;
	}

	aux.setConteudo(valor);

return true;
	
}


/*
 * priemeiro verifica se a lista está vazia, se estiver, o método é encerrado,
 * caso contrário, percorre a lista até achar o conteudo inserido, enquanto isso
 * ocorre a varial No auxiliar vai andando de No em No. Quando o conteúdo é por
 * fim achado, é retornado o a posição na qual ele se encontra
 */
@Override
public int posição(int dado) {
	int cont = 1;
	No aux;
	
	if(vazia()) return 0;
	
	aux = cabeca;
	while(aux != null) {
		
		if(aux.getConteudo() == dado) return cont;
		
		aux = aux.getProximo();
		cont++;
	}
	
	return -1;
	
}

/*
 * faz um novoNo receber o valor inserido, em seguida faz esse mesmo No apontar para o No
 * para o qual a cebeca estava apontando. Em seguida faz cabeca receber o novoNo, fazendo assim
 * ela receber tanto o conteúdo do No como também seu ponteiro apomtando para null que antes
 * lhe pertencia. Por fim o tamanho da lista é acrescido em 1 e true é retornado
 */
private boolean insereInicioDaLista(int valor) {
	No novoNo = new No();
	
	novoNo.setConteudo(valor);
	novoNo.setProximo(this.cabeca);
	this.cabeca = novoNo;
	this.tamanho++;
	
	return true;
}

/*
 * cria um novoNo e o faz receber o dado inserido, em seguida cria um No auxiliar
 * que recebe a cabeca. Logo mais percorremos a lista até que se encontre a posição
 * antecessora à inserida e fazemos o No auxiliar ficar nela e apontar para a que queremos.
 * Em seguida fazemos o novoNo que está com o conteudo novo apontar para a posição que queremos e
 * depois fazemos o No auxiliar apontar para o novoNo, fazendo com a que a lista receba o novoNo
 * como parte da lista. Para melhor entendimento o novoNo vai estar com o conteudo que queremos 
 * inserir na posição e por meio de todo esse proesso ele acaba recebendo a posição que inserimos.
 * Por fim, o tamanho da lista é acrescido em 1 e true é retornado
 */
private boolean insereMeioLista(int pos, int dado) {
	int cont = 1;
	No novoNo = new No();
	novoNo.setConteudo(dado);
	
	No aux = this.cabeca;
	
	while(cont < pos-1 && aux != null) {
	
		aux = aux.getProximo();
		cont++;
		
	}
	
	if(aux == null) return false;
	
	novoNo.setProximo(aux.getProximo());
	aux.setProximo(novoNo);
	tamanho++;
	
	return true;
	
}

/*
 * cria um novoNo atribuindo-lhe o valor inserido pelo usuário, logo após cria um
 * No auxiliar que servirá para andar de No em No até achar o ultimo, ou seja, achar
 * o No que aponta para null. Quando o ultimo é encontrado o No auxiliar passa a apontar
 * para o novoNo e o novoNo, por sua vez, é induzido a apontar para null. Por fim o tamanho
 * da lista é incrementada e true é retornado
 */
private boolean insereFimDaLista(int dado) {
	No novoNo = new No();
	novoNo.setConteudo(dado);
	
	No aux = this.cabeca;
	while(aux.getProximo() != null) {
		aux = aux.getProximo();
	}
	
	novoNo.setProximo(null);
	aux.setProximo(novoNo);
	this.tamanho++;
	
	return true;
}

/*
 * primeiro testa se a lista esta vazia e se a posição é diferente de 1, se for o caso
 * nos é retornado falso, se não testa se o dado inserido será acrescentado no começo, 
 * no meio ou no fim da lista chamando assim o método referente.
 */
@Override
public boolean insere(int pos, int dado) {

	if(vazia() && pos != 1) return false;
	
	if(pos == 1) {
		return insereInicioDaLista(dado);
	}else if(pos == tamanho) {
		return insereFimDaLista(dado);
	}else{
		return insereMeioLista(pos, dado);
	}
	
}

/*
 * declara um No p que irá receber o dado contido na primeira posição da lista, depois faz a cabeca apontar
 * para o elemento na segunda posição da lista, logo em seguida atibuindo o valor null ao No p, que detém
 * a posição 1. Por fim, nos é retornaod o dado
 */
private int removeInicioDaLista() {
	
	No p = this.cabeca;
	int dado = p.getConteudo();
	
	
	this.cabeca = p.getProximo();
	this.tamanho--;
	
	p = null;
	
	return dado;
}

/*
 * cria dois No's um antecessor e um atual. Depois percorre toda a lista até o No atual ficar na posição
 * inserida. Enquanto isso, o No antecessor sempre ficará um passo atrás do atual. Quando a posição é encontrada
 * é testado se o No atual está 1 posição após a ultima, se estiver, nos é retornado -1 e método é encerrado. 
 * Caso contrário, a variável dado recebe o conteúdo do No atual e o No atecessor passa a apontar para o No
 * após o atual, o tamanho da lista é incrementado em 1 e a variável dado, que contém o No atual recebe null.
 * Por fim dado é retornado
 */
private int removeNaLista(int pos) {
	
	No atual = null;
	No antecessor = null;
	int dado = -1;
	int cont = 1;
	
	atual = this.cabeca;
	
	while(cont < pos && atual != null) {
		
		antecessor = atual;
		atual = atual.getProximo();
		cont++;
		
	}
	
	if(atual == null) return -1;
	
	dado = atual.getConteudo();
	antecessor.setProximo(atual.getProximo());
	this.tamanho++;
	
	atual = null;
	return dado;
	
}

/*
 * primeiro testa se a lista está vazia, se estiver gera uma excessão e o método é encerrado. Caso contrário
 * verifica se a posição a ser removida se trata da primeira ou de outra no meio ou fim da lista, executando
 * assim um dos dois métodos criados
 */
@Override
public int remove(int pos) {
	
	if (vazia()) return -1;
	
	if(pos == 1) {
		return removeInicioDaLista();
	}else {
		return removeNaLista(pos);
	}
	
}
}
