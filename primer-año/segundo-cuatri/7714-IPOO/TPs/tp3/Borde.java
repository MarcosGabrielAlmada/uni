public class Borde {
  // Atriburos de instancia
  private int grosor;
  private Color color;


  // Constructor
  public Borde(int g, Color c) {
    grosor = g;
    color = c;
  }


  // Comandos
  public void establecerGrosor(int g) { grosor = g; }
  public void establecerColor(Color c) { color = c; }
  public void copy(Borde b) {
    grosor = obtenerGrosor();
    color = obtenerColor();
  }

  // Consultas
  public int obtenerGrosor() { return grosor; }
  public Color obtenerColor() { return color; }

  public Borde clone() { return new Borde(grosor, color); }
  public boolean equals(Borde b) { return (grosor == b.obtenerGrosor()) && (color == b.obtenerColor()); }

  public String toString() { return ""+obtenerGrosor()+obtenerColor(); }
}