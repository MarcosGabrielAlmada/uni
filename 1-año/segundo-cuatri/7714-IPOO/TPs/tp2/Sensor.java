public class Sensor {
  // Atributos de clase
  private static double max = 0.1;

  //Atributos de instancia
  private float p1;
  private float p2;


  // Costructor
  public Sensor(float P1, float P2) {
    p1 = P1;
    p2 = P2;
  }

  // Comandos
  public void establecerP1(float p) { p1 = p; }
  public void establecerP2(float p) { p2 = p; }
  public void copy(Sensor s) {
    if (s != null) {
      s.establecerP1(p1);
      s.establecerP2(p2);
    }
  }

  //Consultas
  public float obtenerP1() { return p1; }
  public float obtenerP2() { return p2; }
  public boolean riesgo() { return p2>p1; }
  public boolean emergencia() { return p1<max; }
  public boolean equals(Sensor s) {
    if (s != null)return (p1==s.obtenerP1()) && (p2==s.obtenerP2());
    else return false;
  }
  public Sensor clone() { return new Sensor(p1, p2); }

}