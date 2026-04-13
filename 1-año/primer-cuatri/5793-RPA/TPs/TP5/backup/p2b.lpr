program p2b;
var n, cant, i, suma: integer;

begin
  write('Ingrese la cantidad de numeros: ');
  readln(cant);

  for i:=1 to cant do
    begin
      repeat
        writeln();
        write('Ingrese otro numero natural: ');
        readln(n);
      until (n>=0);
      suma := suma + n;
    end;

  writeln('El promedio de estos numeros es: ', suma/cant);

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
