import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	public static List<Jogador> jogadores;
	public static Dealer jogadorDealer;
	public static int jogadoresParou = 0;
	int baralho;
	boolean inicioPartida = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Baralho baralho = new Baralho();
		jogadores = comecarJogo(sc, baralho);
		verificarCartasIguais(jogadores, sc);
		jogadores = pegarMaisCartas(jogadores, sc, baralho);
		finalizarPartida(jogadores, sc, baralho);

	}

	public static void finalizarPartida(List<Jogador> jogadores, Scanner sc, Baralho baralho) {
		System.out.println("\n\nOs jogadores terminaram suas apostas, agora a banca vai puchar as cartas");
		int cartaEscondidaDealer = jogadorDealer.getCartaEscondida();
		if(cartaEscondidaDealer == 1) {
			jogadorDealer.incrementarSoma(1);
			jogadorDealer.incrementarAis(11);
		} else {
			jogadorDealer.incrementarSoma(cartaEscondidaDealer);
			jogadorDealer.incrementarAis(cartaEscondidaDealer);
		}
		System.out.println("\n\nCarta Escondida da Banca: " + cartaEscondidaDealer + " Mão da banca: " + jogadorDealer.getSoma() + "/" + jogadorDealer.getSomaAIs());
		System.out.println("\nA A mão da banca está menor que 17 pontos ?\n1 - Sim\n2 - Não");
		int pegarCarta = sc.nextInt();
		while(pegarCarta == 1) {
			Carta carta = baralho.pegarCarta();
			System.out.println("\nCarta puchada Banca: " + carta.valor);
			if (carta.valor == "1") {
				jogadorDealer.incrementarSoma(1);
				jogadorDealer.incrementarAis(11);
			} else if (carta.valor == "VALETE" || carta.valor == "DAMA" || carta.valor == "REI") {
				jogadorDealer.incrementarSoma(10);
				jogadorDealer.incrementarAis(10);
			} else {
				jogadorDealer.incrementarAis(Integer.parseInt(carta.valor));
				jogadorDealer.incrementarSoma(Integer.parseInt(carta.valor));
			}
			System.out.println("\n Mão da banca: " + jogadorDealer.getSoma() + "/" + jogadorDealer.getSomaAIs());
			System.out.println("\nA A mão da banca está menor que 17 pontos ?\n1 - Sim\n2 - Não");
			pegarCarta = sc.nextInt();
		}
		
		
		int indiceGanhador = 0;
		double aux = 0;
		for (int j = 0; j < jogadores.size(); j++) {
//			System.out.println("\n Nome: " + jogadores.get(j).nome + " Mão-> " + jogadores.get(j).soma + "/"
//					+ jogadores.get(j).somaAIs + " Total em dinheiro: " + jogadores.get(j).dinheiro);

			if (jogadores.get(j).getSoma() < 22 && aux < jogadores.get(j).getSoma()) {
				aux = jogadores.get(j).getSoma();
				indiceGanhador = j;
			}
		}

		

		System.out.println("\n\nO Com base na mão da banca e do jogadorr quem foi o ganhador: " + "\nNome Jogador: " + jogadores.get(indiceGanhador).nome + "  Mão : "
				+ jogadores.get(indiceGanhador).getSoma() + "/" + jogadores.get(indiceGanhador).getSomaAIs() +"\nBanca: " + jogadorDealer.getSoma() + "/" + jogadorDealer.getSomaAIs());
		;

	}

	public static List<Jogador> pegarMaisCartas(List<Jogador> jogadores, Scanner sc, Baralho baralho) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).parou != true) {
				System.out.print("\n" + jogadores.get(i).nome + "\n" + "1 - Deseja pegar uma carta ?\n"
						+ "2 - Ficar");
				int opcao = sc.nextInt();
				System.out.println("opcao:" + opcao);

				if (opcao == 1) {
					Carta carta = baralho.pegarCarta();
					System.out.println("\n\n\nA carta que você pegou é: " + carta.valor);
					if (carta.valor == "1") {
						jogadores.get(i).incrementarSoma(1);
						jogadores.get(i).incrementarAis(11);
						System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "/"
								+ jogadores.get(i).somaAIs);
					} else if (carta.valor == "VALETE" || carta.valor == "DAMA" || carta.valor == "REI") {
						jogadores.get(i).incrementarSoma(10);
						jogadores.get(i).incrementarAis(10);
						System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "/"
								+ jogadores.get(i).somaAIs);
					} else {
						jogadores.get(i).incrementarSoma(Integer.parseInt(carta.valor));
						jogadores.get(i).incrementarAis(Integer.parseInt(carta.valor));
						System.out.println(jogadores.get(i).nome + " Sua mao: " + jogadores.get(i).soma + "/"
								+ jogadores.get(i).somaAIs);
					}
				} else {
						jogadores.get(i).setParou(true);
						jogadoresParou += 1;
				}
			}
			if (i == (jogadores.size() - 1) && jogadoresParou != jogadores.size()) {
				pegarMaisCartas(jogadores, sc, baralho);
			}
		}

		return jogadores;

	}

	public static void verificarCartasIguais(List<Jogador> jogadores, Scanner sc) {
		for (int j = 0; j < jogadores.size(); j++) {
			System.out.println("\n Nome: " + jogadores.get(j).nome + " Mão-> " + jogadores.get(j).soma + "/"
					+ jogadores.get(j).somaAIs + " Total em dinheiro: " + jogadores.get(j).dinheiro);
//			if (jogadores.get(j).cartaUm == jogadores.get(j).cartaDois) {
//				System.out.println("\nDeseja separar seu baralho ? 1-Sim\n2-Não");
//
//			}

		}
		System.out.println("\n Mão da Banca -> " + jogadorDealer.getSoma() + "/" + jogadorDealer.getSomaAIs());
	}

	public static List<Jogador> comecarJogo(Scanner sc, Baralho baralho) {
		jogadores = new ArrayList<>();
		baralho.embaralhar();
		System.out.println("\nEmbaralhando as Cartas !");
		System.out.print("\nQuantidade de jogadores na partida ?");
		double qtdJogadores = sc.nextInt();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < qtdJogadores; j++) {
				if (i == 1) {
					Carta cartaPuchada2 = baralho.pegarCarta();
					if (cartaPuchada2.valor == "1") {
						jogadores.get(j).incrementarSoma(1);
						jogadores.get(j).incrementarAis(11);
					} else if (cartaPuchada2.valor == "VALETE" || cartaPuchada2.valor == "DAMA"
							|| cartaPuchada2.valor == "REI") {
						jogadores.get(j).incrementarSoma(10);
						jogadores.get(j).incrementarAis(10);
					} else {
						jogadores.get(j).setCartaDois(cartaPuchada2);
						jogadores.get(j).incrementarSoma(Integer.parseInt(cartaPuchada2.valor));
						jogadores.get(j).incrementarAis(Integer.parseInt(cartaPuchada2.valor));
					}

				} else {
					Jogador jogador = new Jogador();
					System.out.print("\nDigite seu nome:");
					jogador.setNome(sc.next());
					System.out.print("\nDigite seu total em dinheiro:");
					jogador.setDinheiro(sc.nextDouble());

					Carta cartaPuchada1 = baralho.pegarCarta();
					if (cartaPuchada1.valor == "1") {
						jogador.incrementarSoma(1);
						jogador.incrementarAis(11);
					} else if (cartaPuchada1.valor == "VALETE" || cartaPuchada1.valor == "DAMA"
							|| cartaPuchada1.valor == "REI") {
						jogador.incrementarSoma(10);
						jogador.incrementarAis(10);
					} else {
						jogador.setCartaUm(cartaPuchada1);
						jogador.incrementarSoma(Integer.parseInt(cartaPuchada1.valor));
						jogador.incrementarAis(Integer.parseInt(cartaPuchada1.valor));
					}
					jogadores.add(jogador);
				}
			}
		}
		
		
		Dealer dealer = new Dealer();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 1; j++) {
				if (i == 1) {
					Carta cartaDealer2 = baralho.pegarCarta();
					if (cartaDealer2.valor == "1") {
						dealer.setCartaEscondida(1);
					} else if (cartaDealer2.valor == "VALETE" || cartaDealer2.valor == "DAMA"
							|| cartaDealer2.valor == "REI") {
						dealer.setCartaEscondida(10);
					} else {
						dealer.setCartaEscondida(Integer.parseInt(cartaDealer2.valor));
					}

				} else {
					dealer.setNome("Banca");
				

					Carta cartaDealer1 = baralho.pegarCarta();
					if (cartaDealer1.valor == "1") {
						dealer.incrementarSoma(1);
						dealer.incrementarAis(11);
					} else if (cartaDealer1.valor == "VALETE" || cartaDealer1.valor == "DAMA"
							|| cartaDealer1.valor == "REI") {
						dealer.incrementarSoma(10);
						dealer.incrementarAis(10);
					} else {
						dealer.incrementarSoma(Integer.parseInt(cartaDealer1.valor));
						dealer.incrementarAis(Integer.parseInt(cartaDealer1.valor));
					}
					jogadorDealer = dealer;
				}
			}
		}
		

		return jogadores;
	}

}
