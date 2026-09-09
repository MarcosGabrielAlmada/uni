program p5a;
var c: char; letras: boolean; ordenC: integer;

begin
  write('Ingrese una secuencia de caracteres terminada en #: ');
  letras := true;

  repeat
    read(c);

    ordenC := ord(c);
    if ((ordenC < 97) or (ordenC > 122))
    then letras :=  false;

  until (not letras) or (c = '#');

  if (letras)
  then writeln('La secuencia contiene unicamente letras')
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
