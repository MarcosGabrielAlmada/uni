package e13;

public class DispositivoFull extends Dispositivo {

	// Atributos de instancia
	protected double p3;
	protected double p4;

	// Constructor
	public DispositivoFull(double pU, double pD, double pT, double pC) {
		super(pU, pD);
		p3 = pT;
		p4 = pC;
	}

	// Comandos
	public void establecerP3(double p) {
		p3 = p;
	}

	public void establecerP4(double p) {
		p4 = p;
	}

	// Consultas
	public double obtenerP3() {
		return p3;
	}

	public double obtenerP4() {
		return p4;
	}

	public boolean riesgo() {
		return (p2 > p1 | p4 > p3);
	}

	public boolean emergencia() {
		return p4 < max;
	}

	public boolean equals(Dispositivo d) {
		boolean ig;
		DispositivoFull df = (DispositivoFull) d;
		ig = super.equals(d) && p3 == df.obtenerP3() && p4 == df.obtenerP4();
		return ig;
	}

	public boolean equals(DispositivoFull e) {
		boolean ig;
		if (this == e)
			ig = true;
		else if (e == null)
			ig = false;
		else if (getClass() != e.getClass())
			ig = false;
		else {
			DispositivoFull r = (DispositivoFull) e;
			ig = super.equals(e) && p3 == r.obtenerP3() && p4 == r.obtenerP4();
		}
		return ig;
	}

	public DispositivoFull clone() {
		DispositivoFull df = new DispositivoFull(p1, p2, p3, p4);
		return df;
	}
}