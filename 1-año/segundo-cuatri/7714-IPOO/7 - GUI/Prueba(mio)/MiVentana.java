import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MiVentana extends JFrame {
	private JPanel panel1,panel2;
	private JLabel etiqueta;
	private JButton boton;

	public MiVentana(String img) {
		super("Mi primera ventana");

		this.setSize(1000, 1000);
		this.getContentPane().setBackground(Color.GREEN);
		this.setLayout(new GridLayout(1,2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.getContentPane().zadd(panel1);
		this.getContentPane().add(panel2);

		this.etiqueta = new JLabel("Hola Mundo");
		this.etiqueta.setIcon(new ImageIcon(img));
		this.etiqueta.setVerticalTextPosition(JLabel.BOTTOM);
		this.etiqueta.setHorizontalTextPosition(JLabel.CENTER);
		this.etiqueta.setVerticalAlignment(JLabel.CENTER);
		this.etiqueta.setHorizontalAlignment(JLabel.CENTER);
		this.etiqueta.setBackground(Color.WHITE);
		this.panel1.add(this.etiqueta);
		
		this.boton = new JButton("Piola");
		OyenteBoton oyenteboton = new OyenteBoton();
		this.boton.addActionListener(oyenteboton);
		this.panel2.add(this.boton);
	}

	public class OyenteBoton implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			etiqueta.setText("Chau Mundo");
		}
	}
}