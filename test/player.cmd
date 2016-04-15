@echo off

if "%1"=="" goto usage

set BOT=%~dpnx1

cd srv
start /min keyboard.bat archer ^
  CFGOGDUTYxGAJmPGsmhYsec#CFGCSfWWOGepyTEqUw@UIUs#CFGAaOaOmUgZaXIBWdIcIBG#CFGkIqqIkADuRgiksiJOjmv#CFGKIvAUieJqPuEqvcporIY#CFGCukQbIWetUgmqWhoDKBg#CFGKWMoQGoUXYImECGXsEyU#CFGSOceNsIjQFIZiDSUHcqU#CFGcYAAgQvSQBqxIcdICmSf#CFGKYukVYECnogScxAdAOKZ#CFGWCisaealAHYdcyYNSGOC#CFGAaOgHQRqHKvCSKcbqCjy#CFGCagsfoRahUxIEOZijWiX ^
  y


cd ..\..\contest\bin-net
start "BOT" bot.exe "%BOT%" localhost 20016
goto :eof

:usage
echo usage: runtest ^<bot.lua^>
goto :eof
