program p2e;
var a: integer;

function esbiciesto(ano : integer): boolean;
  begin
    esbiciesto := false;

    if ((ano mod 4 = 0) and (ano mod 100 <> 0)) or (ano mod 400 = 0)
    then esbiciesto := true;
  end;

begin
  write('Ingrese un ano: ');
  readln(a);


  if (esbiciesto(a))
  then writeln(a, ' SI es biciesto')
  else writeln(a, ' NO es biciesto');

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
