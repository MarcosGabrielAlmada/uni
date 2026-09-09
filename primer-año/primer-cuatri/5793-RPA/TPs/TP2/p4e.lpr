program p4e;
 var c: real;
 begin
  write('Ingrese el costo: ');
  readln(c);

  c := c * 1.15;

  writeln();
  writeln('El monto final, con un 15% de aumento, es de: ', c:0:2);

  readln;
end.
