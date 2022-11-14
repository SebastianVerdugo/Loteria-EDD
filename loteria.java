package clasesLoteria;

import java.util.*;

public class loteria implements Iloteria{
	
	private Cartas inicio;
	private int tamañoLot;

	public loteria()
	{
		inicio=null;
		tamañoLot=0;
	}
	@Override
	public void agregarCarta(Cartas insertarCarta) {
		if(inicio!=null)
		{
			insertarCarta.setSiguienteCarta(inicio);
			inicio=insertarCarta;
			tamañoLot++;
		}
		else
		{
			inicio=insertarCarta;
			tamañoLot++;
		}
	}

	@Override
	public Cartas sacarCarta() 
	{
		while (!estaVacia())
		{
			Cartas auxiliar=inicio;
			inicio=inicio.getSiguienteCarta();
			tamañoLot--;
			return auxiliar;
		}
		System.out.println("Todas las cartas han sido sacadas");
		return null;
	}

	@Override
	public void barajear() {
	
		
		String [] nomusados = new String [tamañoLot];
		Cartas cartaAux =inicio;
		int [] numusados = new int [tamañoLot];
		numusados=usadosBarajear();
		for(int j=0; j<tamañoLot; j++)
		{
			//System.out.println("entra for " +j);
			cartaAux=inicio;
			//System.out.println(numusados[j]);
			while(cartaAux.getNumero()!=numusados[j])
			{
				//System.out.println("entra while");
				cartaAux=cartaAux.getSiguienteCarta();
			}
			nomusados[j]=cartaAux.getNombre();
			//System.out.println(nomusados[j]);
		}
		cartaAux=inicio;
		for(int j=0; j<tamañoLot; j++)
		{
			cartaAux.setNumero(numusados[j]);
			cartaAux.setNombre(nomusados[j]);
			cartaAux=cartaAux.getSiguienteCarta();
		}
		
	}
	private int [] usadosBarajear()
	{
		int i=0,  a = 0, x=0;
		Random na= new Random ();
		int [] numusados = new int [54];
		for(int j=0; j<tamañoLot; j++)
		{
			//System.out.println("entra for "+j);
			i= na.nextInt(54)+1;
			x=0;
			while(a==0)
			{
				if(numusados[x]!=i)
				{
					x++;
				}
				if(x==54)
				{
					break;
				}
				if(numusados[x]==i)
				{
					i=na.nextInt(54)+1;
					x=0;
				}
				//System.out.println(x);
			}
			numusados[j]=i;
			//System.out.println("numero usado "+numusados[j]);
		}
		return numusados;
	}
	
	@Override
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
				cartaAux=cartaAux.getSiguienteCarta();
			}
		}
		System.out.println("no se encontro la posicion");
		return null;
	}
	
	public boolean estaVacia() {
		return tamañoLot==0;
	}
	@Override
	public void mostrar() {
		Cartas cartaAux= inicio;
		while(cartaAux!=null)
		{
			System.out.println(cartaAux.toString());
			cartaAux=cartaAux.getSiguienteCarta();
		}
		
		
	}


	
	
	

}
