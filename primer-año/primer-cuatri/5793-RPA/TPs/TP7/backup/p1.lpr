program p1;
var a, b: integer;

function divisionEntera(a, b: integer): integer;
begin
  a := abs(a);
  b := abs(b);

  if (a<b)
  then divisionEntera := 0
  else divisionEntera := divisionEntera(a-b,b) + 1;
end;

begin
  repeat
    write('Ingrese un numero natural A: ');
    readln(a);
  until (a>0);

  repeat
    write('Ingrese un numero natural B: ');
    readln(b);
  until (b>0);

  writeln();

  writeln('La division entera entre ', A, ' y ', B, ' es: ', divisionEntera(a,b));
  readln();

end.


{

Ejercicio 1:

Implemente en Pascal una función recursiva que se corresponda con el siguiente planteo,
para calcular la división entera entre dos números A y B, utilizando como
operaciones aritméticas la suma y la resta.

Planteo División Entera entre A y B
CB: Si A es menor que B, la División Entera entre A y B es cero.
CR: Si A es mayor o igual a B, la División Entera entre A y B es 1 + la División Entera entre A-B y B.

}
