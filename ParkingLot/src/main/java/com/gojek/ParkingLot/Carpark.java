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
    
    public void leave(String slotNo) {
    	
    	if (this.MAX_SIZE == 0) {
            System.out.println("Parking lot has not been created");
            System.out.println();
        } 
        
        else if (this.slot_to_car.size() > 0) {
            Car leaving_car = this.slot_to_car.get(slotNo);
            if (leaving_car != null) {
                this.slot_to_car.remove(slotNo);
                this.reg_to_slot.remove(leaving_car.regNo);
                ArrayList<String> regNoList = this.colour_to_reg.get(leaving_car.colour);
                if (regNoList.contains(leaving_car.regNo)) {
                    regNoList.remove(leaving_car.regNo);
                }
                
                this.list_of_available_slots.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
            } 
            
            else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } 
        
        else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }

    	
    }
    
    public void status() {
    	 
    	if (this.MAX_SIZE == 0) {
             System.out.println("Parking lot has not been created");
             System.out.println();
         } 
         
         else if (this.slot_to_car.size() > 0) {
             
             System.out.println("Slot No.\tRegistration No.\tColour");
             Car car;
             for (int i = 1; i <= this.MAX_SIZE; i++) {
                 String key = Integer.toString(i);
                 if (this.slot_to_car.containsKey(key)) {
                     car = this.slot_to_car.get(key);
                     System.out.println(i + "\t" + car.regNo + "\t" + car.colour);
                 }
             }
             System.out.println();
         } 
         
         else {
             System.out.println("Parking lot is empty");
             System.out.println();
         }
    }
    
    public void registration_numbers_for_cars_with_colour(String colour) {
    	
    	if (this.MAX_SIZE == 0) {
            System.out.println("Parking lot has not been created");
            System.out.println();
        } 
        
        else if (this.colour_to_reg.containsKey(colour)) {
            ArrayList<String> regNoList = this.colour_to_reg.get(colour);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } 
        
        else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void slot_numbers_for_cars_with_colour(String colour) {
    	
    	if (this.MAX_SIZE == 0) {
            System.out.println("Parking lot has not been created");
            System.out.println();
        } 
        
        else if (this.colour_to_reg.containsKey(colour)) {
            ArrayList<String> regNoList = this.colour_to_reg.get(colour);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.reg_to_slot.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } 
        
        else {
            System.out.println("Not found");
            System.out.println();
        }
    	
    }

}
