package clasesLoteria;

public class ListaTablones implements ListaTablonesI{
	
	private Tablon inicio;
	private Tablon fin;
	private int tamañolist;
	
	public int getTamañolist() {
		return tamañolist;
	}
	public void setTamañolist(int tamañolist) {
		this.tamañolist = tamañolist;
	}
	@Override
	public void agregarTablon(Tablon tablonInsertar) {
		if(inicio==null)
		{
			inicio = fin =  tablonInsertar;
		}
		
		else
		{
			fin.setSiguiente(tablonInsertar);
			fin=tablonInsertar;
		}
		
	}
	@Override
	
	public Tablon encontrarTablon(int numeroTablon)
	{
		Tablon tablonAux=inicio;
		while(tablonAux!=null)
		{
			if(tablonAux.getNumeroTablon()==numeroTablon)
			{
				return tablonAux;
			}
			else
			{
				tablonAux=tablonAux.getSiguiente();
			}
		}
		System.out.println("No se encontro el tablon");
		return null;
	}
	public void vaciarLista() {
		
		tamañolist=0;

	}
	
	
	
	

}
