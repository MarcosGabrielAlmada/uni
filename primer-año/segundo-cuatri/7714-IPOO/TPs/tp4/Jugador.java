public public class Jugador {

  // Atributos de instancia
  private String nombre;
  private int nroCamiseta;
  private int posicion;
  private int golesConvertidos;
  private int partidosJugados;

  // Constructor
  public Jugador(String nom) {
    nombre = nom;
  }

  // Comandos
  public void establecerNroCamiseta(int n) {
    nroCamiseta = n;
  }

  public void establecerPosicion(int n) {
    posicion = n;
  }

  public void establecerGolesConvertidos(int n) {
    golesConvertidos = n;
  }

  public void establecerPartidosJugados(int n) {
    partidosJugados = n;
  }

  public void aumentarGoles(int n) {
    golesConvertidos = golesConvertidos + n;
  }

  public void aumentarUnPartido() {
    partidosJugados = partidosJugados + 1;
  }

  // Consultas
  public String obtenerNombre() {
    return nombre;
  }

  public int obtenerNroCamiseta() {
    return nroCamiseta;
  }

  public int obtenerPosicion() {
    return posicion;
  }

  public int obtenerGolesConvertidos() {
    return golesConvertidos;
  }

  public int obtenerPartidosJugados() {
    return partidosJugados;
  }

  public int promedioGolesXPart() {
    return partidosJugados / golesConvertidos;
  }

  public boolean masGoles(Jugador j) {
    boolean tieneMas = false;
    if (golesConvertidos > j.obtenerGolesConvertidos())
      tieneMas = true;
    return tieneMas;
  }

  public Jugador jugConMasGoles(Jugador j) {
    Jugador conMasGoles;
    if (this.obtenerGolesConvertidos() > j.obtenerGolesConvertidos())
      conMasGoles = this;
    else
      conMasGoles = j;
    return conMasGoles;
  }

  public String toString() {
    return "Nombre: " + nombre +
        " Numero de Camiseta: " + nroCamiseta +
        " Posicion: " + posicion +
        " Goles Convertidos: " + golesConvertidos +
        " Partidos Jugados: " + partidosJugados;
  }

  public Jugador clone() {
    Jugador j1 = new Jugador(nombre);
    j1.posicion = this.posicion; // se copian manualmente porque no hay parametros mas que para nombre
    j1.nroCamiseta = this.nroCamiseta;
    j1.golesConvertidos = this.golesConvertidos;
    j1.partidosJugados = this.partidosJugados;

    return j1;
  }

  public boolean equals(Jugador j) {
    boolean esIgual = false;
    if (nombre == j.obtenerNombre() &&
        nroCamiseta == j.obtenerNroCamiseta() &&
        posicion == j.obtenerPosicion() &&
        golesConvertidos == j.obtenerGolesConvertidos() &&
        partidosJugados == j.obtenerPartidosJugados())
      esIgual = true;
    return esIgual;
  }

}
