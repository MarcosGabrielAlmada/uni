public class Imagen extends MatrizGenerica{
  public Imagen (int f, int c){
    super(f, c);  
  }
  
  public int cantidadNegros(){
    int cont = 0;
    for (int i = 0; i < cantFilas(); i++) 
      for (int j = 0; j < cantColumnas(); j++)
        if (m[i][j] != null) {
          Pixel p = (Pixel) m[i][j]; 
          if (p.obtenerR() == 0 && p.obtenerG() == 0 && p.obtenerB() == 0) 
            cont++; 
      }
    return cont;   
  }
}
