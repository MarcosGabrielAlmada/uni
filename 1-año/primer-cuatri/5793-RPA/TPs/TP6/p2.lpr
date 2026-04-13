program p2;
var n: integer;

function Invertir(num : integer): integer;
  var inv: integer;

  begin
    inv := 0;
    while num > 0 do
      begin
        inv := inv * 10 + (num mod 10);
        num := num div 10;
      end;
      Invertir := inv;
  end;

begin
  write('Ingrese un numero: ');
  readln(n);

  if (n = Invertir(n))
  then writeln('El numero es capicua')
  else writeln('El numero no es capicua');

  readln();

end.


{

Ejercicio 2: Implemente las siguientes funciones:

a. function FACTORIAL (Nro: integer): integer; { Calcula el factorial de un número Nro }

b. function POTENCIA (Base, Exponente: integer ): integer; { Calcula la potencia base al exponente}

c. function ESPRIMO (Nro: integer ): boolean; { Determina si Nro es primo }

d. function CANTVECES (d, Nro: integer): integer; { Calcula la cantidad de veces que aparece el dígito d en el número Nro}.

e. function ESBISIESTO (a: integer): boolean; { Determina si el año a es bisiesto. (Un año es bisiesto si es múltiplo de 4 y no de 100; o es múltiplo de 400)}.

f. function ESVOCAL (car: char ): boolean; { Devuelve verdadero si car es vocal minúscula, caso contrario devuelve falso}

}
