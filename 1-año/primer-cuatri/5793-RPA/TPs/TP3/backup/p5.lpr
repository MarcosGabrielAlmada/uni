program p6;
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




