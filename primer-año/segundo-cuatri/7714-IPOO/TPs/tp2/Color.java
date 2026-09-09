public class Color {
  // Atributos de instancia
  private int rojo;
  private int verde;
  private int azul;


  // Constructores
  public Color() {
    rojo = 0;
    verde = 0;
    azul = 0;
  }

  public Color(int r, int a, int v) {
    if (((r >= 0) && (r <= 255))
     && ((a >= 0) && (a <= 255))
     && ((v >= 0) && (v <= 255))) {
      rojo = r;
      verde = v;
      azul = a;
    } else {
      rojo = 0;
      verde = 0;
      azul = 0;
    }
  }


  // Comandos
  private int calcularVariar(int comp, int val) {
    if (comp+val < 0) comp = 0;
    else if (comp+val > 255) comp = 255;
    else comp += val;

    return comp;
  }

  public void variar(int val) {
    rojo = calcularVariar(rojo, val);
    verde = calcularVariar(verde, val);
    azul = calcularVariar(azul, val);
  }

  public void variarRojo(int val) { rojo = calcularVariar(rojo, val); }
  public void variarVerde(int val) { verde = calcularVariar(verde, val); }
  public void variarAzul(int val) { azul = calcularVariar(azul, val); }

  public void establecerRojo(int val) { rojo = val; }
  public void establecerVerde(int val) { verde = val; }
  public void establecerAzul(int val) { azul = val; }

  public void copy(Color c) {
    if (c != null) {
      c.establecerRojo(rojo);
      c.establecerVerde(verde);
      c.establecerAzul(azul);
    }
  }


  // Consultas
  public int obtenerRojo() { return rojo; }
  public int obtenerVerde() { return verde; }
  public int obtenerAzul() { return azul; }

  public boolean esRojo() { return (rojo==255) && (verde==0) && (azul==0); }
  public boolean esGris() { return (rojo==verde) && (rojo==azul) && (rojo!=0); }
  public boolean esNegro() { return (rojo==0) && (verde==0) && (azul==0); }

  public boolean equals(Color c) {
    boolean res;

    if (c != null) res = (rojo==c.obtenerRojo()) && (verde==c.obtenerVerde()) && (azul==c.obtenerAzul());
    else res = false;

    return res;
  }

  public Color clone() {
    return new Color(rojo, verde, azul);
  }

  public String toString() {
    return "Rojo: "+rojo+"; Verde: "+verde+"; Azul: "+azul;
  }
}