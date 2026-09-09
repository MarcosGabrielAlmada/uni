program p3c;
var n: integer;

function esprimo(n: integer): boolean;
var i :integer;

begin
  esprimo := true;
  n := abs(n);

  if (n=0) or (n=1) then esprimo := false;

  if (esprimo)
  then
  begin
    for i:=2 to (n-1) do
    begin
      if (esprimo) and (n mod i = 0)
      then esprimo := false;
    end;
  end;
end;

begin
  write('Ingrese una secuencia de numeros terminada en 0: ');


  repeat
    read(n);

    if (esprimo(n))
    then writeln(n, ' SI es primo')
    else writeln(n, ' NO es primo');
  until (n = 0);

  readln();
  readln();
end.


{

Ejercicio 3: Utilizando las funciones definidas en el ejercicio anterior, resuelva los siguientes incisos:

a. Escriba un programa que solicite al usuario una fecha
(representada por tres números enteros) y determine si la misma es válida o no.


b. Escriba un programa que dada una secuencia de números naturales finalizada en 0,
indique por pantalla cuántos números primos se ingresaron.


c. Escriba un programa para mostrar por pantalla todos los números primos
entre 1 y un valor natural ingresado por el usuario (inclusive).

Por ejemplo:Ingrese un valor: 32
Los números primos entre 1 y 32 son: 2 3 5 7 11 13 17 19 23 29 31


d. Escriba un programa que determine si un número N es o no especial.
Un número N es especial si cada dígito que está en N aparece tantas veces como su propia magnitud.

Por ejemplo, si el dígito 3 aparece en un número entonces deberá aparecer
en exactamente 3 posiciones distintas para que dicho número sea especial;
si el 1 aparece, deberá aparecer sólo una vez;
si el 2 aparece está dos veces, etc.
Ejemplos de números especiales: 333, 3313, 4234132434.

}
