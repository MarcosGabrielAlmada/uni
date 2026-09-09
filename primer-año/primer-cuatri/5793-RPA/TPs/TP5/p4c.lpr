program p4c;
var v: integer; positivos: boolean;

begin
  write('Ingrese una secuencia de numeros terminada en 0: ');
  positivos := false;

  repeat
    read(v);
    if (v<>0) then positivos := (v > 0);
  until (not positivos) or (v=0);

  if (positivos)
  then writeln('En la secuencia es totalmente positiva')
  else writeln('En la secuencia NO es totalmente positiva');

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
