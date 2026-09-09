program p7;
var piso: integer; horas, costo: real;
begin
  costo := -1;
  write('Ingrese el numero de piso en el que va a aparcar(1, 2 o 3): '); readln(piso);
  write('Ingrese el numero de horas que va a dejar el auto: '); readln(horas);
  writeln();

  case piso of
    1:
      begin
        if (horas <= 5)
          then costo := 100*horas
          else costo := 5000
      end;
    2:
      begin
        if (horas <= 5)
          then costo := 80*horas
          else costo := 4000
      end;
    3:
      begin
        if (horas <= 5)
          then costo := 60*horas
          else costo := 3000
      end
    else writeln('El numero de piso ingresado NO es valido');
  end;

  if (costo <> -1)
    then writeln('El costo es de: $', costo:0:2);

  readln();
end.


{

  Estacionamiento de 3 pisos

  1er: 100 por hora
  2do: 80  por hora
  3ro: 60  por hora

  +5horas, minimo:
  1er: $5000
  2do: $4000
  3er: $3000

  DE: piso, horas
  DS: costo

}

