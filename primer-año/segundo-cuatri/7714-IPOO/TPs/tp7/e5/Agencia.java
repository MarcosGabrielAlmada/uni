package e5;

public class Agencia {
  protected Alojamiento[] alojamiento;


  public Agencia(int n) {
    this.alojamiento = new Alojamiento[n];
  }


  public boolean insertarAlojamiento(Alojamiento aloj, int pos) {
    boolean res = false;
    if (this.alojamiento[pos].obtenerId() != aloj.obtenerId()) {
      this.alojamiento[pos] = aloj;
      res = true;
    }
    return res;
  }

  public void eliminarAlojamiento(int pos) {
    this.alojamiento[pos] = null;
  }

  public void eliminarAlojamiento(Alojamiento aloj) {
    boolean encontro = false;
    for (int i=0; i<this.alojamiento.length && !encontro; i++)
      if (this.alojamiento[i].obtenerId() == aloj.obtenerId()) {
        encontro = true;
        this.alojamiento[i] = null;
      }
  }

  public int cantAlojamientos() {
    int cant = 0;
    for (int i=0; i<this.alojamiento.length; i++)
      if (this.alojamiento[i] != null)
        cant++;
    return cant;
  }
  
  public int tamanioTabla() {
    return this.alojamiento.length;
  }
  
  public Alojamiento recuperarAlojamiento(int pos) {
    return this.alojamiento[pos];
  }
  
  public int recuperarPosicion(Alojamiento aloj) {
    int pos = -1;
    for (int i=0; i<this.alojamiento.length && pos == -1; i++)
      if (this.alojamiento[i] == aloj)
        pos = i;
    return pos;
  }
  
  public Alojamiento estaAlojamiento(int c) {
    Alojamiento esta = null;
    for (int i=0; i<this.alojamiento.length && esta == null; i++)
      if (this.alojamiento[i].obtenerId() == c)
        esta = this.alojamiento[i];
    return esta;
  }
  
  public boolean estaLlena() {
    boolean llena = true;
    for (int i=0; i<this.alojamiento.length && llena; i++)
      if (this.alojamiento[i] == null)
        llena = false;
    return llena;
  }
  
  public boolean hayAlojamientos() {
    boolean hay = false;
    for (int i=0; i<this.alojamiento.length && !hay; i++)
      if (this.alojamiento[i] == null)
        hay = true;
    return hay;
  }
  
  public Agencia menorCosto(float c, int n, int p) {
    Agencia res = new Agencia(this.alojamiento.length);
    if (exactamenteNConsMayorC(c, n, p)) {
      // falta
    }
    return res;
  }

  private boolean exactamenteNConsMayorC(float c, int n, int p) {
    int veces = 0;
    for (int i=0; i<(this.alojamiento.length-n) && veces <= n; i++) {
      veces = 0;
      if (this.alojamiento[i].costoDiario(p) > c && veces < n)
        veces++;
      else
        veces = 0;
    }
    return veces == n;
  }
}
