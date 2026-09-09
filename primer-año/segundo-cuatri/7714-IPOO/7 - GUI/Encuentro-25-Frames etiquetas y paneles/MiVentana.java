import java.awt.*;
import javax.swing.*;

public class MiVentana extends JFrame{
  
  public MiVentana(String titulo){
    super(titulo);  
    setSize(400, 200);
    getContentPane().setBackground(Color.GREEN);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
    
}
