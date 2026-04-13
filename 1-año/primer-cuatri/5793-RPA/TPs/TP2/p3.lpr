program p3a;
 Const
  X = 1; Y = 2; Z = 3;
 var A, B: Integer; C: Real;
 begin
  A := (Z * Z) DIV Y;
  B := (Y + 2 * Z) MOD Z;
  C := A / B;

  writeln('Los valores de A, B y C son:');
  writeln('A: ', A);
  writeln('B: ', B);
  writeln('C: ', C:0:0);
  readln;
end.
