package com.gojek.ParkingLot;

import java.util.ArrayList;
import java.util.Map;

public class Carpark {
	
	int MAX_SIZE = 0;
	// List of available slots
    ArrayList<Integer> list_of_available_slots;
    // Mapping of slot no to car
    Map<String, Car> slot_to_car;
    // Mapping of reg no to slot no
    Map<String, String> reg_to_slot;
    // Mapping of colour to list of reg_no with that colour
    Map<String, ArrayList<String>> colour_to_reg;
    
    public void create_parking_lot(String size){
    	
    }

}
