import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	public static List<Jogador> jogadores;
	public static List<Jogador> jogadoresParou;
	public static Jogador jogadorDealer;
	int baralho;
	boolean inicioPartida = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Baralho baralho = new Baralho();
		jogadores = comecarJogo(sc, baralho);
		listaJogadores(jogadores);
		List<Jogador> jogadoresStop = pegarMaisCartas(jogadores, sc, baralho);

//		listaJogadores(jogadores, dealer, sc);

	}

	public static List<Jogador> pegarMaisCartas(List<Jogador> jogadores, Scanner sc, Baralho baralho) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).parou != true) {
				System.out.print("\n" + jogadores.get(i).nome + "\n" + "1 - Deseja pegar uma carta ?\n"
						+ "2 - Deseja Continuar com sua mão");
				int opcao = sc.nextInt();
				System.out.println("opcao:" + opcao);

				if (opcao == 1) {
					Carta carta = baralho.pegarCarta();
					System.out.println("\n A carta que você pegou é: " + carta.valor);
					if (carta.valor == "1") {
						jogadores.get(i).incrementarSoma(Integer.parseInt(carta.valor));
						jogadores.get(i).incrementarAis(11);
						System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: "
								+ jogadores.get(i).somaAIs);
					} else if (carta.valor == "VALETE" || carta.valor == "DAMA" || carta.valor == "REI") {
						jogadores.get(i).incrementarSoma(10);
					} else {
						jogadores.get(i).incrementarSoma(Integer.parseInt(carta.valor));
						System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: "
								+ jogadores.get(i).somaAIs);
					}
				} else {
					jogadores.get(i).setParou(true);
				//	pegarMaisCartas(jogadores, sc, baralho);
				}
			} else {
			//	jogadoresParou.add(jogadores.get(i));
//				Jogador add = jogadores.get(i);
//				jogadores.add(add);
//				jogadores.remove(i);
				pegarMaisCartas(jogadores, sc, baralho);
			}

		}

		return jogadoresParou;

	}

	public static void listaJogadores(List<Jogador> jogadores) {
		for (int j = 0; j < jogadores.size(); j++) {
			System.out.println("Nome: " + jogadores.get(j).nome + " Mão-> " + jogadores.get(j).soma + "/"
					+ jogadores.get(j).somaAIs);
		}
	}

//	public static void listaJogadores(List<Jogador> jogadores, Dealer dealer, Scanner sc) {
//		Baralho baralho = new Baralho();
//		System.out.println("\nBanca: " + "Carta 1: " + dealer.cartaUm);
//		for(int i = 0; i < jogadores.size(); i++) {
//			System.out.println("\nNome: " + jogadores.get(i).nome + "\t" + " Carta 1: " + jogadores.get(i).cartaUm + " Carta 2: " + jogadores.get(i).cartaDois + " Soma: " + jogadores.get(i).soma + " Soma Ais:" + jogadores.get(i).somaAIs);
//		}
//		
//		for(int i = 0; i < jogadores.size(); i++) {
//			System.out.print("\nSelecione as opções desejadas 1-Sim/ 2-Não \n " + jogadores.get(i).nome + "\n" + "1 - Deseja pegar uma carta ?\n" + "2 - Deseja Continuar com sua mão" );
//			int opcao = sc.nextInt();
//			System.out.println("opcao:" + opcao);
//			
//			
//			if (opcao == 1) {
//				String carta = baralho.pegarCarta();
//				System.out.println("\n A carta que você pegou é: " + jogadores.get(i));
//				if (carta == "1") {
//					jogadores.get(i).incrementarSoma(Integer.parseInt(carta));
//					jogadores.get(i).incrementarAis(Integer.parseInt(carta));
//					System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: " + jogadores.get(i).somaAIs);
//				} else {
//					jogadores.get(i).incrementarSoma(Integer.parseInt(carta));
//					System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "Soma Ais: " + jogadores.get(i).somaAIs);
//				}
//			}
//		}
//		sc.close();
//	}

	public static List<Jogador> comecarJogo(Scanner sc, Baralho baralho) {
		jogadores = new ArrayList<>();
		baralho.embaralhar();
		System.out.println("\nEmbaralhando as Cartas !");
		System.out.print("\nQuantidade de jogadores na partida ?");
		double qtdJogadores = sc.nextDouble();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < qtdJogadores; j++) {
				if (i == 1) {
					Carta cartaPuchada2 = baralho.pegarCarta();
//		    		System.out.println("Carta 2: " + cartaPuchada2.valor);
					if (cartaPuchada2.valor == "1") {
						jogadores.get(j).incrementarAis(11);
					} else if (cartaPuchada2.valor == "VALETE" || cartaPuchada2.valor == "DAMA"
							|| cartaPuchada2.valor == "REI") {
						jogadores.get(j).incrementarSoma(10);
					} else {
						jogadores.get(j).incrementarSoma(Integer.parseInt(cartaPuchada2.valor));
					}

				} else {
					Jogador jogador = new Jogador();
					System.out.print("\nDigite seu nome:");
					jogador.setNome(sc.next());
					Carta cartaPuchada1 = baralho.pegarCarta();
//			        System.out.println("CARTA1: " + cartaPuchada1.valor);
					if (cartaPuchada1.valor == "1") {
						jogador.incrementarAis(11);
					} else if (cartaPuchada1.valor == "VALETE" || cartaPuchada1.valor == "DAMA"
							|| cartaPuchada1.valor == "REI") {
						jogador.incrementarSoma(10);
					} else {
						jogador.incrementarSoma(Integer.parseInt(cartaPuchada1.valor));
					}
					jogadores.add(jogador);
				}
			}
		}

		Dealer dealer = new Dealer();
		dealer.setNome("Banca");
		Carta cartaDealer1 = baralho.pegarCarta();
		Carta cartaDealer2 = baralho.pegarCarta();
		if (cartaDealer1.valor == "1") {
			dealer.incrementarAis(11);
		} else if (cartaDealer2.valor == "1") {
			dealer.incrementarAis(11);
		} else if (cartaDealer1.valor == "VALETE" || cartaDealer1.valor == "DAMA" || cartaDealer1.valor == "REI") {
			dealer.incrementarSoma(10);
		} else if (cartaDealer2.valor == "VALETE" || cartaDealer2.valor == "DAMA" || cartaDealer2.valor == "REI") {
			dealer.setCartaEscondida(10);
		} else {
			dealer.incrementarSoma(Integer.parseInt(cartaDealer1.valor));
			dealer.setCartaEscondida(Integer.parseInt(cartaDealer2.valor));
		}
		jogadorDealer = dealer;
		return jogadores;
	}

}
