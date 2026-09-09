program p8b;
var n1, n2, cant, contadorPropiedad: integer;

begin
  propiedad := false;
  contadorPropiedad := 0;

  repeat
    write('Ingrese la cantidad de pares de numeros(mayor o igual a 1): ');
    readln(cant);
  until (cant >= 1);

  write('Ingrese una secuencia de pares de numeros: ');

  repeat
  begin
    read(n1, n2);
    if (n1 < 0) and (n2 < 0) then contadorPropiedad := contadorPropiedad + 1;

    cant := cant - 1;
  end;
  until (cant = 0);


  if (contadorPropiedad = 3)
  then writeln('La secuencia SI tiene exactamente 3 pares de numeros negativos')
  else writeln('La secuencia NO tiene exactamente 3 pares de numeros negativos');

  readln();
  readln();
end.


{

Ejercicio 8:

Dada una secuencia de n PARES de números enteros, n ingresado por el usuario:

a) Escriba un programa que indique si existe al menos un par de números
donde el primer número es mayor al segundo número del mismo par.

b) Escriba un programa que indique si existen exactamente 3 pares de números negativos.

c) Escriba un programa que cuente cuantos de los pares cumplen con la siguiente propiedad:
ambos son pares o ambos son impares.

Por ejemplo,
n = 4
Secuencia: 3 5 6 18 4 7 10 12
La cantidad de pares es 3. Ya que los elementos del primer par son ambos impares,
los elementos del segundo par son ambos pares, y los elementos del último par son ambos pares.

}
