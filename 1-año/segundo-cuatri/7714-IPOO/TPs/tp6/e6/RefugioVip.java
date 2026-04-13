package e6;

public class RefugioVip extends Refugio {
  private static int capacidadSillones = 10;
  private int sillones;


  public RefugioVip(int a, int b, int c, int s) {
    super(a, b, c);
    this.sillones = s;
  }


  public boolean ocuparSillon() {
		boolean res = false;
		if (this.sillones > 0) {
    	this.sillones--;
			res = true;
		}
		return res;
  }
  public boolean desocuparSillon() {
		boolean res = false;
		if (this.sillones < capacidadSillones) {
    	this.sillones++;
			res = true;
		}
		return res;
  }

  
  public int obtenerSillones() {
    return this.sillones;
  }
  public int disponibilidad() {
		return super.disponibilidad() + this.sillones;
  }
  public RefugioVip clone() {
    return new RefugioVip(super.alimentos, super.bebidas, super.camas, sillones);
  }

}
