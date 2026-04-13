package ejemploParcial2;

public class Jardin {
	private static int cantFilas = 5;
	private Personaje[][] g;

	public Jardin(int cantCols) {
		this.g = new Personaje[cantFilas][cantCols];
	}

	public void establecerPersonaje(int f, int c, Personaje p) {
		this.g[f][c] = p;
	}

	public Personaje obtenerPersonaje(int f, int c) {
		return this.g[f][c];
	}

	public int primerFilaConNConFuerzaF(int n, int f) {
		int cant = 0;
		int fila = -1;
		for (int i = 0; i < this.g.length && fila != -1; i++) {
			cant = 0;
			for (int j = 0; j < this.g[0].length && cant <= n; j++) {
				if (this.g[i][j].obtenerFuerza() == f) {
					cant++;
				}
			}
			if (cant == n) {
				fila = i;
			}
		}
		return fila;
	}

	public TablaPersonajes personajesEquiv(Personaje p) {
		TablaPersonajes tp = null;
		if (p != null) {
			tp = new TablaPersonajes(cantFilas * this.g[0].length);
			for (int i = 0; i < this.g.length; i++) {
				for (int j = 0; j < this.g[0].length; j++) {
					if (this.g[i][j].equals(p)) {
						tp.agregarPersonaje(g[i][j]);
					}
				}
			}
		}
		return tp;
	}

	public boolean hayFilasConVivosFuertes(int n, int f) {
		boolean res = false;
		int filas = 0;
		int cant = 0;
		for (int i = 0; i < this.g.length && filas <= n; i++) {
			cant = 0;
			for (int j = 0; j < this.g[0].length && cant < 1; j++) {
				if (this.g[i][j].obtenerSalud() > 0 && this.g[i][j].obtenerFuerza() > f) {
					cant++;
				}
			}
			if (cant >= 1) {
				filas++;
			}
		}
		if (filas == n) {
			res = true;
		}
		return res;
	}
}
