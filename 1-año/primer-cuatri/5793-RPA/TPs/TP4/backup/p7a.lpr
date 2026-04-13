program p7a;
uses crt;
var inicio, n, m, suma, i: integer;
begin
  inicio := 1;
  suma := 0;
  repeat
    clrscr;

    if (n>=m) and (inicio<>1)
      then
        begin
          writeln('|-----------------------------------------------------|');
          writeln('|Error. El inicio del intervalo DEBE ser menor al fin.|');
          writeln('|-----------------------------------------------------|');
          writeln();
        end;

    write('Ingrese el inicio del intervalo: ');
    readln(n);
    write('Ingrese el fin del intervalo(debe ser mayor al inicio): ');
    readln(m);
    writeln();
    inicio := 0;
  until n < m ;


  writeln(); writeln();

  write('Los numeros entre ', n,' y ', m, ' es: ');
  for i:=n to m do
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


