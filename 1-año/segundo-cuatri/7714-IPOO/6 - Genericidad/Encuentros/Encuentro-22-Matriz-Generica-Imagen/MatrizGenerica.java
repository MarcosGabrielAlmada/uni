class MatrizGenerica {
  protected Elemento [][] m;
  //Constructor
  public MatrizGenerica (int f,int c){
    m = new Elemento [f][c];  
  }
  //Comandos
  public void establecerE(int f,int c, Elemento e){
    m[f][c] = e;
  }
  public void invertirFilas(int f1, int f2){
    Elemento e = null;
    for (int c = 0; c < cantColumnas(); c++){
      e = m[f1][c];
      m[f1][c] = m[f2][c];
      m[f2][c] = e;
    }          
  }
  //Consultas
  public boolean existePos(int f, int c){
    return 0 <= f && f < cantFilas() && 0 <= c && c < cantColumnas();   
  }
  public Elemento obtenerE(int f, int c){
    return m[f][c];
  }
  public int cantFilas(){
    return m.length; 
  }
  public int cantColumnas(){
    return m[0].length; 
  }
  public boolean todosNeutros() {
    boolean es = true;
    for (int i=0; i<cantFilas() && es; i++)
      for(int j=0; j<cantColumnas() && es; j++)
        if (m[i][j]!=null) 
          es = m[i][j].esNeutro();
    return es;
  }
  public MatrizGenerica clone(){
    MatrizGenerica nueva = new MatrizGenerica(cantFilas(), cantColumnas());
    for (int i=0; i<cantFilas(); i++)
      for (int j=0; j<cantColumnas(); j++)
        if (m[i][j] != null) 
          nueva.establecerE(i, j, m[i][j].clone());
        else
          nueva.establecerE(i, j, null);
    return nueva;
  }
  public boolean equals(MatrizGenerica mat){
    boolean es = cantFilas() == mat.cantFilas() && cantColumnas() == mat.cantColumnas();
    for (int i=0; i<cantFilas() && es; i++)
      for (int j=0; j<cantColumnas() && es; j++)
        if (m[i][j] != null && mat.obtenerE(i, j) != null) 
          es = m[i][j].equals(mat.obtenerE(i, j));
        else  
          es = (m[i][j] == null && mat.obtenerE(i, j) == null);
    return es;
  }
}