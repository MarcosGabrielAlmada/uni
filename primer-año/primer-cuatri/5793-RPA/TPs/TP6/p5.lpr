program p5;
var n: integer;

procedure mostrarDivisores(n: integer);
var i, cantD: integer;

begin
  cantD := 0;
  n := abs(n);

  write(n, ': ');
  for i:=1 to n do
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

Ejercicio 5:

Implemente un procedimiento en lenguaje Pascal para que lea una secuencia de caracteres
y devuelva cuántas vocales mayúsculas y cuántas vocales minúsculas se ingresaron.

El procedimiento deberá tener tres parámetros:
un dato de entrada (longitud de la secuencia)
y dos datos de salida (cantidad de vocales mayúsculas y cantidad de vocales minúsculas).

Utilizando la primitiva del inciso anterior, escriba un programa para solicitar y
leer la longitud de la secuencia de caracteres y el ingreso de la misma y
muestre por pantalla y con un cartel adecuado la cantidad total de vocales ingresadas,
cantidad de mayúsculas y cantidad de minúsculas

}
