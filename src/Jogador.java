
public class Jogador {
	String nome;
	int soma = 0;
	int somaAIs = 0;
	boolean parou = false;
	
	
	public void setNome(String nome) {
		this.nome = nome;
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
