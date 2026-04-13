package e1;

public class PromocionPymes extends PlanBase {
  protected boolean activa;

  public PromocionPymes(int u, int b) {
    super(u,b);
  }

  public void cambiarActiva() {
    activa = !activa;
  }

  public boolean estaActiva() {
    return activa;
  }

  public int costoPlan() {
    int res = base;
    if (!activa)
      res += usuarios*5; 
    return res;
  }
}