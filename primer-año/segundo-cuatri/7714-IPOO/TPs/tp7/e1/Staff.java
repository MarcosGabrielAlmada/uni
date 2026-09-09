public class Staff {
	protected Rubrica[] s;
	protected int cant;

	public Staff(int max) {
		this.s = new Rubrica[max];
		this.cant = 0;
	}

	public boolean agregarRubrica(Rubrica r) {
		boolean res = false;
		if (r != null && this.cant < this.s.length) {
			this.s[this.cant] = r;
			this.cant++;
			res = true;
		}
		return res;
	}

	public void eliminar(int p) {
		for (int i=0; i<this.cant; i++)
			while (this.s[i].productividad() < p) {
				for (int j=i; j<this.cant; j++)
					this.s[j] = this.s[j+1];
				this.cant--;
			}
	}
}