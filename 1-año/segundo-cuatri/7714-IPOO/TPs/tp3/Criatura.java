public class Criatura {
  // Atributos de clase
  private static int maxEnergia = 100;
  private static int minEnergia = 0;
  private static int consumoEnergia = 10;

  // Atributos de instancia
  private int energia;
  private Refugio refugio;
  private boolean despierto;
  private int caminatas;


  // Constructor
  public Criatura(Refugio r) {
    energia = maxEnergia;
    refugio = r;
    despierto = true;
    caminatas = 0;
  }

  // Comandos
  public boolean comer() {
    if (despierto && refugio.obtenerAlimentos()>0 && (energia+1 <= maxEnergia)) {
      energia++;
      refugio.consumirAlimento();
      return true;
    } else return false;
  }

  public boolean beber() {
    if (despierto && refugio.obtenerBebidas()>0 && (energia+1<= maxEnergia)) {
      refugio.consumirBebida();
      energia++;
      return true;
    } else return false;
  }

  public boolean dormir() {
    if (despierto && (refugio.obtenerCamas()>0)) {
      refugio.ocuparCama();
      despierto = false;
      return true;
    }
    else return false;
  }

  public boolean despertar() {
    if (!despierto) {
      refugio.desocuparCama();
      despierto = true;
      caminatas = 0;
      return true;
    } else return false;
  }

  public boolean caminar() {
    boolean res = false;

    if (despierto && (energia>=consumoEnergia)) {
      if (caminatas<3) {
        caminatas++;
        energia -= consumoEnergia;
        res = true;
      } else {
        if (refugio.obtenerCamas()>0) dormir();
        else energia = minEnergia;
      }
    }
    return res;

  }

  // Consultas
  public int obtenerEnergia() { return energia; }
  public int obtenerCaminatas() { return caminatas; }

  public int obtenerHumor() {
    int res = 1;

    if (refugio.esHabitable()) {
      if (energia>=0 && energia<=40) res = 1;
      else if (energia>=40 && energia<=70) res = 2;
      else res = 3;
    }

    return res;
  }

  public Refugio obtenerRefugio() { return refugio; }
  public boolean estaDormido() { return !despierto; }
  public boolean mayorEnergia(Criatura c) { return (energia>c.obtenerEnergia()); }
  public String toString() {
    return "Energia: "+energia+"\n\nRefugio\nAlimentos: "+refugio.obtenerAlimentos()+"\nBebidas: "+refugio.obtenerBebidas()+"\nCamas: "+refugio.obtenerCamas()+"\n\nDespierto: "+despierto+"\nCaminatas: "+caminatas;
      }
}
