import java.awt.*;
import javax.swing.*; 

public class DosPaneles extends JFrame{
  Container contenedor;
  JLabel piojos, redondos;
  JPanel panelPiojos, panelRedondos;
  
  public DosPaneles(String titulo, int b, int h){
    super(titulo);  
    setSize(800, 700);
    
    panelPiojos = new JPanel();
    panelRedondos = new JPanel();
    contenedor = getContentPane();
    
    piojos = new LabelBanda("piojos");
    redondos = new LabelBanda("redondos");
    
    panelPiojos.add(piojos);
    panelRedondos.add(redondos);
    
    contenedor.setLayout(new GridLayout(b, h));
    contenedor.add(panelPiojos);
    contenedor.add(panelRedondos);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }
     
}
