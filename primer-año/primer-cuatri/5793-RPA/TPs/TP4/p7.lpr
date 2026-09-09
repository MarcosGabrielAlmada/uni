program p7;
var n, m, suma, i: integer;
begin
  suma := 0;
  repeat
    write('Ingrese el inicio del intervalo: ');
    readln(n);
    write('Ingrese el fin del intervalo(debe ser mayor al inicio): ');
    readln(m);
    writeln();
    if (n>m)
      then
        begin
          writeln('|-----------------------------------------------------|');
          writeln('|Error. El inicio del intervalo DEBE ser menor al fin.|');    
          writeln('|-----------------------------------------------------|');
          writeln();
        end;
  until n < m ;

  for i:=n to m do
    suma := suma + i;

  writeln(); writeln();
  writeln('La suma de los numeros entre ', n,' y ', m, ' es: ', suma);



  readln();
end.


{

Ejercicio 7:
Escriba un programa en Pascal para resolver cada uno de los siguientes ejercicios:
a) Mostrar los primeros n números naturales y luego la suma de los mismos, con n ingresado por el usuario.
Por ejemplo, si n=5 se debe mostrar:
1 2 3 4 5
la suma es 15
b) Calcular el producto de los primeros N naturales pares, para un N ingresado por el usuario.
Por ejemplo, si n=10 se debe mostrar:
el producto es 3840
Establezca casos de prueba adecuados para cada inciso y verifique la correctitud de sus programas para los casos de prueba establecidos.

}


