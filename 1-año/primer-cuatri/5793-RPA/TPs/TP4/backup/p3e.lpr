program p3e;
var num, aux, cant: integer;
begin
  cant := 0;
  writeln(-32768);
  writeln(-32769);
  writeln(32767);
  writeln(99999999999999999999+11);
  write('Ingrese un numero: '); readln(num);
  aux := num;

  while (aux>0) do
    if ((aux div 10) >= 0)
       then
         begin
           aux := aux div 10;
           cant := cant + 1;
         end;


  writeln('El numero ', num, ' tiene ', cant, ' cifras');
  readln();
end.




{
Dado un número natural N ingresado por el usuario, calcule y muestre:

a) La cantidad de dígitos de N. Ejemplo:
si ingresa 343 deberá mostrar 3;
si ingresa 20 deberá mostrar 2.

}
