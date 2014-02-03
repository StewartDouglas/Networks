@echo off

echo Distributed Systems Coursework - Install Utility
echo (c) Arosha Bandara, DoC Imperial College London, Oct 2003
echo.

del  rmiclient.csh rmiserver.csh udpclient.csh udpserver.csh Makefile
xcopy /Y scripts\*.bat .

echo.
echo Done!
echo.
