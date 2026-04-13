program p8b;
var i, n, cant: integer;
begin
  write('Ingrese un numero natural: ');
  readln(n);
  writeln();


  for i:=1 to n do
    if (n mod i = 0)
      then
      begin
        cant := cant + 1;
      end;

  if (cant > 2)
    then writeln('EL numero ', n, ' NO es primo')
    else writeln('EL numero ', n, ' SI es primo');

  readln();
end.


{

Ejercicio 8:
a) Escriba el algoritmo y luego el programa en Pascal para que
solicite al usuario un número natural y como resultado muestre por pantalla
todos los divisores naturales de dicho número y a continuación la cantidad total de divisores.

Por ejemplo:
- si se ingresa el número 12, se deberá mostrar: 1 2 3 4 6 12 cantidad divisores: 6
- si se ingresa el número 11, se deberá mostrar: 1 11 cantidad divisores: 2

b) Escriba un algoritmo y luego un programa en Pascal que
dado un número natural n ingresado por el usuario determine si n es primo.

}


