program p2;
var n, cant, i: integer;

begin
  write('Ingrese la cantidad de numeros: ');
  readln(cant);

  for i:=1 to cant do
    begin
      repeat
        write('Ingrese otro numero natural: ');
        readln(n);
      until (n>=0);

      if (n div 100 <> 0)
      then
        writeln(n, ' tiene 3 o mas de 3 cifras');
    end;

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
