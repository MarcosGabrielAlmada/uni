package e4;

public class Punto {

	private double x;
	private double y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void establecerX(double x) {
		this.x = x;
	}
	
	public void establecerY(double y) {
		this.y = y;
	}

	public void copy(Punto p) {
		this.x = p.obtenerX();
		this.y = p.obtenerY();
	}

	public double obtenerX() {
		return this.x;
	}

	public double obtenerY() {
		return this.y;
	}

	public boolean equals(Punto p) {
		return (this.x == p.obtenerX() &&
						this.y == p.obtenerY());
	}

	public double distancia(Punto p) {
		return Math.sqrt((this.x-p.obtenerX())*(this.x-p.obtenerX())+(this.y-p.obtenerY())*(this.y-p.obtenerY()));
	}

	public Punto clone() {
		return new Punto(this.x, this.y);
	}

	public String toString() {
		return this.x + " " + this.y;
	}
}
