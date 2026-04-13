program p3c;
var ano: integer;
begin
  write('Ingrese un ano: '); readln(ano);
  writeln('');

  if (((ano mod 4) = 0) and (ano mod 100 <> 0)) or (ano mod 400 = 0)
  then writeln('El ano ', ano, ' es un ano bisiesto')
  else writeln('El ano ', ano, ' NO es un ano bisiesto');

  readln();
end.




{

d) Dado un entero que representa un año,
indique si corresponde a un año bisiesto o no
(un año es bisiesto si es múltiplo de 4 y no de 100; o es múltiplo de 400).

}
