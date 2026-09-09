public class Pixel extends Elemento{
    protected int r;
    protected int b;
    protected int g;
    public Pixel(int pr, int pb, int pg){
        // requiere pr, pb y pg válidos.
        r = pr;
        b = pb;
        g = pg;
    }
    public void establecerR(int pr){
      // requiere pr válido.
      r = pr;
    }
    public void establecerB(int pb){
      // requiere pb válido.
      b = pb;
    }
    public void establecerG(int pg){
      // requiere pg válido.
      g = pg;
    }
    public int obtenerR(){
      return r;
    }
    public int obtenerB(){
      return b;
    }
    public int obtenerG(){
      return g;
    }
    public boolean equals(Elemento e){
       Pixel p = null;
       boolean es = this == e;
       if ( !es && e!= null && getClass() == e.getClass()){
         p = (Pixel) e;
         es = r ==p.obtenerR() && b == p.obtenerB() && g == p.obtenerG();
       }
       return es;
    }
    public boolean esNeutro(){
      return r == 255 && g == 255 && b == 255;
    }
    public Elemento clone(){
      return new Pixel(r, b, g);
    }
}
