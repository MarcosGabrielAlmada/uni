program p2d;
var n, d: integer;

function cantveces(num, dig : integer): integer;
  begin
    num := abs(num);
    dig := abs(dig);
    cantveces := 0;

    while (num>0) do
    begin
      if (num mod 10 = dig) then cantveces := cantveces + 1;
      num := num div 10;
    end;
  end;

begin
  write('Ingrese un numero: ');
  readln(n);

  repeat
    write('Ingrese un digito que se encuentre en el numero: ');
    readln(d);
  until (d>=-9) and (d<=9);

  if (cantveces(n,d) > 0)
  then writeln(d ,' esta ', cantveces(n,d), ' en ', n)
  else writeln(d ,' NO esta en ', n);

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
