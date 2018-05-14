#!/bin/bash
chmod 777 parking_lot.sh

PASSED=$1
if  [[ -f $PASSED ]]
then 

	mvn package
	java -jar target/ParkingLot-0.0.1-SNAPSHOT.jar file_inputs.txt
	
	
else
	
	mvn package
	java -jar target/ParkingLot-0.0.1-SNAPSHOT.jar 

fi