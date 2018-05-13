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

}
