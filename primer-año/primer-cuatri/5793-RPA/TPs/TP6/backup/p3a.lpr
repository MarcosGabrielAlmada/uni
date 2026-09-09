program p3a;
var d,m,a: integer;

function esbiciesto(ano : integer): boolean;
  begin
    if ((ano mod 4 = 0) and (ano mod 100 <> 0)) or (ano mod 400 = 0)
    then esbiciesto := true
    else esbiciesto := false;
  end;

function fechavalida(dia, mes, ano : integer): boolean;
  begin
    fechavalida := false;

    if ((dia>=1) and (dia<=31)) and ((mes>=1) and (mes<=12)) and (ano>=1)
    then
      begin
        if  (mes=1) or (mes=3) or (mes=5) or (mes=7) or (mes=8) or (mes=10) or (mes=12)
        then fechavalida := true

        else if (mes<>2) and (dia<=30)
        then fechavalida := true

        else
          begin
            if (esbiciesto(ano)) and (dia<=29)
            then fechavalida := true

            else if not (esbiciesto(ano)) and (dia<=28)
            then fechavalida := true;
          end;
      end;
  end;

begin
  repeat
  writeln('Ingrese una fecha:');
  write('Dia: '); readln(d);
  write('Mes: '); readln(m);
  write('Ano: '); readln(a);


  if (fechavalida(d,m,a))
  then writeln(d, '/', m, '/', a, ' SI es una fecha valida')
  else writeln(d, '/', m, '/', a, ' NO es una fecha valida');

  readln();
        until(false);
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
