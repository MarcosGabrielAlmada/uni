program p4b;
var n, v: integer; hay: boolean;

begin
  write('Ingrese una secuencia de numeros terminada en 0: ');
  hay := false;

  repeat
    read(v);
    if (v<>0) then hay := (v mod 5 = 0);
  until (hay) or (v=0);

  if (hay)
  then writeln('En la secuencia SI hay multiplo de 5')
  else writeln('En la secuencia NO hay un multiplo de 5');

  readln();
  readln();
end.


{

Ejercicio 4: Dada una secuencia de números enteros terminada en 0 (cero):

a) Escriba un programa que busque cuántas veces está el entero num (num ingresado por el usuario).
b) Escriba un programa que determine si hay algún múltiplo de 5.
c) Escriba un programa que determine si todos sus elementos de la secuencia son positivos.
d) Escriba un programa que determine cuántos pares de números iguales tiene la secuencia.

}
