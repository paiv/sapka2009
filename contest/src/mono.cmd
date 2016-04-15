rem @echo off

set MONOBIN=C:\programs\system\mono\bin
set BINOUT=..\bin

call "%MONOBIN%\gmcs" -lib:./lib -recurse:Archer.Sapka/*.cs ^
  -res:Archer.Sapka/Parser/sapka.cgt,Archer.Sapka.Parser.sapka.cgt ^
  -r:GoldParser ^
  -t:library -out:"%BINOUT%/Archer.Sapka.dll"

call "%MONOBIN%\gmcs" -lib:./lib -lib:../bin -recurse:Archer.Sapka.Bot/*.cs ^
  -r:GoldParser -r:Tao.Lua -r:Archer.Sapka ^
  -t:exe -out:"%BINOUT%/bot.exe"

call "%MONOBIN%\gmcs" -lib:../bin -recurse:Archer.Sapka.Visualizer/*.cs ^
  -r:Archer.Sapka ^
  -t:exe -out:"%BINOUT%/SapkaViz.exe"
