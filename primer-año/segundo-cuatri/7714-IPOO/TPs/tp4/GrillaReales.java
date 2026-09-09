public class GrillaReales {
  private float[][] grilla;

  public GrillaReales(int f, int c) {
    grilla = new float[f][c];
  }

  public void establecerReal(int f, int c, float r) {
    grilla[f][c] = r;
  }
  public void reemplazar(float r1, float r2) {
    for (int i=0; i<cantFilas(); i++)
      for (int j=0; j<cantColumnas(); j++)
        if (grilla[i][j] == r1)
          grilla[i][j] = r2;
  }
  public void reemplazar(float r1, float r2, int f) {
    int ult = -1;
    for (int i=0; i<cantFilas(); i++) {
      ult = -1;
      if (i == f)
        for (int j=0; j<cantColumnas(); j++)
          if (grilla[i][j] == r1)
            ult = j;
    }
    if (ult != -1)
      grilla[f][ult] = r2;
  }
  public boolean intercambiarFilas(int  f1, int f2) {
    boolean res = false;
    if (f1 >= 0 && f1 < cantFilas() && f2 >= 0 && f2 < cantFilas()) {
      float[] aux = grilla[f1];
      grilla[f1] = grilla[f2];
      grilla[f2] = aux;

      res = true;
    }
    return res;
  }



  public int cantFilas() { return grilla.length; }
  public int cantColumnas() { return grilla[0].length; }
}
