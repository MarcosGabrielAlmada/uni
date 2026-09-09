public class ColorTester {
  public static void main(String[] args) {
    Color color1 = new Color(0, 100, 200);
    Color color2 = new Color(255, 0, 0);
    Color color3 = new Color(142, 142, 142);
    Color color4 = new Color(0, 0, 0);
    Color color5;

    System.out.println("Color 1: "+color1.toString());
    System.out.println("Color 2: "+color2.toString());
    System.out.println("Color 3: "+color3.toString());
    System.out.println("Color 4: "+color4.toString());

    System.out.println();
    if (color1.esRojo()) System.out.println("Color 1 es rojo");
    if (color2.esRojo()) System.out.println("Color 2 es rojo");
    if (color3.esRojo()) System.out.println("Color 3 es rojo");
    if (color4.esRojo()) System.out.println("Color 4 es rojo");
    
    System.out.println();
    if (color1.esGris()) System.out.println("Color 1 es gris");
    if (color2.esGris()) System.out.println("Color 2 es gris");
    if (color3.esGris()) System.out.println("Color 3 es gris");
    if (color4.esGris()) System.out.println("Color 4 es gris");

    System.out.println();
    if (color1.esNegro()) System.out.println("Color 1 es negro");
    if (color2.esNegro()) System.out.println("Color 2 es negro");
    if (color3.esNegro()) System.out.println("Color 3 es negro");
    if (color4.esNegro()) System.out.println("Color 4 es negro");
    
    System.out.println();
    System.out.println("Color 1 copiado por Color 2");
    color1.copy(color2);

    System.out.println();
    if (color1.equals(color2)) System.out.println("Color 1 es igual a Color 2");

    System.out.println();
    color5 = color1.clone();
    System.out.println("Color 1 clono a Color 5");
    System.out.println("Color 5: "+color5.toString());

  }
}