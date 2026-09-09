program p6;
var c: char; propiedad, propParcial: boolean;

begin
  propiedad := false;

  write('Ingrese una oracion terminada en ".":');

  repeat
  begin
    read(c);
    if (c = 'r') and (not propParcial) then propParcial := true
    else if (c = 'r') and (propParcial) then propiedad := true;;
  end;
  until (propiedad) or (c = #46);


  if (propiedad)
  then writeln('La secuencia contiene "rr"')
  else writeln('La secuencia NO contiene "rr"');

  readln();
  readln();
end.


{

Ejercicio 7:

Dada una secuencia de caracteres que representa una oración
y finaliza con ‘.’ determine si en la misma hay alguna palabra con ‘rr’.

}
