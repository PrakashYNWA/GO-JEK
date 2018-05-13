package com.gojek.ParkingLot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Commands {
	public Map<String, Method> commandsMap;

    public Commands() {
        commandsMap = new HashMap<String, Method>();
        try {
        	insert_into_CommandsMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void insert_into_CommandsMap() throws NoSuchMethodException {
    	 
    	commandsMap.put("create_parking_lot", Carpark.class.getMethod("create_parking_lot", String.class));
         commandsMap.put("park", Carpark.class.getMethod("park", String.class, String.class));
         commandsMap.put("leave", Carpark.class.getMethod("leave", String.class));
         commandsMap.put("status", Carpark.class.getMethod("status"));
         commandsMap.put("registration_numbers_for_cars_with_colour", Carpark.class.getMethod("registration_numbers_for_cars_with_colour", String.class));
         commandsMap.put("slot_numbers_for_cars_with_colour", Carpark.class.getMethod("slot_numbers_for_cars_with_colour", String.class));
         commandsMap.put("slot_number_for_registration_number", Carpark.class.getMethod("slot_number_for_registration_number", String.class));
    }

}
