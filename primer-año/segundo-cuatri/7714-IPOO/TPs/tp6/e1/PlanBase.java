package e1;

public class PlanBase {
  protected int usuarios;
  protected int base;

  public PlanBase(int u, int b) {
    usuarios = u;
    base = b;
  }

  public int obtenerUsuarios(){
    return usuarios;
  }

  public int obtenerBase(){
    return base;
  }

  public int costoPlan(){
    return base*2+10*usuarios;
  }
}