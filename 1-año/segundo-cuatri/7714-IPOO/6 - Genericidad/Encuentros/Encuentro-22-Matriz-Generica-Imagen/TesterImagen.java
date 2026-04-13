public class TesterImagen{
    public static void main(String args[]){
        Imagen im = new Imagen (4,4);
        Pixel p1 = new Pixel(255,255,0);
        Pixel p2 = new Pixel(255,255,255);
        Pixel p3 = new Pixel(255,0,0);
        Pixel p4 = new Pixel(255,255,255);
        Pixel p5 = new Pixel(0,0,0); //color negro
        Pixel p6 = new Pixel(55,155,0);
        
        im.establecerE(0,0,p1);
        im.establecerE(0,1,p2);
        im.establecerE(1,1,p3);
        im.establecerE(2,0,p4);
        im.establecerE(2,2,p5);
        im.establecerE(3,2,p6);
        
        System.out.println("Cantidad negros: " + im.cantidadNegros());
        
    }
}