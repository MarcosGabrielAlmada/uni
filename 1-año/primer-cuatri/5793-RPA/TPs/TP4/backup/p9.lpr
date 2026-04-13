program p9;
var n, naux, digito, suma, mayor, pos, cant, sign: integer;
begin
  suma := 0;
  mayor := 0;
  pos := 0;
  cant := 0;
  sign := -1;

  write('Ingrese un numero natural: ');
  readln(n);
  writeln();
  writeln();

  naux := n;
  while (naux>0) do
    begin
      digito := naux mod 10;
      pos := pos + 1;
      if (digito mod 2 <> 0)
      then
        begin
          suma := suma + digito;
          if (pos mod 2 = 0) then cant := cant + 1;
          if (sign = -1) then sign := pos;
        end;

      if (digito > mayor) then mayor := digito;


      naux := naux div 10;
    end;

  writeln('Las suma de los digitos en posiciones impares: ', suma);
  writeln('El digito mayor: ', mayor);
  writeln('La cantidad de digitos impares en posiciones pares: ', cant);
  writeln('La posicion menos significativa, donde esta el primer numero impar: ', sign);


  readln();
end.


{

Ejercicio 9: Para cada uno de los siguientes enunciados escriba un programa que
dado un número natural N ingresado por el usuario, indique cuál es:

a) La suma de todos los dígitos que se encuentran en posiciones impares
(la posición de las unidades es la posición nro. 1).
Ejemplo: si ingresa 343 deberá mostrar 6 (3 + 3); si ingresa 20 mostrará 0.

b) El mayor dígito de N.

c) La cantidad de dígitos impares que se encuentran en posiciones pares.

d) La posición menos significativa (primera posición empezando por derecha)
en la que aparece el primer dígito impar en N. Si N no tiene dígitos impares muestra 0.
Ejemplo: si N = 233456, la posición menos significativa del primer impar es 2
(el dígito 5 está en el segundo lugar empezando por derecha).

}


