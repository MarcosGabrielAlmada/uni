package ejemploParcial2;

abstract public class Personaje {
	private int salud;
	private int fuerza;

	public Personaje(int s, int f) {
		this.salud = s;
		this.fuerza = f;
	}

	public int obtenerSalud() {
		return this.salud;
	}

	 public int obtenerFuerza() {
		return this.fuerza;
	 }

	 public boolean equals(Personaje p) {
		return this.getClass() == p.getClass()
				&& this.salud == p.obtenerSalud()
				&& this.fuerza == p.obtenerFuerza();
	 }


	 public void recibirAtaque(int d) {
		this.salud -= d;
		if (this.salud < 0) {
			this.salud = 0;
		}
	 }

	 public void atacar(Personaje p) {
		if (p.obtenerFuerza() < this.obtenerFuerza()) {
			p.recibirAtaque(this.obtenerFuerza());
		}
	 }
}
