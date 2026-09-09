import javax.swing.*;

public class VentanaEtiqueta extends JFrame{
  private JLabel etiqueta;
  
  public VentanaEtiqueta(String s){
    super(s);
    setSize(200, 420);
    etiqueta = new JLabel("HOLA, estoy cursando IPOO...");
    getContentPane().add(etiqueta);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
      
  }
    
}
