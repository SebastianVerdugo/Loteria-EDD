package clasesLoteria;

import java.util.Scanner;

public class Juego {
	
	loteria baraja;
	ListaTablones tablones;
	Jugador [] Jugadores;
	Scanner sc;
	
	public Juego(int tamañoJugadores)
	{
		baraja= new loteria();
		tablones= new ListaTablones();
		Jugadores=new Jugador[tamañoJugadores];
		sc= new Scanner (System.in);
		
	}
	
	
	private void LlenarBaraja()
	{
		baraja.agregarCarta(new Cartas (1, "El gallo")); 
		baraja.agregarCarta(new Cartas (2, "El diablo"));
		baraja.agregarCarta(new Cartas (3, "La dama"));
		baraja.agregarCarta(new Cartas (4, "El catrín"));
		baraja.agregarCarta(new Cartas (5, "El paraguas"));
		baraja.agregarCarta(new Cartas (6, "La sirena"));
		baraja.agregarCarta(new Cartas (7, "La escalera"));
		baraja.agregarCarta(new Cartas (8, "La botella"));
		baraja.agregarCarta(new Cartas (9, "El barril"));
		baraja.agregarCarta(new Cartas (10, "El árbol"));
		baraja.agregarCarta(new Cartas (11, "El melón"));
		baraja.agregarCarta(new Cartas (12, "El valiente"));
		baraja.agregarCarta(new Cartas (13, "El gorrito"));
		baraja.agregarCarta(new Cartas (14, "La muerte"));
		baraja.agregarCarta(new Cartas (15, "La pera"));
		baraja.agregarCarta(new Cartas (16, "La bandera"));
		baraja.agregarCarta(new Cartas (17, "El bandolón"));
		baraja.agregarCarta(new Cartas (18, "El violoncello"));
		baraja.agregarCarta(new Cartas (19, "La garza"));
		baraja.agregarCarta(new Cartas (20, "El pájaro"));
		baraja.agregarCarta(new Cartas (21, "La mano"));
		baraja.agregarCarta(new Cartas (22, "La bota"));
		baraja.agregarCarta(new Cartas (23, "La luna"));
		baraja.agregarCarta(new Cartas (24, "El cotorro"));
		baraja.agregarCarta(new Cartas (25, "El borracho"));
		baraja.agregarCarta(new Cartas (26, "El negrito"));
		baraja.agregarCarta(new Cartas (27, "El corazón"));
		baraja.agregarCarta(new Cartas (28, "La sandía"));
		baraja.agregarCarta(new Cartas (29, "El tambor"));
		baraja.agregarCarta(new Cartas (30, "El camarón"));
		baraja.agregarCarta(new Cartas (31, "Las jaras"));
		baraja.agregarCarta(new Cartas (32, "El músico"));
		baraja.agregarCarta(new Cartas (33, "La araña"));
		baraja.agregarCarta(new Cartas (34, "El soldado"));
		baraja.agregarCarta(new Cartas (35, "La estrella"));
		baraja.agregarCarta(new Cartas (36, "El cazo"));
		baraja.agregarCarta(new Cartas (37, "El mundo"));
		baraja.agregarCarta(new Cartas (38, "El apache"));
		baraja.agregarCarta(new Cartas (39, "El nopal"));
		baraja.agregarCarta(new Cartas (40, "El alacrán"));
		baraja.agregarCarta(new Cartas (41, "La rosa"));
		baraja.agregarCarta(new Cartas (42, "La calavera"));
		baraja.agregarCarta(new Cartas (43, "La campana"));
		baraja.agregarCarta(new Cartas (44, "El cantarito"));
		baraja.agregarCarta(new Cartas (45, "El venado"));
		baraja.agregarCarta(new Cartas (46, "El sol"));
		baraja.agregarCarta(new Cartas (47, "La corona"));
		baraja.agregarCarta(new Cartas (48, "La chalupa"));
		baraja.agregarCarta(new Cartas (49, "El pino"));
		baraja.agregarCarta(new Cartas (50, "El pescado"));
		baraja.agregarCarta(new Cartas (51, "La palma"));
		baraja.agregarCarta(new Cartas (52, "La maceta"));
		baraja.agregarCarta(new Cartas (53, "El arpa"));
		baraja.agregarCarta(new Cartas (54, "La rana"));
		baraja.barajear();
	}
	
	private Tablon llenarTablon(int i)
	{
		int x=0;
		Tablon tablonAux=new Tablon(i);
		while(!tablonAux.estaLlena())
		{
			tablonAux.agregarCartas(baraja.sacarCarta());
		}
		baraja=new loteria();
		LlenarBaraja();
		return tablonAux;
	}
	
