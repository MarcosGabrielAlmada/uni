program p1;
var n: integer; capicua: boolean;

function Invertir(num : integer): integer;
  var inv: integer;

  begin
    inv := 0;
    while num > 0 do
      begin
        inv := inv * 10 + (num mod 10);
        num := num div 10;
      end;
      Invertir := inv;
  end;

begin
  capicua := false;

  write('Ingrese un numero: ');
  readln(n);

  if (n = Invertir(n))
  then writeln('El numero es capicua')
  else writeln('El numero no es capicua');

  readln();

end.


{

Ejercicio 1:

Determinar si un numero es capicua, utilizando la funcion dada.

}
