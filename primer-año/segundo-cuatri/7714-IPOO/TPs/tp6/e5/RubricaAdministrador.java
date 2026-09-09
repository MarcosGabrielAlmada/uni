package e5;

public class RubricaAdministrador extends Rubrica {
	protected int proyectos;

	public RubricaAdministrador(int l, int c, int a, int r, int p) {
		super(l, c, a, r);
		this.proyectos = p;
	}

	public void aumentarProyectos(int p) {
		this.proyectos++;
	}

	public int obtenerProyectos() {
		return this.proyectos;
	}

	public String toString() {
		return super.toString() + " " + this.proyectos;
	}

	public float productividad() {
		return (float) (4 * super.promedio() + 10 * this.proyectos);
	}
}
