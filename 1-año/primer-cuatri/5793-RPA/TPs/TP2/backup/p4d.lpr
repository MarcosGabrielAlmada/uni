program p4e;
 var c: integer;
 begin
  write('Ingrese el costo: ');
  readln(c);

  c := c * 1.15;

  writeln();
  writeln('El monto final, con un 15% de aumento, es de: ', c);

  readln;
end.
