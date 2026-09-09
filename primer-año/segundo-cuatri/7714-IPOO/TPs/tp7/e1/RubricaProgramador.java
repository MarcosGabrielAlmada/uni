public class RubricaProgramador extends Rubrica {
	protected int lineasCodigo;

	public RubricaProgramador(int l, int c, int a, int r, int lc) {
		super(l, c, a, r);
		this.lineasCodigo = lc;
	}

	public void aumentarLineasCodigo(int p) {
		this.lineasCodigo++;
	}

	public int obtenerLineasCodigo() {
		return this.lineasCodigo;
	}

	public String toString() {
		return super.toString() + " " + this.lineasCodigo;
	}

	public float productividad() {
		return (float) (1.5 * this.comunicacion + 3 * this.autonomia + 5 * this.responsabilidad
				+ this.lineasCodigo / 10000);
	}
}
