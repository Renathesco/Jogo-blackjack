
public class Jogador {
	
	String nome;
	double aposta;
	double dinheiro;
	int soma = 0;
	int somaAIs = 0;
	Carta cartaUm;
	Carta cartaDois;
	boolean parou = false;
	
	
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public double getDinheiro() {
		return dinheiro;
	}
	
	public void setCartaDois(Carta cartaDois) {
		this.cartaDois = cartaDois;
	}
	
	public void setCartaUm(Carta cartaUm) {
		this.cartaUm = cartaUm;
	}
	
	public Carta getCartaDois() {
		return cartaDois;
	}
	
	public Carta getCartaUm() {
		return cartaUm;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSomaAIs() {
		return somaAIs;
	}
	
	public String getNome() {
		return nome;
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
		this.somaAIs += valor;
	}
	
	public void verificarCartasIguais(Carta carta1, Carta carta2) {
		
	}
	
	public boolean transferirDinheiroParaAposta(double valor) {
		if(this.dinheiro > valor) {
			this.dinheiro -= valor;
			this.aposta = valor;
			return true;
		}
		else {
			System.out.println("Não foi possível realizar o pagamento da sua aposta!");
			return false;
		}
	}
	

}
