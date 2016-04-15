@echo off

if "%2"=="" goto usage

set BotA=%~dpnx1
set BotB=%~dpnx2

start "SRV" /min srv\start.bat
cd ..\contest\bin-net
pause
start "Bot A" bot.exe "%BotA%" localhost 20015
start "Bot B" bot.exe "%BotB%" localhost 20016

goto :eof

:usage
echo usage: runtest ^<bot1.lua^> ^<bot2.lua^>
goto :eof
