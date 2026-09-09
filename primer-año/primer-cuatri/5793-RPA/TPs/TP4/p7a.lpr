program p7a;
uses crt;
var inicio, n, suma, i: integer;
begin
  suma := 0;

  write('Ingrese el rango de numeros naturales: ');
  readln(n);
  writeln();


  writeln(); writeln();

  write('Los numeros naturales hasta ', n, ' son: ');
  for i:=1 to n do
    begin
      write(i, ' ');
      suma := suma + i;
    end;
  writeln();
  writeln('Y su suma es :', suma);



  readln();
end.


{

Ejercicio 7:
a) Mostrar los primeros n números naturales y luego la suma de los mismos, con n ingresado por el usuario.
Por ejemplo, si n=5 se debe mostrar:
1 2 3 4 5
la suma es 15

b) Calcular el producto de los primeros N naturales pares, para un N ingresado por el usuario.
Por ejemplo, si n=10 se debe mostrar:
el producto es 3840
Establezca casos de prueba adecuados para cada inciso y verifique la correctitud de sus programas para los casos de prueba establecidos.

}


