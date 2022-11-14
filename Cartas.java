package clasesLoteria;

public class Cartas {	

	private int numero;
	private String nombre;
	private Cartas siguienteCarta;
	private Cartas siguienteEspacio;

	public Cartas(int numero, String nombre)
	{
		this.numero=numero;
		this.nombre=nombre;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero=numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cartas getSiguienteCarta() {
		return siguienteCarta;
	}

	public void setSiguienteCarta(Cartas siguienteCarta) {
		this.siguienteCarta = siguienteCarta;
	}
	
	public Cartas getSiguienteEspacio() {
		return siguienteEspacio;
	}


	public void setSiguienteEspacio(Cartas siguienteEspacio) {
		this.siguienteEspacio = siguienteEspacio;
	}


	public String toString() {
		return "\nnumero carta: " + numero + "\nnombre carta: " + nombre;
	}

	
}
