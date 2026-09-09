package e2;

public class Poliza{
  // Atributos de Instancia
  protected int nroPoliza;
  protected float incendio;
  protected float robo;
  protected boolean activa = true;

  // Constructores
  public Poliza(int np){
    nroPoliza = np;
  }

  public Poliza(int np, float i, float r){
    nroPoliza = np;
    incendio = i;
    robo = r;
  }

  //Comandos
  public void establecerIncendio(float m){ incendio = m; }

  public void establecerRobo(float m){ robo = m; }

  public void actualizarPorcentaje(int p) {
    if (activa) {
      robo += robo*p/100;
      incendio += incendio*p/100;
    }
  }

  public void activar(){ activa = true; }

  public void desactivar(){ activa = false; }

  // Consulta
  public int obtenerNroPoliza(){ return nroPoliza; }

  public float obtenerIncendio(){ return incendio; }

  public float obtenerRobo(){ return robo; }

  public float obtenerCostoPoliza(){ return (robo + incendio);}

  public boolean estaActiva(){ return activa; }

  public String toString(){ 
    float costo = incendio + robo;
    if (activa)
      return "Poliza nro: "+nroPoliza+"\nSu costo es: "+costo+"\nEstado: activa";
    else
      return "Poliza nro: "+nroPoliza+"\nSu costo es: "+costo+"\nEstado: no activa";
    }
}