package e5;

public class RubricaLider extends Rubrica {
	protected int gestionConflictos;
	protected int gestionCambios;

	public RubricaLider(int l, int c, int a, int r, int go, int ga) {
		super(l, c, a, r);
		this.gestionConflictos = go;
		this.gestionCambios = ga;
	}

	public void establecerConflictos(int p) {
		this.gestionConflictos = p;
	}

	public void establecerCambios(int p) {
		this.gestionCambios = p;
	}

	public int obtenerConflictos() {
		return this.gestionConflictos;
	}

	public int obtenerCambios() {
		return this.gestionConflictos;
	}

	public String toString() {
		return super.toString() + " " + this.gestionConflictos + " " + this.gestionCambios;
	}

	public int total() {
		return super.total() + this.gestionConflictos + this.gestionCambios;
	}

	public float promedio() {
		return (float) (super.promedio() + (this.gestionConflictos + this.gestionCambios) / 2);
	}
}
