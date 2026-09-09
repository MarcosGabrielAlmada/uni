program p3b;
var num, aux, cant: integer;
begin
  cant := 0;
  write('Ingrese un numero: '); readln(num);
  aux := num;

  while (aux>0) do
    if ((aux div 10) >= 0)
       then
         begin
           if (aux mod 2 <> 0)
              then cant := cant + 1;
           aux := aux div 10;
         end;


  writeln('El numero ', num, ' tiene ', cant, ' cifras impares');
  readln();
end.




{
Dado un número natural N ingresado por el usuario, calcule y muestre:

b) La cantidad de dígitos impares de N.
si ingresa 343 deberá mostrar 2;
si ingresa 20 deberá mostrar 0.

}
