package e5;

public class Departamento extends Alojamiento{
  private int ambientes;
  private boolean balcon;


  public Departamento(int id, int p, int a, boolean b) {
    super(id, p);
    this.ambientes = a;
    this.balcon = b;
  }


  public boolean tieneBalcon() {
    return this.balcon;
  }

  public float costoDiario(int p) {
    float res = this.ambientes * p;
    if (balcon)
      res += 150;
    return res;
  }
}
