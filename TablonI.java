package clasesLoteria;

public interface TablonI 
{
	public void agregarCartas(Cartas insertarCarta);
	public boolean modificarTablon(int numeroCarta, int referencia, loteria loteriaAux);
	public Cartas encontrarCarta(int numeroCarta);
	public boolean tablonGanador();
	public void mostrarTablon ();
	public boolean estaVacio();
	public boolean estaLlena();
	

}
