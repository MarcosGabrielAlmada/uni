program p2c;
var c: char; cant: integer;

begin
  cant := 0;
  writeln('Ingrese una secuencia de caracteres, terminada en ".": ');

  repeat
    read(c);
    case UpCase(c) of
      'A','E','I','O','U': cant := cant + 1;
    end;
  until (c='.');

  if (cant > 0)
  then writeln('La cantidad de vocales son: ', cant)
  else writeln('No hay vocales');

  readln();
  readln();
end.


{

Ejercicio 2: Escriba un programa en Pascal para resolver
cada uno de los siguientes ejercicios:

a) Leer una secuencia de números naturales terminada en 0 y
mostrar aquellos valores leídos que tienen más de tres cifras.

b) Leer una secuencia de números reales terminada en 0 y
mostrar el promedio de los mismos.

c) Leer una secuencia de caracteres terminando con un punto y
mostrar la cantidad de vocales mayúsculas.

}
