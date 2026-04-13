program p5;
var v: char; letras: boolean;

begin
  write('Ingrese una secuencia de caracteres terminada en #: ');
  letras := false;

  repeat
    read(v);
    if (v<>'#')
    then
      begin
        case (UpCase(v)) of
          'A'..'Z': letras := true
          else letras := false;
        end;
      end;

  until (not letras) or (v='#');

  if (letras)
  then writeln('La secuencia es totalmente de letras')
  else writeln('La secuencia no contiene unicamente letras');

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