	private void agregarTablonLista(int tamañoList)
	{
		int j=0;
		Tablon tablonAux;
		tablones.setTamañolist(tamañoList);
		for(int i=1; i<=tablones.getTamañolist(); i++)
		{
			j++;
			tablonAux=llenarTablon(j);
			tablones.agregarTablon(tablonAux);
		}
	}
	private void Jugadoresop()
	{
		int opc=0;
		for(int i=0; i<Jugadores.length;i++)
		{
			boolean continuar=false;
			while(continuar==false)
			{
				System.out.println("----Jugador "+Jugadores[i].getNoJugador()+ " opciones:----");
				System.out.println("1.- Elegir tablon");
				System.out.println("2.- Modificar tablon");
				System.out.println("3.- Mostrar tablon");
				System.out.println("4.- Continuar al otro jugador");
				System.out.println();
				System.out.print("Elija una opcion jugador "+Jugadores[i].getNoJugador()+":");
				opc=sc.nextInt();
				System.out.println();
				switch(opc)
				{
					case 1:
						int tablonE=0;
						if(Jugadores[i].getTablonJ()!=null)
						{
							System.out.println("El jugador ya tiene tablon");
							System.out.println();
							continue;
						}
						System.out.println("¿Cual tablon desea elegir");
						System.out.println();
						System.out.println("Tablones disponibles:");
						for(int j=1; j<=tablones.getTamañolist(); j++)
						{
							if(tablones.encontrarTablon(j).isUsado()==false)
							{
								System.out.println("Tablon "+j+":");
								tablones.encontrarTablon(j).mostrarTablon();
							}
							System.out.println();
						}
						System.out.print("Elija el tablon: ");
						tablonE=sc.nextInt();
						System.out.println();
						if(tablones.encontrarTablon(tablonE).isUsado()==true)
						{
							System.out.println("Este tablon ya esta siendo usado");
							System.out.println();
							continue;
						}
						Jugadores[i].setTablonJ(tablones.encontrarTablon(tablonE));
						Jugadores[i].getTablonJ().setUsado(true);
						break;
					case 2:
						int numeroCarta=0, posicionCarta=0;
						if(Jugadores[i].getTablonJ()==null)
						{
							System.out.println("No se encontro tablon para modificar");
							System.out.println();
							continue;
						}
						baraja.mostrar();
						System.out.println();
						System.out.print("¿Que carta desea colocar en el tablon?");
						numeroCarta=sc.nextInt();
						System.out.println();
						if(Jugadores[i].getTablonJ().encontrarCarta(numeroCarta)!=null)
						{
							System.out.println("La carta ya se encuentra en el tablon");
							System.out.println();
							continue;
						}
						Jugadores[i].getTablonJ().mostrarTablon();
						System.out.println();
						System.out.print("¿En que posicion desea colocarla?(coloque numero de carta):");
						posicionCarta=sc.nextInt();
						System.out.println();
						Jugadores[i].getTablonJ().modificarTablon(numeroCarta, posicionCarta, baraja);
						break;
					case 3:
						if(Jugadores[i].getTablonJ()==null)
						{
							System.out.println("No se encontro tablon");
							System.out.println();
							continue;
						}
						Jugadores[i].getTablonJ().mostrarTablon();
						System.out.println();
						break;
					case 4:
						continuar=true;
				}
				
			}
		}
	}
	public void Jugar()
	{
		int nTablones=0;
		boolean ganador=false;
		Cartas cartaAux=null;
		LlenarBaraja();
		System.out.println();
		for(int i=0; i<Jugadores.length; i++)
		{
			Jugador jugador = new Jugador(i+1);
			Jugadores[i]=jugador;
		}
		System.out.print("¿Cuantos tablones desea generar?");
		nTablones=sc.nextInt();
		System.out.println();
		agregarTablonLista(nTablones);
		Jugadoresop();
		while(!baraja.estaVacia() && ganador==false)
		{
			cartaAux=baraja.sacarCarta();
			System.out.println("Salio la carta: "+cartaAux.toString());
			System.out.println();
			for(int i=0; i<Jugadores.length;i++)
			{
				if(Jugadores[i].getTablonJ().encontrarCarta(cartaAux.getNumero())!=null)
				{
					System.out.println("Se encontro la carta: "+cartaAux.toString() );
					System.out.println("Con el jugador "+Jugadores[i].getNoJugador());
					System.out.println();
					Jugadores[i].getTablonJ().encontrarCarta(cartaAux.getNumero()).setNumero(0);
				}
			}
			for(int i=0; i<Jugadores.length;i++)
			{
				if(Jugadores[i].getTablonJ().tablonGanador()==true)
				{
					System.out.println("El jugador "+Jugadores[i].getNoJugador()+ " es el ganador!! :D");
					System.out.println("fin del juego.....");
					ganador=true;
				}
			}
		}		
	}
	
	
	
	

}
