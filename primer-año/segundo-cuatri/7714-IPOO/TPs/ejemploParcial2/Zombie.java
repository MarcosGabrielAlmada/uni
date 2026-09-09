package ejemploParcial2;

public class Zombie extends Personaje {
	private int velocidad;
	private boolean casco;

	public Zombie(int s, int f, int vel, boolean c) {
		super(s, f);
		this.velocidad = vel;
		this.casco = c;
	}

	public int obtenerVelocidad() {
		return this.velocidad;
	}

	public boolean obtenerCasco() {
		return this.casco;
	}

	public boolean equals(Personaje p) {
		boolean res = false;
		if (this.getClass() == p.getClass()) {
			Zombie z = (Zombie) p;
			res = super.equals(p) &&
					this.obtenerVelocidad() == z.obtenerVelocidad() &&
					this.obtenerCasco() == z.obtenerCasco();
		}
		return res;
	}

	public void atacar(Personaje p) {
		if (this.getClass() != p.getClass()) {
			if (this.obtenerCasco() && this.obtenerVelocidad() > 2) {
				p.recibirAtaque(this.obtenerFuerza()*2);
			} else {
				super.atacar(p);
			}
		}
	}
}
