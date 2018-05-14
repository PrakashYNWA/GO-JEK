#!/bin/bash
chmod +x

PASSED=$1
if  [[ -f $PASSED ]]
then 

	mvn package
	java -jar target/ParkingLot-0.0.1-SNAPSHOT.jar input_file.txt
	
	
else
	
	mvn package
	java -jar target/ParkingLot-0.0.1-SNAPSHOT.jar 

fi