public class Prestamo {
  // Atributos de intancia
  private Libro libro;
  private String socio;
  private Fecha fechaPrestamo;
  private Fecha fechaDevolucion;
  private boolean devuelto;


  // Constructor
  public Prestamo(Libro l, Fecha fp, Fecha fd, String s) {
    libro = l;
    socio = s;
    fechaPrestamo = fp;
    fechaDevolucion = fd;
    devuelto = false;
  }


  // Consultas
  public Libro obtenerLibro() { return libro; }
  public Fecha obtenerFechaPrestamo() { return fechaPrestamo; }
  public Fecha obtenerFechaDevolucion() { return fechaDevolucion; }
  public boolean estaDevuelto() { return devuelto; }
  public String obtenerSocio() { return socio; }

  public boolean estaAtrasado(Fecha hoy) {
    boolean res = false;
    if (!devuelto) {
      if (fechaDevolucion.esAnterior(hoy)) res = true;
    }
    return res;
  }

  public Prestamo masAntiguo(Prestamo p) {
    if (fechaPrestamo.esAnterior(p.obtenerFechaPrestamo())) return this;
    else return p;
  }

  public boolean equals(Prestamo p) {
    return libro == p.obtenerLibro()
        && socio.equals(p.obtenerSocio())
        && fechaPrestamo.equals(p.obtenerFechaPrestamo())
        && fechaDevolucion.equals(p.obtenerFechaDevolucion());
  }

}