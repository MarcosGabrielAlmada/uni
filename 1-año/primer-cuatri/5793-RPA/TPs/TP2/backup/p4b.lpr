program p4b;
 var Dm: integer; Dp: Real;
 begin
  write('Ingrese un a distancia en metros, para convertirla en pies: ');
  readln(Dm);

  Dp := Dm*39.37/12;

  writeln(Dm, ' metros son, aproximadamente, ', Dp:0:0, ' pies');

  readln;
end.

{1 metro = 39.37 pulgadas y 12 pulgadas = 1 pie.}
