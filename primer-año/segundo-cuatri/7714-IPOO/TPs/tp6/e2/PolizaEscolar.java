package e2;

public class PolizaEscolar extends Poliza {
  protected int cantAlumnos;
  protected int cantDocentes;

  public PolizaEscolar(int np) {
    super(np);
  }

  public PolizaEscolar(int np, float i, float r, int ca, int cd) {
    super(np, i, r);
    cantAlumnos = ca;
    cantDocentes = cd;
  }

  public void establecerCantAlumnos(int n) {
    cantAlumnos = n;
  }

  public void establecerCantDocentes(int n) {
    cantDocentes = n;
  }

  public int obtenerCantAlumnos() {
    return cantAlumnos;
  }

  public int obtenerCantDocentes() {
    return cantDocentes;
  }

  public float obtenerCostoPoliza(int p) {
    return super.obtenerCostoPoliza() + cantAlumnos * p * 1.5f + cantDocentes * p;
  }

}
