#!/bin/csh

setenv SECPOLICY "file:./policy"
java -cp . -Djava.security.policy=$SECPOLICY rmi.RMIServer
