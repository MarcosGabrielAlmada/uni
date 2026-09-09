package ejemploParcial2;

public class Planta extends Personaje {
	protected int energia;

	public Planta(int s, int f, int ener) {
		super(s, f);
	}

	public int obtenerEnergia() {
		return this.energia;
	}

	public boolean equals(Personaje p) {
		boolean res = false;
		if (this.getClass() == p.getClass()) {
			Planta pl = (Planta) p;
			res = super.equals(p) &&
						this.obtenerEnergia() == pl.obtenerEnergia();
		}
		return res;
	}
}
