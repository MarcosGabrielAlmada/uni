package ejemploParcial2;

public class TablaPersonajes {
	private Personaje[] t;

	public TablaPersonajes(int max) {
		this.t = new Personaje[max];
	}

	public boolean agregarPersonaje(Personaje p) {
		boolean agrego = false;
		if (p != null) {
			for (int i = 0; i < this.t.length && !agrego; i++) {
				if (t[i] == null) {
					t[i] = p;
					agrego = true;
				}
			}
		}
		return agrego;
	}

	public void eliminarMasDebil() {
		if (this.t.length == 0) {
			this.t[0] = null;
		} else {
			int debil = this.t[0].obtenerFuerza();
			int pos = 0;
			for (int i = 1; i < (this.t.length-1) && debil != 0; i++) {
				if (this.t[i] == null) {
					if (debil > this.t[i].obtenerFuerza()) {
						debil = this.t[i].obtenerFuerza();
						pos = i;
					}
				}
			}
			this.t[pos] = null;
		}
	}

	public Personaje obtenerPersonaje(int pos) {
		Personaje p = null;
		if (pos >= 0 && pos < this.t.length) {
			p = this.t[pos];
		}
		return p;
	}
}
