program p2;
var n: integer;

function cantDigImpares(n: integer): integer;
begin
  cantDigImpares := 0;

  if (n mod 2 <> 0)
  then cantDigImpares := 1;

  if (n >= 10)
      then cantDigImpares := cantDigImpares + cantDigImpares(n div 10);
end;

begin
  repeat
    write('Ingrese un numero natural: ');
    readln(n);
  until (n>0);

  writeln();

  writeln(n, ' tiene ', cantDigImpares(n), ' digitos impares');
  readln();

end.


{

Ejercicio 2:

Escriba un planteo recursivo y luego implemente en Pascal una función recursiva
que se corresponda con ese planteo, para calcular la cantidad de dígitos impares de un número N.

}
