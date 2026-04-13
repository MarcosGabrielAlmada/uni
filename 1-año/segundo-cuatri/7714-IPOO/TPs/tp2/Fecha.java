public class Fecha {
  // Atriburos de instancia
  private int dia, mes, anio;

  // Constructor
  public Fecha (int d, int m, int a) {
    dia = d;
    mes = m;
    anio = a;
  }

  // Comandos
  public void establecerDia(int d) { dia = d; }
  public void establecerMes(int m) { mes = m; }
  public void establecerAnio(int a) { anio = a; }

  // Consultas
  public int obtenerDia() { return dia; }
  public int obtenerMes() { return mes; }
  public int obtenerAnio() { return anio; }
  public boolean esBisiesto() { return (((anio%4 == 0) && (anio%100 != 0)) || ((anio%400 == 0))); }
  public boolean esAnterior(Fecha f) {
    if (anio < f.obtenerAnio()) { return true; }
    else if (anio == f.obtenerAnio()) {

      if (mes < f.obtenerMes()) { return true; }
      else if (mes == f.obtenerMes()) {
        
        if (dia < f.obtenerDia()) { return true; }
      }
    }
    return false;
  }
  public boolean mismoAnio(Fecha f) { return (anio == f.obtenerAnio());}
  public boolean equals(Fecha f) { return ((f.obtenerAnio() == anio) && (f.obtenerMes() == mes) && (f.obtenerDia() == dia)); }
  public String toString() { return "Dia: "+dia+". Mes: "+mes+".Anio: "+anio; }
}