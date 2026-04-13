program p6;
var ancho, largo, alto, m3, temp, min, max: real;
begin
  writeln('Por favor, ingrese los siguientes datos sobre su ambiente:');
  write('Ancho(metros): '); readln(ancho);
  write('Largo(metros): '); readln(largo);
  write('Alto(metros): '); readln(alto);
  write('Temperatura Deseada(grados): '); readln(temp);
  writeln('');

  m3 := ancho*largo*alto;
  writeln('Para mantener su ambiente de ', m3:0:2, 'm3 en ', temp:0:2,' grados se requieren:');

  if (temp < 30)
    then
      begin
        min := m3*36.15;
        max := m3*47;
      end
    else if (temp >= 30) and (temp <= 40)
      then
        begin
          min := m3*43.4;
          max := m3*56.4;
        end
    else
      begin
        min := m3*50.6;
        max := m3*65.8;
      end;

  writeln('Minimo: ', min:0:2, ' de frigorias');
  writeln('Maximo: ', max:0:2, ' de frigorias');

  readln();
end.



