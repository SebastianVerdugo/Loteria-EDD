package clasesLoteria;

import java.util.*;

public class Main {
	
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("-------Juego loteria mexicana-------");
		System.out.println();
		int tamañoJugadores=0;
		System.out.print("¿Cuantos jugadores desea agregar?");
		tamañoJugadores= sc.nextInt();
		Juego jugarLoteria = new Juego (tamañoJugadores);
		jugarLoteria.Jugar();
	}

}
