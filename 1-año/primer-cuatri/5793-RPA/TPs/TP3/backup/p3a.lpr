program p3a;
var a, b, c: real;
begin
  write('Ingrese el primer numero: '); readln(a);
  write('Ingrese el segundo numero: '); readln(b);
  write('Ingrese el tercer numero: '); readln(c);
  writeln('');

  if (a-b) > c
  then
    begin
     write('El producto de ', a:0:2, ' y ', b:0:2, 'es: ', (a*b):0:2)
    end
  else
     write('El cociente entre ', a:0:2 ' y ', b:0:2, 'es: ', (a/b):0:2);
  readln();

end.




{

b) Dados tres números a, b, y c, si la diferencia entre a y b es mayor que c,
calcular el producto de a y b; de lo contrario, calcular el cociente entre a y b.

}
