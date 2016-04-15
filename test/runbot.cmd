@echo off

if "%1"=="" goto usage

set BOT=%~dpnx1
cd ..\contest\bin-net
start "BOT" bot.exe "%BOT%" localhost 20016
goto :eof

:usage
echo usage: runtest ^<bot.lua^>
goto :eof
