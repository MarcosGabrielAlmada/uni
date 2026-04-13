program p2c;
var n, b: integer;

function esprimo(num : integer): boolean;
var cont: integer;

  begin
    num := abs(num);   
    esprimo := false;

    if (num > 1)
    then
    begin
      cont := num;
      repeat
        begin
          if ((num mod (sqrt(cont))) = 0)
          then esprimo := true;
          cont := cont - 1;
        end;
      until (cont = 1) or (esprimo);
    end;
  end;

begin
  write('Ingrese un numero: ');
  readln(n);

  if (esprimo(n))
  then writeln(n ,' SI ES un numero primo')
  else writeln(n ,' NO ES un numero primo');

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
