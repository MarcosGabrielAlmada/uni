program p3b;
var nota: char;
begin
  write('Ingrese la nota del alumno(A, B, C o D): '); readln(nota);
  writeln('');

  case nota of
    A, B: writeln('El alumno aprobó');
    C: writeln('El alumno debe recuperar');
    D: writeln('El alumno perdió la materia');
  end;
  readln();

end.




{

c) Dada la nota de un alumno como una letra ‘A’, ‘B’, ‘C’ o ‘D’.
Indicar si el alumno aprobó, recupera o perdió la materia.
Se conoce que un alumno aprueba si tiene ‘A’ o ‘B’;
recupera si tiene una ‘C’ y pierde la materia si tiene una ‘D’.

}
