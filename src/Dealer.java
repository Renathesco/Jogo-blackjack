
public class Dealer {
	int cartaUm;
	private int cartaDois;
	int soma;
	
	public int getCartaDois() {
		return cartaDois;
	}
	
	public void setCartaDois(int cartaDois) {
		this.cartaDois = cartaDois;
	}
	
	public void setCartaUm(int cartaUm) {
		this.cartaUm = cartaUm;
	}
	
	public int getCartaUm() {
		return cartaUm;
	}
	
	public int pegarCarta() {
		Baralho baralho = new Baralho();
		String carta = baralho.pegarCarta();
		return Integer.parseInt(carta);
	}
	
	public void soma() {
		this.soma = this.cartaUm + this.cartaDois;
	}
	
}

