public class Historicos {
  Jugador jugadoresHistoricos[];
  int cant;

  public Historicos(int n) { 
    jugadoresHistoricos = new Jugador[n];
    cant = 0;
  }

  public void establecerJugador(Jugador j) {
    jugadoresHistoricos[cant] = j;
    cant++;
  }

  public void ordenar() {
    
  }





}