package e2;

public class Coleccion {
	private Elemento[] col;
	private int cant;

	public Coleccion(int max) {
		this.col = new Elemento[max];
	}

	public void insertar(Elemento e) {
		this.col[this.cant] = e;
		this.cant++;
	}

	public void eliminar(Elemento e) {
		int aux = this.cant;
		for (int i = 0; i < this.cant && aux == this.cant; i++)
			if (this.col[i].equals(e)){
				aux = i;
				this.cant--;
			}
		for (int j = aux; j < this.cant + 1; j++)
			this.col[j] = this.col[j + 1];
	}

	public void ordenada() {
		
	}

}
