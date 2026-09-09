package e2;

public class SensorAlfa extends Sensor {

	private double p3;
	private double p4;

	public SensorAlfa(double pU, double pD, double pT, double pC) {
		super(pU, pD);
	}

	public void establecerP3(double p) {

	}

	public void establecerP4(double p) {

	}

	public double obtenerP3() {
		return 0.0;
	}

	public double obtenerP4() {
		return 0.0;
	}

	public boolean riesgo() {
		return false;
	}

	public boolean emergencia() {
		return false;
	}

	public boolean equals(Sensor s) {
		return false;
	}

	public SensorAlfa clone() {
		return null;
	}

	public SensorAlfa copy() {
		return null;
	}
}
