import java.awt.*;
import javax.swing.*; 

public class LabelBanda extends JLabel{
  public LabelBanda(String banda){
    super(banda);
    setIcon(new ImageIcon(banda+".jpg"));
    setHorizontalAlignment(JLabel.CENTER);
    setHorizontalTextPosition(JLabel.CENTER);
    setVerticalTextPosition(JLabel.BOTTOM);
  }
    
}
