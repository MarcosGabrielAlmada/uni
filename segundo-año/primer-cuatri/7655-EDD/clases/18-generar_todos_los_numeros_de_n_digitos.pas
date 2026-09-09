
program GenerarTodosLosNumerosDeNDigitos;
type arreglo =  array[1..1000] of integer;
procedure generar(noriginal:integer; n:integer; var a:arreglo);
var i : integer;
begin
   if n=0 then begin
       for i := 1 to noriginal do write(a[i]);
       writeln;
   end
   else begin
       for i := 0 to 9 do begin
          a[n]:=i; generar(noriginal, n-1, a);
       end;
   end;

end;

var arr:arreglo;
    digitos:integer;
begin
  writeln ('Hello World');
  digitos := 10;
  generar(digitos,digitos,arr)
end.
