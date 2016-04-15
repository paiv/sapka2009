@echo off

set WD=%~dp0
set BOT=%WD%\noop-ko.lua
rem cd ..\contest\bin-net
bot.exe "%BOT%" localhost 20016
rem 2>&1 > "%WD%\error.log"
rem exit
