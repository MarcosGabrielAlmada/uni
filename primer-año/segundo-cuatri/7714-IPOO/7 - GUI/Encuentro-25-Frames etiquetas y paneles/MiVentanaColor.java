
import java.awt.*; 
import javax.swing.*;

public class MiVentanaColor extends JFrame{
  Container panel;
  public MiVentanaColor(String titulo, Color col){
    super(titulo);
    setSize(400,300);
    panel = getContentPane();
    panel.setBackground(col);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
