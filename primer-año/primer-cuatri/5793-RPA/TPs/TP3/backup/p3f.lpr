program p3f;
var tipo: char; precio: real;
begin
  write('Ingrese el tipo de socio y monto(todo junto, ej: A2500): '); readln(tipo, precio);

  case LowerCase(tipo) of
    'a': writeln('El monto total con descuento es: ', precio*0.5:0:2);
  end;

  readln();
end.





{

f) Una obra social tiene tres clases de socios:

Los socios tipo ‘A’ abonan una cuota mayor pero tiene un 50% de descuento
en todos los tipos de tratamientos odontológicos.

Los socios tipo ‘B’ abonan una cuota moderada y tienen un 35% de descuento
para los mismos tratamientos que los socios del tipo A.

Los socios que menos aportan, los de tipo ‘C’,
no reciben descuentos sobre dichos tratamientos.

Dado un caracter que representa la clase de un socio junto con el costo
del tratamiento (previo al descuento) determine el importe en efectivo a pagar por dicho socio.

}
