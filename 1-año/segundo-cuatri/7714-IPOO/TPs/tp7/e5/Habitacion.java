package e5;

public class Habitacion extends Alojamiento{
  private int camas;


  public Habitacion(int id, int p, int c) {
    super(id, p);
    this.camas = c;
  }


  public int obtenerCamas() {
    return this.camas;
  }

  public float costoDiario(int p) {
    return this.camas*p/2;
  }
}
