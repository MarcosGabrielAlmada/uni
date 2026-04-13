program p3e;
var n, d: integer;

function ausente(n, d: integer): boolean;
begin
  if (n < 10)
  then
    begin
      if (n <> d)
      then ausente := true
      else ausente := false;
    end

  else
  begin
    if (n mod 10 = d)
    then ausente := false
    else ausente := ausente(n div 10, d);
  end;

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

  if (ausente (n, d))
  then writeln(d, ' NO esta en ', n)
  else writeln(d, ' SI esta en ', n);
  readln();

end.

{

AUSENTE D en N
Caso Base
* Si N tiene un dígito y es igual a D, AUSENTE D en N es FALSO
* Si N tiene un dígito y es distinto a D, AUSENTE D en N es VERDADERO

Caso General
* Si N tiene más de un dígito y su último digito es igual a D, AUSENTE D en N es FALSO
* Si N tiene más de un dígito y su último digito es distinto a D, AUSENTE D en N es AUSENTE D en N'

(Siendo N': N sin su último dígito)

}



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
