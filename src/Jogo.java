import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	public static List<Jogador> jogadores;
	int baralho;
	boolean inicioPartida = true;

	public static void main(String[] args) {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Dealer dealer = createdealer();
		jogadores = jogadoresParticipantes();
		listaJogadores(jogadores, dealer);
		
	}
	
	public static Dealer createdealer() {
		Dealer dealer = new Dealer();
		int carta1 = dealer.pegarCarta();
		dealer.setCartaUm(carta1);
		int carta2 = dealer.pegarCarta();
		dealer.setCartaDois(carta2);
		dealer.soma();
		return dealer;
	}
	
	public static void listaJogadores(List<Jogador> jogadores, Dealer dealer) {
		System.out.println("Banca: " + "Carta 1: " + dealer.cartaUm);
		for(int i = 0; i < jogadores.size(); i++) {
			System.out.println("Nome: " + jogadores.get(i).nome + "\t" + " Carta 1: " + jogadores.get(i).cartaUm + " Carta 2: " + jogadores.get(i).cartaDois + " Soma: " + jogadores.get(i).soma + " Soma Ais:" + jogadores.get(i).somaAIs);
		}
	}
	
	public static List<Jogador> jogadoresParticipantes() {
		jogadores = new ArrayList<>();
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.print("Quantidade de jogadores na partida ?");
	    double qtdJogadores = sc.nextDouble();
	   
	    for(int i = 0; i < qtdJogadores; i++ ) {
	    	Jogador jogador = new Jogador();
	        System.out.print("Digite seu nome:");
	        jogador.setNome( sc.next());
	        
	        Baralho baralho = new Baralho();
	        String cartaPuchada1 = baralho.pegarCarta(); // listaCartas.get(gerador.nextInt(51)).valor;
	        String cartaPuchada2 = baralho.pegarCarta();
	        
	        if(cartaPuchada1 == "1" || cartaPuchada2 == "1") {
	        	System.out.println("Caiu No Ais");
		        int somaAiss = Integer.parseInt(cartaPuchada1) + Integer.parseInt(cartaPuchada2);
		        jogador.setSomaAIs(somaAiss);
	        }
	        jogador.setCartaUm(Integer.parseInt(cartaPuchada1));
	        jogador.setCartaDois(Integer.parseInt(cartaPuchada2));
	        jogador.setSoma(Integer.parseInt(cartaPuchada1) + Integer.parseInt(cartaPuchada2));
	        jogadores.add(jogador);
	    }
	    
        sc.close();
		return jogadores;
	}

}
