package e5;

public abstract class Alojamiento {
  protected int id;
  protected int personas;


  public Alojamiento(int id, int p) {
    this.id = id;
    this.personas = p;
  }


  public int obtenerId() {
    return this.id;
  }

  public int obtenerPersonas() {
    return this.personas;
  }

  public String toString() {
    return this.id + " " + this.personas;
  }

  public abstract float costoDiario(int p);
}
