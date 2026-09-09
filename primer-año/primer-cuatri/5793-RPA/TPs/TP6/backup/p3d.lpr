program p3d;
var n, naux: integer; especialTotal: boolean;

function verificarEspecial(dig, num: integer): boolean;
var cont: integer;

begin
  verificarEspecial := false;
  cont := 0;

  while (num>0) do
    begin
      if (num mod 10 = dig)
        then cont := cont + 1;
      num := num div 10;
      verificarEspecial := (cont = dig);
    end;
end;

begin
  especialTotal := true;

  write('Ingrese un numero: ');
  readln(n);

  naux := n;
  while (naux>0) and (especialTotal) do
    begin
      if (verificarEspecial(naux mod 10, n))
        then
          begin
            especialTotal := true;
            naux := naux div 10;
          end
      else
        especialTotal := false;
    end;

  if (especialTotal)
    then writeln(n, ' SI es un numero especial')
    else writeln(n, ' NO es un numero especial');

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
