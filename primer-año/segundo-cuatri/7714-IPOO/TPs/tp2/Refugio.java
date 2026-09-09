public class Refugio {
  // Atributos de clase
  private static int capacidadAlacena = 20;
  private static int cantidadCamas = 10;

  // Atributos de intancia
  private int alimentos;
  private int bebidas;
  private int camas;


  // Constructor
  public Refugio(int a, int b, int c) {
    if ((a+b) > capacidadAlacena) { // --------- raro
      alimentos = capacidadAlacena/2;
      bebidas = capacidadAlacena/2;
    } else {
      alimentos = a;
      bebidas = b;
    }
    if (c>cantidadCamas) camas = cantidadCamas;
    else camas = c;
  }


  // Comandos
  public void consumirAlimento() { alimentos--; }
  public void consumirBebida() { bebidas--; }
  public boolean ocuparCama() {
    if (camas<cantidadCamas) {
      camas--;
      return true;
    } else return false;
  }

  public boolean desocuparCama() {
    if (camas>0) {
      camas--;
      return true;
    } else return false;
  }
  public boolean reponerAlimentos(int n) {
    if (n>0 && capacidadAlacena>0 && n+alimentos<=capacidadAlacena) {
      alimentos++;
      return true;
    } else return false;
  }
  public boolean reponerBebidas(int n) {
    if (n>0 && capacidadAlacena>0 && n+bebidas<=capacidadAlacena) {
      bebidas++;
      return true;
    } else return false;
  }

  // // Consultas
  public int obtenerAlimentos() { return alimentos; }
  public int obtenerBebidas() { return bebidas; }
  public int obtenerCamas() { return camas; }
  public int obtenerCapacidadAlacena() { return capacidadAlacena; }

  public boolean esHabitable() { return (disponibilidad()>0); }
  public int disponibilidad() { return camas; }
  public int diasSupervivencia() {
    if (alimentos > bebidas) return bebidas;
    else return alimentos;
  }
  public boolean mayorAlimentos(Refugio r) {
    return (r!=null && alimentos>r.obtenerAlimentos());
  }
  
  public boolean equals(Refugio r) {
    return (r!=null && alimentos==r.obtenerAlimentos() && bebidas==r.obtenerBebidas() && camas==r.obtenerCamas());
  }
  public Refugio clone() {
    return new Refugio(alimentos, bebidas, camas);
  }
  public String toString() { return "Hay "+obtenerCamas()+" camas, "+obtenerAlimentos()+" alimentos y "+obtenerBebidas()+" bebidas."; }

}
