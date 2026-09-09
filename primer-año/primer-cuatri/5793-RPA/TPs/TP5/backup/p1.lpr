program p1;
var n, cant, suma, mayor, i, pos: integer;

begin
  suma := 0;
  mayor := 0;

  write('Ingrese la cantidad de numeros: ');
  readln(cant);

  for i:=1 to cant do
    begin   
      write('Ingrese otro numero: ');
      readln(n);
      suma := suma + n;
      if (n > mayor)
      then
        begin
          mayor := n;
          pos := i;
        end;
    end;

  writeln();
  writeln('La suma de todos los numeros es: ', suma);
  writeln('El numero mayor es: ', mayor);
  writeln('la posicion del numero mayor es: ', pos);
  readln();
end.


{

Ejercicio 1: Para cada uno de los siguientes enunciados escriba un programa que
dado un número entero N ingresado por el usuario y una secuencia de
N números reales leída a continuación,

Calcule y muestre:
a) La suma de todos los números leídos.
b) El mayor número leído.
c) La posición del mayor número leído, considerando que la posición del primer número leído es 1 y la del último es N.

}
