program p2b;
var n, b: integer;

function potencia(base, num : integer): integer;
  var i : integer;

  begin
    potencia := 1;
    if (n <> 0)
    then
      begin
        for i := 1 to base do
          begin
            potencia := potencia * num;
          end;
      end;
  end;

begin
  write('Ingrese un numero: ');
  readln(n);

  repeat
    write('Ingrese un numero de base: ');
    readln(b);
  until (b>0);

  writeln(n ,' elevado ', b, ' da: ', potencia(b,n));

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
