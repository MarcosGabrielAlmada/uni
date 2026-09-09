program p3;
var c: char;

function esvocal(car : char): boolean;
  begin
    esvocal := false;

    if (ord(car)>=65) and (ord(car)<=85) then esvocal := true;
  end;

begin
  repeat
    write('Ingrese un la vocal: ');
    readln(c);
  until (c=#65) or (c=#69) or (c=#73) or (c=#79) or (c=#85) or (c=#97) or (c=#101) or (c=#105) or (c=#111) or (c=#117);


  if (esvocal(c))
  then writeln(c, ' es mayuscula')
  else writeln(c, ' es minuscula');

  readln();

end.


{

Ejercicio 2: Implemente las siguientes funciones:

a. function FACTORIAL (Nro: integer): integer;  Calcula el factorial de un número Nro

b. function POTENCIA (Base, Exponente: integer ): integer;  Calcula la potencia base al exponente

c. function ESPRIMO (Nro: integer ): boolean;  Determina si Nro es primo

d. function CANTVECES (d, Nro: integer): integer; Calcula la cantidad de veces que aparece el dígito d en el número Nro.

e. function ESBISIESTO (a: integer): boolean; Determina si el año a es bisiesto. (Un año es bisiesto si es múltiplo de 4 y no de 100; o es múltiplo de 400).

f. function ESVOCAL (car: char ): boolean; Devuelve verdadero si car es vocal minúscula, caso contrario devuelve falso

}
