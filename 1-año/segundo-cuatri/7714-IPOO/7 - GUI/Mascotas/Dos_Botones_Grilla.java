
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Dos_Botones_Grilla extends JFrame {
	/* Objetos Gráficos */
	private MiEtiqueta etiqueta;
	private JButton botonPerro, botonGato;
	private JPanel panelControl, panelImagen;

	public Dos_Botones_Grilla() {
		// Establece los valores de los atributos del frame
		setLayout(new GridLayout(1, 2));
		setSize(420, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Arma los paneles
		panelControl = new JPanel();
		panelControl.setBackground(Color.BLUE);

		panelImagen = new JPanel();

		botonPerro = new JButton("Perro");
		botonPerro.setPreferredSize(new Dimension(124, 50));
		botonPerro.setSize(150, 50);
		botonPerro.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.RED, 4, false), null));

		botonGato = new JButton("Gato");
		botonGato.setPreferredSize(new Dimension(124, 50));
		botonGato.setSize(150, 50);
		botonGato.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GREEN, 3, false), null));

		etiqueta = new MiEtiqueta();
		etiqueta.setText("Jack");
		etiqueta.setIcon(new ImageIcon("perro.gif"));

		botonGato.addActionListener(new OyenteBotonG());
		botonPerro.addActionListener(new OyenteBotonG());

		// Insertar los botones en el panel de control
		panelControl.add(botonPerro);
		panelControl.add(botonGato);
		panelImagen.add(etiqueta);

		// Inserta los paneles en el panel del frame
		getContentPane().add(panelControl);
		getContentPane().add(panelImagen);
	}

	private class OyenteBotonG implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	  		if (etiqueta.getText().equals("Jack")) {
				etiqueta.setIcon(new ImageIcon("gato.gif"));
				etiqueta.setText("Tom");
			} else {
				etiqueta.setIcon(new ImageIcon("perro.gif"));
				etiqueta.setText("Jack");
			}
		}
	}
}