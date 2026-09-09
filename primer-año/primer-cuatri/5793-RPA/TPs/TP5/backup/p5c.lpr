program p5c;
var n1, nAnt: integer; cant: integer;

begin
  nAnt: 0;

  repeat
    write('Ingrese la cantidad de numeros a ingresar(mayor igual que 2): ');
    readln(cant);
  until (cant >= 2);

  write('Ingrese una secuencia de numeros: ');

  repeat
    read(c1);

    if (c1 <> #35)
    then
      begin
        read(c2);

        if (c2 <> #35)
        then
          begin
            ordenC1 := ord(c1);
            ordenC2 := ord(c2);
            if (ordenC1 = 32) and (ordenC2 = 32)
            then consecutivas :=  true;
          end;
      end;

  until (consecutivas) or (c1 = '#') or (c2 = '#');

  if (consecutivas)
  then writeln('La secuencia tiene espacios consecutivas')
  else writeln('La secuencia NO tiene espacios consecutivas');

  readln();
  readln();
end.


{

Ejercicio 6:

Dada una secuencia de n números reales, n ingresado por el usuario,
escriba un programa que determine si la secuencia ingresada es creciente,
(esto es el primer número menor al segundo, el segundo menor al tercero, tercero menor al cuarto y así siguiendo).

Ejemplo:
2.3 3.56 4.0 5.66 es creciente
2.3 3.56 3.0 4.8 no es creciente

}
