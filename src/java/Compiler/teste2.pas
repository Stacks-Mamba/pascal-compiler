program Fact_rec(output);
function factorial(n:integer):integer;
begin
  if n>1 then
    factorial:=n*factorial(n-1)
  else
    factorial:=1;
end;
var n, f: integer;
begin
  write('n = ');
  readln(n);
  f:=factorial(n);
  writeln(n,'! = ',f);
  readln;
end.
