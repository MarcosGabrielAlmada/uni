program p3;
var cantPares, primero, segundo, i: integer;

begin
  write('Ingrese una cantidad de numeros pares: ');
  readln(cantPares);
  write('Ingrese una secuencia de numeros: ');

  for i:=1 to cantPares do
    begin
      read(primero);
      read(segundo);
      write((primero + segundo), ' ');
    end;

  readln();
end.


{

Ejercicio 3:
Escriba un programa que reciba un número entero N ingresado por el usuario
y una secuencia de N pares de números enteros,
y muestre por pantalla la suma de cada par leído.

}
