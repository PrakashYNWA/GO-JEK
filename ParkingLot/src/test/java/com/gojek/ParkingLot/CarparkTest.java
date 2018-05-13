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
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-2701", "Blue");
        carpark.leave("4");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
    }
	
	@Test
    public void status() throws Exception {
        carpark.status();
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-2701", "Blue");
        carpark.status();
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "SlotNo.\tRegistrationNo.\tColour\n" +
                "1\tKA-01-BB-0001\tBlack\n" +
                "2\tKA-01-HH-2701\tBlue", outContent.toString().trim().replace(" ", ""));
    }
	
	@Test
    public void registration_numbers_for_cars_with_colour() throws Exception {
        carpark.registration_numbers_for_cars_with_colour("Black");
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-3141", "Black");
        carpark.registration_numbers_for_cars_with_colour("Black");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-BB-0001,KA-01-HH-3141", outContent.toString().trim().replace(" ", ""));
        carpark.registration_numbers_for_cars_with_colour("Gold");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-BB-0001,KA-01-HH-3141Notfound", outContent.toString().trim().replace(" ", ""));
    }
	
	@Test
    public void slot_numbers_for_cars_with_colour() throws Exception {
        carpark.slot_numbers_for_cars_with_colour("Black");
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-3141", "Black");
        carpark.slot_numbers_for_cars_with_colour("Black");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2", outContent.toString().trim().replace(" ", ""));
        carpark.slot_numbers_for_cars_with_colour("Gold");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }
	
	@Test
    public void slot_number_for_registration_number() throws Exception {
        carpark.slot_number_for_registration_number("KA-01-BB-0001");
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
        carpark.create_parking_lot("6");
        carpark.park("KA-01-BB-0001", "Black");
        carpark.park("KA-01-HH-3141", "Black");
        carpark.slot_number_for_registration_number("KA-01-BB-0001");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1", outContent.toString().trim().replace(" ", ""));
        carpark.slot_number_for_registration_number("KA-01-HH-3141");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2", outContent.toString().trim().replace(" ", ""));
        carpark.leave("1");
        carpark.slot_number_for_registration_number("KA-01-BB-0001");
        assertEquals("Parkinglothasnotbeencreated\n" +
                "\n" +
                "Createdaparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "Slotnumber1isfree\n" +
                "\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }


}
