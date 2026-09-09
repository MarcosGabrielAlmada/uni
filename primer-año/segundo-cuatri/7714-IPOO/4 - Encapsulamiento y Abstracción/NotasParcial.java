class NotasParcial{  
  //Atributos de instancia
  private int [] notas;
  //Constructor
  public NotasParcial (int cant){
    notas = new int [cant];   
  }
  //Comandos
  public void establecerNota(int n, int i){
    //Requiere i válido
    if (n >= 0 && n <=100)
      notas[i] = n;
  }
  //Consultas
  public int obtenerNota(int i){
    //Requiere i válido
    return notas[i]; 
  }
  public int cantNotas(){
    return notas.length;  
  }
  public int cantAprobados(){
    int cont = 0;
    for(int i = 0; i < cantNotas(); i++)
      if (notas[i] >= 60)
        cont++;
    return cont;  
  }
  public float promedioGeneral(){
      float retornar = 0;
      int sum = 0;
      for (int i = 0; i < cantNotas(); i++)
          sum = sum + notas[i];     
      retornar = sum / cantNotas();
      return retornar;
  }
  public float promedioAprobados(){
      int cont = 0;
      int sum = 0;
      float prom = -1;
      for(int i = 0; i < cantNotas(); i++)
        if (notas[i] >= 60){
          cont++;
          sum = sum + notas[i];
        }
      if (cont > 0)
        prom = sum/cont;
    return prom;  
  }
  public boolean alMenos100(){
    boolean hayAlMenos1 = false;
    for(int i = 0; i < cantNotas() && !hayAlMenos1; i++)
      hayAlMenos1 = notas[i] == 100;  
    return hayAlMenos1;
  }
  public boolean exactamente100(){
    int cont = 0;
    for(int i = 0; i < cantNotas() && cont<=1; i++)
      if (notas[i] == 100)
        cont++;  
    return cont==1;
  }
}
