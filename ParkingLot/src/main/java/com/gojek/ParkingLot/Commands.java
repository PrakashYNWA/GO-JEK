package com.gojek.ParkingLot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Commands {
	public Map<String, Method> commandsMap;

    public Commands() {
        commandsMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
    	
    }

}
