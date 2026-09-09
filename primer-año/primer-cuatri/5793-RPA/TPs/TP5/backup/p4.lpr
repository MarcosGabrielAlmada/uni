program p4;
var n, v, cant: integer;

begin
  write('Ingrese un numero: ');
  readln(n);
  write('Ingrese una secuencia de numeros terminada en 0: ');


  repeat
    read(v);
    if (v=n)
    then cant := cant + 1;
  until (v=0);

  writeln(n, 'esta ', cant, 'veces en la secuencia');

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
