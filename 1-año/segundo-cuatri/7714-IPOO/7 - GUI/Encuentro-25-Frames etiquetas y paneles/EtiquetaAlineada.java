import java.awt.*;
import javax.swing.*;

public class EtiquetaAlineada extends JFrame{
  private JLabel etiquetaBanda;
  
  public EtiquetaAlineada(String titulo){
    super(titulo);  
    setSize(500,500);
    etiquetaBanda = new JLabel();
    etiquetaBanda.setText("Los Piojos");
    etiquetaBanda.setIcon(new ImageIcon("piojos.jpg"));
    
    etiquetaBanda.setHorizontalAlignment(JLabel.CENTER);
    etiquetaBanda.setHorizontalTextPosition(JLabel.CENTER);
    etiquetaBanda.setVerticalTextPosition(JLabel.BOTTOM);
    
    getContentPane().add(etiquetaBanda);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


}