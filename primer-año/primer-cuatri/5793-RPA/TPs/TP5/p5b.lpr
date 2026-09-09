program p5b;
var c1,c2: char; consecutivas: boolean; ordenC1, ordenC2: integer;

begin
  write('Ingrese una secuencia de caracteres terminada en #: ');
  consecutivas := false;

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
            if (ordenC1 >= 97) or (ordenC1 <= 122) and (ordenC2 >= 97) or (ordenC2 <= 122)
            then if ((ordenC1 + 1) = ordenC2)
            then consecutivas :=  true;
          end;
      end;

  until (consecutivas) or (c1 = '#') or (c2 = '#');

  if (consecutivas)
  then writeln('La secuencia tiene letras ')
  else writeln('La secuencia NO contiene unicamente letras');

  readln();
  readln();
end.


{

Ejercicio 5: Dada una secuencia de caracteres terminada en ‘#’,

a) Escriba un programa que determine si todos los caracteres de la secuencia son letras.
b) Escriba un programa que determine si hay al menos dos letras iguales consecutivas.
Ejemplo: sdfFFaOuuuccuoudues# hay al menos 2 vocales juntas
c) Escriba un programa que cuente cuántas veces se encontraron dos espacios consecutivos.

}
