program p8c;
var n1, n2, cant, contadorPar, contadorImpar: integer;

begin
  contadorPar := 0;
  contadorImpar := 0;

  repeat
    write('Ingrese la cantidad de pares de numeros(mayor o igual a 1): ');
    readln(cant);
  until (cant >= 1);

  write('Ingrese una secuencia de pares de numeros: ');

  repeat
  begin
    read(n1, n2);
    if (n1 mod 2 = 0) and (n2 mod 2 = 0) then contadorPar := contadorPar + 1
    else if (n1 mod 2 <> 0) and (n2 mod 2 <> 0) then contadorImpar := contadorImpar + 1;

    cant := cant - 1;
  end;
  until (cant = 0);


  if (contadorPar > 0) or (contadorImpar > 0)
  then
    begin
      writeln('La secuencia tiene:');
      writeln(contadorPar, ' pares de numeros pares');
      writeln(contadorImpar, ' pares de numeros impares');
    end
  else writeln('La secuencia no tiene pares de numeros pares o impares');

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
