package com.gojek.ParkingLot;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandsTest {

	
	    Commands commands = new Commands();
	    @Test
	    public void checkCommandInList() throws Exception {
	        assertFalse(commands.commandsMap.isEmpty());
	        assertTrue(commands.commandsMap.containsKey("create_parking_lot"));
	        assertTrue(commands.commandsMap.containsKey("park"));
	        assertTrue(commands.commandsMap.containsKey("leave"));
	        assertFalse(commands.commandsMap.containsKey("test"));
	        
	    }
	

}
