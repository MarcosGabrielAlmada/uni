program p4;
var n: integer;

procedure mostrarDivisores(n: integer);
var i, cantD: integer;

begin
  cantD := 0;
  n := abs(n);

  write(n, ': ');
  for i:=1 to n/2 do
  begin
    if (n mod i = 0)
    then
      begin
        cantD := cantD+1;
        write(' ', i);
      end;
  end;

  if (cantD = 2) then write('. Es primo');

  writeln();
end;

begin
  write('Ingrese una secuencia de numeros enteros terminada en 0: ');

  repeat
    read(n);
    if (n<>0)
    then
      begin
        mostrarDivisores(n);

      end;
  until (n=0);


  readln();
  readln();
end.


{

Ejercicio 4:

Escriba un procedimiento en Pascal que muestre los divisores de un número N recibido como parámetro.
Además, el procedimiento deberá devolver la cantidad de divisores encontrados.

Escriba un programa que lea una secuencia de números enteros finalizada en 0
y utilizando el procedimiento definido antes muestre por pantalla cada número leído
seguido de sus divisores. Para cada número leído, el programa principal deberá decidir
si se trata de un número primo o no.
(Un número N es primo si solo tiene dos divisores: 1 y N)

}
