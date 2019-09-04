
public class Jogador {
	String nome;
	int soma;
	int somaAIs = 0;
	int cartaUm;
	int cartaDois;
	boolean parou = false;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCartaUm(int cartaUm) {
		this.cartaUm = cartaUm;
	}
	
	public int getCartaUm() {
		return cartaUm;
	}
	
	public void setCartaDois(int cartaDois) {
		this.cartaDois = cartaDois;
	}
	
	public int getCartaDois() {
		return cartaDois;
	}
	
	public int getSomaAIs() {
		return somaAIs;
	}
	
	public void setSomaAIs(int somaAIs) {
		this.somaAIs = somaAIs;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setSoma(int soma) {
		this.soma = soma;
	}
	
	public int getSoma() {
		return soma;
	}
	
	public void setParou(boolean parou) {
		this.parou = parou;
	}
	
	public void incrementarSoma(int valor) {
		this.soma += valor;
	}
	
	public void incrementarAis(int valor) {
		this.soma += valor;
	}
	
	

}
