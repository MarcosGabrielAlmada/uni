Program p10;
var n, d, aux, ultimo: integer; impar, ordenado: boolean;

begin
  write('Ingrese un numero: ');
  readln(n);
  write('Ingrese otro numero: ');
  readln(d);
  writeln();

  aux := n;
  ordenado := true;
  while (aux > 0) do
    begin
      if (aux div 10 <> 0)
        then
          begin
            if (aux mod 2  <> 0) then impar := true;

            aux := aux div 10;

            if (aux mod 10 > ultimo) and (ordenado = true)
              then
                begin
                  ordenado := true;
                  ultimo := aux mod 10;
                end
              else ordenado := false;
          end;
    end;

  writeln(ordenado);
  readln();
end.

{

Ejercicio 10:
Escriba un programa para cada uno de los siguientes enunciados
donde N será un natural ingresado por el usuario.
Considere si es necesario o no procesar todo el número para obtener la solución.

a) N tiene algún dígito impar.
b) N tiene los dígitos ordenadas en forma creciente, es decir dm>dm-1>…> d1
c) El dígito D está presente en N. (D también ingresado por el usuario).

}
