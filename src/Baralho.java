import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {
	
	private final List<Carta> cartas;
	public int disponiveis;
	
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
            c.setValor("VALETE");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            c = new Carta();
            c.setValor("DAMA");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            c = new Carta();
            c.setValor("REI");
            c.setNaipe(naipes[pos]);
            cartas.add(c);
            pos++;
        }
        disponiveis = cartas.size();
    }
	
	
	public void embaralhar() {
		Collections.shuffle(cartas);
	}
	
	public Carta pegarCarta() {
		return cartas.get(--disponiveis);
	}

}
