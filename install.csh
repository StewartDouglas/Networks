#!/bin/csh

echo Distributed Systems Coursework - Install Utility
echo \(c\) Arosha Bandara, DoC Imperial College London, Oct 2003

rm -f rmiclient.bat rmiserver.bat udpclient.bat udpserver.bat build.bat 
cp scripts/Makefile .
cp scripts/*.csh .
dos2unix policy
foreach i ( *.csh )
dos2unix $i
end
chmod u+x *.csh

echo Done!
