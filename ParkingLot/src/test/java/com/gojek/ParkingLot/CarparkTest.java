package com.gojek.ParkingLot;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CarparkTest {
	
	Carpark carpark = new Carpark();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

	@Test
	public void create_parking_lot() throws Exception {
		carpark.create_parking_lot("6");
        assertEquals(6, carpark.MAX_SIZE);
        assertEquals(6, carpark.list_of_available_slots.size());
        assertTrue("createdaparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
        
    }
	
	@Test
    public void park() throws Exception {
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-2701", "Blue");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-2701", "Blue");
        assertEquals(4, carpark.list_of_available_slots.size());
    }
	
	@Test
    public void leave() throws Exception {
        carpark.leave("2");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-2701", "Blue");
        carpark.leave("4");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
    }

}
