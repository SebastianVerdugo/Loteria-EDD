package clasesLoteria;

public class Jugador {
	
	private int noJugador;
	private Tablon tablonJ;
	
	public Jugador(int noJugador)
	{
		this.noJugador=noJugador;
		tablonJ=null;
	}

	public Tablon getTablonJ() {
		return tablonJ;
	}

	public void setTablonJ(Tablon tablonJ) {
		this.tablonJ = tablonJ;
	}

	public int getNoJugador() {
		return noJugador;
	}

	public void setNoJugador(int noJugador) {
		this.noJugador = noJugador;
	}

}
