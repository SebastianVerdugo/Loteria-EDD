package clasesLoteria;


public class Tablon implements TablonI{

	private Cartas inicio;
	private Cartas fin;
	private Tablon siguiente;
	private int tamañoTablon;
	private boolean usado;
	private int numeroTablon;
	

	public Tablon (int numeroTablon)
	{
		inicio=fin=null;
		tamañoTablon=0;
		usado=false;
		this.numeroTablon=numeroTablon;
	}
	
	
	public int getNumeroTablon() {
		return numeroTablon;
	}


	public void setNumeroTablon(int numeroTablon) {
		this.numeroTablon = numeroTablon;
	}


	public boolean isUsado() {
		return usado;
	}


	public void setUsado(boolean usado) {
		this.usado = usado;
	}


	public int getTamañoTablon() {
		return tamañoTablon;
	}


	public void setTamañoTablon(int tamañoTablon) {
		this.tamañoTablon = tamañoTablon;
	}


	public Tablon getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(Tablon siguiente) {
		this.siguiente = siguiente;
	}

	public void agregarCartas(Cartas insertarCarta) {
		
		if(inicio==null)
		{
			inicio = fin =  insertarCarta;
			tamañoTablon++;
		}
		
		else
		{
			fin.setSiguienteEspacio(insertarCarta);
			fin=insertarCarta;
			tamañoTablon++;
		}
	}

	@Override
	public boolean modificarTablon(int numeroCarta, int referencia, loteria loteriaAux) {
		Cartas cartaAux=inicio;
		Cartas guardaCarta;
		guardaCarta=loteriaAux.encontrarCarta(numeroCarta);
		while(cartaAux!=null)
		{
			if(cartaAux.equals(guardaCarta))
			{
				return false;
			}
			cartaAux=cartaAux.getSiguienteEspacio();
		}
		cartaAux=inicio;
		while(cartaAux!=null)
		{
			if(cartaAux.getNumero()==referencia)
			{
				cartaAux=guardaCarta;
			}
			cartaAux=cartaAux.getSiguienteEspacio();
		}
		return true;
	}
	
	public Cartas encontrarCarta(int numeroCarta) {
		Cartas cartaAux=inicio;
		while(cartaAux!=null)
		{

			if(numeroCarta==cartaAux.getNumero())
			{
				return cartaAux;
			}
			else
			{
				cartaAux=cartaAux.getSiguienteEspacio();
			}
		}
		return null;
	}
	
	public boolean tablonGanador()
	{
		Cartas cartaAux=inicio;
		int contador=0;
		while(cartaAux!=null)
		{
			if(cartaAux.getNumero()==0)
			{
				contador++;
			}
			cartaAux=cartaAux.getSiguienteEspacio();
		}
		if(contador==16)
		{
			return true;
		}
		return false;
	}

	@Override
	public void mostrarTablon() {
		Cartas cartaAux=inicio;
		int n=1;
		while(cartaAux!=null)
		{
			System.out.print(cartaAux.getNumero()+" "+cartaAux.getNombre()+"\t");
			cartaAux=cartaAux.getSiguienteEspacio();
			if(n%4==0)
			{
				System.out.println();
			}
			n++;
		}
		
	}

	@Override
	public boolean estaVacio() {
		return tamañoTablon==0;
	}
	
	public boolean estaLlena()
	{
		return tamañoTablon==16;
	}
	
	

}
