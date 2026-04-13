package e1;

public class EnNube extends PlanBase {
  protected int espacio;

  public EnNube(int u, int b, int e) {
    super(u, b);
    espacio = e;
  }

  public int obtenerEspacio() {
    return espacio;
  }

  public int costoPlan(int p){
    return espacio*p + base + usuarios;
  }
}