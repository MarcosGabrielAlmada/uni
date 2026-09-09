program p3e;
var ano, mes: integer;
begin
  write('Ingrese un ano: '); readln(ano);
  write('Ingrese un mes: '); readln(mes);
  writeln('');

  case mes of
    1,3,5,7,8,10,12: writeln('La cantidad de dias que tiene el mes ', mes, ' es: ', 31);
    4,6,9,11: writeln('La cantidad de dias que tiene el mes ', mes, ' es: ', 30);
    2:
      begin
        write('La cantidad de dias que tiene el mes ', mes, ' es: ');
        if (((ano mod 4) = 0) and (ano mod 100 <> 0)) or (ano mod 400 = 0)
        then writeln(29)
        else writeln(28);
      end
    else writeln('El numero de mes ', mes, ' no es correcto.');
  end;
  readln();
end.





{

e) Dado un mes y un año calcule la cantidad de días de ese mes en ese año.

}
