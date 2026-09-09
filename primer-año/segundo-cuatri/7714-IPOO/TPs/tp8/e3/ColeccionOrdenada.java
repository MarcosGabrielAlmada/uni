package e3;

public class ColeccionOrdenada {
	private Elemento[] t;
	private int cant;

	public ColeccionOrdenada(int max) {
		this.t = new Elemento[max];
		this.cant = 0;
	}

	public void insertar(Elemento e) {
		if (this.cant < t.length) {
			t[cant] = e;
		}
	}

	public void eliminar(Elemento e) {
		boolean eliminado = false;
		for (int i = 0; i < cantElementos() && !eliminado; i++) {
			if (this.t[i] == e) {
				for (int j = i; j < this.cant - 1; j++) {
					this.t[j] = this.t[j + 1];
				}
				this.cant--;
				eliminado = true;
			}
		}
	}

	public boolean estaLlena() {
		return this.cant == t.length;
	}

	public boolean hayElementos() {
		return this.cant >= 1;
	}

	public int cantElementos() {
		return this.cant;
	}

	public boolean existePosicion(int p) {
		return p >= 0 && p < this.cant;
	}

	public Elemento recuperarElemento(int p) {
		Elemento res = null;
		if (existePosicion(p)) {
			res = this.t[p];
		}
		return res;
	}

	public boolean estaElemento(Elemento e) {
		boolean encontrado = false;
		for (int i = 0; i < cantElementos() && !encontrado; i++) {
			if (this.t[i] == e) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public ColeccionOrdenada intercalar(ColeccionOrdenada c) {
		ColeccionOrdenada res = new ColeccionOrdenada(this.cant + c.cantElementos());
		for (int i = 0; i < cantElementos(); i++) {
			if (i % 2 == 0) {
				
			} else {

			}
		}
		return res;
	}
}
