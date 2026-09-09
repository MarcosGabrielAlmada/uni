program p3e;
var ano, mes: integer;
begin
  write('Ingrese un ano: '); readln(ano);
  write('Ingrese un mes: '); readln(mes);
  writeln('');

  if (odd(mes = 1) or mes = 3 or mes = 5 or mes = 7 or mes = 8 or mes = 10 or mes = 12)
    then writeln('La cantidad de dias que tiene el mes ', mes, ' es: ', 31)
  else if (mes = 4 or mes = 6 or mes = 9 or mes = 11)
    then writeln('La cantidad de dias que tiene el mes ', mes, ' es: ', 30)
  else if (mes = 2)
    then
      begin
        write('La cantidad de dias que tiene el mes ', mes, ' es: ');
        if (((ano mod 4) = 0) and (ano mod 100 <> 0)) or (ano mod 400 = 0)
        then writeln(29)
        else writeln(28);
      end
  else writeln('El numero de mes ', mes, ' no es correcto.');

  readln();
end.





{

e) Dado un mes y un año calcule la cantidad de días de ese mes en ese año.

}
