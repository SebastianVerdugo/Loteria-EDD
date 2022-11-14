package clasesLoteria;

public interface Iloteria 
{
	public void agregarCarta(Cartas insertarCarta);
	public Cartas sacarCarta();
	public void barajear();
	public Cartas encontrarCarta(int numeroCarta);
	public boolean estaVacia();
	public void mostrar();


}
