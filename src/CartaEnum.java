
public enum CartaEnum {
	VALETE(11), DAMA(12), REI(13);
	
	private final int valor;
	private CartaEnum(int valorCarta) {
		valor = valorCarta;
	}
	
	public int getvalor() {
		return valor;
	}

}
