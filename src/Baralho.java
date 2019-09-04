import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	
	private final List<Carta> cartas;
	
	public Baralho() {
		cartas = new ArrayList<>();

        String[] naipes = {"Paus", "Ouros", "Copas", "Espadas"};
        int pos = 0;
        Carta c;

        while (pos < 4) {
            for (int i = 1; i <= 10; i++) {
                c = new Carta();
                c.setValor(i + "");
                c.setNaipe(naipes[pos]);

                cartas.add(c);
            }
            
            c = new Carta();
            c.setValor("10");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            c = new Carta();
            c.setValor("10");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            c = new Carta();
            c.setValor("10");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            pos++;
        }
    }
	
	
	public void embaralhar() {
		return;
	}
	
	public String pegarCarta() {
		Random gerador = new Random();
		String cartaPuchada = cartas.get(gerador.nextInt(51)).valor;
		return  cartaPuchada;
	}

}
