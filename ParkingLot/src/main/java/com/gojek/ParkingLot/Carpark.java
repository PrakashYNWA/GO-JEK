package com.gojek.ParkingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    	try{
			this.MAX_SIZE = Integer.parseInt(size);
		}
		catch (Exception e){
			System.out.println("Please input a valid number for the carpark size");
			System.out.println();
		}
		
		this.list_of_available_slots = new ArrayList<Integer>();
		for (int i = 0; i < this.MAX_SIZE; i++){
			this.list_of_available_slots.add(i+1);
		}
		this.slot_to_car = new HashMap<String,Car> ();
		this.reg_to_slot = new HashMap<String, String>();
        this.colour_to_reg = new HashMap<String, ArrayList<String>>();

		System.out.println("Created a parking lot with " +size + " slots");
		System.out.println();
    }
    
    public void park(String regNo, String colour) {
    	
    	if (this.MAX_SIZE == 0) {
            System.out.println("Parking lot has not been created");
            System.out.println();
        } 
        
        else if (this.slot_to_car.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } 
        
        else {
            Collections.sort(list_of_available_slots);
            String slot = list_of_available_slots.get(0).toString();
            Car car = new Car(regNo, colour);
            this.slot_to_car.put(slot, car);
            this.reg_to_slot.put(regNo, slot);
   
            if (this.colour_to_reg.containsKey(colour)) {
                ArrayList<String> regNoList = this.colour_to_reg.get(colour);
                this.colour_to_reg.remove(colour);
                regNoList.add(regNo);
                this.colour_to_reg.put(colour, regNoList);
            } 
            
            else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNo);
                this.colour_to_reg.put(colour, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            list_of_available_slots.remove(0);
        }
    
    }

}
