program p8;
var c: char; propiedad, propParcial: boolean;

begin
  propiedad := false;

  write('Ingrese una oracion terminada en ".":');

  repeat
  begin
    read(c);
    if (c = 'r') and (not propParcial) then propParcial := true
    else if (c = 'r') and (propParcial) then propiedad := true;;
  end;
  until (propiedad) or (c = #46);


  if (propiedad)
  then writeln('La secuencia contiene "rr"')
  else writeln('La secuencia NO contiene "rr"');

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
