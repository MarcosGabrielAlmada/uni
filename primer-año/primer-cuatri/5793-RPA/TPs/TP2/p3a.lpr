program p3a;
 var A, B, X, Y, Z: Integer; C: Real;
 begin
  write('Ingrese un valor para la variable X: ');
  readln(X);
  write('Ingrese un valor para la variable Y: ');
  readln(Y);
  write('Ingrese un valor para la variable Z: ');
  readln(Z);

  A := (Z * Z) DIV Y;
  B := (Y + 2 * Z) MOD Z;
  C := A / B;

  writeln('Los valores de A, B y C son:');
  writeln('A: ', A);
  writeln('B: ', B);
  writeln('C: ', C:0:0);
  readln;
end.
