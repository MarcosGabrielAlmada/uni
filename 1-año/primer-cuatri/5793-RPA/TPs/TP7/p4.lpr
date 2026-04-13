program p4;
var n, d: integer;

function ausente(n, d: integer): boolean;
begin
  if (n < 10)
  then
    begin
      if (n <> d)
      then ausente := true
      else ausente := false;
    end

  else
  begin
    if (n mod 10 = d)
    then ausente := false
    else ausente := ausente(n div 10, d);
  end;

end;

begin
  repeat
    write('Ingrese un numero natural: ');
    readln(n);
  until (n>0);

  writeln();

  if (ausente (n, d))
  then writeln(d, ' NO esta en ', n)
  else writeln(d, ' SI esta en ', n);
  readln();

end.




{

Ejercicio 4:

Dado un número natural N, definiremos como su número promedio de N al número
que se obtiene de sumar sus dígitos impares y restar sus dígitos pares.

Por ejemplo, el número promedio de N = 1227 es 1 – 2 – 2 + 7 = 4
Escriba el planteo recursivo e implemente en Pascal una función para obtener el número promedio de N.

}
