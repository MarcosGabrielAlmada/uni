import javax.swing.*;

public class EtiquetaConImagen extends JFrame{
  private JLabel etiquetaBanda;
  
  public EtiquetaConImagen(String titulo){
    super(titulo);  
    setSize(500,500);
    etiquetaBanda = new JLabel();
    etiquetaBanda.setText("Los Piojos");
    etiquetaBanda.setIcon(new ImageIcon("piojos.jpg"));
    getContentPane().add(etiquetaBanda);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


}
