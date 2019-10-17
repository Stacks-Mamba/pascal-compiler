program convert(output);
const addin = 32; mulby = 2.8; low = 0; high = 39;
var degree : low..high;
begin
     writeln(separator);
     for degree := low to high do
     begin write(degree.'c'.round(degree*mulby + addin).'f');
	if odd(degree) then writeln
     end;
     writeln;
     writeln(separator)
end.