program p3a;
var n, d: integer;

function veces(d, n: integer): integer;
begin
  if (d = n)
  then veces := 1

  else if (n>=10)
  then
    begin
      if (d = n mod 10)
      then veces := 1 + veces(d, n div 10)
      else veces := veces(d, n div 10);
    end

  else veces := 0;
end;

begin
  repeat
    write('Ingrese un numero natural: ');
    readln(n);
  until (n>0);

  repeat
    write('Ingrese un digito natural: ');
    readln(d);
  until (d>0) and (d<10);

  writeln();

  writeln(d, ' esta ', veces(d, n), ' veces en ', n);
  readln();

end.


{

Ejercicio 3:

Escriba un planteo recursivo y luego implemente en Pascal una función recursiva
que se corresponda con ese planteo, para que dado un natural N y un dígito d:

a. VECES d en N: Calcule la cantidad de apariciones del dígito d en N.
Ejemplo: N=23224 y d=2, VECES d en N es 3.

b. MAS SIGNIFICATIVO en N es d: Determine si d es el dígito más significativo de N.
Ejemplo: Si N=23224 y d=2, MAS SIGNIFICATIVO d en N es verdadero
porque el 2 es el primer dígito de N. Si N=5 y d=2, es falso.

c. PRESENTE d en N: Determine si d está presente en N.
Ejemplo: N=23224 y d=2, PRESENTE d en N es verdadero porque el 2 está presente en N.
Pero si N=23224 y d=8, es falso porque el 8 no está presente en N.

d. N SIN d: Devolver el número que se obtiene eliminando de N todas las apariciones de d.
Ejemplo: Si N=345323 y d=3, N SIN d es 452. Si N=6 y d=7, N SIN d es 6.

e. AUSENTE de en N: Determine si d no está en N.

f. REPITE d en N: Devolver el número que se obtiene luego de repetir d
todas las veces que aparece en N.
Ejemplo: Si N=234 y d=3, REPITE d en N es 2334. Si N=5 y d=5,
REPITE d en N es 55. Si N= 26 y d=9, REPITE d en N es 26. Si N=787 y d=7,
REPITE d en N es 77877.

}
