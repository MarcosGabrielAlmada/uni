package e4;

public class Grilla {
	protected Figura[][] figura;

	public Grilla(int cantFil, int cantCol) {
		this.figura = new Figura[cantFil][cantCol];
	}

	public void establecerFigura(int f, int c, Figura fig) {
		this.figura[f][c] = fig;
	}

	public void intercambiar(int f1, int f2) {
		Figura[] aux = this.figura[f1];
		this.figura[f1] = this.figura[f2];
		this.figura[f2] = aux;
	}

	public int cantFilas() {
		return this.figura.length;
	}

	public int cantColumnas() {
		return this.figura[0].length;
	}

	public Figura obtenerFigura(int f, int c) {
		return this.figura[f][c];
	}

	public int cantidadFiguras() {
		int cant = 0;
		for (int f = 0; f < cantFilas(); f++) {
			for (int c = 0; c < cantFilas(); c++) {
				if (this.figura[f][c] != null) {
					cant++;
				}
			}
		}
		return cant;
	}

	// public int cantidadFiguras(float p, float r) { return 0; } ni ganas

	public boolean todosMayores(float x) {
		boolean mayores = true;
		for (int f = 0; f < cantFilas() && mayores; f++) {
			for (int c = 0; c < cantFilas() && mayores; c++) {
				if (this.figura[f][c] != null) {
					mayores = false;
				}
			}
		}
		return mayores;
	}

	// public int contarCoincidenciasArea(Grilla gr) { return 0; } ni ganas
}
