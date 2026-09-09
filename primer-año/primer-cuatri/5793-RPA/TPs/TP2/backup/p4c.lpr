program p4c;
 var c, p, vueltoReal, vuelto, x, y, z: integer;
 begin
  write('Ingrese el costo: ');
  readln(c);
  write('Ingrese el pago: ');
  readln(p);

  vueltoReal := 36;
  vuelto := vueltoReal;

  x := vuelto div 10;
  vuelto := vuelto - x*10;

  y := vuelto div 5;
  vuelto := vuelto - y*5;

  z := vuelto div 1;

  writeln('El vuelto es: ', vuelto);
  writeln('Monedas de 10: ', x);
  writeln('Monedas de 5: ', y);
  writeln('Monedas de 1: ', z);

  readln;
end.

{Una persona compra un objeto que cuesta c pesos pagando con p pesos
(c es menor o igual que p). El "vuelto" resultante será p-c pesos.
Suponiendo que se dispone de una cantidad ilimitada de monedas de 10, 5 y 1 pesos.
Calcule la cantidad a dar de cada nominación si se desea utilizar la menor cantidad de monedas posibles.}
