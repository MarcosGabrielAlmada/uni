program p5;
var nota: integer;
begin
  write('Ingrese la nota del alumno: '); readln(nota);

  case nota of
    0..3: writeln('La calificacion del alumno es Aplazada');
    4..6: writeln('La calificacion del alumno es Aprobado');
    7,8: writeln('La calificacion del alumno es Distinguido');
    9: writeln('La calificacion del alumno es Excelente');
    10: writeln('La calificacion del alumno es Sobresaliente');
  end;

  readln();
end.





{

Realice un algoritmo y un programa en PASCAL para determinar y mostrar con un cartel
la calificación de un alumno en función de la nota obtenida.

El usuario deberá ingresar una nota numérica correspondiente a un entero entre 0 y 10.
La calificación se determina de acuerdo al siguiente detalle:

0 a 3: Aplazado;
4 a 6: Aprobado;
7 a 8: Distinguido;
    9: Excelente;
   10: Sobresaliente;

}
