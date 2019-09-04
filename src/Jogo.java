import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	public static List<Jogador> jogadores;
	int baralho;
	boolean inicioPartida = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Dealer dealer = createdealer();
		jogadores = jogadoresParticipantes(sc);
		listaJogadores(jogadores, dealer, sc);
		
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
	
	public static void listaJogadores(List<Jogador> jogadores, Dealer dealer, Scanner sc) {
		Baralho baralho = new Baralho();
		System.out.println("\nBanca: " + "Carta 1: " + dealer.cartaUm);
		for(int i = 0; i < jogadores.size(); i++) {
			System.out.println("\nNome: " + jogadores.get(i).nome + "\t" + " Carta 1: " + jogadores.get(i).cartaUm + " Carta 2: " + jogadores.get(i).cartaDois + " Soma: " + jogadores.get(i).soma + " Soma Ais:" + jogadores.get(i).somaAIs);
		}
		
		for(int i = 0; i < jogadores.size(); i++) {
			System.out.print("\nSelecione as opções desejadas 1-Sim/ 2-Não \n " + jogadores.get(i).nome + "\n" + "1 - Deseja pegar uma carta ?\n" + "2 - Deseja Continuar com sua mão" );
			int opcao = sc.nextInt();
			System.out.println("opcao:" + opcao);
			
			
			if (opcao == 1) {
				String carta = baralho.pegarCarta();
				System.out.println("\n A carta que você pegou é: " + jogadores.get(i));
				if (carta == "1") {
					jogadores.get(i).incrementarSoma(Integer.parseInt(carta));
					jogadores.get(i).incrementarAis(Integer.parseInt(carta));
					System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: " + jogadores.get(i).somaAIs);
				} else {
					jogadores.get(i).incrementarSoma(Integer.parseInt(carta));
					System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: " + jogadores.get(i).somaAIs);
				}
			}
		}
		sc.close();
	}
	
	public static List<Jogador> jogadoresParticipantes(Scanner sc) {
		jogadores = new ArrayList<>();
	    System.out.print("Quantidade de jogadores na partida ?");
	    double qtdJogadores = sc.nextDouble();
	   
	    for(int i = 0; i < qtdJogadores; i++ ) {
	    	Jogador jogador = new Jogador();
	        System.out.print("\nDigite seu nome:");
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
	 
		return jogadores;
	}

}
