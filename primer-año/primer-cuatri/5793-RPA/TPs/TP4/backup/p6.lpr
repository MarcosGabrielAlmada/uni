program p6;
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
          writeln('-----------------------------------------------------');
          writeln('Error. El inicio del intervalo DEBE ser menor al fin.');    
          writeln('-----------------------------------------------------');
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

Ejercicio 6:
Mostrar por pantalla la suma de los números comprendidos entre n y m inclusive,
con n y m ingresados por el usuario.

Su programa debe validar que se cumpla: n < m,
y en caso que no se cumpla se deben volver a ingresar los datos.

Utilice las estructuras de control repetitivas que sean más convenientes.

}


