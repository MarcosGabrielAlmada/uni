package e5;

public class Rubrica {
	protected int legajo;
	protected int comunicacion;
	protected int autonomia;
	protected int responsabilidad;

	public Rubrica(int l, int c, int a, int r) {
		this.legajo = l;
		this.comunicacion = c;
		this.autonomia = a;
		this.responsabilidad = r;
	}

	public void establecerComunicacion(int p) {
		this.comunicacion = p;
	}

	public void establecerAutonomia(int p) {
		this.autonomia = p;
	}

	public void establecerResponsabilidad(int p) {
		this.responsabilidad = p;
	}

	public int obtenerLegajo() {
		return this.legajo;
	}

	public int obtenerComunicacion() {
		return this.comunicacion;
	}

	public int obtenerAutonomia() {
		return this.autonomia;

	}

	public int obtenerResponsabilidad() {
		return this.responsabilidad;

	}

	public String toString() {
		return this.legajo + " " + this.comunicacion + " " + this.autonomia + " " + this.autonomia + " ";
	}

	public int total() {
		return this.comunicacion + this.autonomia + this.responsabilidad;
	}

	public float promedio() {
		return total() / 3;
	}

	public float productividad() {
		return 2 * this.comunicacion + 3 * this.autonomia + 5 * this.responsabilidad;
	}
}
