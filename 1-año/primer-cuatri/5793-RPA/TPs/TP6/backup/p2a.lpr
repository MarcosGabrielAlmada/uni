program p2a;
var n: integer;

function factorial(num : integer): integer;
  var i : integer;

  begin
    if (n = 0)
    then factorial := 1
    else
      begin
        for i := 1 to num do
          begin
            factorial := factorial * i;
          end;
      end;
  end;

begin
  repeat
    write('Ingrese un numero natural: ');
    readln(n);
    if (n<0) then writeln('Error! No se puede calcular el numero factorial de un numero negativo.');
  until (n>=0);

  writeln('El factorial de ', n, ' es: ', factorial(n));

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
