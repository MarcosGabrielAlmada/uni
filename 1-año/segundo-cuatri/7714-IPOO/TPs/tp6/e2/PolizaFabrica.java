package e2;

public class PolizaFabrica extends Poliza{
  protected int cantOperarios;
  protected float valorEquipo;

  public PolizaFabrica(int np) {
    super(np);
  }

  public PolizaFabrica(int np, float i, float r, int co, float ve) {
    super(np, i, r);
    cantOperarios = co;
    valorEquipo = ve;
  }

  public void establecerCantOperarios(int n) {
    cantOperarios = n;
  }

  public void establecerValorEquipo(int n) {
    valorEquipo = n;
  }

  public int obtenercantOperarios(){
    return cantOperarios;
  }

  public float obtenervalorEquipo(){
    return valorEquipo;
  }

  public float obtenerCostoPoliza(){
    return super.obtenerCostoPoliza()+cantOperarios*500+valorEquipo*0.8f;
  }
}
