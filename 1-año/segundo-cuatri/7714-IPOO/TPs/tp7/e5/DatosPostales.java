package e5;

public class DatosPostales {
  private String domicilio;
  private String edificio;
  private int cp;


  public DatosPostales(String d, String e, int c) {
    this.domicilio = d;
    this.edificio = e;
    this.cp = c;
  }


  public String obtenerDomicilio() {
    return this.domicilio;
  }

  public String obtenerEdificio() {
    return this.edificio;
  }

  public int obtenerCP() {
    return this.cp;
  }

  public String toString() {
    return this.domicilio + " " + this.edificio + " " + this. cp;
  }
}
